package steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import processes.AmazonSearchProcess;

public class AmazonSearchSteps{

    AmazonSearchProcess amazonSearchProcess;

    public AmazonSearchSteps() {
        amazonSearchProcess = new AmazonSearchProcess();
    }

    @Given("Searches for '$textToBeSearched'")
    public void searchFor(String textToBeSearched) {
        amazonSearchProcess.search(textToBeSearched);
    }

    @Given("Navigates to the page number '$pageNumber'")
    public void searchFor(int pageNumber) {
        amazonSearchProcess.goToPage(pageNumber);
    }

    @Given("Selects the item number '$elementNumber'")
    public void selectItem(int elementNumber) {
        amazonSearchProcess.selectItem(elementNumber);
    }

    @Then("The item is available for purchase")
    public void theItemIsAvailableForPurchase() {
        amazonSearchProcess.verifyItemIsAvailableForPurchase();
    }

}