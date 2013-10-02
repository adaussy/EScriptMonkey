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
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class CoreExpressionAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/escriptmonkey/scripting/ui/expression/xtext/parser/antlr/internal/InternalCoreExpression.tokens");
	}
}
