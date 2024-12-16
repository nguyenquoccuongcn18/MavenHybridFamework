package orangehrmPageObjects;

import org.openqa.selenium.WebDriver;

public class JobObjects extends BaseActions {
    WebDriver driver;
    public JobObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
