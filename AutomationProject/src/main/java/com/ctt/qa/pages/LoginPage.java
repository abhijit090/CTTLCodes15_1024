package com.ctt.qa.pages;

	import java.io.IOException;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	import com.ctt.qa.base.TestBase;

	public class LoginPage extends TestBase {
	    
	    @FindBy(id="username")
	    WebElement username;
	    
	    @FindBy(id="password")
	    WebElement password;
	    
	    @FindBy(xpath = "//button[normalize-space()='Login']")
	    WebElement loginBtn;
	    
	    @FindBy(xpath="(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")
		WebElement loginPersonName;
		
		public String getUserNameText() {
			String displayName = loginPersonName.getText();
			System.out.println("Login Person Name: " + displayName);
			return displayName;
		}
		

	    // Constructor for LoginPage class
	    public LoginPage(){
//	        super();
	        PageFactory.initElements(driver, this);
	    }
	    
	    // Action
	    public String validateLoginPageTitle() {
	        return driver.getTitle();
	    } 

	    // Login page details
	    public HomePage login(String un, String pwd) {
	        username.sendKeys(un);
	        password.sendKeys(pwd);
	        loginBtn.click();
	        return new HomePage();
	    }
}
