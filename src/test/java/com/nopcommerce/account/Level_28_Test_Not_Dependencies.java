package com.nopcommerce.account;


import commons.BaseTest;
import commons.GlobalConstants;
import orangehrmPageObjects.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjectsUser.HomePageObject;
import pojoData.orangehrm.EmployeeInfo;


public class Level_28_Test_Not_Dependencies extends BaseTest {

    private WebDriver driver;

     private HomePageObject homePage;
    private EmployeeInfo employeeInfo;
    private LoginPageObjects loginPage;
    private DashboardObjects dashboardPage;
    private EmployeeListObjects employeeListPage;
    private PersonalDetailObjects personalDetailPage;
    private AddEmployeeObjects addEmployeePage;


    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriverUrl(browserName,url);
//        homePage = PageGeneratorManager.getHomePage(driver);

        loginPage = orangehrmPageObjects.PageGeneratorManager.getLoginPage(driver);
        sleepInsecons(3);
        loginPage.inputToUsernameField(GlobalConstants.ADMIN_ORGANGE_HRM_USERNAME);
        sleepInsecons(3);
        loginPage.inputToPasswordField(GlobalConstants.ADMIN_ORGANGE_HRM_PASSWORD);
        sleepInsecons(3);
        dashboardPage = loginPage.clickToLoginButton();
        sleepInsecons(5);
//        employeeListPage = dashboardPage.openPIMModule();
    }
    @Test
    public void shouldBeSearchByEmptyData() {
        sleepInsecons(3);
        employeeListPage = dashboardPage.isSearchOrangeHRM(" ");
        sleepInsecons(5);
    }
    @Test
    public void shouldBeSearchByPIM() {
        sleepInsecons(3);
        employeeListPage = dashboardPage.isSearchOrangeHRM("PIM");

    }
    @Test
    public void shouldBeSearchByPI() {
        sleepInsecons(3);
        employeeListPage = dashboardPage.isSearchOrangeHRM("PI");
    }
    @AfterMethod
         public void afterTest() {
            driver.quit();
    }
}
