package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChosenTo implements Task {

    public static Performable runAGoogleSearch() {
        return instrumented(ChosenTo.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Navigate.toGooglePage()
        );
    }
}
