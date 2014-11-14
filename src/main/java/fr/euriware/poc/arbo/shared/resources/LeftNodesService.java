package fr.euriware.poc.arbo.shared.resources;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.euriware.poc.arbo.shared.dto.LeftNodeDto;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("leftnodes")
public interface LeftNodesService extends RemoteService {
	// String greetServer(String name) throws IllegalArgumentException;

	List<LeftNodeDto> getNodes();
}
