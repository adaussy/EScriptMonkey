package org.eclipse.escriptmonkey.scripting.storedscript.metada;

import org.eclipse.emf.common.util.EList;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;


public class AbstractMetadataUtils {

	protected static String getUniqueMeta(IStoredScript script, String key) {
		if(script != null) {
			EList<ScriptMetadata> metas = script.getMetadatas();
			for(ScriptMetadata s : metas) {
				if(key.equals(s.getKey())) {
					EList<String> v = s.getValue();
					if(!v.isEmpty()) {
						return v.get(0);
					} else {
						return null;
					}
				}
			}
		}
		return null;
	}

}
