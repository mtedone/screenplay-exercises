package serenitylabs.tutorials.trains.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class TheSearchResult implements Question<List<String>>{

    @Override
    public List<String> answeredBy(Actor actor) {
        List<WebElementFacade> elements = BrowseTheWeb.as(actor)
                .findAll(By.className("g"));

        List<String> results = new ArrayList<>();
        elements.forEach(e -> results.add(e.getText()));
        return results;
    }

    public static Question<List<String>> list() {
        return new TheSearchResult();
    }
}
