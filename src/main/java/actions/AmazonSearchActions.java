package actions;

import org.testng.Assert;
import pages.AmazonHomeP;
import pages.AmazonResultP;
import pages.AmazonResultsSearchP;

public class AmazonSearchActions {

    AmazonHomeP amazonHomeP;
    AmazonResultsSearchP amazonResultsSearchP;
    AmazonResultP amazonResultP;

    public AmazonSearchActions() {
        amazonHomeP =  new AmazonHomeP();
        amazonResultsSearchP = new AmazonResultsSearchP();
        amazonResultP = new AmazonResultP();
    }

    public void search(String textToBeSearched) {
        amazonHomeP.writeInSearchInput(textToBeSearched);
        amazonHomeP.doSearch();
    }

    public void verifyResults() {
        amazonResultsSearchP.verifyResultsLoaded();
    }

    public void goToPage(int pageNumber) {
        amazonResultsSearchP.goToPage(pageNumber);
    }

    public void selectItem(int elementNumber) {
        String headerResults = amazonResultsSearchP.selectItem(elementNumber-1).substring(0,10);
        String headerResult = amazonResultP.getHeaderTitle().substring(0,10);
        Assert.assertTrue(headerResults.equalsIgnoreCase(headerResult));
    }

    public void verifyItemIsAvailableForPurchase() {
        boolean isEnabled = amazonResultP.isAddToCartEnabled();
        Assert.assertTrue(isEnabled);
    }

}
