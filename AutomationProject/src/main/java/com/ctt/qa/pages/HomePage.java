package com.ctt.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ctt.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")
	WebElement loginPersonName;
	
	public String getUserNameText() {
		String displayName = loginPersonName.getText();
		System.out.println("Login Person Name: " + displayName);
		return displayName;
	}
	@FindBy(xpath = "(//button[normalize-space()='Users'])[1]")
	private
	 WebElement userButton;
	


public HomePage(){
//    super();
    PageFactory.initElements(driver, this);
}
public String validateHomePageTitle() {
    return driver.getTitle();
} 

public HomePage clickOnuserButton() {
	userButton.click();
	return new HomePage();
}
public By getUserButton() {
	// TODO Auto-generated method stub
	return null;
}

}