package CTT_Demo1;

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

public class Single_SKU_SrchDB_AWR {
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
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
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
		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		passwordField.sendKeys("OLOtx095");

		// Find and click the login button
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
		loginButton.click();
		Thread.sleep(5000);

	}

	@Test(priority = 2)
	public void Verify_Login_Person_Name() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
		String displayName = element.getText();
		System.out.println("Login Person Name: " + displayName);
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void Open_Specific_Project() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

		// Open specific
		WebElement element11 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
		element11.click();
		Thread.sleep(8000);
		// iframe
		WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		driver.switchTo().frame(iframe1z1);
		Thread.sleep(8000);
		WebElement nodeTextElement1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
		Thread.sleep(4000);
		nodeTextElement1.click();
		Thread.sleep(2000);
		// Visible buttons checked on VIZ tool screen
		// click on the pop button on header and Verify aatribuite
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(1000);
		// Click on the Attribute verify SKU
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(1000);
		// Click on the Sku & verified Ag gridscreen
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(1000);
		// Click on the node
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// Screen maximize
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='maximize'])[1]")));
		nodeTextElement11.click();
		Thread.sleep(2000);

	}

	@Test(priority = 4)
	public void To_Verify_that_Data_Not_Available_In_AWR_Database() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Select any one cell and Right click
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//div[@role='gridcell'][normalize-space()='M140025'])[1]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// singl SKU serach
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='SKU Search'])[1]"));
		abc1.click();
		Thread.sleep(2000);

		// selectAttributesHeader screen open
		WebElement selectAttributesHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));

		// Check if the "Select Attributes" screen is displayed
		if (selectAttributesHeader.isDisplayed()) {
			System.out.println("The 'Select Attributes' screen is open. \n");
		} else {
			System.out.println("The 'Select Attributes' screen is NOT open.");
		}
		Thread.sleep(1000);
		// select DB search
		WebElement awrSearchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='DB Search'])[1]")));
		awrSearchButton.click();
		// Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATTa = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'PROD NO')]")));
		selectATTa.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd1 = driver
				.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
		Actions actions1qt1 = new Actions(driver);
		actions1qt1.moveToElement(abcd1).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd1.sendKeys("Testabcd143");
		Thread.sleep(2000);
		// Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);
		// Wait for the first success message
		WebElement successMessage11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text11 = successMessage11.getText();
		System.out.println(text11 + "\n");
		Thread.sleep(3000);
		// Click on the cancel
		driver.findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void Verify_Through_the_database() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

		// Select any one cell and Right click
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//div[@role='gridcell'][normalize-space()='M140025'])[1]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// singl SKU serach
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='SKU Search'])[1]"));
		abc1.click();
		Thread.sleep(2000);

		// selectAttributesHeader screen open
		WebElement selectAttributesHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));

		// Check if the "Select Attributes" screen is displayed
		if (selectAttributesHeader.isDisplayed()) {
			System.out.println("The 'Select Attributes' screen is open. \n");
		} else {
			System.out.println("The 'Select Attributes' screen is NOT open.\n");
		}
		// select DB search
		WebElement awrSearchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='DB Search'])[1]")));
		awrSearchButton.click();
		// Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li[contains(text(), 'PROD NO')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("SNT200CL");
		Thread.sleep(2000);
		// Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);
		// pop-up message print
		WebElement successMessage146 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1456 = successMessage146.getText();
		System.out.println(text1456 + "\n");
		Thread.sleep(3000);
		// select checkbox
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")));
		checkbox.click();
		Thread.sleep(2000);
		// Wait until the 'Next' button is clickable and then click it
		WebElement nextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Next'])[1]")));
		nextButton.click();
		Thread.sleep(2000);
		// Wait until the 'Attribute List' screen is visible
		WebElement elementAs = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Attribute List'])[1]")));

		// Check if the 'Attribute List' screen is visible and print the result
		if (elementAs.isDisplayed()) {
			System.out.println("Attribute List screen is open." + "\n");
		} else {
			System.out.println("Attribute List screen is NOT open." + "\n");
		}
		Thread.sleep(2000);
		// Select cell
		WebElement elementA2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'Body_Color')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA2.click();
		Thread.sleep(2000);
		// double click
		WebElement dbclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"((//*[contains(text(),'Body_Color')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions = new Actions(driver);
		actions.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// click dropdown menu
		WebElement elementA3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")));
		elementA3.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//ul//li[contains(text(), 'Quantity')])[1]")));
		selectATT1.click();
		Thread.sleep(2000);

		// Select one more
		// Select cell
		WebElement elementA21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("((//*[contains(text(),'Status')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA21.click();
		Thread.sleep(2000);
		// double click
		WebElement dbclick1 = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("((//*[contains(text(),'Status')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions1 = new Actions(driver);
		actions1.doubleClick(dbclick1).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// click dropdown menu
		WebElement elementA31 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")));
		elementA31.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT11 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//ul//li[contains(text(), 'Short Description => Collected Description')])[1]")));
		selectATT11.click();
		Thread.sleep(2000);

		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);
		// View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		// click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage1.getText();
		System.out.println(text14);
		// Open same node
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
		// View last end
		WebElement element1231 = driver
				.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element1231);
		Thread.sleep(2000);
		// Mouse over to the collected dis
		// Locate the column header element
		WebElement columnHeader = driver.findElement(By.xpath("(//*[@class='ag-header-cell-resize'])[4]"));

		// Scroll the column into view using JavaScript
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("arguments[0].scrollIntoView(true);", columnHeader);

		// Optional: wait for a moment to visually confirm the scroll
		Thread.sleep(2000);

		// Verify if the column header is now visible
		if (columnHeader.isDisplayed()) {
			System.out.println("The 'Collected Description' column is now visible. \n");
		} else {
			System.out.println("The 'Collected Description' column is NOT visible.\n");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 6)
	public void Verify_Through_the_database_Update() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

		// Select any one cell and Right click
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//div[@role='gridcell'][normalize-space()='M140025'])[1]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// singl SKU serach
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='SKU Search'])[1]"));
		abc1.click();
		Thread.sleep(2000);

		// selectAttributesHeader screen open
		WebElement selectAttributesHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));

		// Check if the "Select Attributes" screen is displayed
		if (selectAttributesHeader.isDisplayed()) {
			System.out.println("The 'Select Attributes' screen is open. \n");
		} else {
			System.out.println("The 'Select Attributes' screen is NOT open.\n");
		}
		// select DB search
		WebElement awrSearchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='DB Search'])[1]")));
		awrSearchButton.click();
		// Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li[contains(text(), 'PROD NO')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("SNT200CL");
		Thread.sleep(2000);
		// Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);
		// pop-up message print
		WebElement successMessage146 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1456 = successMessage146.getText();
		System.out.println(text1456);
		Thread.sleep(3000);
		// select checkbox
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")));
		checkbox.click();
		Thread.sleep(2000);
		// Wait until the 'Next' button is clickable and then click it
		WebElement nextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Next'])[1]")));
		nextButton.click();
		Thread.sleep(2000);
		// Wait until the 'Attribute List' screen is visible
		WebElement elementAs = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Attribute List'])[1]")));

		// Check if the 'Attribute List' screen is visible and print the result
		if (elementAs.isDisplayed()) {
			System.out.println("Attribute List screen is open.\n");
		} else {
			System.out.println("Attribute List screen is NOT open.\n");
		}
		Thread.sleep(2000);
		// Select cell
		WebElement elementA2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA2.click();
		Thread.sleep(2000);
		// double click
		WebElement dbclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions = new Actions(driver);
		actions.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// click dropdown menu
		WebElement elementA3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")));
		elementA3.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//ul//li[contains(text(), 'Quantity')])[1]")));
		selectATT1.click();
		Thread.sleep(2000);

		// Select one more
		// Select cell
		WebElement elementA21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA21.click();
		Thread.sleep(2000);
		// double click
		WebElement dbclick1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions1 = new Actions(driver);
		actions1.doubleClick(dbclick1).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// click dropdown menu
		WebElement elementA31 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")));
		elementA31.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT11 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//ul//li[contains(text(), 'Short Description => Collected Description')])[1]")));
		selectATT11.click();
		Thread.sleep(2000);

		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);
		// View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		// click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage1.getText();
		System.out.println(text14);
		// Open same node
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se = new Actions(driver);
		actions1se.moveToElement(rootnode11e).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// View last end
		WebElement element1231 = driver
				.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element1231);
		Thread.sleep(2000);
		// Mouse over to the collected dis
		// Locate the column header element
		WebElement columnHeader = driver.findElement(By.xpath("(//*[@class='ag-header-cell-resize'])[4]"));

		// Scroll the column into view using JavaScript
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("arguments[0].scrollIntoView(true);", columnHeader);

		// Optional: wait for a moment to visually confirm the scroll
		Thread.sleep(2000);

		// Verify if the column header is now visible
		if (columnHeader.isDisplayed()) {
			System.out.println("The 'Collected Description' column is now visible.\n");
		} else {
			System.out.println("The 'Collected Description' column is NOT visible.\n");
		}
		Thread.sleep(2000);

	}

	@Test(priority = 7)
	public void Verify_Through_the_database_AI_Mapping() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));

		// Select any one cell and Right click
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//div[@role='gridcell'][normalize-space()='M140025'])[1]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// singl SKU serach
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='SKU Search'])[1]"));
		abc1.click();
		Thread.sleep(2000);

		// selectAttributesHeader screen open
		WebElement selectAttributesHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));

		// Check if the "Select Attributes" screen is displayed
		if (selectAttributesHeader.isDisplayed()) {
			System.out.println("The 'Select Attributes' screen is open. \n");
		} else {
			System.out.println("The 'Select Attributes' screen is NOT open.\n");
		}
		// select DB search
		WebElement awrSearchButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='DB Search'])[1]")));
		awrSearchButton.click();
		// Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li[contains(text(), 'PROD NO')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("SNT200CL");
		Thread.sleep(2000);
		// Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);
		// pop-up message print
		WebElement successMessage146 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1456 = successMessage146.getText();
		System.out.println(text1456);
		Thread.sleep(3000);
		// select checkbox
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("((//*[contains(text(),'Grainger2022Build')])[1]//parent::div//following-sibling::div)[1]")));
		checkbox.click();
		Thread.sleep(2000);
		// Wait until the 'Next' button is clickable and then click it
		WebElement nextButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Next'])[1]")));
		nextButton.click();
		Thread.sleep(2000);
		// Wait until the 'Attribute List' screen is visible
		WebElement elementAs = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Attribute List'])[1]")));

		// Check if the 'Attribute List' screen is visible and print the result
		if (elementAs.isDisplayed()) {
			System.out.println("Attribute List screen is open.\n");
		} else {
			System.out.println("Attribute List screen is NOT open.\n");
		}
		Thread.sleep(2000);

		// Select cell
		WebElement elementA2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA2.click();
		Thread.sleep(2000);
		// double click
		WebElement dbclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions = new Actions(driver);
		actions.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// click dropdown menu
		WebElement elementA3 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")));
		elementA3.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//ul//li[contains(text(), 'Product Type')])[1]")));
		selectATT1.click();
		Thread.sleep(2000);

		// Select one more
		// Select cell
		WebElement elementA21 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA21.click();
		Thread.sleep(2000);
		// double click
		WebElement dbclick1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
		Actions actions1 = new Actions(driver);
		actions1.doubleClick(dbclick1).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// click dropdown menu
		WebElement elementA31 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[11]")));
		elementA31.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT11 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//ul//li[contains(text(), 'Short Description => Collected Description')])[1]")));
		selectATT11.click();
		Thread.sleep(2000);

		// Click on the AI Mapping
		WebElement aimapping = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='AI MAPPING'])[1]")));
		aimapping.click();
		Thread.sleep(2000);
		// Verify the message
		// Wait for the first success message
		WebElement successMessage12 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text124 = successMessage12.getText();
		System.out.println(text124);
		Thread.sleep(3000);
		// AI maaping in progress
		WebElement successMessage121 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1241 = successMessage121.getText();
		System.out.println(text1241);
		Thread.sleep(2000);
		// MAppining fetch sucessfully
		WebElement successMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Mapping fetched successfully')][1]")));
		String text = successMessage.getText();
		System.out.println(text);
		Thread.sleep(2500);

		// select cell particular after AI mapping
		// Select cell
		WebElement elementA211 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'OPItemId')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA211.click();
		Thread.sleep(2000);
		// select
		WebElement elementA2111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'PT_MPN_1')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA2111.click();
		Thread.sleep(2000);
		// Select another cell
		WebElement elementA21111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"((//*[contains(text(),'PT_Client_URL')])[1]//parent::div//parent::div//following-sibling::div)[3]")));
		elementA21111.click();
		Thread.sleep(2000);

		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);
		// View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		// click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage1.getText();
		System.out.println(text14);
		// Open same node
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement rootnode11e = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se = new Actions(driver);
		actions1se.moveToElement(rootnode11e).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// View last end
		WebElement element1231 = driver
				.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element1231);
		Thread.sleep(2000);
		// Mouse over to the collected dis
		// Locate the column header element
		WebElement columnHeader = driver.findElement(By.xpath("(//*[@class='ag-header-cell-resize'])[4]"));

		// Scroll the column into view using JavaScript
		JavascriptExecutor js12 = (JavascriptExecutor) driver;
		js12.executeScript("arguments[0].scrollIntoView(true);", columnHeader);

		// Optional: wait for a moment to visually confirm the scroll
		Thread.sleep(2000);

		// Verify if the column header is now visible
		if (columnHeader.isDisplayed()) {
			System.out.println("The 'Collected Description' column is now visible.\n");
		} else {
			System.out.println("The 'Collected Description' column is NOT visible.\n");
		}
		Thread.sleep(2000);

		// Click on save button
		WebElement nodeTextElement19 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='save'])[1]")));
		nodeTextElement19.click();
		Thread.sleep(3000);

	}
	
	@Test(priority = 8)
	public void Verify_Through_AWR() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(1000);
		// Wait until the iframe is present and switch to it
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//iframe[@id='iframeD3'])[1]")));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);
        // Wait until the element containing 'Batteries' text is visible
        WebElement rootnode11e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Batteries')])[1]")));
        // Perform the actions once the element is visible
        Actions actions1se = new Actions(driver);
        actions1se.moveToElement(rootnode11e).perform();
        Thread.sleep(2000);
        // Switch back to the main content
        driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// Screen maximize
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='maximize'])[1]")));
		nodeTextElement11.click();
		Thread.sleep(2000);

		// Select any one cell and Right click
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//div[@role='gridcell'][normalize-space()='VS10066'])[1]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// singl SKU serach
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='SKU Search'])[1]"));
		abc1.click();
		Thread.sleep(2000);

		// selectAttributesHeader screen open
		WebElement selectAttributesHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));

		// Check if the "Select Attributes" screen is displayed
		if (selectAttributesHeader.isDisplayed()) {
			System.out.println("The 'Select Attributes' screen is open. \n");
		} else {
			System.out.println("The 'Select Attributes' screen is NOT open.");
		}
		Thread.sleep(1000);
		// Select AWR Option
		WebElement inputElement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='AWR Search'])[1]")));
		inputElement.click();
		Thread.sleep(1000);
		// Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Brand')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("Lifts");
		Thread.sleep(2000);
		// Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);
		// pop-up message print
		WebElement successMessage146 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1456 = successMessage146.getText();
		System.out.println(text1456 + "\n");
		Thread.sleep(3000);
		//// pop-up message print
		WebElement successMessage1461 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'URLs Fetched Succesfully')][1]")));
		String text14561 = successMessage1461.getText();
		System.out.println(text14561 + "\n");
		Thread.sleep(3000);
		// radioButton.click();
		Thread.sleep(4000);
		// Wait until the element is visible and enabled
		WebElement radioButton = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radioButton);
		Thread.sleep(2000);
		// Click on the Extarct button
		driver.findElement(By.xpath("(//button[normalize-space()='Extract Attributes'])[1]")).click();
		Thread.sleep(2000);
		// Wait for the first success message
		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1 = successMessage.getText();
		System.out.println(text1);
		Thread.sleep(3000);

		//// pop-up message print
		WebElement successMessage14611 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Attributes Fetched Successfully')][1]")));
		String text145611 = successMessage14611.getText();
		System.out.println(text145611 + "\n");
		Thread.sleep(3000);
		//
		// Click on the AI Mapping
		WebElement aimapping = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='AI MAPPING'])[1]")));
		aimapping.click();
		Thread.sleep(2000);
		// Verify the message
		// Wait for the first success message
		WebElement successMessage12 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text124 = successMessage12.getText();
		System.out.println(text124);
		Thread.sleep(3000);
		// AI maaping in progress
		WebElement successMessage121 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1241 = successMessage121.getText();
		System.out.println(text1241);
		Thread.sleep(2000);
		// MAppining fetch sucessfully
		WebElement successMessage1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Mapping fetched successfully')][1]")));
		String text = successMessage1.getText();
		System.out.println(text);
		Thread.sleep(3000);

	//// Select cell First
			driver.findElement(By.xpath(
					"((//*[contains(text(),'LIFTS')])[2]//parent::div//parent::div)[5]"))
					.click();
			Thread.sleep(2000);
		// double click
		WebElement dbclick = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//*[contains(text(),'LIFTS')])[2]//parent::div/div[3]")));
		Actions actions = new Actions(driver);
		actions.doubleClick(dbclick).perform();
		Thread.sleep(1000);
		// select drop down which aatribute map
		// Attribute select
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[14]")));
		dropdown.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//ul//li[contains(text(), 'Product Type')])[1]")));
		selectATT1.click();
		Thread.sleep(2000);

		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);

		// View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		// click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage11.getText();
		System.out.println(text14);
		// Open same node
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(3000);
		WebElement rootnode11e1 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se1 = new Actions(driver);
		actions1se1.moveToElement(rootnode11e1).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// View last end
		WebElement element1231 = driver
				.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element1231);
		Thread.sleep(2000);

		// Click on save button
		WebElement nodeTextElement19 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='save'])[1]")));
		nodeTextElement19.click();
		Thread.sleep(3000);

	}

	@Test(priority = 9)
	public void Verify_Through_AWR_and_Update_AWR_Value() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		Thread.sleep(1000);
		// iframe
		WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		driver.switchTo().frame(iframe1z1);
		Thread.sleep(3000);

		// mouseover on the node
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// Screen maximize
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='maximize'])[1]")));
		nodeTextElement11.click();
		Thread.sleep(2000);
		//// Select any one cell and Right click
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//div[@role='gridcell'][normalize-space()='VS10066'])[1]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// singl SKU serach
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='SKU Search'])[1]"));
		abc1.click();
		Thread.sleep(2000);

		// selectAttributesHeader screen open
		WebElement selectAttributesHeader = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Select Attributes'])[1]")));

		// Check if the "Select Attributes" screen is displayed
		if (selectAttributesHeader.isDisplayed()) {
			System.out.println("The 'Select Attributes' screen is open. \n");
		} else {
			System.out.println("The 'Select Attributes' screen is NOT open.");
		}
		Thread.sleep(1000);
		// Select AWR Option
		WebElement inputElement = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='AWR Search'])[1]")));
		inputElement.click();
		Thread.sleep(1000);
		// Attribute select
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Brand')]")));
		selectATT.click();
		Thread.sleep(2000);
		// Enter value
		WebElement abcd = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//input[@class='MuiInputBase-input MuiInput-input css-etuic5'])[1]")));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("Lifts");
		Thread.sleep(2000);
		// Click on search
		driver.findElement(By.xpath("(//button[normalize-space()='search'])[1]")).click();
		Thread.sleep(2000);
		// pop-up message print
		WebElement successMessage146 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1456 = successMessage146.getText();
		System.out.println(text1456 + "\n");
		Thread.sleep(3000);
		//// pop-up message print
		WebElement successMessage1461 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'URLs Fetched Succesfully')][1]")));
		String text14561 = successMessage1461.getText();
		System.out.println(text14561 + "\n");
		Thread.sleep(3000);
		// radioButton.click();
		Thread.sleep(4000);
		// Wait until the element is visible and enabled
		WebElement radioButton = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", radioButton);
		Thread.sleep(2000);
		// Click on the Extarct button
		driver.findElement(By.xpath("(//button[normalize-space()='Extract Attributes'])[1]")).click();
		Thread.sleep(2000);
		// Wait for the first success message
		WebElement successMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text1 = successMessage.getText();
		System.out.println(text1);
		Thread.sleep(3000);

		//// pop-up message print
		WebElement successMessage14611 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Attributes Fetched Successfully')][1]")));
		String text145611 = successMessage14611.getText();
		System.out.println(text145611 + "\n");
		Thread.sleep(6000);

	//// Select cell First
		WebElement element = driver.findElement(By.xpath("((//*[contains(text(),'Service Name')])[1]//parent::div//parent::div//following-sibling::div)[3]"));
		element.click();
		Thread.sleep(2000);
	// double click
	WebElement dbclick = wait.until(ExpectedConditions
			.elementToBeClickable(By.xpath("((//*[contains(text(),'Service Name')])[1]//parent::div//parent::div//following-sibling::div)[5]")));
	Actions actions1 = new Actions(driver);
	actions1.doubleClick(dbclick).perform();
	Thread.sleep(1000);
		// select drop down which aatribute map
		// Attribute select
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[14]")));
		dropdown.click();
		Thread.sleep(2000);
		// Select attribute
		WebElement selectATT1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//ul//li[contains(text(), 'Product Brand => Brand')])[1]")));
		selectATT1.click();
		Thread.sleep(2000);
		// Click on the save button
		driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]")).click();
		Thread.sleep(3000);

		// View last end
		WebElement element123 = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element123);
		Thread.sleep(2000);
		// click on the main save button
		WebElement element1 = driver.findElement(By.xpath("(//button[@aria-label='save'])[1]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", element1);
		// Wait for the first success message
		WebElement successMessage11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]")));
		String text14 = successMessage11.getText();
		System.out.println(text14);
		// Open same node
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(3000);
		WebElement rootnode11e1 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1se1 = new Actions(driver);
		actions1se1.moveToElement(rootnode11e1).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		// View last end
		WebElement element1231 = driver
				.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));
		JavascriptExecutor js11 = (JavascriptExecutor) driver;
		js11.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth", element1231);
		Thread.sleep(2000);

		// Click on save button
		WebElement nodeTextElement19 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='save'])[1]")));
		nodeTextElement19.click();
		Thread.sleep(3000);
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		// Click on home page
		// Find the button
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Home'][1]"));

		// Use JavaScript to click the button
		JavascriptExecutor js21 = (JavascriptExecutor) driver;
		js21.executeScript("arguments[0].click();", button);
		Thread.sleep(1000);

	}

	@AfterSuite
	public void closeBrowser() {
		// Close the WebDriver instance
		driver.quit();
	}
}
