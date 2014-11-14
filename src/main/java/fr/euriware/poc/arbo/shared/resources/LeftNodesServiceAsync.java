package fr.euriware.poc.arbo.shared.resources;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LeftNodesServiceAsync {
	// void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void getNodes(AsyncCallback<List<String>> callback);
}
