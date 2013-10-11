package org.eclipse.escriptmonkey.scripting.ui.metadata;

import java.util.regex.Pattern;

import org.eclipse.escriptmonkey.scripting.storedscript.metada.AbstractRegexMetadataParser;


public class EffectiveScriptGenerationMetadata extends AbstractRegexMetadataParser {

	public EffectiveScriptGenerationMetadata() {
	}

	@Override
	protected Pattern createPattern() {
		return Pattern.compile("GenerateInjectedCodeFile:\\s*(.*)");
	}


}
