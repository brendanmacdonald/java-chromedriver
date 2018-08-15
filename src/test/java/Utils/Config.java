package Utils;

import Utils.WebdriverHelper.BrowserType;

public class Config {

    // Command line parameters.
    private BrowserType browserType;

    public BrowserType getBrowserType() {
        return browserType;
    }

    public void setBrowserType(BrowserType browserType) {
        this.browserType = browserType;
    }
}
