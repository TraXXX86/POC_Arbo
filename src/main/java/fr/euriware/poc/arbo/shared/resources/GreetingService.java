package fr.euriware.poc.arbo.shared.resources;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("test")
public interface GreetingService extends RemoteService {
	// String greetServer(String name) throws IllegalArgumentException;

	String test();
}
