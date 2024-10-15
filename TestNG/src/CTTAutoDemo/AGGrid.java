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


	public class AGGrid {
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

			// Find the specific project name within the parent div class
			WebElement projectNameElement = parentDiv.findElement(By.xpath(".//*[contains(text(), 'aarushCTTAB')]"));
			wait.until(ExpectedConditions.visibilityOf(projectNameElement));

			// Click on the drop down
			WebElement assignUserButton = parentDiv.findElement(By.xpath(".//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
			assignUserButton.click();

			// Click on the specific node (e.g., "Switches")
			WebElement switchesNode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[contains(text(), 'Switches')]")));
			switchesNode.click();
			Thread.sleep(4000);
			// Click on home page
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/p/button[1]")).click();
			Thread.sleep(4000);
		}
		
		@Test(priority = 4, enabled = false)
		public void OpenSameProject_ChecksHeaderTab() throws InterruptedException {
			// Open specific
				WebElement element11 = driver.findElement(By.xpath("//*[contains(text(), 'aarushCTTAB')]"));
				element11.click();
				Thread.sleep(15000);
				// Right-click on root node
				WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				// Switch to the iframe
				driver.switchTo().frame(iframe1);
				Thread.sleep(1000);
				//Visible buttons checked on VIZ tool screen
				//click on the  pop button on header and Verify aatribuite
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				WebElement nodeTextElement11 = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				Actions actions1 = new Actions(driver);
				actions1.moveToElement(nodeTextElement11).perform();
				Thread.sleep(4000);
				//Close aatribute screen
				WebElement nodeTextElement12 = driver
						.findElement(By.xpath("//*[@id=\"closeicon\"]/img"));
				nodeTextElement12.click();
				Thread.sleep(2000);
				//Click on the Attribute verify SKU
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				WebElement nodeTextElement1 = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				nodeTextElement1.click();
				Thread.sleep(4000);
				//  Click on the  node 
				WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Electronic Components')])[1]"));
				Actions actions1s = new Actions(driver);
				actions1s.moveToElement(rootnode11).perform();
				Thread.sleep(4000);
				//close sku table 
				WebElement nodeTextElement16 = driver
						.findElement(By.xpath("//*[@id=\"closeicon\"]/img"));
				nodeTextElement16.click();
				Thread.sleep(2000);
				
				//Click on the Sku & verified Ag gridscreen
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(3000);
				WebElement nodeTextElementag = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				Actions actions1g = new Actions(driver);
				actions1g.moveToElement(nodeTextElementag).perform();
				Thread.sleep(3000);
				
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement nodeTextElement19 = driver
						.findElement(By.cssSelector("button[aria-label='close']"));
				nodeTextElement19.click();
				Thread.sleep(3000);
//				WebDriverWait wait = new WebDriverWait(driver, 10);
//				WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='close']")));
//	             myElement.click();
//				nodeTextElement19.click();
				//Verifyed pivotree logo and add search 
				WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				driver.switchTo().frame(iframe);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				WebElement nodeTextElementagq = driver.findElement(By.xpath("//*[@id=\"menucontainer\"]/div[1]"));
				Actions actions1gd = new Actions(driver);
				actions1gd.doubleClick(nodeTextElementagq).perform();
				Thread.sleep(4000);
				//Click on the rightClick
				WebElement nodeTextElementag1 = driver
						.findElement(By.xpath("//*[contains(text(), 'Welding Equipment')]"));
				Actions actions1g1 = new Actions(driver);
				actions1g1.contextClick(nodeTextElementag1).perform();
				Thread.sleep(2000);
			//  click on child name
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Search Taxonomy in Database')]")).click();
				Thread.sleep(4000);
				//delet&rollup
				driver.findElement(By.xpath("//*[@id=\"menucontainer\"]/div[1]")).click();
				Thread.sleep(4000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(-200, 0)");
				Thread.sleep(4000);
				WebElement nodeTextElementag1p = driver
						.findElement(By.xpath("//*[contains(text(), 'Results from Natalie Database')]"));
				Actions actions1g1p = new Actions(driver);
				actions1g1p.contextClick(nodeTextElementag1p).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete & roll-up')]")).click();
				Thread.sleep(4000);
				//Switch back to the default content (main page)
				driver.switchTo().defaultContent();
				// Click on home page
				driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/p/button[1]"))
						.click();
				Thread.sleep(6000);
		}
		
		
		@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
//	        driver.quit();
	    }
}

	//click on the same project drop down and open assign node
	// Locate the parent div class that contains all the project names
//	WebElement parentDiv11w11 = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
//	Thread.sleep(4000);
//	// Find the specific project name within the parent div class
//	WebElement project11e = parentDiv11w11.findElement(By.xpath("//*[contains(text(), 'aarushCTTAB')]"));
//	Thread.sleep(4000);
//	//Click on the drop down
//	WebElement assignUserButton11e = project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
//		assignUserButton11e.click();
//	Thread.sleep(4000);
//	// Click on the specific node (e.g., "Switches")
//	List<WebElement> TestAb = driver.findElements(By.xpath("(//*[contains(text(),'Switches')])"));
//	
//	for(
//		WebElement ele1 : TestAb
//	) 
//	{
//		
//		if(ele1.getText().equalsIgnoreCase("Switches"))
//		{
//			
//			ele1.click();
//		}
//	}
//	
//	Thread.sleep(4000);

