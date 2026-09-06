package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.data.Data;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.BasicAuth;
import io.cucumber.pages.Home;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAuthSteps extends Context {

  private final BasicAuth basicAuth;
  List<String> actualExamples;

  public BasicAuthSteps(Manager manager) {
    super(manager);
    this.basicAuth = new BasicAuth(this.driver);
  }

  @When("the Basic Auth example is opened and credentials are {string}")
  public void openBasicAuthLogin(String credentialType) {
    String username;
    String password;
    if (credentialType.equals("valid")){
      username = "admin";
      password = "admin";
    }
    else {
      throw new IllegalArgumentException("'credentialType' invalid");
    }

    String authURL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
    basicAuth.get(authURL);
  }

  @Then("Congratulations should be displayed")
  public void isUserAuthenticated(){
    basicAuth.getCongratulationsMessage().getText();
  }
  }