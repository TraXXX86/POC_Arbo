package fr.euriware.poc.arbo.client.gquery.view;

import com.google.gwt.user.client.ui.IsWidget;

import fr.euriware.poc.arbo.client.gquery.activity.GqueryActivity;

public interface GqueryView extends IsWidget {

	/* Methods available from view to activity */

	public interface GqueryPresenter {

	}

	/* Methods available from activity to view */

	void setPresenter(GqueryActivity mainActivity);

	void launchTest();

	// void addValues(String... values);

}
