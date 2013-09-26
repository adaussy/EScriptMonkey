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
package org.eclipse.escriptmonkey.scripting.storedscript.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.escriptmonkey.scripting.debug.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.IHeaderParser;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.IMetadataParser;
import org.eclipse.escriptmonkey.scripting.storedscript.metada.Metadata;
import org.eclipse.escriptmonkey.scripting.storedscript.service.impl.StoredScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptType;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptFactory;


/**
 * Service use to parse metadata of a stored script
 * 
 * @author adaussy
 * 
 */
public class MetadaParserService {

	private static final String ID_ATTR_EXT_POINT = "id";

	private static final String TYPE_ATTR_EXT_POINT = "type";

	private static final String SCRIPT_TYPE_ATTR_EXT_POINT = "script_type";

	private static final String PARSER_CLASS_ATTR_EXT_POINT = "parser_class";

	private static final String METADATA_PARSER_EXT_POINT = "org.eclipse.escriptmonkey.scripting.storedscript.metadata";

	private static final String PARSER_ATTR_EXT_POINT = "parser";


	MetadaParserService() {
	}


	private static class SingletonHolder {

		public static final MetadaParserService INSTANCE = new MetadaParserService();
	}

	public static MetadaParserService getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public EList<ScriptMetadata> parseMetadata(IStoredScript storedScript) throws CoreException {
		IHeaderParser parser = getParserFor(storedScript.getScriptType());
		if(parser == null) {
			Logger.logError("Unable to find a metadata parser for the script " + storedScript.getUri());
			return null;
		}
		EList<ScriptMetadata> metadata = storedScript.getMetadatas();
		metadata.clear();
		String header = parser.getHeader(storedScript);
		if(header != null) {
			for(Metadata metaDef : getMetadatas()) {
				List<String> metas = metaDef.parse(header);
				if(metas != null) {
					ListIterator<String> ite = metas.listIterator();
					while(ite.hasNext()) {
						String data = (String)ite.next();
						ScriptMetadata meta = StoredscriptFactory.eINSTANCE.createScriptMetadata();
						metadata.add(meta);
						meta.setKey(metaDef.getName());
						meta.getValue().add(data);
					}
				}
			}
		}
		return metadata;
	}

	private Map<String, IHeaderParser> parsers = null;

	private Map<ScriptType, IHeaderParser> parsersFromType = null;

	private Set<Metadata> metadatas = null;





	/**
	 * @return the metadata
	 */
	public Set<Metadata> getMetadatas() {
		if(metadatas == null) {
			metadatas = new HashSet<Metadata>();
			final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(METADATA_PARSER_EXT_POINT);

			for(final IConfigurationElement e : config) {
				if("metadata".equals(e.getName())) {
					String name = e.getAttribute("name");
					Object parser;
					try {
						parser = e.createExecutableExtension("impl");
						if(parser instanceof IMetadataParser) {
							metadatas.add(new Metadata(name, (IMetadataParser)parser));
						}
					} catch (CoreException e1) {
						e1.printStackTrace();
					}
				}
			}

		}
		return metadatas;
	}

	protected void init() {
		if(parsers == null) {
			parsers = new HashMap<String, IHeaderParser>();
			parsersFromType = new HashMap<ScriptType, IHeaderParser>();
			final IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(METADATA_PARSER_EXT_POINT);

			for(final IConfigurationElement e : config) {
				if(PARSER_ATTR_EXT_POINT.equals(e.getName())) {
					String id = e.getAttribute(ID_ATTR_EXT_POINT);
					Object extension;
					try {
						extension = e.createExecutableExtension(PARSER_CLASS_ATTR_EXT_POINT);
						if(extension instanceof IHeaderParser) {
							IHeaderParser parser = (IHeaderParser)extension;
							parsers.put(id, parser);
							for(IConfigurationElement child : e.getChildren(SCRIPT_TYPE_ATTR_EXT_POINT)) {
								String type = child.getAttribute(TYPE_ATTR_EXT_POINT);
								ScriptType scriptType = StoredScriptService.getInstance().getScriptType(type);
								if(scriptType == null) {
									Logger.logError("[Metadata parser] The reference script type with the id " + type + " is uncorrect");
								} else {
									/*
									 * TODO Should be improve to use priority
									 */
									parsersFromType.put(scriptType, parser);
								}
							}
						}
					} catch (CoreException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}


	public IHeaderParser getParserFor(ScriptType type) {
		if(type != null) {
			if(parsersFromType == null) {
				init();
			}
			return parsersFromType.get(type);
		}
		return null;
	}

	public Set<IHeaderParser> getParsers() {
		if(parsers == null) {
			init();
		}
		return Collections.unmodifiableSet(new HashSet<IHeaderParser>(parsers.values()));
	}
}
