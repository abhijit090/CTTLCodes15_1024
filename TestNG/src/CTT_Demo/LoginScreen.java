package CTT_Demo;



	

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScreen { 
		private static String iframe;
		public static String screenShotSubFoderName;
		private  WebDriver driver;
		WebDriverWait wait;
		
		@BeforeSuite
		public void appLaunch() throws InterruptedException {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
			 driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login");
			Thread.sleep(2000);
				
		}
		 
		@Test(priority = 1)
		public void CTT_Login_Page_Displayed_And_Enters_Login_Details() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login");

	        // Wait until the title matches the expected title
	        wait.until(ExpectedConditions.titleIs("Content Transformation Tool"));

	        // Get the title of the page
	        String title = driver.getTitle();

	        // Verify that the title matches the expected title
	        Assert.assertEquals(title, "Content Transformation Tool");

	        // Print the title
	        System.out.println(title);
			
			// Find and fill the username field
	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	        usernameField.sendKeys("aarushp123098@gmail.com");

	        // Find and fill the password field
	        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
	        passwordField.sendKeys("OLOtx095");

	        // Find and click the login button
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
	        loginButton.click();
	        Thread.sleep(8000);

	    }
		@Test(priority = 2)
		public void Verify_Login_Person_Name() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
			String displayName = element.getText();
			System.out.println("Login Person Name: " + displayName);	
			Thread.sleep(4000);
		}
		@Test(priority = 3)
		public void open_Specific_Project() throws InterruptedException {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement parent = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
			// Find the specific project name within the parent div class
			WebElement projectName = parent.findElement(By.xpath("(//*[contains(text(), 'aarushCTT1AB')])[2]"));
			projectName.click();
			Thread.sleep(4000);
		}
		
		@Test(priority = 4)
		public void Open_AGGrid_Screen() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			// Switch to the iframe
			driver.switchTo().frame(iframe1);
			Thread.sleep(3000);
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), '40K IP GAMES')])[1]")));
			nodeTextElement1.click();
			Thread.sleep(2000);
			//Visible buttons checked on VIZ tool screen
			//click on the  pop button on header and Verify aatribuite
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//Click on the Attribute verify SKU
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//Click on the Sku & verified Ag gridscreen
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//  Click on the  node 
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), '40K IP GAMES')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(4000);
			//clocse ag grid
//			WebElement closetab11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='close']")));
//			closetab11.click();
//			Thread.sleep(2000);/
			WebElement closetab11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Save']")));
			closetab11.click();
			// Switch back to the default content (main page)
//			driver.switchTo().defaultContent();
			// Click on home page
//			WebElement homeButton = wait
//					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
//			homeButton.click();
//			Thread.sleep(2000);
			
		}	
		
		
		
		@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
	        driver.quit();
	    }
}



