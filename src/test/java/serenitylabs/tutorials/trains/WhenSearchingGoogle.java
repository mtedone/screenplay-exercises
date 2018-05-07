package serenitylabs.tutorials.trains;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenitylabs.tutorials.trains.questions.TheSearchResult;
import serenitylabs.tutorials.trains.task.SearchFor;
import serenitylabs.tutorials.trains.ui.ChosenTo;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.empty;

@RunWith(SerenityRunner.class)
public class WhenSearchingGoogle {

    Actor tracy;

    @Managed(driver = "chrome", uniqueSession = true)
    private WebDriver browser;

    @Before
    public void setTheStage() {
        tracy = Actor.named("Tracy");
        tracy.can(BrowseTheWeb.with(browser));
    }

    @Test
    public void the_TFL_page_title_should_be_visible() {

        //Tracy goes to the website to book a ticket

        //GIVEN
        tracy.has(ChosenTo.runAGoogleSearch());
        //Tracy views the tickets from London Paddington to Oxford

        tracy.attemptsTo(SearchFor.name("Marco Tedone"));

        Question<List<String>> list = TheSearchResult.list();
        list.answeredBy(tracy).forEach(
                l -> System.out.println(l)
        );

        //Tracy should see that the departure and destination stations are the expected ones
        tracy.should(seeThat(list, Matchers.is(Matchers.not(empty()))));
    }

}
