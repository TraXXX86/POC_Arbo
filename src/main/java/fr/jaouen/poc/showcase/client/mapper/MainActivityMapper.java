/**
 * 
 */
package fr.jaouen.poc.showcase.client.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import fr.jaouen.poc.showcase.client.ClientFactory;
import fr.jaouen.poc.showcase.client.gquery.place.GqueryPlace;
import fr.jaouen.poc.showcase.client.tree.place.MainPlace;

/**
 * @author majaouen
 * 
 */
public class MainActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public MainActivityMapper(final ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	/**
	 * Check if this is the first activity to launch
	 * 
	 * @return
	 */
	public boolean isStartFirstActivity() {
		return startFirstActivity;
	}

	/**
	 * Keep if we have ever launch first activity
	 */
	private boolean startFirstActivity = false;

	/**
	 * Get activity
	 */
	public Activity getActivity(final Place place) {
		startFirstActivity = true;
		if (place instanceof MainPlace || place == Place.NOWHERE) {
			return clientFactory.getMainActivity();
		} else if (place instanceof GqueryPlace) {
			return clientFactory.getGqueryActivity();
		}
		return clientFactory.getMainActivity();
	}
}
