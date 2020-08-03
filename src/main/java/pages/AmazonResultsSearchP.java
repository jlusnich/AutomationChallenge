package pages;

public class AmazonResultsSearchP extends BasePage {

    public static final String GRID_RESULTS_0 = "div[data-cel-widget='search_result_0']";
    public static final String PAGINATION_SECTION_BUTTONS = "span[cel_widget_id='MAIN-PAGINATION'] div li";
    public static final String RESULTS_LIST_ITEM_LOCATOR = "div[data-index='%s'] h2";

    public AmazonResultsSearchP() {
        super();
    }

    public void verifyResultsLoaded() {
        waitElementVisible(GRID_RESULTS_0);
    }

    public void goToPage(int pageNumber) {
        click(getElementByText(PAGINATION_SECTION_BUTTONS, String.valueOf(pageNumber)));
    }

    public String selectItem(int elementNumber) {
        String locator = String.format(RESULTS_LIST_ITEM_LOCATOR, String.valueOf(elementNumber));
        String header = getTextFromElement(locator);
        click(locator);
        return header;
    }

}
