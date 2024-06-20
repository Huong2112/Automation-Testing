package stepDefinitions;

import io.cucumber.gherkin.Main;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import pages.*;

import java.util.Arrays;
import java.util.List;

public class MyStepdefs {

    AddressScreen addressScreen = new AddressScreen();
    BeverageListScreen beverageListScreen = new BeverageListScreen();
    CartScreen cartScreen = new CartScreen();
    CategoryScreen categoryScreen = new CategoryScreen();
    CoffeeListScreen coffeeListScreen = new CoffeeListScreen();
    DefaultDeliveryLocationScreen defaultDeliveryLocationScreen = new DefaultDeliveryLocationScreen();
    FastFoodListScreen  fastFoodListScreen = new FastFoodListScreen();
    FreshVegetableListScreen freshVegetableListScreen = new FreshVegetableListScreen();
    HomeScreen homeScreen = new HomeScreen();
    LoginScreen loginScreen = new LoginScreen();
    MainScreen mainScreen = new MainScreen();
    PaymentScreen paymentScreen = new PaymentScreen();
    ProductDetailScreen productDetailScreen = new ProductDetailScreen();
    ProfileScreen profileScreen = new ProfileScreen();
    SearchProductScreen searchProductScreen = new SearchProductScreen();

    @Given("Open eCart App")
    public void openECartApp() {
    }

    @Then("welcome screen with some fields displayed:Skip button, Next button, {string}")
    public void welcomeScreenWithSomeFieldsDisplayedSkipButtonNextButton(String text) {
        Assert.assertTrue(homeScreen.verifyWelcomeScreen(text));
    }

    @When("Click to next -> next -> Get Started")
    public void clickToNextNextGetStarted() {
        homeScreen.clickToNext();
        homeScreen.clickToNext();
        homeScreen.clickToGetStarted();
    }

    @Then("The Default Delivery Location screen display some items: Search Pin textbox, Search Button, Location display: {string}, {string}, {string}, {string}, {string}, {string}")
    public void theDefaultDeliveryLocationScreenDisplaySomeItemsSearchPinTextboxSearchButtonLocationDisplay(String st , String nd , String rd , String fourth, String fifth, String sixth) {
        List<String> expectedLocations = Arrays.asList(new String[]{st, nd, rd, fourth, fifth, sixth});
        Assert.assertTrue(defaultDeliveryLocationScreen.verifyDefaultDeliveryLocationDisplay(expectedLocations));
    }

    @When("Select {string} location")
    public void selectLocation(String location) {
        if (defaultDeliveryLocationScreen.checkLocationDisplay()){
            defaultDeliveryLocationScreen.searchAndSelectLocation(location);
        }
    }

    @And("Click to Category menu item")
    public void clickToCategoryMenuItem() {
        mainScreen.clickToCategory();
    }

    @Then("The Category screen display {int} categories: {string}, {string}, {string}, {string}, {string}, {string}")
    public void theCategoryScreenDisplayCategories(int numberOfCategory, String coffee, String fastfood, String homeSupply, String beverage, String babyNeeds, String vegetable) {
        List<String> expectedCategory = Arrays.asList(new String[]{coffee,fastfood,homeSupply,beverage, babyNeeds, vegetable});
        System.out.println(expectedCategory.toString());
        Assert.assertTrue(categoryScreen.verifySixCategory(numberOfCategory, coffee,  fastfood,homeSupply, beverage, babyNeeds,  vegetable));
    }


    @Then("The Fresh Vegetables category should be displayed {int} products")
    public void theFreshVegetablesCategoryShouldBeDisplayedProducts(int numberOfProduct) {
        Assert.assertTrue(mainScreen.verifyDisplayNProduct(numberOfProduct));
    }

    @When("Click to View All in Vegetable")
    public void clickToViewAllInVegetable() {
        mainScreen.clickToViewAllInFreshVegetables();
    }


    @And("Scroll to Fresh Vegetables")
    public void scrollToFreshVegetables() {
        mainScreen.scrollIntoFreshVegetables();
    }

    @Then("Fresh Vegetables screen should be displayed {int} products")
    public void freshVegetablesScreenShouldBeDisplayedProducts(int number) {
        Assert.assertTrue(freshVegetableListScreen.verifyDisplayNproduct(number));
    }

    @And("Scroll to Coffee")
    public void scrollToCoffee() {
        mainScreen.scrollToCoffee();
    }

    @And("Click to View All in Coffee")
    public void clickToViewAllInCoffee() {
        mainScreen.clickToViewAllInCoffee();
    }


    @Then("The product detail screen should be displayed: {string}, {string}, Add to Cart button, Go to Cart button, Similar Products text")
    public void theProductDetailScreenShouldBeDisplayedAddToCartButtonGoToCartButtonSimilarProductsText(String name, String price) {
       Assert.assertTrue(productDetailScreen.verifyDetailScreenDisplay(name,price));
    }

    @And("Click to Fast Food")
    public void clickToFastFood() {
        categoryScreen.clickToFastFood();
    }


    @And("Click to Cart icon on top screen")
    public void clickToCartIconOnTopScreen() {
        searchProductScreen.clickToCartIcon();
    }


    @Then("The Cart should be display: {string}, {string}, {string}, {string}, {string}, Delete Button,Save for later button,Use Promo Code button, CONTINUE button")
    public void theCartShouldBeDisplayQuantityDeleteButtonSaveForLaterButtonUsePromoCodeButtonCONTINUEButton(String name, String price, String measure, String totalPrice, String quantity) {
        Assert.assertTrue(cartScreen.verifyCartScreen(name, price, measure, totalPrice, quantity));
        cartScreen.clickToDeleteButton();
    }

    @And("Click to Beverages")
    public void clickToBeverages() {
        categoryScreen.clickToBeverage();
    }

    @And("Click to CONTINUE button")
    public void clickToCONTINUEButton() {
        cartScreen.clickToContinueButton();
    }

    @And("Select default address and click CONTINUE")
    public void selectDefaultAddressAndClickCONTINUE() {
        addressScreen.clickToDefaultAddress();
        addressScreen.clickToContinueButton();

    }

    @Then("The Payment screen should be display: Shipping detail with Pin Code: {string}, Preferred Delivery: Date, time, {string}")
    public void thePaymentScreenShouldBeDisplayShippingDetailWithPinCodePreferredDeliveryDateTime(String pinCode, String grandTotal) {
       Assert.assertTrue( paymentScreen.verifyPaymentScreen(pinCode, grandTotal));
    }

    @And("Order Summary should be display correct information: {string}, {string}, {string}, {string}, {string} and Grand Total.")
    public void orderSummaryShouldBeDisplayCorrectInformationAndGrandTotal(String name, String price, String subtotal, String delivery, String save) {
        Assert.assertTrue(paymentScreen.verifyOrderSummary(name, price, subtotal, delivery, save));
    }

    @And("Click to Profile on footer menu")
    public void clickToProfileOnFooterMenu() {
        mainScreen.clickToProfile();
    }

    @And("Click to Welcome Guest")
    public void clickToWelcomeGuest() {
        profileScreen.clickToWelcomeGuest();
    }

    @Then("The login screen should be displayed:Mobile textbox, Password textbox,Login button, Forgot password?,Sign up button")
    public void theLoginScreenShouldBeDisplayedMobileTextboxPasswordTextboxLoginButtonForgotPasswordSignUpButton() {
        Assert.assertTrue(loginScreen.verifyLoginScreen());
    }

    @When("Click to login button")
    public void clickToLoginButton() {
        loginScreen.clickToLoginButton();
    }

    @And("Click again to Profile on footer menu")
    public void clickAgainToProfileOnFooterMenu() {
        mainScreen.clickToProfile();
    }

    @Then("The profile screen should be displayed:Home, Cart, Notifications, Your Orders, Wallet History, Transaction History, Change Password")
    public void theProfileScreenShouldBeDisplayedHomeCartNotificationsYourOrdersWalletHistoryTransactionHistoryChangePassword() {
        Assert.assertTrue(profileScreen.verifyProfileScreen());
    }


    @And("Click Add to Cart with Quantity = {int} of {string} product 1")
    public void clickAddToCartWithQuantityOfProduct1(int quantity, String name) {
        fastFoodListScreen.clickToSearchIcon();
        searchProductScreen.addProductToCart(quantity, name);

    }
    @And("Click Add to Cart with Quantity = {int} of {string} product")
    public void clickAddToCartWithQuantityOfProduct(int quantity, String name) {
        beverageListScreen.clickToSearchIcon();
        searchProductScreen.addSunfeastDarkProductToCart(quantity, name);
    }

    @And("Click to {string}")
    public void clickTo(String name) {
        coffeeListScreen.clickToSearchIcon();
        searchProductScreen.searchAndClickToProduct(name);
    }
}
