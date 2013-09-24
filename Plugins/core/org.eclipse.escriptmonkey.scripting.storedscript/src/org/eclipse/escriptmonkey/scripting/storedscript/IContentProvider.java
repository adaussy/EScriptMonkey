package org.eclipse.escriptmonkey.scripting.storedscript;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;


public interface IContentProvider {

	public URI createURI();

	public String getContent() throws CoreException, IOException;

	public InputStream getInputStream() throws IOException;

}
