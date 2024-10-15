package CTTAutoDemo;


	import java.time.Duration;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
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


	public class TestRaw {
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
		public void CTT_Project_LoginPage_Displayed() throws InterruptedException {
			String titile = driver.getTitle();
			Assert.assertEquals(titile, "Content Transformation Tool");
			System.out.println(titile);
			Thread.sleep(4000);
		}
			
		@Test(priority = 2)
		public void CTT_EnterLogin_Details() throws InterruptedException {
			driver.findElement(By.id("username")).sendKeys("aarushp123098@gmail.com");// Enter Gmail
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#password")).sendKeys("OLOtx095");// Password
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button[type='button']")).click();// Login
			Thread.sleep(8000);
	    }
		@Test(priority = 3)
		public void open_assigne_node() throws InterruptedException {
			WebElement parentDiv = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
			 wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement element11 = driver.findElement(By.xpath("(//*[contains(text(), 'aarushCTT1AB')])[2]"));
				element11.click();
				Thread.sleep(15000);
				// Right-click on root node
				WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				// Switch to the iframe
				driver.switchTo().frame(iframe1);
				Thread.sleep(1000);
				// Mouse over to the battery node
				WebElement batteryNode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'VSGDoverProduct')])[1]")));
				Actions actionsA = new Actions(driver);
				actionsA.moveToElement(batteryNode).perform();
				Thread.sleep(3000); // Wait for the menu to appear, adjust time as needed
				// Now perform the actions you need after the mouse hover
				WebElement element11A = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'SKU')]")));
				String text111 = element11A.getText();
				System.out.println(text111);
				Thread.sleep(2000);
		}
		@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
//	        driver.quit();
	    }
}