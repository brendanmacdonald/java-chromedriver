package Model;

import org.openqa.selenium.By;

public class GoogleSearchPage {

    private By searchBox = By.name("q");
    private By logo = By.id("logo");

    public By getLogo() {
        return logo;
    }

    public By getSearchBox() {
        return searchBox;
    }
}
