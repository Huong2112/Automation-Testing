package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.*;

public class MyStepdefs {

    BuyNewVCPage buyNewVCPage = new BuyNewVCPage();
    EditProfilePage editProfilePage = new EditProfilePage();
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RequestMoneyPage requestMoneyPage = new RequestMoneyPage();
    VirtualCardPage virtualCardPage = new VirtualCardPage();
    WelcomePage welcomePage = new WelcomePage();


    @Given("Open Wallet application")
    public void openWalletApplication() {
        welcomePage.clickToLoginButton();
    }

    @When("Input {string} & {string}")
    public void input(String email, String pass) throws InterruptedException {
        loginPage.input(email, pass);
    }

    @And("click to login")
    public void clickToLogin() throws InterruptedException {
        loginPage.clickToLoginButton();
    }

    @Then("The Dashboard display: Deposits and WithDrawals tab")
    public void theDashboardDisplayDepositsAndWithDrawalsTab() {
        Assert.assertTrue(homePage.verifyDepositAndWithdraw());
    }

    @And("In Deposits tab display Deposit to Us Dollar with Amount = {float} USD")
    public void inDepositsTabDisplayDepositToUsDollarWithAmountAmountUSD(float number) {
        String formattedNumber = String.format("%.2f", number);
        Assert.assertTrue(homePage.verifyUsDollarAmount(formattedNumber));

    }

    @And("Click to icon Virtual Cards at footer menu")
    public void clickToIconVirtualCardsAtFooterMenu() {
        homePage.clickToVirtualCard();
    }

    @And("Click to Buy Card")
    public void clickToBuyCard() {
        virtualCardPage.clickToBuyCard();
    }

    @Then("The Buy a New Virtual Card display Name textbox and Fund button")
    public void theBuyANewVirtualCardDisplayNameTextboxAndFundButton() {
        Assert.assertTrue(buyNewVCPage.verifyBuyNewCardScreen());

    }

    @And("Click to menu left icon")
    public void clickToMenuLeftIcon() {
        homePage.clickToMenuLeftIcon();
    }

    @And("Click to request")
    public void clickToRequest() {
        homePage.clickToRequest();
    }

    @Then("The Request money display with Amount textbox, Email textbox, Request description and Send button")
    public void theRequestMoneyDisplayWithAmountTextboxEmailTextboxRequestDescriptionAndSendButton() {
        Assert.assertTrue(requestMoneyPage.verifyRequestMoneyScreen());
    }

    @And("Click to Setting")
    public void clickToSetting() {
        homePage.clickToSetting();
    }

    @And("Scroll to Change Password")
    public void scrollToChangePassword() {
        editProfilePage.scrollIntoChangePassword();
    }

    @Then("Verify screen display textbox: Current password, New password, Repeat New Password")
    public void verifyScreenDisplayTextboxCurrentPasswordNewPasswordRepeatNewPassword( ) {
            Assert.assertTrue(editProfilePage.verifyChangePasswordDisplay());
    }

    @And("Input {string} and click to the Fund button")
    public void inputAndClickToTheFundButton(String name) {
        buyNewVCPage.enterNameOnCard(name);
        buyNewVCPage.clickToFundButton();
    }

    @And("Add USD amount: {int} and click next icon")
    public void addUSDAmountAmountAndClickNextIcon(int number) {
        buyNewVCPage.enterAmount(String.valueOf(number));
        buyNewVCPage.clickToNextIcon();
    }

    @Then("The screen display error message: {string}")
    public void theScreenDisplayErrorMessage(String message) {
        System.out.println(message);
        Assert.assertTrue(buyNewVCPage.verifyMessage(message));
    }

}
