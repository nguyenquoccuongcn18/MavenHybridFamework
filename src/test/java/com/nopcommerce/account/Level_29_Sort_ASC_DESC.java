package com.nopcommerce.account;


import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.SauceLab.LoginPageObjects;
import pageObjects.SauceLab.PageGeneratorManagerSauceLab;
import pageObjects.SauceLab.ProductPageObjects;


public class Level_29_Sort_ASC_DESC extends BaseTest {

    private WebDriver driver;

     private LoginPageObjects loginPage;
    private ProductPageObjects productPage;



    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeClass(String browserName,String url) {
        driver= getBrowerDriverUrl(browserName,url);
        loginPage = PageGeneratorManagerSauceLab.getLoginPage(driver);

        loginPage.enterToUsername(GlobalConstants.USER_NAME_SAUCEDEMO);
        loginPage.enterToPassword(GlobalConstants.PASSWORD_SAUCEDEMO);
        productPage = loginPage.clickToLoginButton();

    }
    @Test
    public void Sort_01_Name() {
        productPage.selectItemInSortDropdown("Name (A to Z)");
        Assert.assertTrue(productPage.isProductByNameSortAscendingASC());

        productPage.selectItemInSortDropdown("Name (Z to A)");
        Assert.assertTrue(productPage.isProductByNameSortDescendingDESC());


    }
    @Test
    public void Sort_01_Price() {
        productPage.selectItemInSortDropdown("Price (low to high)");
        Assert.assertTrue(productPage.isProductByPriceSortAscendingASC());

        productPage.selectItemInSortDropdown("Price (high to low)");
        Assert.assertTrue(productPage.isProductByPriceSortDescendingDESC());
        
    }
    @Test
    public void Sort_01_Date_Month() {

    }
    @AfterMethod
         public void afterTest() {
            driver.quit();
    }
}
