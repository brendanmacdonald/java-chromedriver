package Utils;

public enum BrowserOptions {

    START_MAXIMIZED("start-maximized"),
    HEADLESS("--headless"),
    WIDTH("width"),
    HEIGHT("height"),
    PIXEL_RATIO("pixelRatio"),
    DEVICE_METRICS("deviceMetrics"),
    MOBILE_EMULATION("mobileEmulation");

    private final String option;

    BrowserOptions(String option) {
        this.option = option;
    }

    public String getBrowserOption() {
        return this.option;
    }
}
