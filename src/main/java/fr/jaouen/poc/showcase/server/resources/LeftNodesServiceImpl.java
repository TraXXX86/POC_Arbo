package fr.jaouen.poc.showcase.server.resources;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.jaouen.poc.showcase.shared.dto.LeftNodeDto;
import fr.jaouen.poc.showcase.shared.resources.LeftNodesService;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LeftNodesServiceImpl extends RemoteServiceServlet implements LeftNodesService {

	public List<LeftNodeDto> getNodes() {
		List<LeftNodeDto> result = new ArrayList<>();

		for (int i = 1; i < 1000; i++) {
			result.add(new LeftNodeDto("Node " + i));
		}

		return result;
	}

}
