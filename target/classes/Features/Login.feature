
@smoketest
Feature: Login

  @TC_101
  Scenario: As a user, must do sucessfully login with valid credential
    Given Open a browser
    And Go to application URL
    When Click Sign in BTN
    And put user email address
    And Put password
    And Click Second login BTN 
    Then Validation

 