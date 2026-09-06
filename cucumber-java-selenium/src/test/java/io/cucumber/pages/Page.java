package io.cucumber.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Page {

  protected ChromeDriver driver;

  public Page(ChromeDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
    waitForPageLoad();
  }

  public void waitForPageLoad() {
    new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(webDriver ->
                    ((JavascriptExecutor) webDriver)
                            .executeScript("return document.readyState")
                            .equals("complete")
            );
  }

  public WebElement waitUntilVisible(By locator) {
    return new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void get(String url){
    driver.get(url);
    waitForPageLoad();
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }

  public List<WebElement> getTableRowsByIndex(String tableId, int rowNum) {
    String adjustedRowNum = String.valueOf(rowNum + 1); //Because xpath indexing starts at 1
    String rowXpath = String.format("/tbody/tr[%s]",adjustedRowNum);

    WebElement table = driver.findElement(By.id(tableId));
    List<WebElement> row = table.findElements(By.xpath(rowXpath));

    return row;
  }

  public String getTableCellByIndex(String tableId, int rowNum, int colNum) {
    String adjustedRowNum = String.valueOf(rowNum + 1); //Because xpath indexing starts at 1
    String adjustedColNum = String.valueOf(colNum + 1); //Because xpath indexing starts at 1

    String colXpath = String.format("/tbody/tr[%s]/td[%s]", adjustedRowNum, adjustedColNum);

    WebElement table = driver.findElement(By.id(tableId));
    WebElement column = (WebElement) table.findElement(By.xpath(colXpath));

    return column.getText();
  }

  public List<String> getTableHeaders(String tableId) {
    List<String> headerTexts = new ArrayList<>();

    WebElement table = driver.findElement(By.id(tableId));
    List<WebElement> headerElements = table.findElements(By.xpath("./thead//th"));

    for (WebElement element: headerElements){
      String headerText = element.getText();
      headerTexts.add(headerText);
    }
    return headerTexts;
  }

  public List<List<String>> getTableCellsById(String tableId) {
    List<List<String>> cellTexts = new ArrayList<>();

    WebElement table = driver.findElement(By.id(tableId));

    List<WebElement> tableRows = table.findElements(By.xpath("./tbody/tr"));

    for (int row = 0; row < tableRows.size(); row++) {
      cellTexts.add(new ArrayList<>());
      List<WebElement> cells = tableRows.get(row).findElements(By.xpath("./td"));
      for (int col = 0; col < cells.size(); col++){
        String cellText = cells.get(col).getText();
        cellTexts.get(row).add(cellText);
      }
    }
    return cellTexts;
  }
}