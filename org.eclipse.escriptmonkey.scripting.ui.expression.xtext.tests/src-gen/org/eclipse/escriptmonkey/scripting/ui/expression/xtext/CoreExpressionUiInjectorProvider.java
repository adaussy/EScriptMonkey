/*
* generated by Xtext
*/
package org.eclipse.escriptmonkey.scripting.ui.expression.xtext;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class CoreExpressionUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return org.eclipse.escriptmonkey.scripting.ui.expression.xtext.ui.internal.CoreExpressionActivator.getInstance().getInjector("org.eclipse.escriptmonkey.scripting.ui.expression.xtext.CoreExpression");
	}
	
}
