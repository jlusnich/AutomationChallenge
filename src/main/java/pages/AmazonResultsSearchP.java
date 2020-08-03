package pages;

public class AmazonResultsSearchP extends BasePage {

    public static final String GRID_RESULTS_0 = "div[data-cel-widget='search_result_0']";
    public static final String PAGINATION_SECTION_BUTTONS = "span[cel_widget_id='MAIN-PAGINATION'] div li";

    public AmazonResultsSearchP() {
        super();
    }

    public void verifyResultsLoaded() {
        waitElementVisible(GRID_RESULTS_0);
    }

    public void goToPage(int pageNumber) {
        click(getElementByText(PAGINATION_SECTION_BUTTONS, String.valueOf(pageNumber)));
    }

}
