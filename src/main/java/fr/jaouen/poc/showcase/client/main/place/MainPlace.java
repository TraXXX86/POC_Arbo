package fr.jaouen.poc.showcase.client.main.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MainPlace extends Place {

	public MainPlace() {
	}

	public static class Tokenizer implements PlaceTokenizer<MainPlace> {

		public String getToken(MainPlace place) {
			return "home";
		}

		public MainPlace getPlace(String token) {
			return new MainPlace();
		}
	}

}
