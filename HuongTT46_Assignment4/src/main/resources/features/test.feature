Feature: Google Searching
  Scenario: Search image
    Given Web browser opens successfully
    When Navigate to "https://www.google.com/"
    Then The web page loads successfully and the Google image is visible
    When Enter "panda" in the search bar
    Then Links related to "panda" are shown on the results page
    When Click on the "Images" link at the top of the results page
    Then Images related to "panda" are shown on the results page

  Scenario: Google search result page elements
    Given the user navigates to the Google home page
    When the user entered "panda" at the search bar
    Then the results page shows links related to "panda"
    And image links for "panda"
    And video links for "panda"
  Scenario: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "panda" is entered
    Then results for "panda" are shown
    And the following related results are shown
      | related |
      | Panda Express |
      | giant panda |
      | panda videos |

  Scenario: Mario jumps
    Given a level is started
    When the player pushes the "A" button
    Then Mario jumps straight up

  Scenario Outline: Mario jumps
    Given a level is started
    When the player pushes the "<letter>" button
    Then Mario jumps straight up

    Examples: Buttons
      | letter |
      | A |
      | B |