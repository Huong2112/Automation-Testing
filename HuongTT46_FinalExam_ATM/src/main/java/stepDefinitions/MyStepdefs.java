package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.*;

public class MyStepdefs {

    AccountPage accountPage = new AccountPage();
    CartPage cartPage = new CartPage();
    CategoryPage categoryPage = new CategoryPage();
    HomePage homePage = new HomePage();
    ListProductPage listProductPage = new ListProductPage();
    LoginPage loginPage = new LoginPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    SettingPage settingPage = new SettingPage();
    ChangeCurrencyPage changeCurrencyPage = new ChangeCurrencyPage();
    @Given("Open Banggood Easy Online Shopping App")
    public void openBanggoodEasyOnlineShoppingApp() {
        homePage.clickToDeny();
        homePage.clickToAccount();
        accountPage.scrollToSetting();
        accountPage.clickToSetting();
        settingPage.clickToCurrency();
        changeCurrencyPage.clickToUSD();
        settingPage.clickToBack();
        homePage.clickToHome();
    }

    @When("Click to the Category on footer menu")
    public void clickToTheCategoryOnFooterMenu() {
        homePage.clickToCategory();
    }

    @And("Scroll and click to Home and Garden in Left menu")
    public void scrollAndClickToHomeAndGardenInLeftMenu() {
        categoryPage.clickToHomeAndGarden();

    }

    @And("After the right category displayed, click to the Home Decor")
    public void afterTheRightCategoryDisplayedClickToTheHomeDecor() {
        categoryPage.clickToHomeDecor();

    }

    @And("Click to the Filter and input price from {string} to {string}")
    public void clickToTheFilterAndInputPriceFromTo(String min, String max) {
        listProductPage.clickToFilter();
        listProductPage.inputPrice(min, max);

    }

    @And("Click Done")
    public void clickDone() {
        listProductPage.clickToDoneButton();
    }

    @And("Click first product")
    public void clickFirstProduct() {
        listProductPage.clickToFirstProduct();
    }

    @Then("Verify product name should be displayed and product price in range {string} to {string}")
    public void verifyProductNameShouldBeDisplayedAndProductPriceInRangeTo(String fromUSD, String toUSD) {
       Assert.assertTrue( productDetailPage.verifyProductNameAndPrice(fromUSD, toUSD));
    }

    @When("At the Home screen, scroll to Hot Categories")
    public void atTheHomeScreenScrollToHotCategories() throws InterruptedException {
        homePage.scrollToHotCategories();
    }

    @And("Click to the first category")
    public void clickToTheFirstCategory() {
        homePage.clickToFirstCategory();
    }

    @And("Click to the first product")
    public void clickToTheFirstProduct() {
        listProductPage.clickTo2ndProduct();
    }

    @Then("The product detail page should be displayed : Product name, product price, Buy now button and Add to Cart button.")
    public void theProductDetailPageShouldBeDisplayedProductNameProductPriceBuyNowButtonAndAddToCartButton() {
       Assert.assertTrue( productDetailPage.verifyProductDetailScreen());
    }

    @When("Click Add to Cart")
    public void clickAddToCart() {
        productDetailPage.clickToAddToCartButton();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }

    }

    @And("Click to Add to Cart button")
    public void clickToAddToCartButton() {
        productDetailPage.clickToAddToCartButton();
    }

    @And("Click to Cart icon on footer")
    public void clickToCartIconOnFooter() {
        productDetailPage.clickToCartIcon();
    }

    @Then("Verify product name, product size, product price and quantity should be displayed")
    public void verifyProductNameProductSizeProductPriceAndQuantityShouldBeDisplayed() {
        Assert.assertTrue(cartPage.verifyProductInCart());
    }

    @When("Click Account on footer menu")
    public void clickAccountOnFooterMenu() {
        homePage.clickToAccount();
    }

    @And("Click View All Order")
    public void clickViewAllOrder() {
        accountPage.clickToViewAllOrder();
    }

    @Then("Verify the login screen should be displayed with: Email, password and SignIn button.")
    public void verifyTheLoginScreenShouldBeDisplayedWithEmailPasswordAndSignInButton() {
        loginPage.verifyLoginScreen();
    }

    @Given("Open Banggood Easy Online Shopping App Without change currency")
    public void openBanggoodEasyOnlineShoppingAppWithoutChangeCurrency() {
        homePage.clickToDeny();
    }
}
