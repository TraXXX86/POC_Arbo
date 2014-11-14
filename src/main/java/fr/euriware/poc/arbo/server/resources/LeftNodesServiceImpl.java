package fr.euriware.poc.arbo.server.resources;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.euriware.poc.arbo.shared.resources.LeftNodesService;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LeftNodesServiceImpl extends RemoteServiceServlet implements LeftNodesService {

	public List<String> getNodes() {
		List<String> result = new ArrayList<>();

		for (int i = 1; i < 5000; i++) {
			result.add("Node : " + i);
		}

		return result;
	}

}
