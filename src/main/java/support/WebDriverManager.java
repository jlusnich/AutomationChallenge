package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class WebDriverManager {

    private WebDriverManager() {
    }

    static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        if (webDriver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
        return webDriver;
    }

}
