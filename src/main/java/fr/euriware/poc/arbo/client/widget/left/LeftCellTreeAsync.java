package fr.euriware.poc.arbo.client.widget.left;

import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.TreeViewModel;

import fr.euriware.poc.arbo.shared.resources.LeftNodesService;
import fr.euriware.poc.arbo.shared.resources.LeftNodesServiceAsync;

public class LeftCellTreeAsync {

	// Create a cell to render each value in the list.
	TextCell textCell = new TextCell();

	// Create a CellList that uses the cell.
	public final CellTree cellTree;

	public LeftCellTreeAsync() {

		TreeViewModel tvm = new LeftCellTreeAsync.CustomTreeModel();

		cellTree = new CellTree(tvm, "Item 1");

	}

	/**
	 * The model that defines the nodes in the tree.
	 */
	public class CustomTreeModel implements TreeViewModel {

		/**
		 * Get the {@link NodeInfo} that provides the children of the specified value.
		 */
		public <T> NodeInfo<?> getNodeInfo(T value) {

			CustomAsyncDataProvider dataProvider = new CustomAsyncDataProvider();

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

	public class CustomAsyncDataProvider extends AsyncDataProvider<String> {

		private final LeftNodesServiceAsync leftNodesService = GWT.create(LeftNodesService.class);

		@Override
		protected void onRangeChanged(final HasData<String> display) {
			final Range range = display.getVisibleRange();

			leftNodesService.getNodes(new AsyncCallback<List<String>>() {
				@Override
				public void onSuccess(List<String> result) {
					int start = range.getStart();
					display.setRowData(start, result);
					Range newRange = new Range(start, result.size());
					display.setVisibleRangeAndClearData(newRange, false);
					// updateRowCount(result.size(), true);
					updateRowData(start, result);

				}

				@Override
				public void onFailure(Throwable caught) {
					System.err.println("Erreur");
				}
			});
		}
	}

}
