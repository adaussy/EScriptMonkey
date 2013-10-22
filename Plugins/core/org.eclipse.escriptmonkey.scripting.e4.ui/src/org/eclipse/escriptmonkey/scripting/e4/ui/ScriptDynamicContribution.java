/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.e4.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Named;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.AboutToShow;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.commands.MCommand;
import org.eclipse.e4.ui.model.application.commands.MCommandsFactory;
import org.eclipse.e4.ui.model.application.commands.MParameter;
import org.eclipse.e4.ui.model.application.ui.menu.MHandledMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuElement;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.escriptmonkey.scripting.e4.ui.handler.IFragmentConstants;
import org.eclipse.escriptmonkey.scripting.log.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;
import org.eclipse.escriptmonkey.scripting.ui.ScriptGraphService;
import org.eclipse.escriptmonkey.scripting.ui.expression.ExpressionToExpressionCoreSwitch;
import org.eclipse.escriptmonkey.scripting.ui.expression.xtext.CoreExpressionStandaloneSetupGenerated;
import org.eclipse.escriptmonkey.scripting.ui.expression.xtext.parser.antlr.CoreExpressionParser;
import org.eclipse.escriptmonkey.scripting.ui.metadata.IUIMetadata;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptSetUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.SubNode;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.services.IEvaluationService;
import org.eclipse.xtext.parser.IParseResult;

import com.google.inject.Injector;

public class ScriptDynamicContribution {

	public ScriptDynamicContribution() {
		CoreExpressionStandaloneSetupGenerated tt = new CoreExpressionStandaloneSetupGenerated();
		Injector injector = tt.createInjector();
		parser = (CoreExpressionParser)injector.getInstance(org.eclipse.xtext.parser.IParser.class);
	}


	@AboutToShow
	public void aboutToShow(List<MMenuElement> items, MApplication application, @Optional @Named(IServiceConstants.ACTIVE_SELECTION) ISelection selection) {
		if(selection != null) {
			createDynamiqueMenu(application, items, createEvaluationContext(selection));
		}
	}

	protected IEvaluationContext createEvaluationContext(Object defaultvar) {
		IEvaluationContext parent = null;
		IEvaluationService esrvc = (IEvaluationService)PlatformUI.getWorkbench().getService(IEvaluationService.class);
		if(esrvc != null) {
			parent = esrvc.getCurrentState();
		}
		return new EvaluationContext(parent, defaultvar);
	}

	protected MCommand getCommand(MApplication application) {

		for(MCommand c : application.getCommands()) {
			if(IFragmentConstants.COMMAND_ID.equals(c.getElementId()))
				return c;
		}

		return null;
	}

	protected void createDynamiqueMenu(MApplication application, List<MMenuElement> items, IEvaluationContext context) {
		MCommand command = getCommand(application);
		generateAllItemMenu(ScriptGraphService.getInstance().getScriptGraph(), command, items, context);

	}

	protected void generateAllItemMenu(Root root, MCommand command, List<MMenuElement> items, IEvaluationContext context) {
		for(SubNode n : root.getChildren()) {
			createItemMenus(n, command, items, context);
		}

	}


	protected void createItemMenus(SubNode n, MCommand command, List<MMenuElement> items, IEvaluationContext context) {
		if(n instanceof ScriptSetUI) {
			ScriptSetUI parentNode = (ScriptSetUI)n;
			MMenu menu = MMenuFactory.INSTANCE.createMenu();
			menu.setLabel(n.getName());
			menu.setElementId(ScriptGraphService.getInstance().getNodeFragment(n));
			if(!containItemMenu(menu, items)) {
				items.add(menu);
				EList<SubNode> children = parentNode.getChildren();
				ArrayList<SubNode> sortedChildren = new ArrayList<SubNode>(children);
				Collections.sort(sortedChildren, new Comparator<SubNode>() {

					@Override
					public int compare(SubNode o1, SubNode o2) {
						if(o1.getName() != null) {
							return o1.getName().compareTo(o2.getName());
						}
						return -1;
					}
				});
				for(SubNode s : sortedChildren) {
					createItemMenus(s, command, menu.getChildren(), context);

				}
			}
		} else if(n instanceof StoredScriptUI) {
			MHandledMenuItem menuItem = MMenuFactory.INSTANCE.createHandledMenuItem();
			menuItem.setLabel(n.getName());
			menuItem.setEnabled(true);
			//						menuItem.
			menuItem.setElementId(ScriptGraphService.getInstance().getNodeFragment(n));
			menuItem.setCommand(command);
			menuItem.getParameters().add(createMParameter((StoredScriptUI)n));
			menuItem.setVisible(visible(((StoredScriptUI)n).getScript(), context));
			if(!containItemMenu(menuItem, items)) {
				items.add(menuItem);
			}
		}
	}

	CoreExpressionParser parser;

	protected boolean visible(IStoredScript script, IEvaluationContext context) {
		ScriptMetadata metadata = script.getMetadata(IUIMetadata.ENABLE_WHEN);
		if(metadata == null) {
			return false;
		}
		String expression = metadata.getValue();
		if(expression == null) {
			return false;
		}
		IParseResult result = parser.doParse(expression);
		EObject root = result.getRootASTElement();
		//		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor()
		if(root instanceof org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root) {
			org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root exp = (org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root)root;
			ExpressionToExpressionCoreSwitch tt = new ExpressionToExpressionCoreSwitch();
			org.eclipse.core.expressions.Expression coreExp = tt.doSwitch(exp);
			if(coreExp != null) {
				try {
					EvaluationResult eval = coreExp.evaluate(context);
					return EvaluationResult.TRUE.equals(eval);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			} else {
				Logger.logError("Unable to translate to Core expression :\n" + expression);
			}
		}
		return false;

	}

	public boolean containItemMenu(MMenuElement itemMenu, List<MMenuElement> items) {
		for(MMenuElement menu : items) {
			String elementId = menu.getElementId();
			if(elementId != null && elementId.equals(itemMenu.getElementId())) {
				return true;
			}
		}
		return false;

	}

	protected MParameter createMParameter(StoredScriptUI element) {
		MParameter param = MCommandsFactory.INSTANCE.createParameter();
		param.setElementId(element.getName());
		param.setName(IFragmentConstants.SCRIPT_COMMAND_PARAMETER_ID);
		param.setValue(ScriptGraphService.getInstance().getNodeFragment(element));
		return param;

	}



}
