package steps;

import org.jbehave.core.annotations.Given;
import processes.CommonProcess;

public class CommonSteps {

    CommonProcess commonProcess;

    public CommonSteps() {
        commonProcess = new CommonProcess();
    }

    @Given("The user navigates to '$url'")
    public void navigateTo(String url) {
        commonProcess.navigateTo(url);
    }
}