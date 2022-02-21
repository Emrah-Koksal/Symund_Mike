package com.symund.stepdefinitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import io.cucumber.java.en.When;

public class LogoutStepDefs {

    @When("User clicks on the avatar icon")
    public void userClicksOnTheAvatarIcon() {

        BrowserUtils.waitFor(2);
        new LoginPage().avatar.click();
    }

    @When("User clicks on the Log Out option from the dropdown menu")
    public void userClicksOnTheLogOutOptionFromTheDropdownMenu() {
        BrowserUtils.waitFor(1);
        new LoginPage().logout.click();
    }
}