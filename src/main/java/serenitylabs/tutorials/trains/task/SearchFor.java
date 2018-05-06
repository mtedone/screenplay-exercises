package serenitylabs.tutorials.trains.task;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;
import serenitylabs.tutorials.trains.ui.GoogleSearchForm;

public class SearchFor implements Task {


    private final String name;

    public SearchFor(String name) {
        this.name = name;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(name).
                        into(GoogleSearchForm.SEARCH_TERM).thenHit(Keys.ENTER)
        );
    }


    public static Performable name(String name) {
        return Instrumented.instanceOf(SearchFor.class).withProperties(name);
    }
}
