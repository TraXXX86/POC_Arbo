package fr.euriware.poc.arbo.client.main.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fr.euriware.poc.arbo.client.main.activity.MainActivity;
import fr.euriware.poc.arbo.client.main.view.MainView;

public class MainViewImpl extends Composite implements MainView {

	// ########################################## MVP elements

	private static MainViewUiBinder uiBinder = GWT.create(MainViewUiBinder.class);

	@UiTemplate("MainView.ui.xml")
	interface MainViewUiBinder extends UiBinder<Widget, MainViewImpl> {
	}

	@Override
	public void setPresenter(MainActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	private MainActivity mainActivity;

	// ########################################## User Name

	public MainViewImpl() {
		// Init graphical element with UiBinder
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiField
	Label lblUser;

	@UiField
	ListBox listBoxTest;

	@Override
	public void addValues(String... values) {
		for (String value : values) {
			listBoxTest.addItem(value);
		}
	}

	@UiField
	TextBox txtBoxTest;

	@UiField
	Button btnReturn;

	@UiHandler("btnReturn")
	void onClickInit(ClickEvent e) {
		lblUser.setText(txtBoxTest.getText());
	}
}
