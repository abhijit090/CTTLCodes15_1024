package CTTAutoDemo;

	
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



	public class AGGRIDQAChecks {
		
		private static String iframe;
		public static String screenShotSubFoderName;
		public static WebDriver driver;
		WebDriverWait wait;
		static WebDriver browser;
		
		@BeforeSuite
		
		public void appLaunch() throws InterruptedException {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
			 driver = new ChromeDriver(options);
//			WebDriver driver;
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
			
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
			Thread.sleep(2000);
		}
			
		@Test(priority = 2)
		public void CTT_EnterLogin_Details() throws InterruptedException {
			driver.findElement(By.id("username")).sendKeys("aarushp123098@gmail.com");// Enter Gmail
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#password")).sendKeys("OLOtx095");// Password
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("button[type='button']")).click();// Login
			Thread.sleep(6000);
	    }
		@Test(priority = 3)
		public void Check_The_AG_Grid_Page_open_Or_Not() throws InterruptedException {
			//Locate the parent div class that contains all the project names
				WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
				Thread.sleep(1000);
				// Scroll the parentDiv11t into view
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentDiv11t);
	
				// Find the specific project name within the parent div class
				WebElement project11t = parentDiv11t.findElement(By.xpath("(//*[contains(text(), 'Test Dev')])"));
				Thread.sleep(1000);
	
				// Click on the drop down
				WebElement assignUserButton11t = project11t.findElement(By.xpath("//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'][1]"));
				assignUserButton11t.click();
				Thread.sleep(3000);
	
				// Open specific
				WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'aarushCTT1AB')])[1]"));
				testAb.click();
				Thread.sleep(15000);
				// Right-click on root node
				WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				// Switch to the iframe
				driver.switchTo().frame(iframe1);
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
				Thread.sleep(4000);
	}				
		@Test(priority = 4)
		public void Validte_The_Translation_Condition() throws InterruptedException {				
				
				//Check the translation
				WebElement translate = driver.findElement(By.xpath("(//*[contains(text(),'Collected Description')])[1]"));
				Actions actionstranslate = new Actions(driver);
				actionstranslate.moveToElement(translate).perform();
				Thread.sleep(1000);	
				// Wait for the element to be clickable
				driver.findElement(By.xpath("(//span[@class=\"ag-icon ag-icon-menu\"])[2]")).click();
				Thread.sleep(2000);	
				//Click on translate option
				driver.findElement(By.xpath("(//span[normalize-space()='Translate'])[1]")).click();
				Thread.sleep(1000);	
				//Translate Window open Select sources Language
				driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
				Thread.sleep(1000);	
				driver.findElement(By.xpath("//ul/li[contains(text(), 'English')][1]")).click();
				Thread.sleep(2000);	
				//Translate Window open Select Target Language
				driver.findElement(By.xpath("(//button[@title='Open'])[2]")).click();
				Thread.sleep(1000);	
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Hindi')][1]")).click();
				Thread.sleep(2000);
				//Click on the Save button
				WebElement saveButton = driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
			    saveButton.click();
			    Thread.sleep(2000);
			    // Wait for the success message to appear
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			    WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'created successfully')][1]")));
			    String text = successMessage.getText();
			    System.out.println(text);
			    Thread.sleep(2500);
			    
				
	}		    
	@Test(priority = 5)
	public void Verify_The_QA_Checks_Contains_trailing_spaces() throws InterruptedException {			    
			    //Verify table
				List<WebElement> rowsNumber = driver.findElements(By.xpath("(//div[@class='ag-center-cols-viewport'])[1]"));
				int rowCount = rowsNumber.size();
				System.out.println("No of rows in this table : " + rowCount);
				Thread.sleep(1000);
				//Finding number of Columns

				List<WebElement> columnsNumber = driver.findElements(By.xpath("(//div[@class='ag-center-cols-viewport'])[1]"));
				int columnCount = columnsNumber.size();
				System.out.println("No of columns in this table : " + columnCount);
				Thread.sleep(1000);
				
				WebElement cellAddress = driver.findElement(By.xpath("(//*[contains(text(),'VS18458')])[1]/following-sibling::div[3]"));
				String value = cellAddress.getText();
				System.out.println("The Cell Value is: " + value);
				Thread.sleep(1000);
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing = driver.findElement(By.xpath("(//*[contains(text(),'VS18458')])[1]/following-sibling::div[3]"));
				Actions actions1q = new Actions(driver);
				actions1q.contextClick(tralaing).perform();
				Thread.sleep(2000);
				//click on the edits option
				WebElement abc = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("ABC123.000  ");
				Thread.sleep(1000);
				//click on the save button
				 WebElement abced = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaing2 = driver.findElement(By.xpath("(//*[contains(text(),'VS18458')])[1]/following-sibling::div[3]"));
				Actions actions1q2 = new Actions(driver);
				actions1q2.moveToElement(tralaing2).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("//div[contains(text(),'Contains trailing spaces')][1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
	}			
	@Test(priority = 6)
	public void Verify_The_QA_Checks_Contains_trailing_Zeros() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'M140025')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("123.000");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'M140025')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains trailing zeros')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	@Test(priority = 7)
	public void Verify_The_QA_Checks_Contains_leading_Zeros() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'FA849-KIT')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys(".123");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'FA849-KIT')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Does not contain leading zero before decimal point')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	@Test(priority = 8)
	public void Verify_The_QA_Checks_ContainsSpecialChar() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'FA966-63BK')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("ABC@#$%asd");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'FA966-63BK')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	
	@Test(priority = 9)
	public void Verify_The_QA_Checks_Range_Representation_Check() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("10 - 10");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	
	@Test(priority = 10)
	public void Verify_The_QA_Checks_Trademark_and_Copyright_Check() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'VS20635')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("abcdf™ [TM]");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'VS20635')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	@Test(priority = 11)
	public void Verify_The_QA_Checks_contains_Double_Spaces() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'STDA128')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys("AB   CD12");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'STDA128')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	
	
	@Test(priority = 12)
	public void Verify_The_QA_Checks_contains_empty_string() throws InterruptedException, TimeoutException {					
				
				//Right click on the particular node for editing Identify msg Contains trailing spaces
				WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'VS569307')])[1]/following-sibling::div[3]"));
				Actions actions1q1 = new Actions(driver);
				actions1q1.contextClick(tralaing1).perform();
				Thread.sleep(1000);
				//click on the edits option
				WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
				abc1.click();
				Thread.sleep(3000);
				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
				Actions actions1qt = new Actions(driver);
				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
				Thread.sleep(2000);
				abcd.sendKeys(" ");
				Thread.sleep(1000);	
				 Thread.sleep(2000);
				//click on the save button
				 WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
				 abced1.click();
				Thread.sleep(3000);
				//Mouse over to the same node and error verify
				WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'VS569307')])[1]/following-sibling::div[3]"));
				Actions actions1i = new Actions(driver);
				actions1i.moveToElement(tralaingi).perform();
				Thread.sleep(2000);
				WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Contains')])[1]"));
				String textcc1x = elemento1x.getText();
				System.out.println(textcc1x);
				Thread.sleep(3000);
			
	}	
	
	@Test(priority = 13)
	public void Verify_The_NumericUOM() throws InterruptedException, TimeoutException {	
		
				// Scroll the parentDiv11t into view
		// Scroll the page to the right
		((JavascriptExecutor) driver).executeScript("window.scrollBy(300, 0)");
		WebElement applytrans = driver.findElement(By.xpath("(//*[contains(text(),'Alpha code')])[1]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applytrans);
		Actions actionsapply = new Actions(driver);
		actionsapply.moveToElement(applytrans).perform();
		Thread.sleep(3000);	
		// Wait for the element to be clickable
		driver.findElement(By.xpath("(//div[@class='ag-header-cell-comp-wrapper']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation'])[9]")).click();
		Thread.sleep(2000);	
		
		//Click on the set new type 
		driver.findElement(By.xpath("(//*[contains(text(),'Set New Type')])[1]")).click();
		Thread.sleep(1000);	
		driver.findElement(By.xpath("(//*[contains(text(),'Numeric UOM')])[1]")).click();
		Thread.sleep(3000);	
		WebElement elemento1x1 = driver.findElement(By.xpath("(//div[contains(text(),'Column type')])[1]"));
		String textcc1x1 = elemento1x1.getText();
		System.out.println(textcc1x1);
		Thread.sleep(3000);
		//Mouse over to the same node and error verify
		WebElement tralaingi = driver.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[7]"));
		Actions actions1i = new Actions(driver);
		actions1i.moveToElement(tralaingi).perform();
		Thread.sleep(2000);
		WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Uom')])[1]"));
		String textcc1x = elemento1x.getText();
		System.out.println(textcc1x);
		Thread.sleep(2000);
		//Edit the UOM
		WebElement tralaing1 = driver.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[7]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		//click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		//click on the value and enter value
		driver.findElement(By.xpath("//input[@id='valuemodify-multi-col']")).sendKeys("12");
		Thread.sleep(1000);
		//remove the checkbox
		driver.findElement(By.xpath("//label[@id='valueChecked']//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		//click on the uom value and enter value
		driver.findElement(By.xpath("//input[@id='uommodify-multi-col']")).sendKeys("gm");
		Thread.sleep(1000);
		//remove the checkbox
		driver.findElement(By.xpath("//label[@id='uomChecked']//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		//click on the save button
		 WebElement abced1 = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		 abced1.click();
		Thread.sleep(3000);	
			
	}
	
		@Test(priority = 14)
		public void Verify_The_Apply_Translation() throws InterruptedException, TimeoutException {	
			
			//Click on the save button
			driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
			Thread.sleep(2500);
			//verify text
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
			  WebElement successMessage1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
			  String text1 = successMessage1.getText();
			  System.out.println(text1);
			  Thread.sleep(3000);
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
			Thread.sleep(2500);
			// Scroll the parentDiv11t into view
			// Scroll the page to the right
			((JavascriptExecutor) driver).executeScript("window.scrollBy(300, 0)");
			WebElement applytrans = driver.findElement(By.xpath("(//*[contains(text(),'Collected Description Translated')])[1]"));
			//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", applytrans);
			Actions actionsapply = new Actions(driver);
			actionsapply.moveToElement(applytrans).perform();
			Thread.sleep(2000);	
			// Wait for the element to be clickable
			driver.findElement(By.xpath("//div[@class='ag-header-cell ag-column-last ag-header-cell-sortable custom-header-class ag-focus-managed ag-header-active']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation']")).click();
			Thread.sleep(2000);	
			//Click on translate option
			driver.findElement(By.xpath("(//span[normalize-space()='Apply Translation'])[1]")).click();
			Thread.sleep(2000);	
			// Wait for the first success message
			WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(15));
		    WebElement successMessage11 = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]/div")));
		    String text11 = successMessage11.getText();
		    System.out.println(text11);
		    Thread.sleep(3000);			
				
		}
		
		
		@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
	        driver.quit();
	    }
	}
	
	
	
	
//********RAW DATA****//	
	//Particular node select
//	((//*[contains(text(),'M140025')]/parent::div[1])[2]/parent::div/following-sibling::div)[3]
	//select traslation select uom & 
//			(//*[contains (text(),'Collected Description')])[1]

	
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
//	Thread.sleep(3000);
//	
////	Open same node
//	WebElement iframe1w = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
//	// Switch to the iframe
//	driver.switchTo().frame(iframe1w);
//	Thread.sleep(2000);
//	WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
//	Actions actions1se = new Actions(driver);
//	actions1se.moveToElement(rootnode11e).perform();
//	Thread.sleep(4000);
//	driver.switchTo().defaultContent();
//	Thread.sleep(2000);
	
//	@Test(priority = 5)
//	public void Verify_The_QA_Checks_Contains_trailing_spaces() throws InterruptedException {			    
//			    //Verify table
//				List<WebElement> rowsNumber = driver.findElements(By.xpath("(//div[@class='ag-center-cols-viewport'])[1]"));
//				int rowCount = rowsNumber.size();
//				System.out.println("No of rows in this table : " + rowCount);
//				Thread.sleep(1000);
//				//Finding number of Columns
//
//				List<WebElement> columnsNumber = driver.findElements(By.xpath("(//div[@class='ag-center-cols-viewport'])[1]"));
//				int columnCount = columnsNumber.size();
//				System.out.println("No of columns in this table : " + columnCount);
//				Thread.sleep(1000);
//				
//				WebElement cellAddress = driver.findElement(By.xpath("((//*[contains(text(),'VS18458')]/parent::div[1])[2]/parent::div/following-sibling::div)[3]"));
//				String value = cellAddress.getText();
//				System.out.println("The Cell Value is: " + value);
//				Thread.sleep(1000);
//				
//				//Right click on the particular node for editing Identify msg Contains trailing spaces
//				WebElement tralaing = driver.findElement(By.xpath("((//*[contains(text(),'VS18458')]/parent::div[1])[2]/parent::div/following-sibling::div)[3]"));
//				Actions actions1q = new Actions(driver);
//				actions1q.contextClick(tralaing).perform();
//				Thread.sleep(1000);
//				//click on the edits option
//				WebElement abc = driver.findElement(By.xpath("(//span[normalize-space()='Edit Column(s)'])[1]"));
//				abc.click();
//				Thread.sleep(3000);
//				WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control___Electrical_Component_Typemodify-multi-col'])[1]"));
//				Actions actions1qt = new Actions(driver);
//				actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
//				Thread.sleep(2000);
//				abcd.sendKeys("ABC123.000  ");
//				Thread.sleep(1000);
//				//click on the save button
//				 WebElement abced = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
//				 abced.click();
//				Thread.sleep(3000);
//				//Mouse over to the same node and error verify
//				WebElement tralaing2 = driver.findElement(By.xpath("((//*[contains(text(),'VS18458')]/parent::div[1])[2]/parent::div/following-sibling::div)[3]"));
//				Actions actions1q2 = new Actions(driver);
//				actions1q2.moveToElement(tralaing2).perform();
//				Thread.sleep(2000);
//				WebElement elemento1x = driver.findElement(By.xpath("//div[contains(text(),'Contains trailing spaces')][1]"));
//				String textcc1x = elemento1x.getText();
//				System.out.println(textcc1x);
//				Thread.sleep(3000);