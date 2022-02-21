package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement submit;

    @FindBy(xpath = "//div[@id='submit-wrapper']/../p[3]")
    public WebElement invalidCredentialMessage;

    @FindBy(xpath = "//img[@src='/core/img/actions/toggle.svg']")
    public WebElement showPasswordIcon;

    @FindBy(id = "lost-password")
    public WebElement forgotPassword;

    @FindBy(id = "reset-password-submit")
    public WebElement resetPassword;



    public void login(String username, String password){
        BrowserUtils.waitForVisibility(usernameBox,5);
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        submit.click();
    }

    public void loginWithValidCredentials(){
        BrowserUtils.waitForVisibility(usernameBox,5);
        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        submit.click();
    }

}
