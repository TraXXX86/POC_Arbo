package fr.euriware.poc.arbo.client.widget.copy;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fr.euriware.poc.arbo.shared.dto.LeftNodeDto;

public class CellTreePaste {

	// Create a CellList that uses the cell.
	public final CellTree cellTree;

	public SingleSelectionModel<LeftNodeDto> selectionModelCellTree;

	public TreeViewModel tvm;

	public CellTreePaste() {
		selectionModelCellTree = new SingleSelectionModel<LeftNodeDto>();

		// Create Tree view model
		tvm = new CellTreePaste.CustomTreeModel();

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
		public <T> NodeInfo<?> getNodeInfo(T value) {
			/*
			 * Create some data in a data provider. Use the parent value as a prefix for the next level.
			 */
			ListDataProvider<LeftNodeDto> dataProvider = new ListDataProvider<LeftNodeDto>();
			for (int i = 0; i < 5; i++) {
				dataProvider.getList().add(new LeftNodeDto("Copy Node " + String.valueOf(i)));
			}

			Cell<LeftNodeDto> cell = new CustomCell(dataProvider, null);

			// Return a node info that pairs the data with a cell.
			return new DefaultNodeInfo<LeftNodeDto>(dataProvider, cell, selectionModelCellTree, null);
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
