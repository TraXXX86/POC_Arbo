/**
 * 
 */
package fr.euriware.poc.arbo.client.mapper;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

import fr.euriware.poc.arbo.client.ClientFactory;
import fr.euriware.poc.arbo.client.main.place.MainPlace;

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
			return clientFactory.getGqueryActivity();
		}
		return clientFactory.getMainActivity();
	}
}
