package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("FieldCanBeLocal")
public class PageUtils {

    private int explicitTimeout = 10;

    public void waitForWebElementToBeClickable(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver, explicitTimeout);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
}
