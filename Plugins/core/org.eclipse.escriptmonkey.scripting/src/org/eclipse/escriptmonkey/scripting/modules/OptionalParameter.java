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
package org.eclipse.escriptmonkey.scripting.modules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Annotation used to define optional parameter in modules. This annotation has to be used with a parameter defining a default value
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.PARAMETER })
public @interface OptionalParameter {

	String defaultValue() default "null";


	public static class OptionalParameterHelper {

		protected static String getDefaultValue(OptionalParameter in) {
			String defaultValue = in.defaultValue();
			if(defaultValue == null) {
				try {
					Method method = OptionalParameter.class.getMethod("defaultValue", null);
					Object defaultV = method.getDefaultValue();
					if(defaultV instanceof String) {
						defaultValue = (String)defaultV;
					}
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
			}
			return defaultValue;
		}

		public static Object getDefaultValue(OptionalParameter in, Class<?> type) {
			String defaultValue = getDefaultValue(in);
			if(defaultValue == null || "null".equals(defaultValue)) {
				return null;
			}
			if(Integer.class.isAssignableFrom(type)) {
				return Integer.getInteger(defaultValue);
			} else if(String.class.isAssignableFrom(type)) {
				return defaultValue;
			} else if(Boolean.class.isAssignableFrom(type)) {
				return Boolean.getBoolean(defaultValue);
			}
			return null;
		}
	}
}
