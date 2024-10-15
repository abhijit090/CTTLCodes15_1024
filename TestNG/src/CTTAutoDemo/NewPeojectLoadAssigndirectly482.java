package CTTAutoDemo;


	import java.time.Duration;
	import java.util.List;
	import java.util.NoSuchElementException;
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


	public class NewPeojectLoadAssigndirectly482 {
		private static String iframe;
		public static String screenShotSubFoderName;
		public static WebDriver driver;
		private WebElement element;
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
			driver.get("https://staging.d36z6oo50ky8dh.amplifyapp.com/login");
			Thread.sleep(4000);
				
		}
		 
		@Test(priority = 1)
		public void Verify_CTT_Project_Login_Page_Displayed() throws InterruptedException {
			String titile = driver.getTitle();
			Assert.assertEquals(titile, "Content Transformation Tool");
			System.out.println(titile);
			Thread.sleep(2000);
		}
			
		@Test(priority = 2)
		public void User_Enters_Login_Details() throws InterruptedException {
			driver.findElement(By.id("username")).sendKeys("aarushwagh133@gmail.com");// Enter Gmail
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("#password")).sendKeys("hiFHM4As");// Password
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("button[type='button']")).click();// Login
			Thread.sleep(5000);
	    }
		
		@Test(priority = 3)
		public void Verify_Login_with_Person_Name() throws InterruptedException {
			WebElement element = driver.findElement(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]"));
			String displayName = element.getText();
			System.out.println("Login Person Name: " + displayName);
			Thread.sleep(1000);
	    }
		
		
		@Test(priority = 4)
		public void Create_New_Project() throws InterruptedException {
			// Created Project On Home page
			driver.findElement(By.xpath("(//button[normalize-space()='Home'])[1]")).click();
			Thread.sleep(1000);
			String projectName = "AaaaDAM082ab";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			// Click on the "Projects" button
	        WebElement projectsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Projects'])[1]")));
	        projectsButton.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[normalize-space()='Create Project']")).click();// Create project
			Thread.sleep(1000);
			driver.findElement(By.xpath("//h2[@id='customized-dialog-title']")).isDisplayed(); // verify create project
																								// screen display
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='Namecreate-user']")).sendKeys(projectName);// Enter Name
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@id='Descriptioncreate-user']")).sendKeys("AaaaDAM082ab");// Disc
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(
					":nth-child(3) > .MuiAutocomplete-root > .MuiFormControl-root > .MuiInputBase-root > #undefinedcreate-user"))
					.sendKeys("aarushwagh133@gmail.com");// select project lead
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//li[@id='undefinedcreate-user-option-0' and contains(text(), 'aarushwagh133@gmail.com')]"))
					.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@name=\"ProjectGroup\"][1]")).sendKeys("AUTODemoasd");// Project Group
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@name='Domain'][1]")).sendKeys("AaaaDAM082ab");// Project domain
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();// click on save button
			Thread.sleep(3000);
			// Verified Created project //Define the expected text
			String expectedText = projectName;
			// XPath to locate the <p> tag containing the expected text
			String xpathExpression = "//p[contains(text(), '" + projectName + "')]";
			// Find the element using XPath
			WebElement paragraphElement = driver.findElement(By.xpath(xpathExpression));
			// Get the text of the paragraph element
			String actualText = paragraphElement.getText();
			// Verify if the actual text matches the expected text
			if (actualText.equals(expectedText)) {
				System.out.println("Text verification successful!");
			} else {
				System.out.println(
						"Text verification failed. Expected text: " + projectName + ", Actual text: " + actualText);
			}
			Thread.sleep(4000);
		}
		@Test(priority = 5)
		public void Open_Created_Project_and_Add_JSON_File() throws InterruptedException {
			// Click on home page
				driver.findElement(By.xpath(
						"//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-mwapoj']//div//div[1]//p[1]"))
						.click();
				Thread.sleep(3000);
				//Locate the parent div class that contains all the project names
				WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
				Thread.sleep(1000);
				// Scroll the parentDiv11t into view
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentDiv11t);
	
				// Find the specific project name within the parent div class
				WebElement project11t = parentDiv11t.findElement(By.xpath("(//*[contains(text(), 'AUTODemoasd')])"));
				Thread.sleep(1000);
	
				// Click on the drop down
				WebElement assignUserButton11t = project11t.findElement(By.xpath("//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'][1]"));
				assignUserButton11t.click();
				Thread.sleep(3000);
	
				// Open specific
				WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'AaaaDAM082ab')])[1]"));
				testAb.click();
				Thread.sleep(6000);
				// Right-click on root node
				WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				driver.switchTo().frame(iframe);
				Thread.sleep(1000);
				//Load the project 
				// verified current version
				WebElement element1q = driver.findElement(By.xpath("//*[@id='project_version']"));
				// Get the text content of the element
				String actualqTextt = element1q.getText();
				Thread.sleep(4000);
				// Click on load jsON
				WebElement iframeqq = driver.findElement(By.xpath("//*[@id='jsonfile']"));
				iframeqq.sendKeys("C:\\Users\\Abhijit.Jadhav\\eclipse-workspace\\VSGDoverProduct.jzon");
				Thread.sleep(3000);
		}
		
	 @Test(priority = 6)
				public void AssigneNode_To_The_Analyst_WithoutSave_JZON() throws InterruptedException {
					// Locate the node text element within the iframe
						WebElement nodeTextElement1 = driver
								.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
						nodeTextElement1.click();
						Thread.sleep(5000);
						
						// Click on the Switches node
						WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
						Actions actionsz1 = new Actions(driver);
						actionsz1.contextClick(rootnode1).perform();
						Thread.sleep(3000);
						// click on Assign node
						driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
						Thread.sleep(2000);
						
						//Handel alert
						Alert alert11 = driver.switchTo().alert();
						System.out.println();
						// Get the text of the alert
						String AssignedNode11 = alert11.getText();
						System.out.println("Alert message: " + AssignedNode11);
						String expectedAlertText111 = "Save the project before assigning a node";
						// Accept the alert (click OK or Yes)
						alert11.accept();
						Thread.sleep(3000);	
				
	 }
	 
	 
	 @Test(priority = 7)
		public void AssigneNode_To_The_Analyst_After_Save_JZON() throws InterruptedException {
		 
			 	WebElement rootnode = driver.findElement(By.xpath("(//*[contains(text(),'VSGDoverProduct')])[1]"));
				Actions actionsz = new Actions(driver);
				actionsz.contextClick(rootnode).perform();
				Thread.sleep(2500);
		 
				// click on save job
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Save JZON')]")).click();
				Thread.sleep(6000);
				// Switch to the alert
				System.out.println("");
				Alert alert1z1 = driver.switchTo().alert();
				System.out.println("");
				String ProjectJZONalertText16 = alert1z1.getText();
				System.out.println("Alert message: " + ProjectJZONalertText16);
				String expectedAlertText14 = "Project JZON saved successfully";
				Thread.sleep(3000);
				// Accept the alert (click OK or Yes)
				alert1z1.accept();
				Thread.sleep(3000);
				
				// verified current version
				WebElement element1 = driver.findElement(By.xpath("//*[@id='project_version']"));
				// Get the text content of the element
				String actualTextt = element1.getText();
				Thread.sleep(2000);
				
				//Verify assign node after saving JZON
				// Locate the node text element within the iframe
				WebElement nodeTextElement1 = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				Thread.sleep(3000);
				
				// Click on the Switches node
				WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Control Pads, Pendants & Buttons')])[1]"));
				Actions actionsz1 = new Actions(driver);
				actionsz1.contextClick(rootnode1).perform();
				Thread.sleep(3000);
				// click on Assign node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
				Thread.sleep(2000);
				 // verified whether assigned node to analyst window open or not
				WebElement elementa = driver.findElement(By.xpath("//*[@id=\"assignNodeTitle\"]"));
				String text = elementa.getText();
				System.out.println(text);
				Thread.sleep(1000);
				// click on the drop-down
				driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]/option[2]")).click();
				Thread.sleep(2000);
	             //click on the assigned node
				driver.findElement(By.xpath("//*[@id=\"confirmAssignNode\"]")).click();
				Thread.sleep(2000);
				// Handel Alert
				System.out.println();
				Alert alert11 = driver.switchTo().alert();
				System.out.println();
				// Get the text of the alert
				String AssignedNode11 = alert11.getText();
				System.out.println("Alert message: " + AssignedNode11);
				String expectedAlertText111 = "Successfully assigned node to the Analyst";
				// Accept the alert (click OK or Yes)
				alert11.accept();
				Thread.sleep(3000);	
				
				//AFter assign node check color node change or not 
				WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Control Pads, Pendants & Buttons')])[1]"));
				String color = rootnode11.getCssValue("color");

				// Verify if the color has changed to the expected color
			     String expectedColor = "rgba(34, 34, 34, 1)"; // Example: Red color
			     Thread.sleep(2000);
			     System.out.println("Actual color: " + color);
			     System.out.println("Expected color: " + expectedColor);
			     Thread.sleep(5000);
			     if (color.equals(expectedColor)) {
			         System.out.println("Color has changed as expected.");
			     } else {
			         System.out.println("Color has not changed as expected.");
			     }
				
				// Switch back to the default content (main page)
				driver.switchTo().defaultContent();

				// Click on home page
				driver.findElement(By.xpath(
						"//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-mwapoj']//div//div[1]//p[1]"))
						.click();
				Thread.sleep(4000);	
		}	
	 
	 @Test(priority = 8)
		public void Open_Old_Created_Project_and_Add_JSON_File() throws InterruptedException {
				//Locate the parent div class that contains all the project names
			WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
			Thread.sleep(1000);
			// Scroll the parentDiv11t into view
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", parentDiv11t);

			// Find the specific project name within the parent div class
			WebElement project11t = parentDiv11t.findElement(By.xpath("(//*[contains(text(), 'AUTODemoasd')])"));
			Thread.sleep(1000);

			// Click on the drop down
			WebElement assignUserButton11t = project11t.findElement(By.xpath("//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'][1]"));
			assignUserButton11t.click();
			Thread.sleep(4500);

			// Open specific
			WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'AaaaDAM082ab')])[1]"));
			testAb.click();
			Thread.sleep(6000);
			// Right-click on root node
			WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe);
			Thread.sleep(1000);
			//Load the project 
			// verified current version
			WebElement element1q = driver.findElement(By.xpath("//*[@id='project_version']"));
			// Get the text content of the element
			String actualqTextt = element1q.getText();
			Thread.sleep(2000);
			// Click on load jsON
			WebElement iframeqq = driver.findElement(By.xpath("//*[@id='jsonfile']"));
			iframeqq.sendKeys("C:\\Users\\Abhijit.Jadhav\\eclipse-workspace\\VSGDoverProduct.jzon");
			Thread.sleep(3000);
		}	
	 @Test(priority = 9)
		public void old_Created_Project_Open_and_AssigneNode_To_The_Analyst_WithoutSave_JZON() throws InterruptedException {
			// Locate the node text element within the iframe
				WebElement nodeTextElement1 = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				nodeTextElement1.click();
				Thread.sleep(3500);
				
				// Click on the Switches node
				WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]"));
				Actions actionsz1 = new Actions(driver);
				actionsz1.contextClick(rootnode1).perform();
				Thread.sleep(3000);
				// click on Assign node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
				Thread.sleep(2000);
				
				//Handel alert
				Alert alert11 = driver.switchTo().alert();
				System.out.println();
				// Get the text of the alert
				String AssignedNode11 = alert11.getText();
				System.out.println("Alert message: " + AssignedNode11);
				String expectedAlertText111 = "Save the project before assigning a node";
				// Accept the alert (click OK or Yes)
				alert11.accept();
				Thread.sleep(3000);	
		
}


@Test(priority = 10)
public void old_Created_Project_Open_andAssigneNode_To_The_Analyst_After_Save_JZON() throws InterruptedException {

	 	WebElement rootnode = driver.findElement(By.xpath("(//*[contains(text(),'VSGDoverProduct')])[1]"));
		Actions actionsz = new Actions(driver);
		actionsz.contextClick(rootnode).perform();
		Thread.sleep(4000);

		// click on save job
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Save JZON')]")).click();
		Thread.sleep(6000);
		// Switch to the alert
		System.out.println("");
		Alert alert1z1 = driver.switchTo().alert();
		System.out.println("");
		String ProjectJZONalertText16 = alert1z1.getText();
		System.out.println("Alert message: " + ProjectJZONalertText16);
		String expectedAlertText14 = "Project JZON saved successfully";
		Thread.sleep(2500);
		// Accept the alert (click OK or Yes)
		alert1z1.accept();
		Thread.sleep(3000);
		
		// verified current version
		WebElement element1 = driver.findElement(By.xpath("//*[@id='project_version']"));
		// Get the text content of the element
		String actualTextt = element1.getText();
		Thread.sleep(2000);
		
		// Click on the Switches node
		WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]"));
		Actions actionsz1 = new Actions(driver);
		actionsz1.contextClick(rootnode1).perform();
		Thread.sleep(3000);
		// click on Assign node
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
		Thread.sleep(2000);
		 // verified whether assigned node to analyst window open or not
		WebElement elementa = driver.findElement(By.xpath("//*[@id=\"assignNodeTitle\"]"));
		String text = elementa.getText();
		System.out.println(text);
		Thread.sleep(1000);
		// click on the drop-down
		driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]/option[2]")).click();
		Thread.sleep(2000);
      //click on the assigned node
		driver.findElement(By.xpath("//*[@id=\"confirmAssignNode\"]")).click();
		Thread.sleep(2000);
		// Handel Alert
		System.out.println();
		Alert alert11 = driver.switchTo().alert();
		System.out.println();
		// Get the text of the alert
		String AssignedNode11 = alert11.getText();
		System.out.println("Alert message: " + AssignedNode11);
		String expectedAlertText111 = "Successfully assigned node to the Analyst";
		// Accept the alert (click OK or Yes)
		alert11.accept();
		Thread.sleep(3000);	
	
		//AFter assign node check color node change or not 
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]"));
		String color = rootnode11.getCssValue("color");
		Thread.sleep(2000);

     // Verify if the color has changed to the expected color
     String expectedColor = "rgba(34, 34, 34, 1)"; // Example: Red color
     Thread.sleep(1000);
     System.out.println("Actual color: " + color);
     System.out.println("Expected color: " + expectedColor);
     Thread.sleep(1000);
     if (color.equals(expectedColor)) {
         System.out.println("Color has changed as expected.");
     } else {
         System.out.println("Color has not changed as expected.");
     }
		
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();

		// Click on home page
		driver.findElement(By.xpath(
				"//div[@class='MuiToolbar-root MuiToolbar-gutters MuiToolbar-regular css-mwapoj']//div//div[1]//p[1]"))
				.click();
		Thread.sleep(4000);	
 }	

	@AfterSuite
	public void closeBrowser() {
		// Close the WebDriver instance
		driver.quit();
	}
}
	