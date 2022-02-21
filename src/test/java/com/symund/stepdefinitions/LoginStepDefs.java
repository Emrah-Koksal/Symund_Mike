package com.symund.stepdefinitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void User_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }

    @When("User logs in with valid credentials")
    public void User_logs_in_with_valid_credentials() {
        loginPage.loginWithValidCredentials();
    }

    @Then("the {string} should be displayed")
    public void the_should_be_displayed(String expectedTitle) {
        BrowserUtils.waitForPageToLoad(2);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Title does not match", expectedTitle, actualTitle);
    }

    @When("User logs in with {string} and {string}")
    public void UserLogsInWithAnd(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
        String actualMessage = loginPage.invalidCredentialMessage.getText();
        Assert.assertEquals("Error message does not match", expectedMessage, actualMessage);
    }

    @Then("Please fill out this field. message should be displayed")
    public void pleaseFillOutThisFieldMessageShouldBeDisplayed() {

        String expectedEmptyFieldMessage = "Please fill out this field.";
        String actualEmptyFieldMessage = loginPage.usernameBox.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field message doe not match", expectedEmptyFieldMessage, actualEmptyFieldMessage);
    }

    @Then("Please fill out this field. message should be displayed when username  is left empty")
    public void pleaseFillOutThisFieldMessageShouldBeDisplayedWhenUsernameIsLeftEmpty() {
        String expectedEmptyFieldMessage = "Please fill out this field.";
        String actualEmptyFieldMessage = loginPage.usernameBox.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field message doe not match", expectedEmptyFieldMessage, actualEmptyFieldMessage);
    }

    @Then("Please fill out this field. message should be displayed when password  is left empty")
    public void pleaseFillOutThisFieldMessageShouldBeDisplayedWhenPasswordIsLeftEmpty() {
        String expectedEmptyFieldMessage = "Please fill out this field.";
        String actualEmptyFieldMessage = loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field message doe not match", expectedEmptyFieldMessage, actualEmptyFieldMessage);
    }

    @And("the eye icon next to the password box is clicked")
    public void theEyeIconNextToThePasswordBoxIsClicked() {
        loginPage.showPasswordIcon.click();
    }

    @Then("User should see the password explicitly")
    public void UserShouldSeeThePasswordExplicitly() {
        Assert.assertTrue("Password is not displayed", Driver.get().findElement(By.xpath("(//input[@type='text'])[2]")).isDisplayed());
    }

    @When("User enters credentials of {string} and {string}")
    public void UserEntersCredentialsOfAnd(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
    }

    @When("User verifies and clicks on the -Forgot password?-")
    public void UserVerifiesAndClicksOnTheForgotPassword() {
        Assert.assertTrue("Forgot Password is not displayed", loginPage.forgotPassword.isDisplayed());
        loginPage.forgotPassword.click();
    }

    @Then("User verifies Reset Password on the following page")
    public void userVerifiesResetPasswordOnTheFollowingPage() {
        Assert.assertTrue("Reset password is not displayed", loginPage.resetPassword.isDisplayed());
    }

    @Then("User verifies the placeholder on username text box")
    public void userVerifiesThePlaceholderOnUsernameTextBox() {
        String expectedPlaceholder = "Username or email";
        String actualPlaceholder = loginPage.usernameBox.getAttribute("placeholder");
        Assert.assertEquals("The placeholder does not match", expectedPlaceholder, actualPlaceholder);
    }

    @Then("User verifies the placeholder on password text box")
    public void userVerifiesThePlaceholderOnPasswordTextBox() {
        String expectedPlaceholder = "Password";
        String actualPlaceholder = loginPage.passwordBox.getAttribute("placeholder");
        Assert.assertEquals("The placeholder does not match", expectedPlaceholder, actualPlaceholder);
    }


}
