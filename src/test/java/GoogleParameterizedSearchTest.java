import Model.Config;
import Model.GoogleSearchPage;
import Utils.ConfigHelper;
import Utils.PageUtils;
import Utils.WebdriverHelper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Google Tests")
public class GoogleParameterizedSearchTest {

    private static WebDriver driver;
    private Config config;
    private static GoogleSearchPage gsp;
    private static
    PageUtils pu;

    @BeforeAll
    public static void setUpConfig() {
        gsp = new GoogleSearchPage();
        pu = new PageUtils();
    }

    @BeforeEach
    public void setUpDriver() {
        config = ConfigHelper.getConfig();
        driver = WebdriverHelper.createDriver(config.getBrowserType());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "cheese" })
    void search(String value) {
        driver.get(gsp.getUrl());
        By searchBox = gsp.getSearchBox();
        driver.findElement(searchBox).sendKeys(value);
        driver.findElement(searchBox).submit();
        pu.waitForWebElementToBeClickable(driver, gsp.getLogo());
        assertEquals(value + " - Google Search", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
