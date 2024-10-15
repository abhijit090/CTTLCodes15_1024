package CTT_STG;

	import java.time.Duration;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	public class GetSKUMetaData {
			private static String iframe;
			public static String screenShotSubFoderName;
			public static WebDriver driver;
			WebDriverWait wait;
			static WebDriver browser;
			final String serachtext="Test";
			final String Actiontest="Test";
			@BeforeSuite
			public void appLaunch() throws InterruptedException {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				System.setProperty("webdriver.chrome.driver","C:\\Users\\ruchika.dube\\eclipse-workspace\\ContentDEV\\src\\main\\resources\\driver\\chromedriver-win64\\chromedriver.exe");
				 driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get("https://staging.d36z6oo50ky8dh.amplifyapp.com/login");
				Thread.sleep(2000);
			}
			@Test(priority = 1)
			public void CTT_Project_LoginPage_Displayed() throws InterruptedException {
				String titile = driver.getTitle();
				Assert.assertEquals(titile, "Content Transformation Tool");
				System.out.println(titile);
				Thread.sleep(2000);
			}
			@Test(priority = 2)
			public void CTT_EnterLogin_Details() throws InterruptedException {
				driver.findElement(By.id("username")).sendKeys("aarushwagh133@gmail.com");// Enter Gmail
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("#password")).sendKeys("hiFHM4As");// Password
				Thread.sleep(1000);
				driver.findElement(By.cssSelector("button[type='button']")).click();// Login
				Thread.sleep(6000);
		    }
			@Test(priority =3)
			public void  Projectexplore() throws InterruptedException {
			Thread.sleep(2500);
			WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'Grainger 1.5')])[1]"));
			testAb.click();
			Thread.sleep(6000);
			// Right-click on root node
			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			// Switch to the iframe
			driver.switchTo().frame(iframe1);
			Thread.sleep(5000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'NPI')]")));
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
			//hover to Element
			WebElement rootnode11 = driver.findElement(By.xpath("//*[contains(text(), 'NPI')]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);	
			driver.findElement(By.xpath("//button[@aria-label=\"maximize\"]")).click();
		    Thread.sleep(2000);
			}	
			@Test(priority =4)
			public void  GetSkuMetadata() throws InterruptedException {
		   WebElement ItemId= driver.findElement(By.xpath("(//div[@col-id='Item_ID']/span[1])[1]"));
		    Thread.sleep(3000);
			Actions actionsskuID = new Actions(driver);
			actionsskuID.contextClick(ItemId).perform();
			driver.findElement(By.xpath("//span[text()='Get Sku Metadata']")).click();
			String we=driver.findElement(By.xpath("//button[text()='Table']")).getText();
			System.out.println(we);
			driver.findElement(By.xpath("(//button[@aria-label='maximize'])[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@aria-label='maximize'])[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@aria-label='minimize']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='ITEM ID - ']")).click();
			}	
			

	}

