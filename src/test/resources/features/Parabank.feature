Feature: Parabank Automation

  Scenario: Verify registration page
    Given user opens the Parabank homepage
    When user clicks the Register link
    Then the registration page should be displayed


  Scenario: Register a new user
    Given user opens the Parabank homepage
    When user clicks the Register link
    And user enters the valid registration details
    And user clicks the Register button
    Then the account should be created successfully


  Scenario: Login and open a new bank account
    Given user opens the Parabank homepage
    When user enters the valid username and password
    And user clicks the login button
    Then the account overview page should be displayed
    Then user clicks the Open New Account link
    And user selects the account type and select fromaccount
    And user clicks the Open New Account button
    Then verify the new bank account successfully created by the user
    And user navigates to Accounts Overview
    Then the Accounts Overview page should be displayed and screenshot should be captureed


  Scenario: Login with valid credentials
    Given user opens the Parabank homepage
    When user enters the valid username and password
    And user clicks the login button
    Then the account overview page should be displayed

  Scenario: Logout with valid credentials
    Given user opens the Parabank homepage
    When user enters the valid username and password
    And user clicks the login button
    Then the account overview page should be displayed
    When user clicks the logout button
    Then user should be logged out successfully


  Scenario Outline: Transfer funds between accounts
    Given user opens the Parabank homepage
    When user enters the valid username and password
    And user clicks the login button
    Then the account overview page should be displayed
    When user clicks the Transfer Funds link
    And user enters the transfer amount "<amount>"
    And user clicks the Transfer button
    Examples:
      | amount |
      | 10000    |

  Scenario Outline: Bill Payment
    Given user opens the Parabank homepage
    When user enters the valid username and password
    And user clicks the login button
    Then the account overview page should be displayed
    Then user clicks the Bill Pay link
    And user enters the payee detail
    And user enters the bill payment amount "<amount>"
    And user clicks the Send Payment button
    Then the bill payment should be completed successfully
    Examples:
      | amount |
      | 5000     |

    Scenario Outline: Loan Request
      Given user opens the Parabank homepage
      When user enters the valid username and password
      And user clicks the login button
      Then the account overview page should be displayed
      When user clicks the Request Loan link
      And user enters the loan amount "<loanAmount>"
      And user enters the down payment "<downPayment>"
      And user clicks the apply now button
      Then the loan request result should be displayed
      Examples:
        | loanAmount | downPayment |
        | 5000       | 1000        |










