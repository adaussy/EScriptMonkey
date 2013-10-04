/***********************************************************************************************************************
 * Copyright (c) 2009,2010 TOPCASED consortium.
 * 
 * All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Sebastien GABEL (CS) - initial API and implementation
 *               Pierre Gaufillet (Airbus) - fix bug [#4119]
 * 
 **********************************************************************************************************************/
package org.eclipse.escriptmonkey.scripting.integration.modeling;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * Defines a basic utility class for working around EMF markers.
 * 
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 * @since Topcased 2.4.0
 */
public final class EMFMarkerUtil {

	/**
	 * Constructor
	 */
	private EMFMarkerUtil() {
		// prevent from instanciation
	}

	/**
	 * Adds a marker for a given {@link EObject}. Message and severity level are expected.
	 * 
	 * @param toLog
	 *        An eObject for which an EMF marker must be added
	 * @param message
	 *        The content of the marker to log into the Problem View or the Marker View.
	 * @param severity
	 *        The level of severity
	 * @throws CoreException
	 *         If the marker cannot be added because of a null resource.
	 */
	public static void addMarkerFor(EObject toLog, String message, int severity) throws CoreException {
		// find the concerned element.
		IResource resource = findResourceFor(toLog);
		if(resource != null) {
			IMarker marker = resource.createMarker(EValidator.MARKER);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(EValidator.URI_ATTRIBUTE, EcoreUtil.getURI(toLog).toString());
			marker.setAttribute(IMarker.MESSAGE, message);
		} else {
			StringBuffer uriMessage = new StringBuffer();
			if(toLog.eResource() != null && toLog.eResource().getURI() != null) {
				URI uri = toLog.eResource().getURI();
				uriMessage.append(" ").append(uri.toString());
				if(uri.isFile() || uri.isPlatform()) {
					IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR, "Cannot create marker for resource" + uriMessage.toString(), null); //$NON-NLS-1$
					throw new CoreException(status);
				}
			}
		}
	}

	/**
	 * Removes all EMF markers for a specific model object.
	 * 
	 * @param toRemove
	 *        The eObject for which a marker must be removed.
	 * @throws CoreException
	 *         If the marker cannot be removed because of a null resource.
	 */
	public static void removeMarkerFor(EObject toRemove) throws CoreException {
		IResource resource = findResourceFor(toRemove);
		if(resource != null) {
			for(IMarker marker : resource.findMarkers(EValidator.MARKER, false, IResource.DEPTH_INFINITE)) {
				String markerUri = (String)marker.getAttribute(EValidator.URI_ATTRIBUTE);
				if(markerUri != null && markerUri.equals(EcoreUtil.getURI(toRemove).toString())) {
					marker.delete();
				}
			}
		} else {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot delete marker from a null resource"); //$NON-NLS-1$
			throw new CoreException(status);
		}
	}

	/**
	 * Removes all EMF markers for the whole of an EMF resource.
	 * 
	 * @param resource
	 *        The {@link Resource} for which all EMF Markers must be removed.
	 * @throws CoreException
	 *         If the marker cannot be removed because of a null resource.
	 */
	public static void removeAllMarkersFor(Resource resource) throws CoreException {
		IResource file = findResourceFor(resource);
		if(file != null) {
			for(IMarker marker : file.findMarkers(EValidator.MARKER, false, IResource.DEPTH_INFINITE)) {
				marker.delete();
			}
		} else {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Cannot delete markers from a null resource"); //$NON-NLS-1$
			throw new CoreException(status);
		}
	}

	/**
	 * Finds a IResource for an EObject.
	 * 
	 * @param toResolve
	 *        The {@link EObject} for which the corresponding IResource must be found.
	 * @return The IResource that must be often a IFile contained in the workspace
	 */
	public static IResource findResourceFor(EObject toResolve) {
		return findResourceFor(toResolve.eResource());
	}

	/**
	 * Finds a IResource for a Resource contained into the workspace.
	 * 
	 * @param toResolve
	 *        The {@link Resource} for which the corresponding IResource must be found.
	 * @return The IResource that must be often a IFile contained in the workspace
	 */
	private static IResource findResourceFor(Resource toResolve) {
		if(toResolve != null) {
			String relativePath = toResolve.getURI().toPlatformString(true);
			if(relativePath != null) {
				return ResourcesPlugin.getWorkspace().getRoot().findMember(relativePath);
			}
		}
		return null;
	}
}
