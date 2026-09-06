package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  public WebElement getTitle() {
    return title;
  }

  @FindBy(xpath = "//h2[contains(text(), 'Available Examples')]/following-sibling::ul/li")
  private List<WebElement> exampleLinks;

  public List<String> getExampleTexts() {
    List<String> exampleTexts = new ArrayList<>();
    for (WebElement element: exampleLinks ){
      exampleTexts.add(element.getText());
    }
    return exampleTexts;
  }
}
