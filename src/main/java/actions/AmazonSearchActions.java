package actions;

import org.testng.Assert;
import pages.AmazonHomeP;
import pages.AmazonResultsSearchP;

public class AmazonSearchActions {

    AmazonHomeP amazonHomeP;
    AmazonResultsSearchP amazonResultsSearchP;

    public AmazonSearchActions() {
        amazonHomeP =  new AmazonHomeP();
        amazonResultsSearchP = new AmazonResultsSearchP();
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

}
