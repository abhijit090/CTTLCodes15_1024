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
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class diveCall_AWR_Database  {
	private static String iframe;
	public static String screenShotSubFoderName;
	public static WebDriver driver;
	WebDriverWait wait;
	private By with;
	private WebElement descriptionField;
	static WebDriver browser;
	private WebElement dbclick;
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
        Thread.sleep(5000);

    }
	@Test(priority = 2)
	public void Verify_Login_Person_Name() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
		String displayName = element.getText();
		System.out.println("Login Person Name: " + displayName);	
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void Open_Specific_Project() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			Thread.sleep(12000);
			//iframe
			WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe1z1);
			Thread.sleep(12000);
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
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
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
	}				
	@Test(priority = 4)
	public void To_Verify_that_Data_Not_Available_In_AWR_Database() throws InterruptedException {				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		//Select any one cell
				WebElement elementaq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[contains(text(),'M140025')])[1]//parent::div//following-sibling::div)[3]")));
				elementaq.click();
				Thread.sleep(2000);	
				//Click on the Action button and select SKU search option.
				driver.findElement(By.xpath("(//button[normalize-space()='Actions'])[1]")).click();
				Thread.sleep(2000);	
				//Select SKU search
				driver.findElement(By.xpath("(//p[normalize-space()='SKU Search'])[1]")).click();
				Thread.sleep(1000);	
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));
				System.out.println("Attributes screen is open.");
				Thread.sleep(1000);	
				//Attribute select
				driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
				Thread.sleep(2000);	
				//Select attribute
				WebElement selectATT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Item ID')]")));
				selectATT.click();
				Thread.sleep(2000);
				// Enter value
				WebElement abcd = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("Testasdf123");
				Thread.sleep(2000);
				//Click on search
				driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
				Thread.sleep(2000);	
				//pop-up message print
				WebElement successMessage146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
				String text1456 = successMessage146.getText();
				System.out.println(text1456);
				Thread.sleep(5000);	
			//select AWR search
			WebElement awrSearchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='AWR Search'])[1]")));
			awrSearchButton.click();
			//Attribute select
			driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
			Thread.sleep(2000);	
			//Select attribute
			WebElement selectATTa = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'PROD NO')]")));
			selectATTa.click();
			Thread.sleep(2000);
			// Enter value
			WebElement abcd1 = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
			Actions actions1qt1 = new Actions(driver);
			actions1qt1.moveToElement(abcd1).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd1.sendKeys("Testabcd143");
			Thread.sleep(2000);
			//Click on search
			driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
			Thread.sleep(2000);	
			// Wait for the first success message
		    WebElement successMessage11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		    String text11 = successMessage11.getText();
		    System.out.println(text11);
		    Thread.sleep(3000);	
		    //Click on the cancel 
		    driver.findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]")).click();
			Thread.sleep(2000);
			//click on the main close button
			WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='close'])[1]"));
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();", element1);
			Thread.sleep(2000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			// Click on home page
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
		
	}
	
	@Test(priority = 5)
	public void Verify_Through_AWR() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	
			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			Thread.sleep(12000);
			//iframe
			WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe1z1);
			Thread.sleep(12000);
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
			nodeTextElement1.click();
			Thread.sleep(3000);
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
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
	}				
	@Test(priority = 6)
	public void To_Verify_that_reintegrate_additional_data_from_AWR_to_the_AGGrid_table() throws InterruptedException {				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		//Select any one cell
		WebElement elementaq1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[contains(text(),'M140025')])[1]//parent::div//following-sibling::div)[3]")));
		elementaq1.click();
		Thread.sleep(2000);	
		//Click on the Action button and select SKU search option.
		driver.findElement(By.xpath("(//button[normalize-space()='Actions'])[1]")).click();
		Thread.sleep(2000);	
		//Select SKU search
		driver.findElement(By.xpath("(//p[normalize-space()='SKU Search'])[1]")).click();
		Thread.sleep(1000);	
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));
		System.out.println("Attributes screen is open.");
		Thread.sleep(1000);	
		//select AWR search
		driver.findElement(By.xpath("(//span[normalize-space()='AWR Search'])[1]")).click();
		Thread.sleep(2000);	
		//Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);	
		//Select attribute
		WebElement selectATT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'PROD NO')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("DEWALT DCE591D1 CORDLESS");
		Thread.sleep(2000);
		//Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);	
		// Wait for the first success message
	    WebElement successMessage11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
	    String text11 = successMessage11.getText();
	    System.out.println(text11);
	    Thread.sleep(3000);	
		//Select any URL
//	    WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'https://www.toolup.com/DeWalt-DCE591D1-20V-Epoxy-Dispenser-11-21Oz')])[1]//parent::div//input[@type='radio']")));
//        radioButton.click();
        Thread.sleep(2000);	
	    driver.findElement(By.xpath("(//input[@type='radio'])[5]")).click();
		Thread.sleep(2000);	
	    //Click on the Extarct button
		driver.findElement(By.xpath("(//button[normalize-space()='Extract Attributes'])[1]")).click();
		Thread.sleep(2000);	
		// Wait for the first success message
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1 = successMessage.getText();
		System.out.println(text1);
		 Thread.sleep(3000);
		//Select cell
		 driver.findElement(By.xpath("((//*[contains(text(),'Capacity')])[1]//parent::div//parent::div//following-sibling::div)[3]")).click();
		 Thread.sleep(2000);
		//double click
		WebElement dbclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//*[contains(text(),'Capacity')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions = new Actions(driver);
		actions.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		//select drop down which aatribute map
		//Attribute select
		driver.findElement(By.xpath("(//div[@class='ag-picker-field-icon'])[1]")).click();
		Thread.sleep(2000);	
		//Select attribute
		WebElement selectATT1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'PROD NO')])[4]")));
		selectATT1.click();
		Thread.sleep(2000);
		//select three more
		driver.findElement(By.xpath("((//*[contains(text(),'Voltage')])[1]//parent::div//parent::div//following-sibling::div)[3]")).click();
		Thread.sleep(2000);
		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);
		//click action button
		WebElement asdfg = driver.findElement(By.xpath("//button[@id='demo-customized-button']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", asdfg);
		Thread.sleep(2000);
		//View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		//click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage1.getText();
		System.out.println(text14);
		//Open same node
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se = new Actions(driver);
		actions1se.moveToElement(rootnode11e).perform();
		Thread.sleep(2500);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Close AG grid
		WebElement nodeTextElement19 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='close']")));
		nodeTextElement19.click();
		Thread.sleep(3000);
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		// Click on home page
		WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
		homeButton.click();
		
	}
	@Test(priority = 7)
	public void Verify_Through_the_database() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
	
			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			Thread.sleep(12000);
			//iframe
			WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe1z1);
			Thread.sleep(12000);
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
			nodeTextElement1.click();
			Thread.sleep(3000);
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
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
	}				
	
	@Test(priority = 8)
	public void To_Verify_that_reintegrate_additional_data_from_database_to_the_AGGrid_table() throws InterruptedException {				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		//Select any one cell
		WebElement elementaq = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[contains(text(),'M140025')])[1]//parent::div//following-sibling::div)[3]")));
		elementaq.click();
		Thread.sleep(2000);	
		//Click on the Action button and select SKU search option.
		driver.findElement(By.xpath("(//button[normalize-space()='Actions'])[1]")).click();
		Thread.sleep(2000);	
		//Select SKU search
		driver.findElement(By.xpath("(//p[normalize-space()='SKU Search'])[1]")).click();
		Thread.sleep(1000);	
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));
		System.out.println("Attributes screen is open.");
		Thread.sleep(1000);	
		//Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);	
		//Select attribute
		WebElement selectATT = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'PROD NO')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = driver.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("SNT200CL");
		Thread.sleep(2000);
		//Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);	
		//pop-up message print
		WebElement successMessage146 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1456 = successMessage146.getText();
		System.out.println(text1456);
		Thread.sleep(3000);	
		//Select Checkbox
		 driver.findElement(By.xpath("((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")).click();
		 Thread.sleep(2000);
		//Click on next
		driver.findElement(By.xpath("(//button[normalize-space()='Next'])[1]")).click();
		Thread.sleep(3000);	
		//wait for the screen 
		WebElement elementas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Attribute List'])[1]")));
		System.out.println("Attribute List screen is open.");
		 Thread.sleep(2000);
		//Select cell
		 driver.findElement(By.xpath("((//*[contains(text(),'Body Color')])[1]//parent::div//parent::div//following-sibling::div)[3]")).click();
		 Thread.sleep(2000);
		//double click
		WebElement dbclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("((//*[contains(text(),'Body Color')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions = new Actions(driver);
		actions.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		//select drop down which aatribute map
		//Attribute select
		driver.findElement(By.xpath("(//div[@class='ag-picker-field-icon'])[1]")).click();
		Thread.sleep(2000);	
		//Select attribute
		WebElement selectATT1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'PROD NO')])[4]")));
		selectATT1.click();
		Thread.sleep(2000);
		//select three more
		driver.findElement(By.xpath("((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[3]")).click();
		Thread.sleep(2000);
		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);
		//click action button
		WebElement asdfg = driver.findElement(By.xpath("//button[@id='demo-customized-button']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", asdfg);
		Thread.sleep(2000);
		//View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		//click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage1.getText();
		System.out.println(text14);
		//Open same node
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se = new Actions(driver);
		actions1se.moveToElement(rootnode11e).perform();
		Thread.sleep(2500);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//Close AG grid
		WebElement nodeTextElement19 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='close']")));
		nodeTextElement19.click();
		Thread.sleep(3000);
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		// Click on home page
		WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
		homeButton.click();
		
	}
	

	@AfterSuite
    public void closeBrowser() {
        // Close the WebDriver instance
        driver.quit();
    }
}
