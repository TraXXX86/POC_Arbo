package fr.euriware.poc.arbo.client.widget.left;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.TreeViewModel;

import fr.euriware.poc.arbo.shared.dto.LeftNodeDto;
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
		@Override
		public <T> NodeInfo<?> getNodeInfo(T value) {

			CustomAsyncDataProvider dataProvider = new CustomAsyncDataProvider();

			Cell<LeftNodeDto> cell = new AbstractCell<LeftNodeDto>() {
				@Override
				public void render(Context context, LeftNodeDto value, SafeHtmlBuilder sb) {
					if (value != null) {
						sb.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(CustomImageResource.instance.iconTest()).getHTML() + " " + value.getLabel()));
					}
				}
			};

			// Return a node info that pairs the data with a cell.
			return new DefaultNodeInfo<LeftNodeDto>(dataProvider, cell);
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

	public interface CustomImageResource extends ClientBundle {

		public static final CustomImageResource instance = GWT.create(CustomImageResource.class);

		@Source("iconTest.png")
		ImageResource iconTest();

	}

	public class CustomAsyncDataProvider extends AsyncDataProvider<LeftNodeDto> {

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
