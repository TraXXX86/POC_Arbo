package fr.euriware.poc.arbo.client.main.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import fr.euriware.poc.arbo.client.ClientFactory;
import fr.euriware.poc.arbo.client.main.view.MainView;
import fr.euriware.poc.arbo.client.main.view.impl.MainViewImpl;
import fr.euriware.poc.arbo.shared.resources.GreetingService;
import fr.euriware.poc.arbo.shared.resources.GreetingServiceAsync;

public class MainActivity extends AbstractActivity implements MainView.MainPresenter {

	ClientFactory clientFactory;

	public MainActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	private MainViewImpl view;

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {

		// Create View if not exists
		view = new MainViewImpl();

		// Set Presenter
		view.setPresenter(this);

		// Set view on main page
		panel.setWidget(view);

		view.addValues("Salut", "Bonjour", "Yo");

		greetingService.test(new AsyncCallback<String>() {

			@Override
			public void onSuccess(String result) {
				view.addValues(result);

			}

			@Override
			public void onFailure(Throwable caught) {
				System.err.println("Erreur");

			}
		});

	}

}
