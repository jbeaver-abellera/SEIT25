package io.cucumber.glue;

import io.cucumber.java.en.Given;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.Home;
import io.cucumber.data.Data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeSteps extends Context {

  private final Home home;
  List<String> actualExamples;

  public HomeSteps(Manager manager) {
    super(manager);
    this.home = new Home(this.driver);
  }

  @When("the home page actual list of examples are retrieved")
  public void getListOfExamples() {
    actualExamples = home.getExampleTexts();
  }

  @Then("the home page actual examples should match the expected examples")
  public void verifyExamples() {
    assertEquals(
            Data.ExpectedAvailableExamples,
            actualExamples
      );
    }
  }