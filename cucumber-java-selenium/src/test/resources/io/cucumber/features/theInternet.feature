Feature: The Internet
  This feature covers (some) Example pages on 'the-internet.herokuapp.com'

  @xfail #Expected values look outdated
  @TEST_TI_0001
  Scenario: Homepage has a list of links to Expected examples
    Given the page under test is "https://the-internet.herokuapp.com"
    When the home page actual list of examples are retrieved
    Then the home page actual examples should match the expected examples

  @TEST_TI_0002
  Scenario: Basic Auth allows validated access
    Given the page under test is "https://the-internet.herokuapp.com"
    When the Basic Auth example is opened and credentials are "valid"
    Then Congratulations should be displayed

  @TEST_TI_0003
  Scenario: Sortable Data Tables - Example 1 displays the expected 4 results
    Given the page under test is "https://the-internet.herokuapp.com/tables"
    When "Example 1" table is under test
    Then "Example 1" actual tables should match the expected tables
