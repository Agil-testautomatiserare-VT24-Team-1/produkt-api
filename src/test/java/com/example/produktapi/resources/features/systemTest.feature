Feature: Page Loading

  Background: webshop is available
    Given webshop is available

  Scenario: webshop should show correct title
    Then the title should be "Webbutiken"


  Scenario: the page is loaded
    Then The page contains "This shop is all you need" text

  Scenario: The logo is visible
  Given webshop is available
  Then webshop logo should be displayed

  Scenario: product page is visible
    Given webshop is available
    When user click on "shop"
    Then product page should open

  Scenario: checkout button is clickable
    Given webshop is available
    When user click on "checkout"
    Then "Checkout form page" should open

  Scenario: product images is visible
    Given webshop is available
    When product page should open
    Then  The "images" should visible

  Scenario: product is added in to the cart
    Given product page is available
    When  for adding product in cart user  click on add to cart "+Add to cart"
    Then check the quantity in the checkout button

    Scenario: There are 20 items in all category
      Given the user navigates to Shop
      When showing all categories
      Then there are 20 items listed