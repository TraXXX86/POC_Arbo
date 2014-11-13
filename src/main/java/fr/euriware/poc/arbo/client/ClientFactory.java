package fr.euriware.poc.arbo.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;

import fr.euriware.poc.arbo.client.main.activity.MainActivity;

public class ClientFactory {

	/**
	 * Bus d'évenements
	 */
	private static final EventBus EVENTBUS = new SimpleEventBus();

	/**
	 * Contrôleur de Place
	 */
	private static final PlaceController PLACECONTROLLER = new PlaceController(EVENTBUS);

	/**
	 * Singleton de ClientFactory
	 */
	private static ClientFactory singletonClientFactory;

	/**
	 * Récupération du ClientFactory
	 * 
	 * @return
	 */
	public static ClientFactory getClientFactory() {
		if (singletonClientFactory == null) {
			singletonClientFactory = GWT.create(ClientFactory.class);
		}
		return singletonClientFactory;
	}

	/**
	 * Récupération du Bus d'évenements
	 */
	public EventBus getEventBus() {
		return EVENTBUS;
	}

	/**
	 * Récupération du Contrôleur de Place
	 */
	public PlaceController getPlaceController() {
		return PLACECONTROLLER;
	}

	/**
	 * Start Main activity
	 */
	private MainActivity mainActivity;

	/**
	 * Get Main activity
	 * 
	 * @param place
	 * @param clientFactory
	 * 
	 * @return
	 */
	public MainActivity getMainActivity() {
		if (mainActivity == null) {
			mainActivity = new MainActivity(this);
		}
		return mainActivity;
	}

}
