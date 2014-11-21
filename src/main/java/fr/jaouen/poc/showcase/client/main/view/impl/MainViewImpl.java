package fr.jaouen.poc.showcase.client.main.view.impl;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.TreeViewModel.NodeInfo;

import fr.jaouen.poc.showcase.client.main.activity.MainActivity;
import fr.jaouen.poc.showcase.client.main.view.MainView;
import fr.jaouen.poc.showcase.client.widget.copy.CellTreeAsyncCopy;
import fr.jaouen.poc.showcase.client.widget.copy.CellTreePaste;
import fr.jaouen.poc.showcase.client.widget.copy.CustomCell;
import fr.jaouen.poc.showcase.shared.dto.LeftNodeDto;

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

	// ##########################################

	public MainViewImpl() {

		createTrees();

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
	void onClickbtnReturn(ClickEvent e) {
		lblUser.setText(txtBoxTest.getText());
	}

	@UiField
	Button btnPeuple;

	@UiHandler("btnPeuple")
	void onClickBtnPeuple(ClickEvent e) {
		if (copyNodeFromTreeToTree(leftTree, rightTree)) {
			System.out.println("Copy OK");
		}
	}

	// ##########################################

	@UiField(provided = true)
	CellTree leftTree;
	CellTreeAsyncCopy leftAsync;

	@UiField(provided = true)
	CellTree rightTree;
	CellTreePaste rightAsync;

	// CellTreeAsyncCopyPaste rightAsync;

	private void createTrees() {
		// Create Left tree
		// LeftCellTreeAsync leftAsync = new LeftCellTreeAsync();
		// leftTree = leftAsync.cellTree;

		// Create Left tree
		leftAsync = new CellTreeAsyncCopy();
		leftTree = leftAsync.cellTree;

		// Create right tree
		rightAsync = new CellTreePaste();
		rightTree = rightAsync.cellTree;
	}

	private boolean copyNodeFromTreeToTree(CellTree leftTree, CellTree rightTree) {
		LeftNodeDto leftDto = leftAsync.selectionModelCellTree.getSelectedObject();
		LeftNodeDto rightDto = rightAsync.selectionModelCellTree.getSelectedObject();
		NodeInfo<?> rightNode = rightAsync.tvm.getNodeInfo(rightDto);
		CustomCell cell = (CustomCell) rightNode.getCell();

		cell.getListDataProvider().flush();
		cell.getListDataProvider().refresh();

		return cell.getListDataProvider().getList().add(leftDto);
	}
}
