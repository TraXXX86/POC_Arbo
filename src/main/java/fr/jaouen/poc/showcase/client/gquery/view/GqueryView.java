package fr.jaouen.poc.showcase.client.gquery.view;

import com.google.gwt.user.client.ui.IsWidget;

import fr.jaouen.poc.showcase.client.gquery.activity.GqueryActivity;

public interface GqueryView extends IsWidget {

	/* Methods available from view to activity */

	public interface GqueryPresenter {

	}

	/* Methods available from activity to view */

	void setPresenter(GqueryActivity mainActivity);

	void launchTest();

	// void addValues(String... values);

}
