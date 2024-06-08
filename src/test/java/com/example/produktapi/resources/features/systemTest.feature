Feature: Page Loading

  Background: webshop is available
    Given webshop is available

  Scenario: webshop should show correct title
    Then the title should be "Webbutiken"

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




