package CTTAutoDemo;

	import java.awt.AWTException;
	import java.awt.Rectangle;
	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.time.Duration;
	import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
	import java.util.concurrent.TimeoutException;

	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterSuite;
	import org.testng.annotations.BeforeSuite;
	import org.testng.annotations.Test;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class pieChart {

		private static final String ElementName = null;
		private static String iframe;
		public static String screenShotSubFoderName;
		public static WebDriver driver;
		WebDriverWait wait;
		private By with;
		private WebElement descriptionField;
		static WebDriver browser;

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
		public void CTT_Project_LoginPage_Displayed() throws InterruptedException {
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
	        Thread.sleep(2500);
		}

		@Test(priority = 2)
		public void CTT_EnterLogin_Details() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			// Find and fill the username field
	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
	        usernameField.sendKeys("aarushp123098@gmail.com");

	        // Find and fill the password field
	        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
	        passwordField.sendKeys("OLOtx095");

	        // Find and click the login button
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
	        loginButton.click();
	        Thread.sleep(2500);
		}
		
//		@Test(priority = 3)
//		public void AssigneNode_To_The_Analyst() throws InterruptedException {
//			// Open specific
//			WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
//			Thread.sleep(2500);
//			WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
//			testAb.click();
//			Thread.sleep(6000);
//			// Right-click on root node
//			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
//			// Switch to the iframe
//			driver.switchTo().frame(iframe1);
//			Thread.sleep(5000);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
//			nodeTextElement1.click();
//			Thread.sleep(4000);
//				
//				// Click on the Switches node
//				WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
//				Actions actionsz1 = new Actions(driver);
//				actionsz1.contextClick(rootnode1).perform();
//				Thread.sleep(3000);
//				// click on Assign node
//				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
//				Thread.sleep(2000);
//				 // verified whether assigned node to analyst window open or not
//				WebElement elementa = driver.findElement(By.xpath("//*[@id=\"assignNodeTitle\"]"));
//				String text = elementa.getText();
//				System.out.println(text);
//				Thread.sleep(1000);
//				// click on the drop-down
//				driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]")).click();
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]/option[2]")).click();
//				Thread.sleep(2000);
//	             //click on the assigned node
//				driver.findElement(By.xpath("//*[@id=\"confirmAssignNode\"]")).click();
//				Thread.sleep(2000);
//				// Handel Alert
//				System.out.println();
//				Alert alert11 = driver.switchTo().alert();
//				System.out.println();
//				// Get the text of the alert
//				String AssignedNode11 = alert11.getText();
//				System.out.println("Alert message: " + AssignedNode11);
//				String expectedAlertText111 = "Successfully assigned node to the Analyst";
//				// Accept the alert (click OK or Yes)
//				alert11.accept();
//				Thread.sleep(3000);				
//				// Switch back to the default content (main page)
//				driver.switchTo().defaultContent();
//
//				Thread.sleep(2000);
//				// Click on home page
//				driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/p/button[1]"))
//						.click();
//				Thread.sleep(4000);
//	
//	
//		}
		
		@Test(priority = 3)
		public void open_Assigne_node() throws InterruptedException {
			
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));

			// Find the specific project name within the parent div class
			WebElement project11e = wait.until(ExpectedConditions.visibilityOf(parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));

			// Click on the drop down
			WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
			assignUserButton11e.click();

			// Find the specific node (e.g., "Diagnostics & Calibration Systems") within the dropdown
			List<WebElement> nodes = driver.findElements(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])"));

			for (WebElement node : nodes) {
			    // Check if the node text matches the desired node name
			    if (node.getText().equalsIgnoreCase("Diagnostics & Calibration Systems")) {
			        // Click on the node
			        node.click();
			        break; // Exit the loop after clicking on the node
			    }
			}
			Thread.sleep(2500);
		}
				
		
		@Test(priority = 4)
		public void Validate_The_Pie_chart_Visbile_Or_Not() throws InterruptedException {
			Thread.sleep(1000);
			WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			Thread.sleep(1000);
			driver.switchTo().frame(iframe);
			Thread.sleep(1000);
			//Node shfit lright to left and up side
			WebElement nodeText1a = driver.findElement(By.xpath("(//*[contains(text(), 'Diagnostics & Calibration Systems')])[1]"));
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(nodeText1a, 50, 70).clickAndHold().perform();
			Thread.sleep(1000);
			actions.dragAndDropBy(nodeText1a, -80, 0).perform();
			Thread.sleep(4000);
			// Mouse over to the swtich node node
			WebElement Node = driver.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
			Actions actionsAQ = new Actions(driver);
			actionsAQ.moveToElement(Node).perform();
			Thread.sleep(1500); // Wait for the menu to appear, adjust time as needed
			// Scroll to the right (if needed)
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(-200, 0)");
			Thread.sleep(2500);
			// Printed tool tip data
			WebElement elementA = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
			String textQ = elementA.getText();
			System.out.println(textQ);
			Thread.sleep(2500);
			//Calibration System Accessories
			WebElement SwitchNode1 = driver.findElement(By.xpath("(//*[contains(text(),'Calibration System Accessories')])[1]"));
			Actions actionsA1 = new Actions(driver);
			actionsA1.moveToElement(SwitchNode1).perform();
			Thread.sleep(2500);
			WebElement elementA1 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
			String textQ1 = elementA1.getText();
			System.out.println(textQ1);
			Thread.sleep(2000);
			//Calibration System Parts
			WebElement SwitchNode11 = driver.findElement(By.xpath("(//*[contains(text(),'Calibration System Parts')])[1]"));
			Actions actionsA11 = new Actions(driver);
			actionsA11.moveToElement(SwitchNode11).perform();
			Thread.sleep(2500);
			WebElement elementA2 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
			String textQ2 = elementA2.getText();
			System.out.println(textQ2);
			Thread.sleep(2000);
			//Computerized Measuring
			WebElement Switc = driver.findElement(By.xpath("(//*[contains(text(),'Computerized Measuring')])[1]"));
			Actions actionsg= new Actions(driver);
			actionsg.moveToElement(Switc).perform();
			Thread.sleep(2500);
			WebElement elementAg = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
			String textQg = elementAg.getText();
			System.out.println(textQg);
			Thread.sleep(3000);
			
		}
		@Test(priority = 5)
		public void Remove_the_Node_and_Chek_Datafill_Percentage() throws InterruptedException {
			//Click on the Pivotree Logo
			WebElement nodeTextElementagq = driver.findElement(By.xpath("//*[@id='menucontainer']/div[1]"));
			nodeTextElementagq.click();
			Thread.sleep(3000);
			//1.Right Click delete node Measuring System.
			WebElement nodeTextElementag1 = driver.findElement(By.xpath("//*[contains(text(), 'Measuring System Software & Upgrades')]"));
			Actions actions1g1 = new Actions(driver);
			actions1g1.contextClick(nodeTextElementag1).perform();
			Thread.sleep(2000);
			//  click on child name
			WebElement nodeText = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
			Actions actions1gg = new Actions(driver);
			actions1gg.moveToElement(nodeText).perform();
			Thread.sleep(2000);
			//Delete and Delet sku from the root node
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete and delete SKUs')]")).click();	
			Thread.sleep(1000);
			//Handle Alert
			Alert alert11 = driver.switchTo().alert();
			System.out.println();
			Thread.sleep(500);
			// Get the text of the alert
			String alrtred = alert11.getText();
			System.out.println(alrtred);
			alert11.accept();
			Thread.sleep(1500);
			 // Wait for the menu to appear, adjust time as needed
			
			//2.Right Click delete node Calibration System Parts.
			WebElement node = driver.findElement(By.xpath("//*[contains(text(), 'Calibration System Parts')]"));
			Actions actionss = new Actions(driver);
			actionss.contextClick(node).perform();
			Thread.sleep(2000);
			//  click on child name
			WebElement nodesText = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(nodesText).perform();
			Thread.sleep(2000);
			//Delete and Delet sku from the root node
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete and delete SKUs')]")).click();
			Thread.sleep(1000);
			//Handle Alert
			Alert alerta = driver.switchTo().alert();
			System.out.println();
			Thread.sleep(500);
			// Get the text of the alert
			String alrtrea12 = alerta.getText();
			System.out.println(alrtrea12);
			alerta.accept();
			Thread.sleep(1500);
			//3.Right Click delete node Computerized Measuring
			WebElement nodew = driver.findElement(By.xpath("//*[contains(text(), 'Computerized Measuring')]"));
			Actions actionsw = new Actions(driver);
			actionsw.contextClick(nodew).perform();
			Thread.sleep(1000);
			//  click on child name
			WebElement nodesTextw = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
			Actions actions1sw = new Actions(driver);
			actions1sw.moveToElement(nodesTextw).perform();
			Thread.sleep(1000);
			//Delete and Delet sku from the root node
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete and delete SKUs')]")).click();
			Thread.sleep(1000);
			//Handle Alert
			Alert alert111 = driver.switchTo().alert();
			System.out.println();
			Thread.sleep(500);
			// Get the text of the alert
			String alrtred1 = alert111.getText();
			System.out.println(alrtred1);
			alert111.accept();
			Thread.sleep(1500);
			// Mouse over to Diagnostics & Calibration Systems the  node node
			WebElement Node = driver.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
			Actions actionsAQ = new Actions(driver);
			actionsAQ.moveToElement(Node).perform();
			Thread.sleep(2500);
			// Printed tool tip data
			WebElement elementA = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
			String textQ = elementA.getText();
			System.out.println(textQ);
			Thread.sleep(2000);	
			
		}
		@Test(priority = 6)
		public void Add_the_Node_and_Chek_Datafill_Percentage() throws InterruptedException, AWTException {
		//	clik add child node 
			WebElement nodew = driver.findElement(By.xpath("//*[contains(text(), 'Diagnostics & Calibration Systems')]"));
			Actions actionsw = new Actions(driver);
			actionsw.contextClick(nodew).perform();
			Thread.sleep(1500);
			//  click on child name
			WebElement noTex = driver.findElement(By.xpath("//ul/li[contains(text(), 'Add / Create')]"));
			Actions actions = new Actions(driver);
			actions.moveToElement(noTex).perform();
			Thread.sleep(2000);
			//
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement addchild = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Add child node...')]")));
			addchild.click();
			//// Wait for the "CreateNodeName" field to be visible and then send keys
			WebElement createNodeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CreateNodeName']")));
			createNodeNameField.sendKeys("DemoTest");
			Thread.sleep(2000);
			// Wait for the "Create" button to be clickable and then click on it
			WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CreateNodeForm']/div[2]/div[2]/a[2]")));
			createButton.click();
			Thread.sleep(2000);
			
		//Right Click on Diagnostics & Calibration Systems
		WebElement nodew11 = driver.findElement(By.xpath("//*[contains(text(), 'DemoTest')]"));
		Actions actionsw1 = new Actions(driver);
		actionsw1.contextClick(nodew11).perform();
		Thread.sleep(1500);
		//  click on child name
		WebElement noTex1 = driver.findElement(By.xpath("//ul/li[contains(text(), 'Add / Create')]"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(noTex1).perform();
		Thread.sleep(2000);
		
		//Upload file 
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement fileInput = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Create JSON from SKU Data...')]")));
		// Click on the file input element to trigger the file upload dialog
		fileInput.click();
		// Brief delay to allow the file upload dialog to appear
		Thread.sleep(2000);
		// Get the file path
		String filePath = "C:\\Users\\Abhijit.Jadhav\\eclipse-workspace\\File1.txt";
		// Create a Robot instance
		Robot robot = new Robot();
		// Simulate pressing Enter to confirm the file selection dialog
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// Brief delay to allow the file dialog to open
		Thread.sleep(1000);
		// Simulate typing the file path
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		// Simulate pressing Enter to confirm the file selection
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		// Wait for the file to upload
		Thread.sleep(3500);
		System.out.println("File uploaded successfully");
		Thread.sleep(1000);
		//handel Alrt
		Alert alert11 = driver.switchTo().alert();
		System.out.println("Filelloaded");
		Thread.sleep(500);
		// Get the text of the alert
		String alrtred = alert11.getText();
		System.out.println(alrtred);
		alert11.accept();
		Thread.sleep(1500);
		
		// Mouse over to Burner the  node node
		System.out.println("Burners Data fill% ");
		Thread.sleep(2000);
		WebElement Node = driver.findElement(By.xpath("(//*[contains(text(),'Burners')])[1]"));
		Actions actionsAQ = new Actions(driver);
		actionsAQ.moveToElement(Node).perform();
		Thread.sleep(2500);
		// Printed tool tip data
		WebElement elementA = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQ = elementA.getText();
		System.out.println(textQ);
		Thread.sleep(2000);
		// Mouse over to Diagnostics & Calibration Systems the  node node
		System.out.println("Calibration System Accessories Data fill% ");
		WebElement Node1 = driver
				.findElement(By.xpath("(//*[contains(text(),'Calibration System Accessories')])[1]"));
		Actions actionsAQ1 = new Actions(driver);
		actionsAQ1.moveToElement(Node1).perform();
		Thread.sleep(2500);
		// Printed tool tip data
		WebElement elementA1 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQ1 = elementA1.getText();
		System.out.println(textQ1);
		Thread.sleep(2000);
		
		// Mouse over to Diagnostics & Calibration Systems the  node node
		System.out.println("Diagnostics & Calibration Systems Data fill% ");
		WebElement Node1c = driver.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
		Actions actionsAQ1c = new Actions(driver);
		actionsAQ1c.moveToElement(Node1c).perform();
		Thread.sleep(2500);
		// Printed tool tip data
		WebElement elementA1c = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQ1c = elementA1c.getText();
		System.out.println(textQ1c);
		Thread.sleep(2000);
		//Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Click on home page
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/p/button[1]"))
				.click();
		Thread.sleep(2000);
	}
		
		@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
	        driver.quit();
		}
		

}
	

	
//	Thread.sleep(1000);
//	WebElement parentDiv11w11 = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
//	Thread.sleep(2000);
//
//	// Find the specific project name within the parent div class
//	WebElement project11e = parentDiv11w11.findElement(By.xpath("(//*[contains(text(), 'TeZ1')])[2]"));
//	Thread.sleep(2000);
//
//	// Click on the drop down
//	WebElement assignUserButton11e = project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
//	assignUserButton11e.click();
//	Thread.sleep(2000);
//
//	// Click on the specific node (e.g., "Switches")
//	List<WebElement> TestAb = driver.findElements(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])"));
//
//	for (WebElement ele1 : TestAb) {
//	    if (ele1.getText().equalsIgnoreCase("Diagnostics & Calibration Systems")) {
//	        ele1.click();
//	        break;
//	    }
//	}
//
//	Thread.sleep(2500);
//}