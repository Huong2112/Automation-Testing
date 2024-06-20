import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("Web browser opens successfully")
    public void webBrowserOpensSuccessfully() {
    }

    @When("Navigate to {string}")
    public void navigateTo(String url) {
    }

    @Then("The web page loads successfully and the Google image is visible")
    public void theWebPageLoadsSuccessfullyAndTheGoogleImageIsVisible() {
    }

    @When("Enter {string} in the search bar")
    public void enterInTheSearchBar(String animalName) {
    }

    @Then("Links related to {string} are shown on the results page")
    public void linksRelatedToAreShownOnTheResultsPage(String animal) {
    }

    @When("Click on the {string} link at the top of the results page")
    public void clickOnTheLinkAtTheTopOfTheResultsPage(String imageTab) {
    }

    @Then("Images related to {string} are shown on the results page")
    public void imagesRelatedToAreShownOnTheResultsPage(String animal) {
    }

    @Given("the user navigates to the Google home page")
    public void theUserNavigatesToTheGoogleHomePage() {
    }

    @When("the user entered {string} at the search bar")
    public void theUserEnteredAtTheSearchBar(String animalName) {
    }

    @Then("the results page shows links related to {string}")
    public void theResultsPageShowsLinksRelatedTo(String animal) {
    }

    @And("image links for {string}")
    public void imageLinksFor(String animal) {
    }

    @And("video links for {string}")
    public void videoLinksFor(String animal) {
    }

    @Given("a web browser is on the Google page")
    public void aWebBrowserIsOnTheGooglePage() {
    }

    @When("the search phrase {string} is entered")
    public void theSearchPhraseIsEntered(String animal) {
    }

    @Then("results for {string} are shown")
    public void resultsForAreShown(String animal) {
    }

    @And("the following related results are shown")
    public void theFollowingRelatedResultsAreShown() {
    }

    @Given("a level is started")
    public void aLevelIsStarted() {
    }

    @When("the player pushes the {string} button")
    public void thePlayerPushesTheButton(String letter) {
    }

    @Then("Mario jumps straight up")
    public void marioJumpsStraightUp() {
    }
}
