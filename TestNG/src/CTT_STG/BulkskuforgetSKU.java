package CTT_STG;

	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	public class BulkskuforgetSKU {
		private static String iframe;
		public static String screenShotSubFoderName;
		public static WebDriver driver;
		WebDriverWait wait;
		static WebDriver browser;
		final String serachtext="Test";
		final String Actiontest="Test";
		@Test
		public void getsku() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ruchika.dube\\eclipse-workspace\\Content\\src\\main\\resources\\driver\\chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login");
		Thread.sleep(2000);
		String titile = driver.getTitle();
		Assert.assertEquals(titile, "Content Transformation Tool");
		System.out.println(titile);
		Thread.sleep(2000);	
		driver.findElement(By.id("username")).sendKeys("aarushp123098@gmail.com");// Enter Gmail
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#password")).sendKeys("OLOtx095");// Password
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='button']")).click();// Login
		Thread.sleep(10000);
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div/p/button[contains(text(),'aarushCTT1AB 3')])[2]")).click();
		Thread.sleep(6000);
		System.out.println("Redirect to project");
		Thread.sleep(2000);
		System.out.println("open the terminal node");
		
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(5000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='infoPop']")).click();
		System.out.println("popup press");
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='infoPop']")).click();
		System.out.println("Attribute press");
		Thread.sleep(5000);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='infoPop']")).click();
		System.out.println("HTML press");
		Thread.sleep(5000);
		Thread.sleep(5000);
		//hover to Element
	     WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), '40K IP GAMES')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		Thread.sleep(4000);	
		driver.findElement(By.xpath("//button[@aria-label=\"maximize\"]")).click();
		//*********Maximize the window************//
		//Select the checkbox functionality-----------//
		Thread.sleep(5000);
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
		Thread.sleep(4000);	
		driver.findElement(By.xpath("//ul[@role='menu' and @aria-labelledby='demo-customized-button']/li/p[text()='Bulk SKU Search']")).click();
		Thread.sleep(5000);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("*//div/input[@name='-nameinput-for-dropdown']")).click();
		
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("*//div//div[@class='MuiAutocomplete-endAdornment css-mxlkbn']/button")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("*//ul[@role='listbox']/li[1]")).click();
		
		driver.findElement(By.xpath("*//button[text()='verify']")).click();
	    driver.findElement(By.xpath("(//div[@class='ag-center-cols-container'])[2]//div[@row-id='0']//div[@role='gridcell'][1]")).sendKeys("3M");
	   
	    driver.findElement(By.xpath("*//button[text()='search']")).click();
	    Thread.sleep(1000);
	    String text111=driver.findElement(By.xpath("*//div[contains(text(),'JOB ID')]")).getText();
	    Thread.sleep(2000);
		String[] array = text111.split(" ");
		System.out.println(array[2]);
		String BulkSearchID=array[2];
		System.out.println(BulkSearchID);
		Thread.sleep(5000);
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
		//----------Get SKU Functionality--------------//
		
		//hover to Element
		Thread.sleep(40000);
	    WebElement SKUID = driver.findElement(By.xpath("(//div[@col-id='Bulk_Sku_Search_JobId'])[3]"));
		Actions actionsskuID = new Actions(driver);
		actionsskuID.contextClick(SKUID).perform();
		Thread.sleep(2000);	
		
		}

	}
