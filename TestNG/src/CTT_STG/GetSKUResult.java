package CTT_STG;


	import java.time.Duration;
	import java.util.concurrent.TimeUnit;

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
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	public class GetSKUResult {
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
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\ruchika.dube\\eclipse-workspace\\ContentDEV\\src\\main\\resources\\driver\\chromedriver-win64\\chromedriver.exe");
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
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(2500);
		WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'Grainger 1.5')])[1]"));
		testAb.click();
		Thread.sleep(6000);
		// Right-click on root node
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(5000);
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
		@Test(priority=3)
		public void bulksku() throws InterruptedException {
			Thread.sleep(5000);
			
			
		
			driver.findElement(By.xpath("//div[@row-index='1']//div[@class='ag-selection-checkbox']//div[@ref='eWrapper']/input")).click();
			Thread.sleep(5000);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@row-index='2']//div[@class='ag-selection-checkbox']//div[@ref='eWrapper']/input")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@row-index='3']//div[@class='ag-selection-checkbox']//div[@ref='eWrapper']/input")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div[@row-index='4']//div[@class='ag-selection-checkbox']//div[@ref='eWrapper']/input")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("*//button[@id='demo-customized-button']")).click();
			
			Thread.sleep(3000);
			//--------Click on bulk sku search----------//
			driver.findElement(By.xpath("//ul[@role='menu' and @aria-labelledby='demo-customized-button']/li/p[text()='Bulk SKU Search']")).click();
			Thread.sleep(5000);
			
			
			
			
			
			driver.findElement(By.xpath("*//div//div[@class='MuiAutocomplete-endAdornment css-mxlkbn']/button")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("*//ul[@role='listbox']/li[text()='Product Type']")).click();
			driver.findElement(By.xpath("*//button[text()='verify']")).click();
		    driver.findElement(By.xpath("(//div[@class='ag-center-cols-container'])[2]//div[@row-id='0']//div[@role='gridcell'][1]")).sendKeys("3M");
		    Thread.sleep(5000);
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("*//button[text()='search']")).click();
		   
		    Thread.sleep(2000);
		    String text111=driver.findElement(By.xpath("*//div[contains(text(),'JOB ID ')]")).getText();
		  
		    Thread.sleep(5000);
			String[] array = text111.split(" ");
			System.out.println(array[2]);
			String BulkSearchID=array[2];
			System.out.println(BulkSearchID);
			Thread.sleep(5000);
			WebElement scrollableElement = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));

			// Cast WebDriver to JavascriptExecutor
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Scroll the element horizontally by a specific number of pixels
			// For example, scroll right by 500 pixels
			js.executeScript("arguments[0].scrollLeft += 800;", scrollableElement);
			Thread.sleep(1000);
			
			String s=driver.findElement(By.xpath("(//div[@col-id='Bulk_Sku_Search_JobId'])[3]")).getText();
			System.out.println(s);
			Thread.sleep(5000);
			String s2=driver.findElement(By.xpath("(//div[@col-id='Bulk_Sku_Search_JobId'])[3]")).getText();
			System.out.println(s2);
			if(s.equals(s2)) {
				System.out.println("equals");
			}
				else {
				System.out.println("not equal");
			}
			
			Thread.sleep(6000);
		}
		
		
		@Test(priority=4)
		public void getsku() throws InterruptedException {
			
		
		Thread.sleep(10000);	
		//hover to Element
		Thread.sleep(6000);
	    WebElement SKUID = driver.findElement(By.xpath("(//div[@col-id='Bulk_Sku_Search_JobId'])[3]"));
		

	    Thread.sleep(3000);
		Actions actionsskuID = new Actions(driver);
		actionsskuID.contextClick(SKUID).perform();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//span[text()='Get Sku Results']")).click();
		Thread.sleep(2000);	
		driver.findElement(By.xpath("(//button[text()='Map Attributes'])[1]")).click();
		WebElement er=driver.findElement(By.xpath("(//div[@tabindex='-1' and  @col-id='Map_Attribute_To'])[4]"));
		Thread.sleep(2000);	
		Actions ers = new Actions(driver);
		
		ers.doubleClick(er).perform();
		
		//driver.findElement(By.xpath("//li[@role='option' and text()='OpCo']")).click();
		Thread.sleep(2000);	
		String Actualattributevalue=driver.findElement(By.xpath("(//div[@col-id='Attribute_Value'])[4]")).getText();
		System.out.println(Actualattributevalue);
		WebElement MapID=driver.findElement(By.xpath("(//div[@tabindex='-1' and  @col-id='Map_Attribute_To'])[4]"));
		MapID.click();
		Thread.sleep(2000);	
		
//		Thread.sleep(2000);	
//		Actions Mapattrbutearrow = new Actions(driver);
		
//		Mapattrbutearrow.doubleClick(MapID).perform();
	//  dropdown
		
		driver.findElement(By.xpath("//button[text()='Apply & Close']")).click();
		Thread.sleep(3000);
		Thread.sleep(2000);
		// Locate the horizontal scrollable element
		WebElement scrollableElement = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll the element horizontally by a specific number of pixels
		// For example, scroll right by 500 pixels
		js.executeScript("arguments[0].scrollLeft += 800;", scrollableElement);
		Thread.sleep(1000);
		
	    Thread.sleep(2000);
		/*
		 * String ExpectedAttributevalue=driver.findElement(By.
		 * xpath("(//div[@col-id='RefItemID' and @role='gridcell' ])[2]")).getText();
		 * System.out.println(ExpectedAttributevalue);
		 * if(Actualattributevalue.equals(ExpectedAttributevalue)) {
		 * System.out.println("Map attribute successfully"); } else {
		 * System.out.println("not done"); }
		 */
		
		
	}
	}

