# Selenium Java Automation

This repository contains my assigned work for the Selenium Java automation project.

## My Contributions

I was tasked with implementing the following:

* **Features** – Finised `src/test/resources/io.cucumber.features/theInternet.feature` to define test scenarios required.
* **Pages** – Created `Basic Auth`, `Home`, and `Sortable Table` under `src/test/java/io.cucumber/pages`. Also improved 
`Page` with table and get methods.
* **Steps** – Created step definition classes that connect the Cucumber feature steps to the automation code.
* **Data** - A Java class containing all data. For now, it only contains expected values, but can expand to house
more data such as credential data. Since the website is also small, I opted to use single class for all data.

## Step Organization

Step definition files are grouped according to their corresponding pages to keep the project structure
organized and maintainable.

## Scenarios
### Scenario 1: Homepage has a list of links to Expected examples
* Retrieved the list of examples by looping through WebElements of examples, then using `getText()`
* Stored the list of examples in the step properties
* Compared it with actual values that were in `/data` dir

### Scenario 2: Basic Auth allows validated access
* Since 'Basic Auth' in the Internet implements Basic HTTP Authentication, automation
scripts cannot login using `ActionChains` or by using `sendKeys()` on a WebElement.
* Thus, steps will ask for credential type on the feature definition. Depending on the credential type,
the credentials will be filled in the url.
* The test step will then open this URL, and will return an HTML page if user should be authenticated or not

### Scenario 3: Sortable Data Tables - Example 1 displays the expected 4 results
* Similar to Scenario 1, actual values are also in `/data` dir. It can be extended to house multiple tables
* The tables can be retrieved by specifying the table name, which the steps will convert to tableId, an identifier in 
the data directory.
* The method to retrieve table is also placed in the parent `Page` class. This is so that if other pages need 
to retrieve a table, it is available as long as they inherit `Page` class.

## Notes
> Under `@TEST_TI_0001`, I have marked it as xfail, since the list of available examples are not equal to 
the actual examples. It might be possible that the expected values are outdated. I will be keeping the test to 
fail for now until confirmed.
