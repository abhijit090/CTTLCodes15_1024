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




	public class ag_Grid_schema_skuQAchk {
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
			Thread.sleep(22000);
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
		}
		@Test(priority = 5)
		public void Verify_The_QA_Checks_Ohm_v_Omega_in_Values_and_UOMs() throws InterruptedException, TimeoutException {					
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[3]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(3000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='L2modify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("ohm Ω (0x00002126)");
			Thread.sleep(1000);
			Thread.sleep(2000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[3]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(2000);		
		}	
		@Test(priority = 6)
		public void Verify_The_QA_Checks_Dimensions_Without_Space_Separation() throws InterruptedException, TimeoutException {	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			//clocse ag grid
			WebElement closetab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='close']")));
			closetab.click();
			Thread.sleep(1000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			// Switch to the iframe
			driver.switchTo().frame(iframe1);
			Thread.sleep(2000);
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
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), 'DARK ELDAR')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(4000);
			//Scheam table open
			// Click on the any schema name in ag grid table
			WebElement skuname = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@class='ag-center-cols-container']/div[1]/div[2]")));
			skuname.click();
			// Edit Schema Name
			Thread.sleep(1000);
			WebElement editSchemaName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='EditSchemaName'])[1]")));
			editSchemaName.clear();
			editSchemaName.sendKeys("test Attr1 Dimensions");
			Thread.sleep(1000);
			//click on the save 
			// Find and scroll the save button into view without changing the table position
			WebElement saveButton = driver.findElement(By.xpath(
					"//*[@id='EditAttributeNodeForm']//a[@class='button success' and contains(text(), 'Save')]"));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -300)");
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
			Thread.sleep(1000);
			// Wait for the save button to be clickable
			saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			saveButton.click();
			Thread.sleep(3000);
			//close schema table
			WebElement closetab1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
			closetab1.click();
			Thread.sleep(2000);
			//click on more pop-up
			//click on the  pop button on header and Verify aatribuite
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//Click on the Attribute verify SKU
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//open ag grid
		//  Click on the  node 
		WebElement rootnode111 = driver.findElement(By.xpath("(//*[contains(text(), 'DARK ELDAR')])[1]"));
		Actions actions1s1 = new Actions(driver);
		actions1s1.moveToElement(rootnode111).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Verify Dimension check
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99310612001')])[1]/following-sibling::div[6]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(2000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='templatemodify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("3xX4");
			Thread.sleep(1000);
			Thread.sleep(1000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99310612001')])[1]/following-sibling::div[6]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Does')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(2000);	
			//clocse ag grid
			WebElement closetab11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='close']")));
			closetab11.click();
			Thread.sleep(4000);
		}	
		@Test(priority = 7)
		public void Verify_The_QA_Checks_Value_Starts_With_Plus_Minus() throws InterruptedException, TimeoutException {					
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			Thread.sleep(1000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			Thread.sleep(1000);
			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			// Switch to the iframe
			driver.switchTo().frame(iframe1);
			Thread.sleep(1000);
			//mouse hover to the 
			// Click on the node
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), '40K IP GAMES')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[3]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(2000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='L2modify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("+/-5");
			Thread.sleep(1000);
			Thread.sleep(2000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[3]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(2000);		
		}	
		@Test(priority = 8)
		public void Verify_The_QA_Checks_Metric_UOM_with_Fraction_Check() throws InterruptedException, TimeoutException {					
			
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[9]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(2000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='valuemodify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("2-5/8");
			Thread.sleep(1000);
			WebElement abcd1 = driver.findElement(By.xpath("(//input[@id='uommodify-multi-col'])[1]"));
			Actions actions1qt1 = new Actions(driver);
			actions1qt1.moveToElement(abcd1).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd1.sendKeys("mm");
			Thread.sleep(1000);
			Thread.sleep(2000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[9]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Value')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(2000);		
		}	
		@Test(priority = 9)
		public void Verify_The_QA_Checks_Text_with_Unit_of_Measure() throws InterruptedException, TimeoutException {					
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99310605001')])[1]/following-sibling::div[9]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(2000);
//			WebElement abcd = driver.findElement(By.xpath("(//input[@id='valuemodify-multi-col'])[1]"));
//			Actions actions1qt = new Actions(driver);
//			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
//					.sendKeys(Keys.DELETE).perform();
//			Thread.sleep(2000);
//			abcd.sendKeys("ABCD");
//			Thread.sleep(1000);
//			WebElement abcd1 = driver.findElement(By.xpath("(//input[@id='uommodify-multi-col'])[1]"));
//			Actions actions1qt1 = new Actions(driver);
//			actions1qt1.moveToElement(abcd1).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
//					.sendKeys(Keys.DELETE).perform();
//			Thread.sleep(2000);
//			abcd1.sendKeys("g");
//			Thread.sleep(1000);
//			Thread.sleep(2000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(3000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99310605001')])[1]/following-sibling::div[9]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Text')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(3000);		
		}
		@Test(priority = 10)
		public void Verify_The_QA_Checks_NA_NR_or_BlankCheck() throws InterruptedException, TimeoutException {					
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[4]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(3000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='L3modify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("NA");
			Thread.sleep(1000);
			Thread.sleep(2000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[4]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Value')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(2000);		
		}	
		@Test(priority = 11)
		public void Verify_The_QA_Checks_Single_Letter_Value() throws InterruptedException, TimeoutException {					
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[4]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(2000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='L3modify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("A");
			Thread.sleep(1000);
			Thread.sleep(2000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99680699001')])[1]/following-sibling::div[4]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			Thread.sleep(2000);		
		}	
		@Test(priority = 12)
		public void Verify_The_QA_Checks_Wire_With_Hash_Check() throws InterruptedException, TimeoutException {	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			//clocse ag grid
			WebElement closetab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='close']")));
			closetab.click();
			Thread.sleep(1000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			// Switch to the iframe
			driver.switchTo().frame(iframe1);
			Thread.sleep(3000);
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
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), 'DARK ELDAR')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(3000);
			//Scheam table open
			// Click on the any schema name in ag grid table
			WebElement skuname = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@class='ag-center-cols-container']/div[1]/div[2]")));
			skuname.click();
			// Edit Schema Name
			Thread.sleep(1000);
			WebElement editSchemaName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='EditSchemaName'])[1]")));
			editSchemaName.clear();
			editSchemaName.sendKeys("test Attr1 Wire");
			Thread.sleep(1000);
			//click on the save 
			// Find and scroll the save button into view without changing the table position
			WebElement saveButton = driver.findElement(By.xpath(
					"//*[@id='EditAttributeNodeForm']//a[@class='button success' and contains(text(), 'Save')]"));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -300)");
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
			Thread.sleep(1000);
			// Wait for the save button to be clickable
			saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			saveButton.click();
			Thread.sleep(2000);
			//close schema table
			WebElement closetab1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
			closetab1.click();
			Thread.sleep(2000);
			//click on more pop-up
			//click on the  pop button on header and Verify aatribuite
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//Click on the Attribute verify SKU
			driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
			Thread.sleep(2000);
			//open ag grid
		//  Click on the  node 
		WebElement rootnode111 = driver.findElement(By.xpath("(//*[contains(text(), 'DARK ELDAR')])[1]"));
		Actions actions1s1 = new Actions(driver);
		actions1s1.moveToElement(rootnode111).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Verify Dimension check
			WebElement tralaing1 = driver
					.findElement(By.xpath("(//*[contains(text(),'99310612001')])[1]/following-sibling::div[6]"));
			Actions actions1q1 = new Actions(driver);
			actions1q1.contextClick(tralaing1).perform();
			Thread.sleep(1000);
			// click on the edits option
			WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
			abc1.click();
			Thread.sleep(2000);
			WebElement abcd = driver.findElement(By.xpath("(//input[@id='templatemodify-multi-col'])[1]"));
			Actions actions1qt = new Actions(driver);
			actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
					.sendKeys(Keys.DELETE).perform();
			Thread.sleep(2000);
			abcd.sendKeys("#AWG");
			Thread.sleep(1000);
			Thread.sleep(1000);
			// click on the save button
			WebElement abced1 = driver.findElement(By.xpath("(//*[contains(text(),'Save')])[1]"));
			abced1.click();
			Thread.sleep(2000);
			// Mouse over to the same node and error verify
			WebElement tralaingi = driver
					.findElement(By.xpath("(//*[contains(text(),'99310612001')])[1]/following-sibling::div[6]"));
			Actions actions1i = new Actions(driver);
			actions1i.moveToElement(tralaingi).perform();
			Thread.sleep(2000);
			WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Incorrect')])[1]"));
			String textcc1x = elemento1x.getText();
			System.out.println("\n" + textcc1x);
			System.out.println("\n");
			Thread.sleep(2000);	
			//clocse ag grid
			WebElement closetab11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='close']")));
			closetab11.click();
			Thread.sleep(2000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			// Click on home page
			WebElement homeButton = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
			Thread.sleep(2000);
			
		}	
		
		
		
		@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
	        driver.quit();
	    }
}


