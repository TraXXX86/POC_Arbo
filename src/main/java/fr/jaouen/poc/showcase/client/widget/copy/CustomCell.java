package fr.jaouen.poc.showcase.client.widget.copy;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.view.client.ListDataProvider;

import fr.jaouen.poc.showcase.client.widget.copy.CellTreeAsyncCopy.CustomAsyncDataProvider;
import fr.jaouen.poc.showcase.shared.dto.LeftNodeDto;

public class CustomCell extends AbstractCell<LeftNodeDto> {

	CustomAsyncDataProvider dataProvider;
	ListDataProvider<LeftNodeDto> listDataProvider;

	public CustomCell(CustomAsyncDataProvider dataProvider, String... consumedEvents) {
		super(consumedEvents);
		this.dataProvider = dataProvider;
	}

	public CustomCell(ListDataProvider<LeftNodeDto> listDataProvider, String... consumedEvents) {
		super(consumedEvents);
		this.listDataProvider = listDataProvider;
	}

	public ListDataProvider<LeftNodeDto> getListDataProvider() {
		return listDataProvider;
	}

	public CustomAsyncDataProvider getDataProvider() {
		return dataProvider;
	}

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, LeftNodeDto value, SafeHtmlBuilder sb) {
		if (value != null) {
			sb.append(SafeHtmlUtils.fromTrustedString(AbstractImagePrototype.create(CustomImageResource.instance.iconTest()).getHTML() + " " + value.getLabel()));
		}
	}

	/**
	 * Image to use into this tree
	 */
	public interface CustomImageResource extends ClientBundle {

		public static final CustomImageResource instance = GWT.create(CustomImageResource.class);

		@Source("iconTest.png")
		ImageResource iconTest();

	}

}