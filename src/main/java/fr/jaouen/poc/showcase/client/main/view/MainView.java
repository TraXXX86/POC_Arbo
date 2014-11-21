package fr.jaouen.poc.showcase.client.main.view;

import com.google.gwt.user.client.ui.IsWidget;

import fr.jaouen.poc.showcase.client.main.activity.MainActivity;

public interface MainView extends IsWidget {

	/* Methods available from view to activity */

	public interface MainPresenter {

	}

	/* Methods available from activity to view */

	void setPresenter(MainActivity mainActivity);

	void addValues(String... values);

}
