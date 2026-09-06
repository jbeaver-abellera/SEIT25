package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.data.Data;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.BasicAuth;
import io.cucumber.pages.SortableTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableTableSteps extends Context {

  private final SortableTable sortableTable;
  Map<String, List<List<String>>> tableDictionary = new HashMap<>();


  public SortableTableSteps(Manager manager) {
    super(manager);
    this.sortableTable = new SortableTable(this.driver);
  }

  @When("{string} table is under test")
  public void getTable(String tableName) {
    String tableId = "";

    if (tableName.equals("Example 1")) {
      tableId = "table1";
    }

    List<String> headers = sortableTable.getTableHeaders(tableId);
    List<List<String>> tableContents = sortableTable.getTableCellsById(tableId);
    tableContents.addFirst(headers);

    tableDictionary.put(tableName, tableContents);
  }

  @Then("{string} actual tables should match the expected tables")
  public void verifyTables(String tableName) {
    List<List<String>> expectedTableData;
    if (tableName.equals("Example 1")){
      expectedTableData = Data.ExpectedTable1;
    }
    else { expectedTableData = new ArrayList<>();
    }

    assertEquals(
            expectedTableData,
            tableDictionary.get(tableName)
    );
  }
}