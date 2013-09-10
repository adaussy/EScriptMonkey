package org.eclipse.escriptmonkey.scripting.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.escriptmonkey.scripting.debug.Logger;
import org.eclipse.escriptmonkey.scripting.storedscript.notification.IStoredScriptListener;
import org.eclipse.escriptmonkey.scripting.storedscript.service.StoredScriptService;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.IStoredScript;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.ScriptMetadata;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredScriptRegistry;
import org.eclipse.escriptmonkey.scripting.storedscript.storedscript.StoredscriptPackage;
import org.eclipse.escriptmonkey.scripting.ui.metadata.UIMetadataUtils;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.Root;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.ScriptuigraphFactory;
import org.eclipse.escriptmonkey.scripting.ui.scriptuigraph.StoredScriptUI;


public class ScriptGraphService implements IStoredScriptListener {

	private static class SingletonHolder {

		public static ScriptGraphService INSTANCE = new ScriptGraphService();
	}

	public static ScriptGraphService getInstance() {
		return SingletonHolder.INSTANCE;
	}


	protected ScriptGraphService() {
	}

	private Root root = null;

	private ResourceSet resourceSet;


	/**
	 * @return the resourceSet
	 */
	public ResourceSet getResourceSet() {
		if(resourceSet == null) {
			init();
		}
		return resourceSet;
	}


	public Root getScriptGraph() {
		if(root == null) {
			init();
		}
		return root;
	}


	protected void init() {
		StoredScriptService.getInstance().addListener(this);
		resourceSet = new ResourceSetImpl();
		ResourceImpl r = new ResourceImpl();
		resourceSet.getResources().add(r);
		root = ScriptuigraphFactory.eINSTANCE.createRoot();
		r.getContents().add(root);
		Set<IStoredScript> storeScripts = StoredScriptService.getInstance().getStoredScript();
		for(IStoredScript s : storeScripts) {
			addUIScript(s);
		}

	}

	private Map<IStoredScript, StoredScriptUI> map = new HashMap<IStoredScript, StoredScriptUI>();

	@Override
	public void scriptChange(Notification scriptNotif) {
		System.out.println("toto");
		Object notifier = scriptNotif.getNotifier();
		if(notifier instanceof StoredScriptRegistry) {
			StoredScriptRegistry registry = (StoredScriptRegistry)notifier;
			if(StoredscriptPackage.Literals.STORED_SCRIPT_REGISTRY__SCRIPTS.equals(scriptNotif.getFeature())) {
				if(Notification.ADD == scriptNotif.getEventType()) {
					addUIScript((IStoredScript)scriptNotif.getNewValue());
				} else if(Notification.REMOVE == scriptNotif.getEventType()) {
					addUIScript((IStoredScript)scriptNotif.getOldValue());
				}
			}
		} else if(notifier instanceof ScriptMetadata) {
			ScriptMetadata notif = (ScriptMetadata)notifier;
			if(StoredscriptPackage.Literals.SCRIPT_METADATA__VALUE.equals(scriptNotif.getFeature())) {
				IStoredScript script = notif.getScript();
				removeUIScript(script);
				addUIScript(script);
			}
		}


	}

	private void removeUIScript(IStoredScript script) {
		StoredScriptUI node2 = map.get(script);
		if(node2 == null) {
			Logger.logError("No UI element for " + script.getUri());
			return;
		}
		getScriptGraph().removeScript(node2);
		map.remove(script);
	}

	private void addUIScript(IStoredScript script) {
		if(script == null) {
			Logger.logError("No script in registry for " + script.getUri());
		}
		List<String> menus = UIMetadataUtils.getMenu(script);
		StoredScriptUI node = getScriptGraph().addScript(new BasicEList<String>(menus));
		map.put(script, node);
	}





}
