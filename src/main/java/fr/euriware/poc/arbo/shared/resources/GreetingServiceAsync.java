package fr.euriware.poc.arbo.shared.resources;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	// void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void test(AsyncCallback<String> callback);
}
