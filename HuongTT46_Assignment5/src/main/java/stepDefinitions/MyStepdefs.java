package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import pages.CategoryPage;
import pages.HomePage;
import pages.ListProductPage;
import pages.ProductDetailPage;

public class MyStepdefs {

    CategoryPage categoryPage = new CategoryPage();
    HomePage homePage = new HomePage();
    ListProductPage listProductPage = new ListProductPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    @Given("Open TIKI App")
    public void openTIKIApp() {
        homePage.clickToDenyButton();
    }

    @When("Click Danh Muc San Pham")
    public void clickDanhMucSanPham() {
        homePage.clickToCategory();
    }

    @And("Scroll and Click Laptop – May Vi Tinh at Right category")
    public void scrollAndClickLaptopMayViTinhAtRightCategory() throws InterruptedException {
        categoryPage.scrollToLaptopMayViTinhRight();
        categoryPage.clickToLaptopMayViTinhRight();
    }

    @And("Click to Hàng mới")
    public void clickToHangMoi() {
        listProductPage.clickToHangMoi();
    }

    @And("Click to first product")
    public void clickToFirstProduct() {
        listProductPage.clickToFirstProduct();
    }

    @Then("Verify the product name, product price should be displayed")
    public void verifyTheProductNameProductPriceShouldBeDisplayed() {
        productDetailPage.verifyNameAndPriceDisplay();
    }

    @And("Click Điện thoại – Máy tính bảng at Right category")
    public void clickĐiệnThoạiMáyTínhBảngAtRightCategory() {
        categoryPage.clickToDienThoaiMayTinhBangRight();
    }

    @And("Click to the “Lọc” button")
    public void clickToTheLocButton() throws InterruptedException {
       listProductPage.clickToLocButton();
    }

    @And("Scroll to Thương hiệu")
    public void scrollToThươngHiệu() {
        listProductPage.scrollToBrand();
    }

    @And("Select Samsung")
    public void selectSamsung() {
        listProductPage.clickToSamSung();
    }

    @And("Click to Áp Dụng button")
    public void clickToÁpDụngButton() {
        listProductPage.clickToApDungButton();
    }
}
