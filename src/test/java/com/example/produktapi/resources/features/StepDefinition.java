package com.example.produktapi.resources.features;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.List;

public class StepDefinition {

    static WebDriver driver;
   static WebDriverWait wait;
    @Before
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("webshop is available")
    public void webshop_is_available() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);

    }

    @Then("The page contains {string} text")
    public void thePageContainsText(String expectedText) {
        WebElement element = driver.findElement(By.className("display-4"));
        String actualText = element.getText();
        assertEquals(expectedText, actualText);
    }


    @Then("webshop logo should be displayed")
    public void webshopLogoShouldBeDisplayed() {

            WebElement logo = driver.findElement(By.xpath("//a[@class='d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none']/h1"));
            boolean displayedlogo = logo.isDisplayed();
            Assertions.assertTrue(displayedlogo, "The logo should be visible.");
        }


    @When("user click on {string}")
    public void userClickOn(String arg0) throws InterruptedException {
        driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/header/div/div/div/a")).click();
        //Thread.sleep(10000);
        //driver.findElement(By.cssSelector("#main > div:nth-child(1) > div > div > button")).click();

    }

    @Then("{string} should open")
    public void shouldOpen(String arg0) {
        driver.findElement(By.cssSelector("body > main > div.py-5.text-center > h2")).isDisplayed();

    }

    @Then("product page should open")
    public void productPageShouldOpen() {
        driver.findElement(By.xpath("/html/body/div[1]")).isDisplayed();

    }

    @Then("The {string} should visible")
    public void theShouldVisible(String arg0) throws InterruptedException {
        Thread.sleep(10000);
    driver.findElement(By.xpath("//img[@src=\"https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg\"]")).isDisplayed();


    }

    @Given("product page is available")
    public void productPageIsAvailable() {   driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }

    @When("for adding product in cart user  click on add to cart {string}")
    public void forAddingProductInCartUserClickOnAddToCart(String arg0) throws InterruptedException {
        Thread.sleep(10000);
        WebElement xyz =driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(xyz).perform();

        // Now click the button
        xyz.click();
    }

    @Then("check the quantity in the checkout button {string}")
    public void checkTheQuantityInTheCheckoutButton(String checkoutNumber) throws InterruptedException {
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"buttonSize\"]")));
        String quantityText = checkoutButton.getText();
        Thread.sleep(5000);

        Assert.assertEquals(checkoutNumber, quantityText);
    }

    @When("click the checkout button")
    public void clickTheCheckoutButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@type='button' and contains(text(), 'Checkout')]")));
        driver.findElement(By.xpath("//a[@type='button' and contains(text(), 'Checkout')]")).click();
    }

    @Then ("total sum is {string}")
    public void totalSumIs (String expectedTotalSum){
        WebElement listItem = driver.findElement(By.xpath("//li[span[text()='Total (USD)']]"));
        WebElement totalElement = listItem.findElement(By.tagName("strong"));
        String totalSumText = totalElement.getText();
        Assert.assertEquals(totalSumText, expectedTotalSum);
    }

    @Given("the user navigates to Shop")
    public void the_user_navigates_to_shop() {
        //find "Shop" and click
        WebElement element = driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a"));
        element.click();
    }
    @When("showing all categories")
    public void showing_all_categories() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[1]/a"));
        Thread.sleep(4000);
        element.click();
    }
    @Then("there are {int} items listed")
    public void there_are_items_listed(Integer intCount) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col']"));
        assertEquals(intCount, elements.size());
    }

    @AfterAll
        public static void closeDriver() {

            if (driver != null) {
                driver.quit();
            }
        }
}