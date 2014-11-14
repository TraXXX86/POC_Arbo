package fr.euriware.poc.arbo.client.widget.left;

import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.TreeViewModel;

import fr.euriware.poc.arbo.shared.resources.LeftNodesService;
import fr.euriware.poc.arbo.shared.resources.LeftNodesServiceAsync;

public class LeftCellTree {

	/**
	 * The model that defines the nodes in the tree.
	 */
	public static class CustomTreeModel implements TreeViewModel {

		/**
		 * Create a remote service proxy to talk to the server-side Greeting service.
		 */
		private final LeftNodesServiceAsync leftNodesService = GWT.create(LeftNodesService.class);

		/**
		 * Get the {@link NodeInfo} that provides the children of the specified value.
		 */
		public <T> NodeInfo<?> getNodeInfo(T value) {
			/*
			 * Create some data in a data provider. Use the parent value as a prefix for the next level.
			 */
			final ListDataProvider<String> dataProvider = new ListDataProvider<String>();

			leftNodesService.getNodes(new AsyncCallback<List<String>>() {
				@Override
				public void onSuccess(List<String> result) {
					dataProvider.getList().addAll(result);
					dataProvider.refresh();
				}

				@Override
				public void onFailure(Throwable caught) {
					System.err.println("Erreur");
				}
			});

			// for (int i = 0; i < 1000; i++) {
			// dataProvider.getList().add(value + "." + String.valueOf(i));
			// }

			// Return a node info that pairs the data with a cell.
			return new DefaultNodeInfo<String>(dataProvider, new TextCell());
		}

		/**
		 * Check if the specified value represents a leaf node. Leaf nodes cannot be opened.
		 */
		public boolean isLeaf(Object value) {
			// The maximum length of a value is ten characters.
			return value.toString().length() > 100;
		}
	}

}
