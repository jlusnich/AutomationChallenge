package pages;

import support.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BasePage {

    WebDriver driver;
    private final long WAIT_FOR_ELEMENT_VISIBLE_TIMEOUT = 10;
    private final long FREQ_FOR_CHECK_VISIBLE_ELEMENT = 100;

    public BasePage() {
        driver = WebDriverManager.getWebDriver();
    }

    public void writeInput(String locator, String textToBeSearched) {
        getElement(locator).sendKeys(textToBeSearched);
    }

    public void click(String locator){
        int attemps = 5;
        int i = 1;
        while (i<attemps) {
            WebElement elem = getElement(locator);
            new Actions(driver).moveToElement(elem).perform();
            try {
                Thread.sleep(200);
                elem.click();
                break;
            } catch (Exception e) {
                System.out.println("Click failed, trying again");
            }
            i++;
        }
    }

    public void click(WebElement elem){
        elem.click();
    }

    public void waitElementVisible(String locator){
        getElement(locator);
    }

    private WebElement getElement(String locator) {
        return waitForElement().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }

    private List<WebElement> getElements(String locator) {
        return waitForElement().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locator)));
    }

    protected FluentWait<WebDriver> waitForElement() {
        return getFluentWait(WAIT_FOR_ELEMENT_VISIBLE_TIMEOUT, FREQ_FOR_CHECK_VISIBLE_ELEMENT);
    }

    private FluentWait<WebDriver> getFluentWait(long secTimeout, long miliCheckFreq) {
        return new FluentWait<WebDriver>( driver )
                .withTimeout( Duration.of(secTimeout, ChronoUnit.SECONDS) )
                .pollingEvery( Duration.of(miliCheckFreq, ChronoUnit.MILLIS) )
                .ignoring( NoSuchElementException.class )
                .ignoring( TimeoutException.class );
    }

    public WebElement getElementByText(String parentLocator, String text) {
        WebElement result = null;
        List<WebElement> list = getElements(parentLocator);
        for (WebElement elem : list){
            if (elem.getText().equalsIgnoreCase(text)) {
                result = elem;
                break;
            }
        }
        Assert.assertTrue(result != null, "It was not possible to find child element");
        return result;
    }
}
