package Testdemo;


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
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;


	public class Hoffmaster {
		private static String iframe;
		public static String screenShotSubFoderName;
		public static WebDriver driver;
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
				
		}
		 
			
		@Test(priority = 1)
		public void CTT_Login_Page_Displayed_And_Enters_Login_Details() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			driver.get("http://pimtest.hoffmaster.local/webcm/login.do");
			
			// Find and fill the username field
	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='username'])[1]")));
	        Thread.sleep(2000);
	        usernameField.sendKeys("AJadhav");

	        // Find and fill the password field
	        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='password'])[1]")));
	        passwordField.sendKeys("AJadhav");

	        // Find and click the login button
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='login'])[1]")));
	        loginButton.click();

	    }
		@Test(priority = 2)
		public void Verify_Login_Person_Name() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Abhijit Jadhav'])[1]")));
			String displayName = element.getText();
			System.out.println("Login Person Name: " + displayName);	
		}
		@Test(priority = 3)
		public void Navigate_To_The_User_Menu() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90000));
			try {
			// Click on the Flipper  button
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ui-icon ui-icon-triangle-1-e'])[1]")));
			element11.click();
			Thread.sleep(2000);
			//Click on prestg
			WebElement prestg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='dynatree-expander'])[1]")));
			prestg.click();
			Thread.sleep(3000);
			//Click on skuPrestg
			WebElement Skuprestg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='SKU PreStaging'])[1]")));
			Skuprestg.click();
			Thread.sleep(3000);
			//click on the open option
			WebElement open = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Open'])[1]")));
			open.click();
			Thread.sleep(10000);
//			//wait click on refresh page 
//			WebElement refresh = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ui-icon ui-icon-refresh'][normalize-space()='Refresh Tab'])[2]")));
//			refresh.click();
//			Thread.sleep(10000);
//			// Locate the first iframe using CSS selector
//			WebElement iframe1 = driver.findElement(By.xpath("//div[@id='repo-10075']//iframe"));
//			driver.switchTo().frame(iframe1);
//			Thread.sleep(2000);
//			//click on the create new recod option
//			WebElement newrecord = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='add'])[1]")));
//			newrecord.click();
//			Thread.sleep(3000);
//			// Locate the second iframe using CSS selector
//			WebElement iframe2 = driver.findElement(By.xpath("(//div[@id='modalIFrameDialog'])[1]//iframe"));
//			driver.switchTo().frame(iframe2);
//			Thread.sleep(2000);
//			//Enter discription
//			WebElement adddec = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='attrValues(1001831)']")));
//			adddec.sendKeys("Testz21xc");
//			Thread.sleep(3000);
//			
//			//Enter Artdiscription
//			WebElement artadddec = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='attrValues(1001839)']")));
//			artadddec.sendKeys("Test12");
//			Thread.sleep(3000);
//			
//			//select wf
//			WebElement wf = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='attrValues(1001835)']")));
//			wf.click();
//			Thread.sleep(3000);
//			// Locate and click on the "Yes" option
//			WebElement yesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Y -- [Yes]')]")));
//			yesOption.click();
//			Thread.sleep(2000);
//			//custome print id
//			WebElement custome = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@name='attrValues(1001840)']")));
//			custome.click();
//			Thread.sleep(3000);
//			// Locate and click on the any option
//			WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), '1-Ply 13x13 Lunch Napkins - White, 6M')]")));
//			option.click();
//			Thread.sleep(2000);
//			// Locate and click on the save option
//			WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='s-button']")));
//			save.click();
//			Thread.sleep(3000);
//			wait.until(ExpectedConditions.alertIsPresent());
//			Thread.sleep(2000);
//			Alert alert11 = driver.switchTo().alert();
//			String savenode = alert11.getText();
//			System.out.println("Alert message: " + savenode);
//			alert11.accept();
//			Thread.sleep(2000);
//			//iframe 2 out 
//			driver.switchTo().defaultContent();
			//search 
			// Locate the first iframe using CSS selector
			WebElement iframe11 = driver.findElement(By.xpath("//div[@id='repo-10075']//iframe"));
			driver.switchTo().frame(iframe11);
			Thread.sleep(2000);
			WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='singleSearchText']")));
			search.click();
			Thread.sleep(3000);
			search.sendKeys("Testz21xc");
			Thread.sleep(3000);
			////clcik any other 
			WebElement search211 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tsAccordion']/h3[1]/a")));
			search211.click();
			Thread.sleep(3000);
			//click on the serach button
			WebElement search1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='appSingleSearch']")));
			search1.click();
			Thread.sleep(3000);
			//contenttext search
			// Wait for the search result element to be clickable
			WebElement searchres = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='jqgh_F_1001831' and contains(text(),'Extra Description')]")));
			searchres.click();
			Thread.sleep(2000);

			// Now, you can verify the search text
			// For example, let's say you want to verify the presence of a certain text on the page
			String expectedText = "Testz21xc";
			String pageSource = driver.getPageSource(); 
			driver.switchTo().defaultContent();
			if (pageSource.contains(expectedText)) {
			    System.out.println("Search text verification passed!");
			} else {
			    System.out.println("Search text verification failed!");
			}
			
			//Click on PIMstg
			WebElement pimstg = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='dynatree-expander'])[2]")));
			pimstg.click();
			Thread.sleep(3000);
			//Click on sku
			WebElement Sku = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='SKU'])[1]")));
			Sku.click();
			Thread.sleep(3000);
			//click on the open option
			WebElement open3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Open'])[1]")));
			open3.click();
			Thread.sleep(10000);
			//iframe 
			// Locate the first iframe using CSS selector
			WebElement iframe21 = driver.findElement(By.xpath("//div[@id='repo-10011']//iframe"));
			driver.switchTo().frame(iframe21);
			Thread.sleep(2000);
			//search 
			WebElement search2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@id='singleSearchText'])[1]")));
			search2.click();
			Thread.sleep(3000);
			search2.sendKeys("Testz21xc");
			
			//clcik any other 
			WebElement search21 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='tsAccordion']/h3[1]/a")));
			search21.click();
			Thread.sleep(3000);
			
			//click on the serach button
			WebElement search13 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ui-button-text'][normalize-space()='Search'])[1]")));
			search13.click();
			Thread.sleep(3000);
			//contenttext search
			WebElement searchres3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='jqgh_F_1000943' and contains(text(),'Extra Description')]")));
			searchres3.click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			} 
			catch (Exception e) {
			    e.printStackTrace();
			}
				
			
		}
		
		
		
		
		
	@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
//	        driver.quit();
		}
}



