package com.nopcommerce.account;

import commons.BaseTest;
import commons.PageGeneratorManager;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjectsUser.HomePageObject;
import pageObjectsUser.RegisterPageObject;
import reportConfig.AllureTestListener;

@Epic("Account")
@Feature("Create")
public class Level_19_Allure extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private String browerName ;


    @Description("User 01 : Validate register form")
    @Story("register")
    @Severity(SeverityLevel.NORMAL)

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String browserName,String url) {
        this.browerName = browserName;
        driver= getBrowerDriverUrl(browserName,url);
        homePage = PageGeneratorManager.getHomePage(driver);

    }


    @Description("User 01 : Validate register form")
    @Story("register")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void Register_01_Validate () {
//        Assert.assertTrue(homePage.isRegisterLinkDisplayed());

        registerPage = homePage.clickToRegisterLink();

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),"First name is required");

//        Assert.assertEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");
        verifyEquals(registerPage.getLastNameErrorMessageText(),"Last name is required.");



    }
    @Description("User 02 : Validate Success")
    @Story("Success")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Regression Tests")
    @Feature("Hardware")
    @Test
    public void Register_02_Success() {

        registerPage.refreshCurrentPage(driver);
        registerPage.enterToFirstNameTextBox("antony");

        registerPage.enterToLastNameTextBox("Compa");


        registerPage.enterToEmailTextBox("antonyCompa00000008@gmail.com");

        registerPage.enterToPsswordTextBox("12345678");

        registerPage.enterToconfirmPasswordTextBox("12345678");

        registerPage.clickToRegisterButton();

        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed.");


    }
    @AfterClass
    public void afterClass() {
        closeBrowser();
    }



}