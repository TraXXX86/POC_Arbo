package fr.euriware.poc.arbo.client.widget.copy;

import java.util.List;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fr.euriware.poc.arbo.shared.dto.LeftNodeDto;
import fr.euriware.poc.arbo.shared.resources.LeftNodesService;
import fr.euriware.poc.arbo.shared.resources.LeftNodesServiceAsync;

public class CellTreeAsyncCopy {

	// Create a CellList that uses the cell.
	public final CellTree cellTree;

	public SingleSelectionModel<LeftNodeDto> selectionModelCellTree = null;

	public TreeViewModel tvm;

	/**
	 * Launch Tree construction
	 */
	public CellTreeAsyncCopy() {

		selectionModelCellTree = new SingleSelectionModel<LeftNodeDto>();

		// Create Tree view model
		tvm = new CellTreeAsyncCopy.CustomTreeModel();

		// Create Cell tree
		cellTree = new CellTree(tvm, "Root");
	}

	/**
	 * The model that defines the nodes in the tree.
	 */
	public class CustomTreeModel implements TreeViewModel {

		/**
		 * Get the {@link NodeInfo} that provides the children of the specified value.
		 */
		@Override
		public <T> NodeInfo<?> getNodeInfo(T value) {

			// Create data provider for this node
			CustomAsyncDataProvider dataProvider = new CustomAsyncDataProvider();

			// Create Cell
			Cell<LeftNodeDto> cell = new CustomCell(dataProvider, null);

			ListDataProvider<String> test = new ListDataProvider<>();

			// Return a node info that pairs the data with a cell.
			return new DefaultNodeInfo<LeftNodeDto>(dataProvider, cell, selectionModelCellTree, null);

		}

		public void addChild(LeftNodeDto newChild) {
			System.out.println("testadd");
		}

		/**
		 * Check if the specified value represents a leaf node. Leaf nodes cannot be opened.
		 */
		public boolean isLeaf(Object value) {
			if (value instanceof LeftNodeDto) {
				return ((LeftNodeDto) value).isLeaf();
			}
			return false;
		}

	}

	/**
	 * AsyncDataprovider for this tree
	 */
	public class CustomAsyncDataProvider extends ListDataProvider<LeftNodeDto> {

		private final LeftNodesServiceAsync leftNodesService = GWT.create(LeftNodesService.class);

		@Override
		protected void onRangeChanged(final HasData<LeftNodeDto> display) {
			final Range range = display.getVisibleRange();

			leftNodesService.getNodes(new AsyncCallback<List<LeftNodeDto>>() {
				@Override
				public void onSuccess(List<LeftNodeDto> result) {
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
