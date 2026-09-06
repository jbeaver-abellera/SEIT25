package io.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SortableTable extends Page {


    public SortableTable(ChromeDriver driver) {
        super(driver);
    }

    public List<String> getTableHeaders(String tableId) {
        List<String> headerTexts = new ArrayList<>();

        WebElement table = driver.findElement(By.id(tableId));
        List<WebElement> headerElements = table.findElements(By.xpath("./thead//th"));
        int sortableTableColSize = headerElements.size() -1; // We will not include the 'Action' column

        for (int i = 0; i < sortableTableColSize; i++) {
            String headerText = headerElements.get(i).getText();
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
            List<WebElement> rowCells = tableRows.get(row).findElements(By.xpath("./td"));

            int sortableTableColSize = rowCells.size() -1; // We will not include the 'Action' column
            for (int col = 0; col < sortableTableColSize; col++){
                String cellText = rowCells.get(col).getText();
                cellTexts.get(row).add(cellText);
            }
        }
        return cellTexts;
    }

}
