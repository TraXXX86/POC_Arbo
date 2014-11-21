package fr.jaouen.poc.showcase.client.gquery.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class GqueryPlace extends Place {

	public GqueryPlace() {
	}

	public static class Tokenizer implements PlaceTokenizer<GqueryPlace> {

		public String getToken(GqueryPlace place) {
			return "home";
		}

		public GqueryPlace getPlace(String token) {
			return new GqueryPlace();
		}
	}

}
