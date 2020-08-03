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

}