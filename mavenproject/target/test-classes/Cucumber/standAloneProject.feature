
@tag checking the standAloneProject
Feature: Title of your feature
  I want to use this template for my feature file
@background
Given landing page for ecommerece site

  @tag2
  Scenario Outline: positive test of standAlone
    Given logged with given user <username> and password <password>
    When check the order is added to the cart
    Then verify that browser is closed automaticallyin step

    Examples: 
      | name                 | password      | status  |
      | vajmeera@gmail.com	 |     Anil@444  | success |
      | vajmeera@gmail.com   |     Raj@444   | Fail    |
