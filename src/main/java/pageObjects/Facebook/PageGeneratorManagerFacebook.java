package pageObjects.Facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerFacebook {
    public static HomePageObjectFacebook getHomePage(WebDriver driver){
        return new HomePageObjectFacebook(driver);
    }

}
