package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    @Given("Open RAWAL application")
    public void openRAWALApplication() {

    }

    @When("I click to What are you looking for?")
    public void iClickToWhatAreYouLookingFor() {
        homePage.clickToSearchBox();
    }

    @And("Input {string}")
    public void input(String productName) {
        searchPage.search(productName);
    }

    @Then("The search page will display {int} product")
    public void theSearchPageWillDisplayNumberOfProductsProduct(int number) {
        Assert.assertTrue(searchPage.verifySearchResults(number));
    }
}
