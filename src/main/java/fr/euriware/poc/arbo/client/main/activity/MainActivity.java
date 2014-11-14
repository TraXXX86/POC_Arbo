package fr.euriware.poc.arbo.client.main.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.euriware.poc.arbo.client.ClientFactory;
import fr.euriware.poc.arbo.client.main.view.MainView;
import fr.euriware.poc.arbo.client.main.view.impl.MainViewImpl;

public class MainActivity extends AbstractActivity implements MainView.MainPresenter {

	ClientFactory clientFactory;

	public MainActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	private MainViewImpl view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		// Create View if not exists
		view = new MainViewImpl();

		// Set Presenter
		view.setPresenter(this);

		// Set view on main page
		panel.setWidget(view);

		// Test
		view.addValues("Salut", "Bonjour", "Yo");

	}

}
