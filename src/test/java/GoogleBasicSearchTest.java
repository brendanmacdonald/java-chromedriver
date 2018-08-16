import Utils.Config;
import Model.GoogleSearchPage;
import Utils.ConfigHelper;
import Model.PageUtils;
import Utils.WebdriverHelper;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@DisplayName("Google Tests")
@Epic("This is the name of the Epic")
public class GoogleBasicSearchTest {

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


    @Step
    public void openBaseURL() {
        driver.get(gsp.getUrl());
    }

    @Step
    public void enterSearchParam(String param){
        By searchBox = gsp.getSearchBox();
        driver.findElement(searchBox).sendKeys(param);
    }


    @Step
    public void pressSearchBtn() {
        By btn = gsp.getBtn();
        driver.findElement(btn).click();
    }
    @Test
    @DisplayName("First Google Search test")
    @Feature("This is the name of the Feature")
    @Story("This is the name of the Story - perform a basic search")
    public void search() {
        openBaseURL();
        enterSearchParam("cheese");
        pressSearchBtn();
        pu.waitForWebElementToBeClickable(driver, gsp.getLogo());
        assertEquals("ChromeDriver - Google Search", driver.getTitle());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
