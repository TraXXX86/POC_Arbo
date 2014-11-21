package fr.jaouen.poc.showcase.client.gquery.view.impl;

import static com.google.gwt.query.client.GQuery.$;

import com.google.gwt.core.client.GWT;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.css.CSS;
import com.google.gwt.query.client.css.Length;
import com.google.gwt.query.client.plugins.Effects;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import fr.jaouen.poc.showcase.client.gquery.activity.GqueryActivity;
import fr.jaouen.poc.showcase.client.gquery.view.GqueryView;

public class GqueryViewImpl extends Composite implements GqueryView {

	// ########################################## MVP elements

	private static GqueryViewUiBinder uiBinder = GWT.create(GqueryViewUiBinder.class);

	@UiTemplate("GqueryView.ui.xml")
	interface GqueryViewUiBinder extends UiBinder<Widget, GqueryViewImpl> {
	}

	@Override
	public void setPresenter(GqueryActivity mainActivity) {
		this.mainActivity = mainActivity;
	}

	private GqueryActivity mainActivity;

	// ##########################################

	// @Inject
	public GqueryViewImpl() {
		// Init graphical element with UiBinder
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void launchTest() {
		// Hide the text and set the width and append an h1 element
		$("#textLeft").hide().append("<br/>");
		$("#textRight").hide().append("<br/>");
		// .css(CSS.WIDTH.with(Length.px(400))).prepend("<h1>GwtQuery Rocks !</h1>");

		// add a click handler on the button
		$("#btnLeft").click(new Function() {
			public void f() {
				// display the text with effects and animate its background color
				$("#textLeft").as(Effects.Effects).clipDown(1000).animate("backgroundColor: 'yellow'", 1000).delay(1000).animate("backgroundColor: '#fff'", 1500);
			}
		});

		$("#btnRight").click(new Function() {
			public void f() {

				if ($("#textRight").isVisible()) {
					// display the text with effects and animate its background color
					$("#textRight").hide();
					$("#btnRight").text("Afficher le texte droit");
				} else {
					// display the text with effects and animate its background color
					$("#textRight").as(Effects.Effects).clipDown(1000).animate("backgroundColor: 'yellow'", 1000).delay(1000).animate("backgroundColor: '#fff'", 1500);
					$("#btnRight").text("Masquer le texte droit");
				}

			}
		});
	}
}
