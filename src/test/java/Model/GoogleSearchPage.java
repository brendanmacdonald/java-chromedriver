package Model;

import org.openqa.selenium.By;

public class GoogleSearchPage {

    private String url = "http://www.google.com";
    private By searchBox = By.name("q");
    private By logo = By.id("logo");

    public String getUrl() {
        return url;
    }

    public By getLogo() {
        return logo;
    }

    public By getSearchBox() {
        return searchBox;
    }
}
