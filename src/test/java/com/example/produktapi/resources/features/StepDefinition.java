package com.example.produktapi.resources.features;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.List;



import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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

    @AfterAll
    public static void closeDriver() {

        if (driver != null) {
            driver.quit();
        }
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

    //David Galstyan
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
    public void productPageIsAvailable() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }

    @When("for adding product in cart user  click on add to cart {string}")
    public void forAddingProductInCartUserClickOnAddToCart(String arg0) throws InterruptedException {
        Thread.sleep(10000);
        WebElement xyz = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(xyz).perform();

        // Now click the button
        xyz.click();
    }

    @Then("check the quantity in the checkout button")
    public void checkTheQuantityInTheCheckoutButton() throws InterruptedException {
        WebElement checkoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"buttonSize\"]")));
        String quantityText = checkoutButton.getText();
        Thread.sleep(5000);
        try {
            int quantity = Integer.parseInt(quantityText);
            Assertions.assertTrue(quantity > 0, "Quantity is not greater than 0");
        } catch (NumberFormatException e) {
            Assertions.fail("Quantity text is not a valid integer: " + quantityText);
        }
    }

    @When("click the checkout button")
    public void clickTheCheckoutButton() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@type='button' and contains(text(), 'Checkout')]")));
        driver.findElement(By.xpath("//a[@type='button' and contains(text(), 'Checkout')]")).click();
    }

  
    @Then("total sum is {string}")
    public void totalSumIs(String expectedTotalSum) {

        WebElement listItem = driver.findElement(By.xpath("//li[span[text()='Total (USD)']]"));
        WebElement totalElement = listItem.findElement(By.tagName("strong"));
        String totalSumText = totalElement.getText();
        Assert.assertEquals(totalSumText, expectedTotalSum);
    }

   @Given("the user is on the shop page")
    public void theUserIsOnTheShopPage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products.html#");

    }

    @Then("the user should see the following categories:")
    public void theUserShouldSeeTheFollowingCategories(DataTable dataTable) {
        List<String> expectedCategories = dataTable.asList(String.class);
              for (String category : expectedCategories) {
                  String xpath = String.format("//a[normalize-space()='%s']", category);
                     List<WebElement> categoryElements = driver.findElements(By.xpath(xpath));
                       assertTrue("Category not found: " + category, !categoryElements.isEmpty());
        }

    }


    //David Galstyan
    @Given("user navigates to Webshop")
    public void user_navigates_to_webshop() throws InterruptedException {
        Thread.sleep(2000);
        //hitta och klicka "Webshop" knappen
        WebElement element = driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a"));
        element.click();
    }

    //David Galstyan
    @When("adding 2x'Mens Cotton Jacket' to the cart")
    public void adding_2x_mens_cotton_jacket_to_the_cart() throws InterruptedException {
        Thread.sleep(2000);

        WebElement element = driver.findElement(By.xpath("/html/body/main/div[3]/div/div/button"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        //lägg till två "Mens Cotton Jacket" i varukorgen genom att klicka på "Add to cart" knappen två gånger
        element.click();
        element.click();
    }


    //David Galstyan
    @When("navigating to Checkout")
    public void navigating_to_checkout() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/header/div/div/div/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element.click();
    }

    //David Galstyan
    @Then("there are 2x'Mens Cotton Jacket' in the cart costing {double} each")
    public void there_are_2x_mens_cotton_jacket_in_the_cart_costing_each(Double double1) throws InterruptedException {
        Thread.sleep(2000);
        //Kontrollera namn på första artikeln
        WebElement element = driver.findElement(By.xpath("//*[@id=\"cartList\"]/li[1]/div/h6"));
        Assertions.assertEquals("Mens Cotton Jacket", element.getText());
        //Kontrollera namn på andra artikeln
        element = driver.findElement(By.xpath("//*[@id=\"cartList\"]/li[2]/div/h6"));
        Assertions.assertEquals("Mens Cotton Jacket", element.getText());
    }


    //David Galstyan
    @Then("the total price is {string}")
    public void the_total_price_is(String stringPrice) {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"cartList\"]/li[3]/strong"));
        Assertions.assertEquals(stringPrice, element.getText());
    }


    //David Galstyan
    @Given("the user navigates to Shop")
    public void the_user_navigates_to_shop() {
        //find "Shop" and click
        WebElement element = driver.findElement(By.xpath("/html/body/header/div/div/ul/li[2]/a"));
        element.click();
    }


    //David Galstyan
    @When("showing all categories")
    public void showing_all_categories() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[1]/a"));
        Thread.sleep(4000);
        element.click();
    }


    //David Galstyan
    @Then("there are {int} items listed")
    public void there_are_items_listed(Integer intCount) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='col']"));
        assertEquals(intCount, elements.size());
    }


    @When("user search for {string}")       //Ninis
    public void userSearchFor(String arg0) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div/form/input"));
//click on search box
        searchBox.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "var inputEvent = new Event('input', { 'bubbles': true, 'cancelable': true });" +
                "arguments[0].value = arguments[1];" +
                "arguments[0].dispatchEvent(inputEvent);" +
                "var keydownEvent = new KeyboardEvent('keydown', { 'key': 'a', 'bubbles': true, 'cancelable': true });" +
                "arguments[0].dispatchEvent(keydownEvent);";
        js.executeScript(script, searchBox, "women");

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
    }

    @Then("the search result should be displayed")      // NInis
    public void theSearchResultShouldBeDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // wait for a maximum of 20 seconds

        // Wait until at least one element that matches the xpath is present in the DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='card h-100 p-3']")));

        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='card h-100 p-3']"));
        assertFalse(elements.isEmpty(), "The search result should not be empty.");

        //Print each element in the list
        /*for (WebElement element : elements) {
            System.out.println(element.getText());
        }*/
    }
      
    @AfterAll
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}