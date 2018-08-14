import Model.Config;
import Model.GoogleSearchPage;
import Utils.ConfigHelper;
import Utils.PageUtils;
import Utils.WebdriverHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    private static WebDriver driver;
    private Config config;
    private GoogleSearchPage gsp = new GoogleSearchPage();
    private PageUtils pu = new PageUtils();

    @Before
    public void setUp() {
        config = ConfigHelper.getConfig();
        driver = WebdriverHelper.createDriver(config.getBrowserType());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void search() {
        driver.get("http://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        pu.waitForWebElementToBeClickable(driver, gsp.getLogo());
        Assert.assertEquals("ChromeDriver - Google Search", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
