package fr.euriware.poc.arbo.client.gquery.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.euriware.poc.arbo.client.ClientFactory;
import fr.euriware.poc.arbo.client.gquery.view.GqueryView;
import fr.euriware.poc.arbo.client.gquery.view.impl.GqueryViewImpl;

public class GqueryActivity extends AbstractActivity implements GqueryView.GqueryPresenter {

	ClientFactory clientFactory;

	public GqueryActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	private GqueryViewImpl view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		// Create View if not exists
		view = new GqueryViewImpl();

		// Set Presenter
		view.setPresenter(this);

		// Set view on main page
		panel.setWidget(view);

		view.launchTest();

		// Test
		// view.addValues("Salut", "Bonjour", "Yo");

	}

}
