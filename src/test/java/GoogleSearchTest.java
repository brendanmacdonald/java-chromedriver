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
        By searchBox = gsp.getSearchBox();
        driver.findElement(searchBox).sendKeys("ChromeDriver");
        driver.findElement(searchBox).submit();
        pu.waitForWebElementToBeClickable(driver, gsp.getLogo());
        Assert.assertEquals("ChromeDriver - Google Search", driver.getTitle());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
