package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import serenitylabs.tutorials.trains.model.MainMenu;

public class Navigate implements Interaction{

    private static MainMenu mainMenu;

    private BuyTicketsHomePage buyTicketsHomePage;

    public Navigate(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn().the(buyTicketsHomePage)
        );

    }

    public static Performable to(MainMenu mainMenu) {
        Navigate.mainMenu = mainMenu;
        return Instrumented.instanceOf(Navigate.class).withProperties(mainMenu);
    }
}
