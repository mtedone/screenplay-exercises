package serenitylabs.tutorials.trains.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoogleSearchForm {

    public static Target SEARCH_TERM = Target.the("Departure Station")
                                .located(By.id("lst-ib"));

    public static Target SEARCH_BUTTON = Target.the("Search Button")
                .located(By.name("btnK"));
}
