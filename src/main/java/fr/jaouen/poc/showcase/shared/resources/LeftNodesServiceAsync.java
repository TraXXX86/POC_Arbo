package fr.jaouen.poc.showcase.shared.resources;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.jaouen.poc.showcase.shared.dto.LeftNodeDto;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface LeftNodesServiceAsync {
	// void greetServer(String input, AsyncCallback<String> callback) throws IllegalArgumentException;

	void getNodes(AsyncCallback<List<LeftNodeDto>> callback);
}
