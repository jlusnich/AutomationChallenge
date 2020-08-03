package pages;

public class AmazonResultP extends BasePage {

    public static final String GRID_RESULTS_0 = "div[data-cel-widget='search_result_0']";
    public static final String PAGINATION_SECTION_BUTTONS = "span[cel_widget_id='MAIN-PAGINATION'] div li";
    public static final String RESULTS_LIST_ITEM_LOCATOR = "div[data-index='%s'] h2";
    private static final String RESULT_TITLE_LOCATOR = "h1#title";
    private static final String ADD_TO_CART_BUTTON = "input#add-to-cart-button";

    public AmazonResultP() {
        super();
    }

    public String getHeaderTitle() {
        return getTextFromElement(RESULT_TITLE_LOCATOR);
    }

    public boolean isAddToCartEnabled() {
        return isElementEnabled(ADD_TO_CART_BUTTON);
    }
}
