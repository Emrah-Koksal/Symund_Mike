package com.symund.stepdefinitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import io.cucumber.java.en.When;

public class LogoutStepDefs {

    @When("User clicks on the avatar icon")
    public void userClicksOnTheAvatarIcon() {


        new LoginPage().avatar.click();
    }

    @When("User clicks on the Log Out option from the dropdown menu")
    public void userClicksOnTheLogOutOptionFromTheDropdownMenu() {
        BrowserUtils.waitFor(1);
        new LoginPage().logout.click();
    }

    @When("User clicks step back button")
    public void userClicksStepBackButton() {
        Driver.get().navigate().back();
    }
}
