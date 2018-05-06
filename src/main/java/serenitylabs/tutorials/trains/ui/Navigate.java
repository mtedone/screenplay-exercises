package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;

public class Navigate implements Interaction{

    private GoogleHomePage googleHomePage;

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn().the(googleHomePage)
        );

    }

    public static Performable toGooglePage() {
        return Instrumented.instanceOf(Navigate.class).newInstance();
    }
}
