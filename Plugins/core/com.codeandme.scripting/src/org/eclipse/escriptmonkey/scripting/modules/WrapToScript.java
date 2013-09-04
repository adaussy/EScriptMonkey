/*******************************************************************************
 * Copyright (c) 2013 Christian Pontesegger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christian Pontesegger - initial API and implementation
 *******************************************************************************/
package org.eclipse.escriptmonkey.scripting.modules;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation indicating that the annotated method should be wrapped to JavaScript. AbstractJavaScriptModule is a base class that performs auto wrapping for
 * methods annotated this way. Wrappers add JavaScript code that automatically calls the annotated Java method.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface WrapToScript {
    /** Delimiter for alias names. */
    String DELIMITER = ";";

    /**
     * Indicates that the method will be visible to online help. Defaults to <code>true</code>.
     */
    boolean visible() default true;

    /**
     * Defines alias names for the same command. Names are delimited by ";"
     */
    String alias() default "";
}
