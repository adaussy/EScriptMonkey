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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.eclipse.escriptmonkey.scripting.ui.expression.xtext.services.CoreExpressionGrammarAccess;

public class CoreExpressionParser extends AbstractContentAssistParser {
	
	@Inject
	private CoreExpressionGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr.internal.InternalCoreExpressionParser createParser() {
		org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr.internal.InternalCoreExpressionParser result = new org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr.internal.InternalCoreExpressionParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
					put(grammarAccess.getCompositeExpressionAccess().getAlternatives(), "rule__CompositeExpression__Alternatives");
					put(grammarAccess.getOperatorAccess().getAlternatives(), "rule__Operator__Alternatives");
					put(grammarAccess.getEBooleanAccess().getAlternatives(), "rule__EBoolean__Alternatives");
					put(grammarAccess.getVariableAccess().getAlternatives(), "rule__Variable__Alternatives");
					put(grammarAccess.getRootAccess().getGroup(), "rule__Root__Group__0");
					put(grammarAccess.getInstanceExpressionAccess().getGroup(), "rule__InstanceExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup(), "rule__AndExpression__Group__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_3(), "rule__AndExpression__Group_3__0");
					put(grammarAccess.getAndExpressionAccess().getGroup_3_1(), "rule__AndExpression__Group_3_1__0");
					put(grammarAccess.getOrExpresisonAccess().getGroup(), "rule__OrExpresison__Group__0");
					put(grammarAccess.getOrExpresisonAccess().getGroup_3(), "rule__OrExpresison__Group_3__0");
					put(grammarAccess.getOrExpresisonAccess().getGroup_3_1(), "rule__OrExpresison__Group_3_1__0");
					put(grammarAccess.getNotExpressionAccess().getGroup(), "rule__NotExpression__Group__0");
					put(grammarAccess.getNotExpressionAccess().getGroup_3(), "rule__NotExpression__Group_3__0");
					put(grammarAccess.getNotExpressionAccess().getGroup_3_1(), "rule__NotExpression__Group_3_1__0");
					put(grammarAccess.getIterableExpressionAccess().getGroup(), "rule__IterableExpression__Group__0");
					put(grammarAccess.getIterableExpressionAccess().getGroup_5(), "rule__IterableExpression__Group_5__0");
					put(grammarAccess.getIterableExpressionAccess().getGroup_5_1(), "rule__IterableExpression__Group_5_1__0");
					put(grammarAccess.getWithExpressionAccess().getGroup(), "rule__WithExpression__Group__0");
					put(grammarAccess.getWithExpressionAccess().getGroup_3(), "rule__WithExpression__Group_3__0");
					put(grammarAccess.getWithExpressionAccess().getGroup_3_1(), "rule__WithExpression__Group_3_1__0");
					put(grammarAccess.getAdaptExpressionAccess().getGroup(), "rule__AdaptExpression__Group__0");
					put(grammarAccess.getAdaptExpressionAccess().getGroup_3(), "rule__AdaptExpression__Group_3__0");
					put(grammarAccess.getAdaptExpressionAccess().getGroup_3_1(), "rule__AdaptExpression__Group_3_1__0");
					put(grammarAccess.getEqualExpressionAccess().getGroup(), "rule__EqualExpression__Group__0");
					put(grammarAccess.getRootAccess().getExpressionAssignment_1(), "rule__Root__ExpressionAssignment_1");
					put(grammarAccess.getInstanceExpressionAccess().getValueAssignment_1(), "rule__InstanceExpression__ValueAssignment_1");
					put(grammarAccess.getAndExpressionAccess().getExpressionsAssignment_3_0(), "rule__AndExpression__ExpressionsAssignment_3_0");
					put(grammarAccess.getAndExpressionAccess().getExpressionsAssignment_3_1_1(), "rule__AndExpression__ExpressionsAssignment_3_1_1");
					put(grammarAccess.getOrExpresisonAccess().getExpressionsAssignment_3_0(), "rule__OrExpresison__ExpressionsAssignment_3_0");
					put(grammarAccess.getOrExpresisonAccess().getExpressionsAssignment_3_1_1(), "rule__OrExpresison__ExpressionsAssignment_3_1_1");
					put(grammarAccess.getNotExpressionAccess().getExpressionsAssignment_3_0(), "rule__NotExpression__ExpressionsAssignment_3_0");
					put(grammarAccess.getNotExpressionAccess().getExpressionsAssignment_3_1_1(), "rule__NotExpression__ExpressionsAssignment_3_1_1");
					put(grammarAccess.getIterableExpressionAccess().getIfEmptyAssignment_1(), "rule__IterableExpression__IfEmptyAssignment_1");
					put(grammarAccess.getIterableExpressionAccess().getOperandAssignment_3(), "rule__IterableExpression__OperandAssignment_3");
					put(grammarAccess.getIterableExpressionAccess().getExpressionsAssignment_5_0(), "rule__IterableExpression__ExpressionsAssignment_5_0");
					put(grammarAccess.getIterableExpressionAccess().getExpressionsAssignment_5_1_1(), "rule__IterableExpression__ExpressionsAssignment_5_1_1");
					put(grammarAccess.getWithExpressionAccess().getVariableAssignment_1(), "rule__WithExpression__VariableAssignment_1");
					put(grammarAccess.getWithExpressionAccess().getExpressionsAssignment_3_0(), "rule__WithExpression__ExpressionsAssignment_3_0");
					put(grammarAccess.getWithExpressionAccess().getExpressionsAssignment_3_1_1(), "rule__WithExpression__ExpressionsAssignment_3_1_1");
					put(grammarAccess.getAdaptExpressionAccess().getValueAssignment_1(), "rule__AdaptExpression__ValueAssignment_1");
					put(grammarAccess.getAdaptExpressionAccess().getExpressionsAssignment_3_0(), "rule__AdaptExpression__ExpressionsAssignment_3_0");
					put(grammarAccess.getAdaptExpressionAccess().getExpressionsAssignment_3_1_1(), "rule__AdaptExpression__ExpressionsAssignment_3_1_1");
					put(grammarAccess.getEqualExpressionAccess().getValueAssignment_1(), "rule__EqualExpression__ValueAssignment_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr.internal.InternalCoreExpressionParser typedParser = (org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.contentassist.antlr.internal.InternalCoreExpressionParser) parser;
			typedParser.entryRuleRoot();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public CoreExpressionGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(CoreExpressionGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
