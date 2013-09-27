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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext;

import org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Operator;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;


public class Converter extends DefaultTerminalConverters {

	@ValueConverter(rule = "Operator")
	public IValueConverter<Operator> Operator() {
		return new IValueConverter<Operator>() {

			public String toString(Operator value) {
				return value.getLiteral();
			}

			@Override
			public Operator toValue(String string, INode node) throws ValueConverterException {
				if(string != null) {
					return Operator.get(string);
				}
				return null;
			}
		};
	}

	@ValueConverter(rule = "Variable")
	public IValueConverter<org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable> Variable() {
		return new IValueConverter<org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable>() {

			public String toString(org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable value) {
				return value.getLiteral();
			}

			@Override
			public org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable toValue(String string, INode node) throws ValueConverterException {
				if(string != null) {
					return org.eclipse.escriptmonkey.scripting.ui.expression.coreexpression.Variable.get(string);
				}
				return null;
			}
		};
	}
}
