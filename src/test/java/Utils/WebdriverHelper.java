package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;
import java.util.Map;

import static Utils.BrowserOptions.*;

public class WebdriverHelper {

    public enum BrowserType {
        CHROME_HEADLESS, FIREFOX_MAX, MOBILE360x640
    }

    public static RemoteWebDriver createDriver(BrowserType browserType) {

        switch (browserType) {
            case FIREFOX_MAX: {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments(START_MAXIMIZED.getBrowserOption());
                return new FirefoxDriver(options);
            }

            case CHROME_HEADLESS: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(HEADLESS.getBrowserOption());
                return new ChromeDriver(options);
            }

            case MOBILE360x640: {
                Map<String, Object> deviceMetrics = new HashMap<String, Object>();
                deviceMetrics.put(WIDTH.getBrowserOption(), 360);
                deviceMetrics.put(HEIGHT.getBrowserOption(), 640);
                deviceMetrics.put(PIXEL_RATIO.getBrowserOption(), 3.0);

                Map<String, Object> mobileEmulation = new HashMap<String, Object>();
                mobileEmulation.put(DEVICE_METRICS.getBrowserOption(), deviceMetrics);

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption(MOBILE_EMULATION.getBrowserOption(), mobileEmulation);

                return new ChromeDriver(chromeOptions);
            }

            default: {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(START_MAXIMIZED.getBrowserOption());
                return new ChromeDriver(options);
            }
        }
    }
}
