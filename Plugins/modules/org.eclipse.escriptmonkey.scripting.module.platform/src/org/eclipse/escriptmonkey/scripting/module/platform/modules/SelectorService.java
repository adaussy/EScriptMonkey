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
package org.eclipse.escriptmonkey.scripting.module.platform.modules;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.expressions.EvaluationResult;
import org.eclipse.core.expressions.Expression;
import org.eclipse.core.expressions.ExpressionConverter;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.escriptmonkey.scripting.debug.Logger;
import org.eclipse.escriptmonkey.scripting.module.platform.modules.impl.SelectorWrapper;

import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;


/**
 * This service provide selection using {@link ISelector} register by extension point.
 * It's aim is to be able to retrieve custom selection using specific selector
 * @author adaussy
 *
 */
public class SelectorService {

	private static final String SELECTOR_EXT_POINT_ID = "org.eclipse.escriptmonkey.scripting.module.platform.Selector";

	private static class SingletonHolder {

		private static SelectorService INSTANCE = new SelectorService();
	}

	public static SelectorService getInstance() {
		return SingletonHolder.INSTANCE;
	}

	private SortedSetMultimap<Integer, SelectorWrapper> selectors = null;

	private Map<String, SelectorWrapper> selectorsMap = null;

	SelectorService() {
		init();
	}

	/**
	 * Retreive the custom selection using the {@link ISelector} sorted by priority and that Core Expression that match the context
	 * @param in
	 * @param context
	 * @return
	 */
	public Object getSelectionFromContext(Object in, IEvaluationContext context) {

		for(Integer priority : selectors.keySet()) {
			for(SelectorWrapper selector : selectors.get(priority)) {
				Expression expression = selector.getExpression();
				if(expression != null) {
					try {
						if(expression.evaluate(context) == EvaluationResult.TRUE) {
							Object selection = selector.getSelector().getCustomSelection(in);
							if(selection != null) {
								return selection;
							}
						}
					} catch (CoreException e) {
						e.printStackTrace();
						continue;
					}
				} else {
					Object selection = selector.getSelector().getCustomSelection(in);
					if(selection != null) {
						return selection;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Return a custom selection using {@link ISelector} using the {@link ISelector} define the id passed as parameter
	 * @param in
	 * @param id
	 * @return
	 */
	public Object getSelectionFromSelector(Object in, String id) {
		SelectorWrapper selector = selectorsMap.get(id);
		if(selector != null) {
			return selector.getSelector().getCustomSelection(in);
		}
		return null;
	}

	/**
	 * Retrieve a custom selection using only priority of the registered {@link ISelector}
	 * @param in
	 * @return
	 */
	public Object getSelection(Object in) {
		for(Integer priority : selectors.keySet()) {
			for(SelectorWrapper selector : selectors.get(priority)) {
				Object selection = selector.getSelector().getCustomSelection(in);
				if(selection != null) {
					return selection;
				}
			}
		}
		return null;
	}

	protected void init() {
		if(selectors == null) {
			selectors = TreeMultimap.create(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			}, new Comparator<SelectorWrapper>() {

				@Override
				public int compare(SelectorWrapper o1, SelectorWrapper o2) {
					return o1.compareTo(o2);
				}
			});
			selectorsMap = new HashMap<String, SelectorWrapper>();
			final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(SELECTOR_EXT_POINT_ID);

			for(final IConfigurationElement e : config) {
				if("Selector".equals(e.getName())) {
					String id = e.getAttribute("id");
					try {
						ISelector newSelector = (ISelector)e.createExecutableExtension("impl");
						String priorityS = e.getAttribute("priority");
						int priority = Integer.parseInt(priorityS);
						SelectorWrapper oldSelector = selectorsMap.get(id);
						if(oldSelector != null) {
							selectorsMap.remove(id);
							Collection<SelectorWrapper> selects = selectors.get(priority);
							selects.remove(oldSelector);
						}
						Expression expression = null;
						for(IConfigurationElement child : e.getChildren()) {
							expression = ExpressionConverter.getDefault().perform(child);
							if(expression != null) {
								break;
							}
						}
						SelectorWrapper selectorWrapper = new SelectorWrapper(newSelector, expression, id);
						selectors.put(priority, selectorWrapper);
						selectorsMap.put(id, selectorWrapper);
					} catch (CoreException e1) {
						e1.printStackTrace();
						Logger.logError("Unable to create the a selector from " + id);
					}
				}
			}
		}
	}

}
