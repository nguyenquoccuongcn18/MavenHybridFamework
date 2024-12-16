package orangehrmPageObjects;

import org.openqa.selenium.WebDriver;

public class ReportObjects extends BaseActions {
    WebDriver driver;
    public ReportObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
