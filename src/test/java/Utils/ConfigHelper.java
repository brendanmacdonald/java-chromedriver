package Utils;

import Utils.WebdriverHelper.BrowserType;

public class ConfigHelper {

    private static final String BROWSER = "browser";

    public static Config getConfig() {

        Config configuration = new Config();

        // Command line parameters.
        String browser = System.getProperty(BROWSER);

        // Set command line parameter values.
        BrowserType browserType = BrowserType.valueOf(browser);
        configuration.setBrowserType(browserType);

        return configuration;
    }
}
