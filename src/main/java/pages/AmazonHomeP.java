package pages;

import actions.AmazonSearchActions;
import org.openqa.selenium.WebDriver;

public class AmazonHomeP extends BasePage {

    public static final String INPUT_SEARCH_LOCATOR = "input#twotabsearchtextbox";
    public static final String BUTTON_SEARCH_LOCATOR = "div.nav-search-submit";

    public AmazonHomeP() {
        super();
    }

    public void writeInSearchInput(String textToBeSearched) {
        writeInput(INPUT_SEARCH_LOCATOR, textToBeSearched);
    }

    public void doSearch() {
        click(BUTTON_SEARCH_LOCATOR);
    }
}
