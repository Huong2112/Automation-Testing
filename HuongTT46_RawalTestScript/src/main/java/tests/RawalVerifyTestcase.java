package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RawalVerifyTestcase extends BaseTest {
    @Test
    public void Testcase_01(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickToCategory();
        CategoriesPage categoriesPage = new CategoriesPage(getDriver());
        Assert.assertTrue(categoriesPage.verifyCategoryScreen());
    }

    @Test
    public void Testcase_02(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        Assert.assertTrue( myAccountPage.verifyMyAccountDisplay());
    }
    @Test
    public void Testcase_03(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickToCartIcon();
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @Test
    public void Testcase_04() throws InterruptedException {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickToSearchBox();
        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.search("product 20");
        Assert.assertTrue( searchPage.verifySearchResults("Simple Product 20", "Variable 20"));
    }

    @Test
    public void Testcase_05(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickToMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.clickToWelcome();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickToSignUpTab();
        loginPage.signUp("Huong", "Tran","tranhuong@gmail.com", "123456" , "123456");
        Assert.assertTrue(myAccountPage.verifyWelcome("Welcome \nHuong"));
    }


}
