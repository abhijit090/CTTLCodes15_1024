package Testdemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleTitileTest {
	WebDriver driver;
	@BeforeMethod
	public void appLaunch() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login");
		Thread.sleep(8000);
		
		
	}
	
	@Test(priority = 1,groups = "Page Title")
	public void cttProject() throws InterruptedException {
        // CTT Login Page
//		System.out.println("Pagetitle: " + driver.getTitle());
		String titile = driver.getTitle();
		Assert.assertEquals(titile, "Content Transformation Tool");
		System.out.println(titile);
		Thread.sleep(4000);
//		int a = 9/0;
   
    }
	@Test(priority = 2,groups = "Fail Data")
	public void Testdata() throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]"));
		String displayName = element.getText();
		System.out.println("Login Person Name: " + displayName);
		Thread.sleep(2000);
    }
	
	@AfterMethod
    public void closeBrowser() {
        // Close the WebDriver instance
        driver.quit();
    }
}
