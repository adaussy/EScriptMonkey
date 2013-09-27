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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AdaptExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.AndExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.CoreexpressionPackage;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.EqualExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.InstanceExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.IterableExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.NotExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.OrExpresison;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Root;
import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.WithExpression;
import org.eclipse.escriptmonkey.scripting.ui.expression.xtext.services.CoreExpressionGrammarAccess;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractCoreExpressionSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private CoreExpressionGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == CoreexpressionPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case CoreexpressionPackage.ADAPT_EXPRESSION:
				if(context == grammarAccess.getAdaptExpressionRule() ||
				   context == grammarAccess.getCompositeExpressionRule() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_AdaptExpression(context, (AdaptExpression) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.AND_EXPRESSION:
				if(context == grammarAccess.getAndExpressionRule() ||
				   context == grammarAccess.getCompositeExpressionRule() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_AndExpression(context, (AndExpression) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.EQUAL_EXPRESSION:
				if(context == grammarAccess.getEqualExpressionRule() ||
				   context == grammarAccess.getExpressionRule()) {
					sequence_EqualExpression(context, (EqualExpression) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.INSTANCE_EXPRESSION:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getInstanceExpressionRule()) {
					sequence_InstanceExpression(context, (InstanceExpression) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.ITERABLE_EXPRESSION:
				if(context == grammarAccess.getCompositeExpressionRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIterableExpressionRule()) {
					sequence_IterableExpression(context, (IterableExpression) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.NOT_EXPRESSION:
				if(context == grammarAccess.getCompositeExpressionRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getNotExpressionRule()) {
					sequence_NotExpression(context, (NotExpression) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.OR_EXPRESISON:
				if(context == grammarAccess.getCompositeExpressionRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getOrExpresisonRule()) {
					sequence_OrExpresison(context, (OrExpresison) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.ROOT:
				if(context == grammarAccess.getRootRule()) {
					sequence_Root(context, (Root) semanticObject); 
					return; 
				}
				else break;
			case CoreexpressionPackage.WITH_EXPRESSION:
				if(context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getWithExpressionRule()) {
					sequence_WithExpression(context, (WithExpression) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (value=STRING (expressions+=Expression expressions+=Expression*)?)
	 */
	protected void sequence_AdaptExpression(EObject context, AdaptExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((expressions+=Expression expressions+=Expression*)?)
	 */
	protected void sequence_AndExpression(EObject context, AndExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_EqualExpression(EObject context, EqualExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoreexpressionPackage.Literals.VALUED_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoreexpressionPackage.Literals.VALUED_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEqualExpressionAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=STRING
	 */
	protected void sequence_InstanceExpression(EObject context, InstanceExpression semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoreexpressionPackage.Literals.VALUED_EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoreexpressionPackage.Literals.VALUED_EXPRESSION__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getInstanceExpressionAccess().getValueSTRINGTerminalRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ifEmpty?='ifEmpty'? operand=Operator? (expressions+=Expression expressions+=Expression*)?)
	 */
	protected void sequence_IterableExpression(EObject context, IterableExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((expressions+=Expression expressions+=Expression*)?)
	 */
	protected void sequence_NotExpression(EObject context, NotExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((expressions+=Expression expressions+=Expression*)?)
	 */
	protected void sequence_OrExpresison(EObject context, OrExpresison semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     expression=Expression
	 */
	protected void sequence_Root(EObject context, Root semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, CoreexpressionPackage.Literals.ROOT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CoreexpressionPackage.Literals.ROOT__EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getRootAccess().getExpressionExpressionParserRuleCall_1_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (variable=Variable (expressions+=Expression expressions+=Expression*)?)
	 */
	protected void sequence_WithExpression(EObject context, WithExpression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
