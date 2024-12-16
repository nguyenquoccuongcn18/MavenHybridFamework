package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManagerjQuery {
    public static HomePageObjectjQuery getHomePage(WebDriver driver){
        return new HomePageObjectjQuery(driver);
    }
    public static UploadPageObjects getUploadPage(WebDriver driver){
        return new UploadPageObjects(driver);
    }
}
