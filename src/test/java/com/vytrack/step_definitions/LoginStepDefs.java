package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.html5.RemoteWebStorage;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        //Thread.sleep(4000);
        String url = ConfigurationReader.get("url");
        // WebDriver driver= Driver.get();
        Driver.get().get(url);
        // System.out.println("I open browser");

       }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() {
        // System.out.println("user name ,password and login");
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
       }

        @Then("the user should be able to login")
        public void the_user_should_be_able_to_login() {
        //System.out.println("I verify that title changed to Dashboard");
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
        }
       @When("the user enters the sales manager information")
       public void the_user_enters_the_sales_manager_information () {
           //System.out.println("I enter sales manager username and password");
           String username = ConfigurationReader.get("sales_manager_usernamee");
           String password = ConfigurationReader.get("sales_manager_password");
           LoginPage loginPage = new LoginPage();
           loginPage.login(username, password);
        }
        @When("the user enters the store manager information")
        public void the_user_enters_the_store_manager_information () {
           //System.out.println("I enter store manager username and password");
            String username = ConfigurationReader.get("store_manager_username");
            String password = ConfigurationReader.get("store_manager_password");
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
        }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));

    }
}




