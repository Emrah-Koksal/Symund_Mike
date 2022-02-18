package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".app-icon")
    public WebElement moduleIcons;

    public void navigateTo(String moduleText) {
        BrowserUtils.waitForVisibility(moduleIcons,2);
        WebElement module = Driver.get().findElement(By.linkText(moduleText));
        module.click();

    }
}
