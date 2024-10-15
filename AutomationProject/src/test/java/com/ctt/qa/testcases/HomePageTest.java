package com.ctt.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ctt.qa.pages.HomePage;
import com.ctt.qa.pages.LoginPage;

public class HomePageTest extends HomePage {
	LoginPage loginPage;
	HomePage homepage;
	WebDriverWait wait;
	public HomePageTest(){
		super();
	}
	
	@BeforeSuite
    public void setup() throws InterruptedException{
        initialization();
        loginPage = new LoginPage();
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
	@Test(priority = 1)
    public void titleTest() {
        String title = homepage.validateHomePageTitle();
        // Assert the title here or perform other actions
        Assert.assertEquals(title, "Content Transformation Tool");
    }
	@Test(priority = 2)
    public void VerifyclickOnuserButton() {
	    // Click on the user button
	    homepage.clickOnuserButton();
    }
	
	
	@AfterSuite
    public void closeBrowser() {
        driver.quit();
    }

}
