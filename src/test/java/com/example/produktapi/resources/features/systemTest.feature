Feature: Page Loading

  Background: webshop is available
    Given webshop is available

  Scenario: webshop should show correct title
    Then the title should be "Webbutiken"

  Scenario: the page is loaded
    Then The page contains "This shop is all you need" text

