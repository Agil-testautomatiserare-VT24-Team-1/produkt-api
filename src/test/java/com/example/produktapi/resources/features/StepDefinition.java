package com.example.produktapi.resources.features;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.junit.runner.RunWith;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.List;

import io.cucumber.datatable.DataTable;

public class StepDefinition {

    static WebDriver driver;
   static WebDriverWait wait;
    @Before
    public static void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
    public void clickTheCheckoutButton(){
        driver.findElement(By.cssSelector(".btn-warning")).click();
    }


        @When("the user clicks on the {string} button")
        public void theUserClicksOnTheButton(String buttonName) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (10));
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-lg px-4 me-md-2 fw-bold']")));
            button.click();
        }

        @Then("user product page should open")
        public void userProductPageShouldOpen() {
            driver.get("https://webshop-agil-testautomatiserare.netlify.app/products.html");
            // Add assertions to verify that the product page has opened, if necessary
        }



    @Then ("total sum is {string}")
    public void totalSumIs (String expectedTotalSum){
        WebElement listItem = driver.findElement(By.xpath("//li[span[text()='Total (USD)']]"));
        WebElement totalElement = listItem.findElement(By.tagName("strong"));
        String totalSumText = totalElement.getText();
        Assert.assertEquals(totalSumText, expectedTotalSum);
    }

        @AfterAll
        public static void closeDriver() {

            if (driver != null) {
                driver.quit();
            }
        }
   }












