package CTTAutoDemo;

import java.awt.Rectangle;
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
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewChildNodeCreated {

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
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
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
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void Check_The_SKUList_Page_open_Or_Not() throws InterruptedException {
		// Locate the parent div class that contains all the project names
		WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
		Thread.sleep(1000);

		// Open specific
		WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
		testAb.click();
		Thread.sleep(12000);
		
		
		// Right-click on root node
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(4000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement nodeTextElement1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
		nodeTextElement1.click();
		Thread.sleep(2000);
		//shfit the node from up & left side
		WebElement nodeText1a = driver.findElement(By.xpath("(//*[contains(text(), 'VSGDoverProduct')])[1]"));
		Thread.sleep(1000);
		WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(nodeText1a, 52, 107).clickAndHold().perform();
		Thread.sleep(1000);
		actions.dragAndDropBy(nodeText1a, -350, 0).perform();
		Thread.sleep(1000);
		Thread.sleep(4000);
		
		// Visible buttons checked on VIZ tool screen
		// click on the pop button on header and Verify aatribuite
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(2000);
		// Click on the Attribute verify SKU
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(2000);
		// Click on the node
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(3000);

	}

	@Test(priority = 4)
	public void verify_The_SKU_List_Page_Title_And_Cut_The_SingleSKU() throws InterruptedException {

		// Check the sku count
		WebElement translate = driver.findElement(By.xpath("//div[@id='skulist']/div[1]"));
		String text2 = translate.getText();
		System.out.println(text2);
		Thread.sleep(2500);
		// Go the filter By option
		WebElement dropdown = driver.findElement(By.xpath("//div//select[@id='SearchBarSelect']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Sheet");
		Thread.sleep(2000);
		
		// Go to the filter by search tab
		driver.findElement(By.xpath("(//input[@id='search'])[1]")).sendKeys("RTY- FWD - Direct -CF-WS-PARTS");
		Thread.sleep(2000);
		// Right click on the sheet row
		WebElement tralaing1 = driver.findElement(By.xpath("//*[@id='tablecontainer']/table/tbody/tr/td[5]"));
		Actions actions11 = new Actions(driver);
		actions11.contextClick(tralaing1).perform();
		Thread.sleep(2000);
		// Select the option cretae filter
		driver.findElement(By.xpath("//ul/li[contains(text(),'Create Filter Selection Child')]")).click();
		Thread.sleep(2000);
		// Switch to the alert
		Alert alert1z1 = driver.switchTo().alert();
		Thread.sleep(1000);
		// Send keys to the alert
		alert1z1.sendKeys("TESTABC");
		Thread.sleep(1000);
		System.out.println("Alert message: " + alert1z1.getText());
		Thread.sleep(1000);
		// Close the alert
		alert1z1.accept();
		Thread.sleep(2000);
		// Check the sku count
		WebElement translate1 = driver.findElement(By.xpath("//div[@id='skulist']/div[1]"));
		String text21 = translate1.getText();
		System.out.println(text21);
		Thread.sleep(1000);
		// Click on the cross button
		WebElement crossButton = driver.findElement(By.xpath("//*[@id='closeicon']/img"));
		crossButton.click();
		Thread.sleep(2500);
		// Visible Add cut sku elment
//					zoomIn(driver);
//		Thread.sleep(2500);
//		WebElement nodeText1a = driver.findElement(By.xpath("(//*[contains(text(), 'VSGDoverProduct')])[1]"));
//		Thread.sleep(1000);
//		WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(nodeText1a, 52, 107).clickAndHold().perform();
//		Thread.sleep(1000);
//		actions.dragAndDropBy(nodeText1a, -350, 0).perform();
//		Thread.sleep(1000);
//		Thread.sleep(4000);
//		driver.findElement(By.xpath("(//*[contains(text(), 'VSGDoverProduct')])[1]")).click();
//		Thread.sleep(2000);

//		 Mouse over to the cut sku node
		WebElement testabcNode = driver.findElement(By.xpath("(//*[contains(text(), 'TESTABC')])[1]"));
		Thread.sleep(1000);
		Actions actionsA = new Actions(driver);
		Thread.sleep(1000);
		actionsA.moveToElement(testabcNode).perform();
		Thread.sleep(1000);
		// Wait for the menu to appear, adjust time as needed
		// Verify sku cut name
		WebElement translatec = driver.findElement(By.xpath("//div[@id='skulist']/div[1]"));
		Thread.sleep(1000);
		String text2c = translatec.getText();
		System.out.println(text2c);
		Thread.sleep(1000);
		// Click on the crossbar
		driver.findElement(By.xpath("//*[@id='closeicon']/img")).click();
		Thread.sleep(1000);
		
		

	}
		@Test(priority = 5)
		public void Cut_the_All_SKU_From_The_Leaf_Node() throws InterruptedException {
	// Click on the node
			WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(4000);		
			// Check the sku count
			WebElement translate = driver.findElement(By.xpath("//div[@id='skulist']/div[1]"));
			String text2 = translate.getText();
			System.out.println(text2);
			Thread.sleep(1500);	
			//Right click 
			WebElement tralaing1 = driver.findElement(By.xpath("//*[@id=\"tablecontainer\"]/table/tbody/tr[2]/td[3]"));
			Actions actions11 = new Actions(driver);
			actions11.contextClick(tralaing1).perform();
			Thread.sleep(2000);
			// Select the option cretae filter
			driver.findElement(By.xpath("//ul/li[contains(text(),'Create Filter Selection Child')]")).click();
			Thread.sleep(2000);
			// Switch to the alert
			Alert alert1z1 = driver.switchTo().alert();
			Thread.sleep(1000);
			// Send keys to the alert
			alert1z1.sendKeys("AllCutSku");
			System.out.println("Alert message: " + alert1z1.getText());
			// Close the alert
			alert1z1.accept();
			Thread.sleep(2000);
			// Click on the crossbar
			driver.findElement(By.xpath("//*[@id='closeicon']/img")).click();
			Thread.sleep(2500);
			
			//Mouse over to the cut sku node
			WebElement testabcNode = driver.findElement(By.xpath("(//*[contains(text(), 'AllCutSku')])[1]"));
			Thread.sleep(1000);
			Actions actionsA = new Actions(driver);
			Thread.sleep(1000);
			actionsA.moveToElement(testabcNode).perform();
			Thread.sleep(1000);
			// Wait for the menu to appear, adjust time as needed
			// Verify sku cut name
			WebElement translatec = driver.findElement(By.xpath("//div[@id='skulist']/div[1]"));
			Thread.sleep(1000);
			String text2c = translatec.getText();
			System.out.println(text2c);
			Thread.sleep(1000);
			// Click on the crossbar
			driver.findElement(By.xpath("//*[@id='closeicon']/img")).click();
			Thread.sleep(1000);
			//AFter assign node check color node change or not 
			WebElement rootnode111 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
			String color = rootnode111.getCssValue("color");

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
			
	}
	
	
	@Test(priority = 6)
	public void Verify_through_the_AG_grid_Cut_Single_SKU() throws InterruptedException {
		zoomOut(driver);
		// Click on the Sku & verified Ag gridscreen
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(2500);
		// Click on the node
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(4000);
		// move to the AG grid and perform action
		driver.switchTo().defaultContent();
		Thread.sleep(3);
		// Verify count list
		WebElement totalCountSku = driver
				.findElement(By.xpath("(//div//p[@class='MuiTypography-root MuiTypography-body1 css-1botrlj'])[2]"));
		String texte = totalCountSku.getText();
		System.out.println(texte);
		Thread.sleep(2500);
		// AG Grid screen on
		// Click on the filter button
		driver.findElement(By.xpath("(//span[normalize-space()='Filters'])[1]")).click();
		Thread.sleep(2000);
		// select sheet option
		driver.findElement(By.xpath(
				"(//span[@class='ag-group-title ag-filter-toolpanel-group-title'][normalize-space()='Sheet'])[1]"))
				.click();
		Thread.sleep(2000);
		// Uncheck all sku option
		driver.findElement(By.xpath("(//input[@id='ag-132-input'])[1]")).click();
		Thread.sleep(1000);
		// select under the sheet menu Accessories option
		driver.findElement(By.xpath("(//input[@id='ag-134-input'])[1]")).click();
		Thread.sleep(1000);
		// click on the filter option
		driver.findElement(By.xpath("(//span[normalize-space()='Filters'])[1]")).click();
		Thread.sleep(1000);
		//Click on the action button
		driver.findElement(By.xpath("(//button[normalize-space()='Actions'])[1]")).click();
		Thread.sleep(1000);
		// click on the cut filter option
		driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1snb24w'])[1]")).click();
		Thread.sleep(2000);
		// Enter Child Name
		driver.findElement(By.xpath("(//input[@id='childNamecreate-user'])[1]")).sendKeys("TEST");
		Thread.sleep(2000);
		// click on the Save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(2000);
		// Verify SKU cut completed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'SKU')][1]")));
		String text = successMessage.getText();
		System.out.println(text);
		Thread.sleep(2000);
		// Open same node
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe);
		Thread.sleep(1500);
		WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se = new Actions(driver);
		actions1se.moveToElement(rootnode11e).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Verify count list
		WebElement totalCountSku1 = driver
				.findElement(By.xpath("(//div//p[@class='MuiTypography-root MuiTypography-body1 css-1botrlj'])[2]"));
		String texte1 = totalCountSku1.getText();
		System.out.println(texte1);
		Thread.sleep(1500);
		// close the cross tab
		WebElement nodeTextElement19 = driver.findElement(By.cssSelector("button[aria-label='close']"));
		nodeTextElement19.click();
		Thread.sleep(2000);

		// Mouse over to the New cut sku node

		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(2000);
//					zoomIn(driver);
		WebElement rootnode11e1 = driver.findElement(By.xpath("(//*[contains(text(),'Accessories TEST')])[1]"));
		Actions actions1se1 = new Actions(driver);
		actions1se1.moveToElement(rootnode11e1).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Verify count list
		WebElement totalCountSku11 = driver
				.findElement(By.xpath("(//div//p[@class='MuiTypography-root MuiTypography-body1 css-1botrlj'])[2]"));
		String texte11 = totalCountSku11.getText();
		System.out.println(texte11);
		Thread.sleep(2000);
		// close the cross tab
		WebElement nodeTextElement191 = driver.findElement(By.cssSelector("button[aria-label='close']"));
		nodeTextElement191.click();
		Thread.sleep(2000);
	}	
		
		@Test(priority = 7)
		public void Verify_through_the_AG_grid_Cut_ALL_SKU() throws InterruptedException {
		
		// Move to all Sku List
		// Open same node
		WebElement iframe2 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe2);
		Thread.sleep(1500);
		WebElement rootnode11e2 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se2 = new Actions(driver);
		actions1se2.moveToElement(rootnode11e2).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		//Click on the action button
		driver.findElement(By.xpath("(//button[normalize-space()='Actions'])[1]")).click();
		Thread.sleep(1000);
		// click on the cut filter option
		driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 css-1snb24w'])[1]")).click();
		Thread.sleep(2000);
		// Enter Child Name
		driver.findElement(By.xpath("(//input[@id='childNamecreate-user'])[1]")).sendKeys("AllSKUsCut");
		Thread.sleep(2000);
		// click on the Save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3500);
		// Verify SKU cut completed
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement successMessage1 = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'SKU')][1]")));
		String text1 = successMessage1.getText();
		System.out.println(text1);
		Thread.sleep(2000);
		// Open same node
		WebElement iframe3 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe3);
		Thread.sleep(1500);
		WebElement rootnod = driver.findElement(By.xpath("(//*[contains(text(),'AllSKUsCut')])[1]"));
		Actions actions1s3 = new Actions(driver);
		actions1s3.moveToElement(rootnod).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		//count list
		WebElement totalCountSkua = driver
				.findElement(By.xpath("(//div//p[@class='MuiTypography-root MuiTypography-body1 css-1botrlj'])[2]"));
		String textea = totalCountSkua.getText();
		System.out.println(textea);
		Thread.sleep(2000);
		// close the cross tab
		WebElement nodeTextElement2 = driver.findElement(By.cssSelector("button[aria-label='close']"));
		nodeTextElement2.click();
		Thread.sleep(3000);
		//swtich to frame
		WebElement iframe4 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe4);
		Thread.sleep(1500);
		//AFter assign node check color node change or not 
		WebElement rootnode111 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		String color = rootnode111.getCssValue("color");
		Thread.sleep(1000);
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
		zoomOut(driver);
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Click on home page
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/p/button[1]"))
				.click();
		Thread.sleep(1000);
	}

	public static void zoomIn(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'"); // Adjust the zoom level as needed
	}

	public static void zoomOut(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='100%'"); // Resetting to default zoom level
	}

	@AfterSuite
	public void closeBrowser() {
		// Close the WebDriver instance
		driver.quit();
	}
}
// Particular node select
//		((//*[contains(text(),'M140025')]/parent::div[1])[2]/parent::div/following-sibling::div)[3]
// select traslation select uom &
//				(//*[contains (text(),'Collected Description')])[1]

//		Thread.sleep(2000);
//		driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
//		Thread.sleep(3000);
//
////		Open same node
//		WebElement iframe1w = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
//		// Switch to the iframe
//		driver.switchTo().frame(iframe1w);
//		Thread.sleep(2000);
//		WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
//		Actions actions1se = new Actions(driver);
//		actions1se.moveToElement(rootnode11e).perform();
//		Thread.sleep(4000);
//		driver.switchTo().defaultContent();
//		Thread.sleep(2000);

////// *******Move right to left scroll ***???///////
// *[@id='closeicon']/img
// Mouse over to the created node
// scroll to left
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//    js.executeScript("window.scrollTo(10000, 0);");;
//    Thread.sleep(3000);
//    JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollTo(-15000, 0)");
//	Thread.sleep(3000);
//    WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'TESTABC')])[1]"));
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//    Thread.sleep(500); 
//
//	WebElement nodeText1 = driver.findElement(By.xpath("//*[contains(text(), 'VSGDoverProduct')]"));
////	WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
//    Actions actionsAB = new Actions(driver);
//    actionsAB.dragAndDropBy(nodeText1, 30, 460).perform();
////    actionsAB.dragAndDrop(nodeText1, nodeText2).perform();
////    actionsAB.scrollByAmount(5000, 0).perform();
//	Thread.sleep(3000);
//	WebElement elementToDoubleClickAndMove = driver.findElement(By.xpath("(//*[contains(text(),'TESTABC')])[1]"));
//    Thread.sleep(1000);
//    // Scroll to the element if it's not in the viewport
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToDoubleClickAndMove);
//    Thread.sleep(1000);
//    // Create Actions object
//    Actions actions = new Actions(driver);
//    Thread.sleep(1000);
//    // Double-click on the element
//    actions.doubleClick(elementToDoubleClickAndMove).perform();
//    Thread.sleep(1000);
//    // Simulate the movement from right to left
//    actions.dragAndDropBy(elementToDoubleClickAndMove, -100, 0).build().perform();
//    Thread.sleep(1000);