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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class CoreExpressionGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class RootElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Root");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftSquareBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionExpressionParserRuleCall_1_0 = (RuleCall)cExpressionAssignment_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//Root:
		//
		//	"[" expression=Expression "]";
		public ParserRule getRule() { return rule; }

		//"[" expression=Expression "]"
		public Group getGroup() { return cGroup; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0() { return cLeftSquareBracketKeyword_0; }

		//expression=Expression
		public Assignment getExpressionAssignment_1() { return cExpressionAssignment_1; }

		//Expression
		public RuleCall getExpressionExpressionParserRuleCall_1_0() { return cExpressionExpressionParserRuleCall_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2() { return cRightSquareBracketKeyword_2; }
	}

	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cInstanceExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cAndExpressionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cOrExpresisonParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cNotExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cIterableExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		private final RuleCall cWithExpressionParserRuleCall_5 = (RuleCall)cAlternatives.eContents().get(5);
		private final RuleCall cAdaptExpressionParserRuleCall_6 = (RuleCall)cAlternatives.eContents().get(6);
		private final RuleCall cEqualExpressionParserRuleCall_7 = (RuleCall)cAlternatives.eContents().get(7);
		
		//Expression:
		//
		//	InstanceExpression | AndExpression | OrExpresison | NotExpression | IterableExpression | WithExpression |
		//
		//	AdaptExpression | EqualExpression;
		public ParserRule getRule() { return rule; }

		//InstanceExpression | AndExpression | OrExpresison | NotExpression | IterableExpression | WithExpression |
		//
		//AdaptExpression | EqualExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//InstanceExpression
		public RuleCall getInstanceExpressionParserRuleCall_0() { return cInstanceExpressionParserRuleCall_0; }

		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_1() { return cAndExpressionParserRuleCall_1; }

		//OrExpresison
		public RuleCall getOrExpresisonParserRuleCall_2() { return cOrExpresisonParserRuleCall_2; }

		//NotExpression
		public RuleCall getNotExpressionParserRuleCall_3() { return cNotExpressionParserRuleCall_3; }

		//IterableExpression
		public RuleCall getIterableExpressionParserRuleCall_4() { return cIterableExpressionParserRuleCall_4; }

		//WithExpression
		public RuleCall getWithExpressionParserRuleCall_5() { return cWithExpressionParserRuleCall_5; }

		//AdaptExpression
		public RuleCall getAdaptExpressionParserRuleCall_6() { return cAdaptExpressionParserRuleCall_6; }

		//EqualExpression
		public RuleCall getEqualExpressionParserRuleCall_7() { return cEqualExpressionParserRuleCall_7; }
	}

	public class CompositeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CompositeExpression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cAndExpressionParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cOrExpresisonParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cNotExpressionParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cIterableExpressionParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cAdaptExpressionParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//CompositeExpression:
		//
		//	AndExpression | OrExpresison | NotExpression | IterableExpression | AdaptExpression;
		public ParserRule getRule() { return rule; }

		//AndExpression | OrExpresison | NotExpression | IterableExpression | AdaptExpression
		public Alternatives getAlternatives() { return cAlternatives; }

		//AndExpression
		public RuleCall getAndExpressionParserRuleCall_0() { return cAndExpressionParserRuleCall_0; }

		//OrExpresison
		public RuleCall getOrExpresisonParserRuleCall_1() { return cOrExpresisonParserRuleCall_1; }

		//NotExpression
		public RuleCall getNotExpressionParserRuleCall_2() { return cNotExpressionParserRuleCall_2; }

		//IterableExpression
		public RuleCall getIterableExpressionParserRuleCall_3() { return cIterableExpressionParserRuleCall_3; }

		//AdaptExpression
		public RuleCall getAdaptExpressionParserRuleCall_4() { return cAdaptExpressionParserRuleCall_4; }
	}

	public class InstanceExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "InstanceExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cInstanceOfKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//InstanceExpression:
		//
		//	"InstanceOf" value=STRING;
		public ParserRule getRule() { return rule; }

		//"InstanceOf" value=STRING
		public Group getGroup() { return cGroup; }

		//"InstanceOf"
		public Keyword getInstanceOfKeyword_0() { return cInstanceOfKeyword_0; }

		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}

	public class AndExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AndExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cAndExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cAndKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cExpressionsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_0_0 = (RuleCall)cExpressionsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_1_1_0 = (RuleCall)cExpressionsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//AndExpression:
		//
		//	{AndExpression} "And" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
		public ParserRule getRule() { return rule; }

		//{AndExpression} "And" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}"
		public Group getGroup() { return cGroup; }

		//{AndExpression}
		public Action getAndExpressionAction_0() { return cAndExpressionAction_0; }

		//"And"
		public Keyword getAndKeyword_1() { return cAndKeyword_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(expressions+=Expression ("," expressions+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_0() { return cExpressionsAssignment_3_0; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_0_0() { return cExpressionsExpressionParserRuleCall_3_0_0; }

		//("," expressions+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_1_1() { return cExpressionsAssignment_3_1_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_1_1_0() { return cExpressionsExpressionParserRuleCall_3_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class OrExpresisonElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "OrExpresison");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cOrExpresisonAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cOrKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cExpressionsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_0_0 = (RuleCall)cExpressionsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_1_1_0 = (RuleCall)cExpressionsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//OrExpresison:
		//
		//	{OrExpresison} "Or" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
		public ParserRule getRule() { return rule; }

		//{OrExpresison} "Or" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}"
		public Group getGroup() { return cGroup; }

		//{OrExpresison}
		public Action getOrExpresisonAction_0() { return cOrExpresisonAction_0; }

		//"Or"
		public Keyword getOrKeyword_1() { return cOrKeyword_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(expressions+=Expression ("," expressions+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_0() { return cExpressionsAssignment_3_0; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_0_0() { return cExpressionsExpressionParserRuleCall_3_0_0; }

		//("," expressions+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_1_1() { return cExpressionsAssignment_3_1_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_1_1_0() { return cExpressionsExpressionParserRuleCall_3_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class NotExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "NotExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cNotExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cNotKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cExpressionsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_0_0 = (RuleCall)cExpressionsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_1_1_0 = (RuleCall)cExpressionsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//NotExpression:
		//
		//	{NotExpression} "Not" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
		public ParserRule getRule() { return rule; }

		//{NotExpression} "Not" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}"
		public Group getGroup() { return cGroup; }

		//{NotExpression}
		public Action getNotExpressionAction_0() { return cNotExpressionAction_0; }

		//"Not"
		public Keyword getNotKeyword_1() { return cNotKeyword_1; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(expressions+=Expression ("," expressions+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_0() { return cExpressionsAssignment_3_0; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_0_0() { return cExpressionsExpressionParserRuleCall_3_0_0; }

		//("," expressions+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_1_1() { return cExpressionsAssignment_3_1_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_1_1_0() { return cExpressionsExpressionParserRuleCall_3_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class IterableExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IterableExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cIterableExpressionAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cIfEmptyAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cIfEmptyIfEmptyKeyword_1_0 = (Keyword)cIfEmptyAssignment_1.eContents().get(0);
		private final Keyword cIterableKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Assignment cOperandAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cOperandOperatorParserRuleCall_3_0 = (RuleCall)cOperandAssignment_3.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		private final Group cGroup_5 = (Group)cGroup.eContents().get(5);
		private final Assignment cExpressionsAssignment_5_0 = (Assignment)cGroup_5.eContents().get(0);
		private final RuleCall cExpressionsExpressionParserRuleCall_5_0_0 = (RuleCall)cExpressionsAssignment_5_0.eContents().get(0);
		private final Group cGroup_5_1 = (Group)cGroup_5.eContents().get(1);
		private final Keyword cCommaKeyword_5_1_0 = (Keyword)cGroup_5_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_5_1_1 = (Assignment)cGroup_5_1.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_5_1_1_0 = (RuleCall)cExpressionsAssignment_5_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_6 = (Keyword)cGroup.eContents().get(6);
		
		//IterableExpression:
		//
		//	{IterableExpression} ifEmpty?="ifEmpty"? "Iterable" operand=Operator? "{" (expressions+=Expression (","
		//
		//	expressions+=Expression)*)? "}";
		public ParserRule getRule() { return rule; }

		//{IterableExpression} ifEmpty?="ifEmpty"? "Iterable" operand=Operator? "{" (expressions+=Expression (","
		//
		//expressions+=Expression)*)? "}"
		public Group getGroup() { return cGroup; }

		//{IterableExpression}
		public Action getIterableExpressionAction_0() { return cIterableExpressionAction_0; }

		//ifEmpty?="ifEmpty"?
		public Assignment getIfEmptyAssignment_1() { return cIfEmptyAssignment_1; }

		//"ifEmpty"
		public Keyword getIfEmptyIfEmptyKeyword_1_0() { return cIfEmptyIfEmptyKeyword_1_0; }

		//"Iterable"
		public Keyword getIterableKeyword_2() { return cIterableKeyword_2; }

		//operand=Operator?
		public Assignment getOperandAssignment_3() { return cOperandAssignment_3; }

		//Operator
		public RuleCall getOperandOperatorParserRuleCall_3_0() { return cOperandOperatorParserRuleCall_3_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_4() { return cLeftCurlyBracketKeyword_4; }

		//(expressions+=Expression ("," expressions+=Expression)*)?
		public Group getGroup_5() { return cGroup_5; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_5_0() { return cExpressionsAssignment_5_0; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_5_0_0() { return cExpressionsExpressionParserRuleCall_5_0_0; }

		//("," expressions+=Expression)*
		public Group getGroup_5_1() { return cGroup_5_1; }

		//","
		public Keyword getCommaKeyword_5_1_0() { return cCommaKeyword_5_1_0; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_5_1_1() { return cExpressionsAssignment_5_1_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_5_1_1_0() { return cExpressionsExpressionParserRuleCall_5_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_6() { return cRightCurlyBracketKeyword_6; }
	}

	public class WithExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "WithExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cWithKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cVariableAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVariableVariableParserRuleCall_1_0 = (RuleCall)cVariableAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cExpressionsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_0_0 = (RuleCall)cExpressionsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_1_1_0 = (RuleCall)cExpressionsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//WithExpression:
		//
		//	"With" variable=Variable "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
		public ParserRule getRule() { return rule; }

		//"With" variable=Variable "{" (expressions+=Expression ("," expressions+=Expression)*)? "}"
		public Group getGroup() { return cGroup; }

		//"With"
		public Keyword getWithKeyword_0() { return cWithKeyword_0; }

		//variable=Variable
		public Assignment getVariableAssignment_1() { return cVariableAssignment_1; }

		//Variable
		public RuleCall getVariableVariableParserRuleCall_1_0() { return cVariableVariableParserRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(expressions+=Expression ("," expressions+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_0() { return cExpressionsAssignment_3_0; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_0_0() { return cExpressionsExpressionParserRuleCall_3_0_0; }

		//("," expressions+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_1_1() { return cExpressionsAssignment_3_1_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_1_1_0() { return cExpressionsExpressionParserRuleCall_3_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class AdaptExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AdaptExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAdaptToKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cExpressionsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_0_0 = (RuleCall)cExpressionsAssignment_3_0.eContents().get(0);
		private final Group cGroup_3_1 = (Group)cGroup_3.eContents().get(1);
		private final Keyword cCommaKeyword_3_1_0 = (Keyword)cGroup_3_1.eContents().get(0);
		private final Assignment cExpressionsAssignment_3_1_1 = (Assignment)cGroup_3_1.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_3_1_1_0 = (RuleCall)cExpressionsAssignment_3_1_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//AdaptExpression:
		//
		//	"AdaptTo" value=STRING "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
		public ParserRule getRule() { return rule; }

		//"AdaptTo" value=STRING "{" (expressions+=Expression ("," expressions+=Expression)*)? "}"
		public Group getGroup() { return cGroup; }

		//"AdaptTo"
		public Keyword getAdaptToKeyword_0() { return cAdaptToKeyword_0; }

		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }

		//(expressions+=Expression ("," expressions+=Expression)*)?
		public Group getGroup_3() { return cGroup_3; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_0() { return cExpressionsAssignment_3_0; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_0_0() { return cExpressionsExpressionParserRuleCall_3_0_0; }

		//("," expressions+=Expression)*
		public Group getGroup_3_1() { return cGroup_3_1; }

		//","
		public Keyword getCommaKeyword_3_1_0() { return cCommaKeyword_3_1_0; }

		//expressions+=Expression
		public Assignment getExpressionsAssignment_3_1_1() { return cExpressionsAssignment_3_1_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_3_1_1_0() { return cExpressionsExpressionParserRuleCall_3_1_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}

	public class EqualExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EqualExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cEqualKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSTRINGTerminalRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//EqualExpression:
		//
		//	"Equal" value=STRING;
		public ParserRule getRule() { return rule; }

		//"Equal" value=STRING
		public Group getGroup() { return cGroup; }

		//"Equal"
		public Keyword getEqualKeyword_0() { return cEqualKeyword_0; }

		//value=STRING
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_1_0() { return cValueSTRINGTerminalRuleCall_1_0; }
	}

	public class OperatorElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Operator");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cAndKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cOrKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//Operator:
		//
		//	"and" | "or";
		public ParserRule getRule() { return rule; }

		//"and" | "or"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"and"
		public Keyword getAndKeyword_0() { return cAndKeyword_0; }

		//"or"
		public Keyword getOrKeyword_1() { return cOrKeyword_1; }
	}

	public class EBooleanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "EBoolean");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cTrueKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cFalseKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		
		//EBoolean returns ecore::EBoolean:
		//
		//	"true" | "false";
		public ParserRule getRule() { return rule; }

		//"true" | "false"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"true"
		public Keyword getTrueKeyword_0() { return cTrueKeyword_0; }

		//"false"
		public Keyword getFalseKeyword_1() { return cFalseKeyword_1; }
	}

	public class VariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Variable");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cActiveContextsKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final Keyword cActiveEditorKeyword_1 = (Keyword)cAlternatives.eContents().get(1);
		private final Keyword cActiveEditorIdKeyword_2 = (Keyword)cAlternatives.eContents().get(2);
		private final Keyword cActivePartIdKeyword_3 = (Keyword)cAlternatives.eContents().get(3);
		private final Keyword cActiveSiteKeyword_4 = (Keyword)cAlternatives.eContents().get(4);
		private final Keyword cSelectionKeyword_5 = (Keyword)cAlternatives.eContents().get(5);
		
		//Variable:
		//
		//	"activeContexts" | "activeEditor" | "activeEditorId" | "activePartId" | "activeSite" | "selection";
		public ParserRule getRule() { return rule; }

		//"activeContexts" | "activeEditor" | "activeEditorId" | "activePartId" | "activeSite" | "selection"
		public Alternatives getAlternatives() { return cAlternatives; }

		//"activeContexts"
		public Keyword getActiveContextsKeyword_0() { return cActiveContextsKeyword_0; }

		//"activeEditor"
		public Keyword getActiveEditorKeyword_1() { return cActiveEditorKeyword_1; }

		//"activeEditorId"
		public Keyword getActiveEditorIdKeyword_2() { return cActiveEditorIdKeyword_2; }

		//"activePartId"
		public Keyword getActivePartIdKeyword_3() { return cActivePartIdKeyword_3; }

		//"activeSite"
		public Keyword getActiveSiteKeyword_4() { return cActiveSiteKeyword_4; }

		//"selection"
		public Keyword getSelectionKeyword_5() { return cSelectionKeyword_5; }
	}
	
	
	private RootElements pRoot;
	private ExpressionElements pExpression;
	private CompositeExpressionElements pCompositeExpression;
	private InstanceExpressionElements pInstanceExpression;
	private AndExpressionElements pAndExpression;
	private OrExpresisonElements pOrExpresison;
	private NotExpressionElements pNotExpression;
	private IterableExpressionElements pIterableExpression;
	private WithExpressionElements pWithExpression;
	private AdaptExpressionElements pAdaptExpression;
	private EqualExpressionElements pEqualExpression;
	private OperatorElements pOperator;
	private EBooleanElements pEBoolean;
	private VariableElements pVariable;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public CoreExpressionGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.escriptmonkey.scripting.ui.expression.xtext.CoreExpression".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Root:
	//
	//	"[" expression=Expression "]";
	public RootElements getRootAccess() {
		return (pRoot != null) ? pRoot : (pRoot = new RootElements());
	}
	
	public ParserRule getRootRule() {
		return getRootAccess().getRule();
	}

	//Expression:
	//
	//	InstanceExpression | AndExpression | OrExpresison | NotExpression | IterableExpression | WithExpression |
	//
	//	AdaptExpression | EqualExpression;
	public ExpressionElements getExpressionAccess() {
		return (pExpression != null) ? pExpression : (pExpression = new ExpressionElements());
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//CompositeExpression:
	//
	//	AndExpression | OrExpresison | NotExpression | IterableExpression | AdaptExpression;
	public CompositeExpressionElements getCompositeExpressionAccess() {
		return (pCompositeExpression != null) ? pCompositeExpression : (pCompositeExpression = new CompositeExpressionElements());
	}
	
	public ParserRule getCompositeExpressionRule() {
		return getCompositeExpressionAccess().getRule();
	}

	//InstanceExpression:
	//
	//	"InstanceOf" value=STRING;
	public InstanceExpressionElements getInstanceExpressionAccess() {
		return (pInstanceExpression != null) ? pInstanceExpression : (pInstanceExpression = new InstanceExpressionElements());
	}
	
	public ParserRule getInstanceExpressionRule() {
		return getInstanceExpressionAccess().getRule();
	}

	//AndExpression:
	//
	//	{AndExpression} "And" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
	public AndExpressionElements getAndExpressionAccess() {
		return (pAndExpression != null) ? pAndExpression : (pAndExpression = new AndExpressionElements());
	}
	
	public ParserRule getAndExpressionRule() {
		return getAndExpressionAccess().getRule();
	}

	//OrExpresison:
	//
	//	{OrExpresison} "Or" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
	public OrExpresisonElements getOrExpresisonAccess() {
		return (pOrExpresison != null) ? pOrExpresison : (pOrExpresison = new OrExpresisonElements());
	}
	
	public ParserRule getOrExpresisonRule() {
		return getOrExpresisonAccess().getRule();
	}

	//NotExpression:
	//
	//	{NotExpression} "Not" "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
	public NotExpressionElements getNotExpressionAccess() {
		return (pNotExpression != null) ? pNotExpression : (pNotExpression = new NotExpressionElements());
	}
	
	public ParserRule getNotExpressionRule() {
		return getNotExpressionAccess().getRule();
	}

	//IterableExpression:
	//
	//	{IterableExpression} ifEmpty?="ifEmpty"? "Iterable" operand=Operator? "{" (expressions+=Expression (","
	//
	//	expressions+=Expression)*)? "}";
	public IterableExpressionElements getIterableExpressionAccess() {
		return (pIterableExpression != null) ? pIterableExpression : (pIterableExpression = new IterableExpressionElements());
	}
	
	public ParserRule getIterableExpressionRule() {
		return getIterableExpressionAccess().getRule();
	}

	//WithExpression:
	//
	//	"With" variable=Variable "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
	public WithExpressionElements getWithExpressionAccess() {
		return (pWithExpression != null) ? pWithExpression : (pWithExpression = new WithExpressionElements());
	}
	
	public ParserRule getWithExpressionRule() {
		return getWithExpressionAccess().getRule();
	}

	//AdaptExpression:
	//
	//	"AdaptTo" value=STRING "{" (expressions+=Expression ("," expressions+=Expression)*)? "}";
	public AdaptExpressionElements getAdaptExpressionAccess() {
		return (pAdaptExpression != null) ? pAdaptExpression : (pAdaptExpression = new AdaptExpressionElements());
	}
	
	public ParserRule getAdaptExpressionRule() {
		return getAdaptExpressionAccess().getRule();
	}

	//EqualExpression:
	//
	//	"Equal" value=STRING;
	public EqualExpressionElements getEqualExpressionAccess() {
		return (pEqualExpression != null) ? pEqualExpression : (pEqualExpression = new EqualExpressionElements());
	}
	
	public ParserRule getEqualExpressionRule() {
		return getEqualExpressionAccess().getRule();
	}

	//Operator:
	//
	//	"and" | "or";
	public OperatorElements getOperatorAccess() {
		return (pOperator != null) ? pOperator : (pOperator = new OperatorElements());
	}
	
	public ParserRule getOperatorRule() {
		return getOperatorAccess().getRule();
	}

	//EBoolean returns ecore::EBoolean:
	//
	//	"true" | "false";
	public EBooleanElements getEBooleanAccess() {
		return (pEBoolean != null) ? pEBoolean : (pEBoolean = new EBooleanElements());
	}
	
	public ParserRule getEBooleanRule() {
		return getEBooleanAccess().getRule();
	}

	//Variable:
	//
	//	"activeContexts" | "activeEditor" | "activeEditorId" | "activePartId" | "activeSite" | "selection";
	public VariableElements getVariableAccess() {
		return (pVariable != null) ? pVariable : (pVariable = new VariableElements());
	}
	
	public ParserRule getVariableRule() {
		return getVariableAccess().getRule();
	}

	//terminal ID:
	//
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
