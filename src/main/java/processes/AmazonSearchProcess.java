package processes;

import actions.AmazonSearchActions;

public class AmazonSearchProcess {

    AmazonSearchActions amazonSearchActions;

    public AmazonSearchProcess() {
        amazonSearchActions = new AmazonSearchActions();
    }

    public void search(String textToBeSearched) {
        amazonSearchActions.search(textToBeSearched);
        amazonSearchActions.verifyResults();
    }

    public void goToPage(int pageNumber) {
        amazonSearchActions.goToPage(pageNumber);
    }

    public void selectItem(int elementNumber) {
        amazonSearchActions.selectItem(elementNumber);
    }

    public void verifyItemIsAvailableForPurchase() {
        amazonSearchActions.verifyItemIsAvailableForPurchase();
    }

}
