package actions;

import support.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class CommonActions {

    public CommonActions() {
    }

    public WebDriver getWebDriver(){
        return WebDriverManager.getWebDriver();
    }

    public void navigateTo(String url) {
        getWebDriver().get("http://".concat(url));
    }
}
