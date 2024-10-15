package CTT_STG;
import java.time.Duration;
import java.util.List;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class vertical_viewfun {
	
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
		
		driver.get("https://staging.d36z6oo50ky8dh.amplifyapp.com/login");
		Thread.sleep(1000);
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
        usernameField.sendKeys("aarushwagh133@gmail.com");

        // Find and fill the password field
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        passwordField.sendKeys("hiFHM4As");

        // Find and click the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
        loginButton.click();
        Thread.sleep(6000);
    }
	@Test(priority = 2)
	public void Verify_Login_Person_Name() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
		String displayName = element.getText();
		System.out.println("Login Person Name: " + displayName);
		Thread.sleep(1000);
	}
	@Test(priority = 3)
	public void Open_Specific_Project() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Open specific
		WebElement element11 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'AaaDemo')])[1]")));
		element11.click();
		Thread.sleep(4000);		
		// iframe
		WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		driver.switchTo().frame(iframe1z1);
		Thread.sleep(12000);
		WebElement nodeTextElement1 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(), 'Controls & Electrical Components')])[1]")));
		nodeTextElement1.click();
		Thread.sleep(4000);

		// shfit the node from up & left side
		WebElement nodeText1a = driver.findElement(By.xpath("(//*[contains(text(), 'VSGDoverProduct')])[1]"));
		Thread.sleep(1000);
		WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(nodeText1a, 40, 80).clickAndHold().perform();
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
		// Click on the Sku & verified Ag gridscreen
		driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
		Thread.sleep(2000);
		// Click on the node
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Batteries')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Screen maximize
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='maximize'])[1]")));
		nodeTextElement11.click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void Move_To_The_Vertical_View_add_value() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Locate the input element that the switch is controlling
		WebElement inputElement = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3'])[1]"));
		// Click the input element directly
		inputElement.click();
		Thread.sleep(2000);
		// Edit the value under the value col
		
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'Control & Electrical Component Type')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		// click on the value and enter value
		WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("1.200");
		Thread.sleep(1000);
		// click the checkbox
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")).click();
		Thread.sleep(1000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		abced1.click();
		Thread.sleep(3000);
		//Verify the value editale value prent here or not 
		// Locate the WebElement using the provided XPath
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Control & Electrical Component Type')])[1]/following-sibling::div[3]"));

		// Get the text value of the WebElement
		String value = element.getText();

		// Verify that the value is "1.200"
		if (value.equals("1.200")) {
		    System.out.println("The value '1.200' is present in the Vertical view.");
		} else {
		    System.out.println("The value '1.200' is not present in the Vertical view. The actual value is: " + value);
		}
		
		// Locate the horizontal scrollable element
		WebElement scrollableElement = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));

		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll the element horizontally by a specific number of pixels
		// For example, scroll right by 500 pixels
		js.executeScript("arguments[0].scrollLeft += 300;", scrollableElement);
		Thread.sleep(1000);
		// Locate the vertical scrollable element
		WebElement scrollableElement1 = driver.findElement(By.xpath("(//div[@class='ag-body-vertical-scroll-viewport'])[1]"));

		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		// Scroll the element vertically by a specific number of pixels
		// For example, scroll down by 300 pixels
		js1.executeScript("arguments[0].scrollTop += 300;", scrollableElement1);
		Thread.sleep(1000);
		//User Navigate Horizontal view
		// Locate the input element that the switch is controlling
		WebElement inputElement1 = driver
				.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3'])[1]"));
		// Click the input element directly
		inputElement1.click();
		Thread.sleep(2000);
		//Verify the data 
		// Locate the WebElement using the provided XPath
		WebElement element1 = driver.findElement(
				By.xpath("(//span[@sx='[object Object]'][normalize-space()='1.200'])[1]"));

		// Get the text value of the WebElement
		String value1 = element1.getText();

		// Verify that the value is "1.200"
		if (value1.equals("1.200")) {
			System.out.println("The value '1.200' is present in the Horizontal view.");
		} else {
			System.out.println("The value '1.200' is not present in the Horizontal view. The actual value is: " + value1);
		}
		Thread.sleep(2500);
		//Click on the save button
		WebElement nodeTextElement11 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[@aria-label='save'])[1]")));
		nodeTextElement11.click();
		Thread.sleep(2500);
		// verify text
		WebElement successMessage1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
		String text1 = successMessage1.getText();
		System.out.println(text1);
		Thread.sleep(3000);
		
		
	}
	
	@Test(priority = 5)
	public void Verify_the_vertical_end_node_data_presnt_in_PareentNode() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		// Open same node
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		// Switch to the iframe
		driver.switchTo().frame(iframe);
		Thread.sleep(3000);
		WebElement rootnode11e = driver
				.findElement(By.xpath("(//*[contains(text(),'Controls & Electrical Components')])[1]"));
		Actions actions1se = new Actions(driver);
		actions1se.moveToElement(rootnode11e).perform();
		Thread.sleep(2500);
		driver.switchTo().defaultContent();
		Thread.sleep(2500);
		//Screen maximize
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='maximize'])[1]")));
		nodeTextElement11.click();
		Thread.sleep(2000);
		
		// Locate the input element that the switch is controlling
		WebElement inputElement = driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3'])[1]"));
		// Click the input element directly
		inputElement.click();
		Thread.sleep(2000);
		//Verify the End node editable data are avilave here or not 
		WebElement element = driver.findElement(By.xpath("(//*[contains(text(),'Control & Electrical Component Type')])[1]/following-sibling::div[3]"));

		// Get the text value of the WebElement
		String value = element.getText();

		// Verify that the value is "1.200"
		if (value.equals("1.200")) {
		    System.out.println("The value '1.200' is present in the Vertical view.");
		} else {
		    System.out.println("The value '1.200' is not present in the Vertical view. The actual value is: " + value);
		}
		
		// Edit the value under the value col
		
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'Control & Electrical Component Type')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		// click on the value and enter value
		WebElement abcd = driver.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys(" Test ");
		Thread.sleep(1000);
		// click the checkbox
		driver.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[1]")).click();
		Thread.sleep(1000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		abced1.click();
		Thread.sleep(3000);
		//Verify the value editale value prent here or not 
		// Locate the WebElement using the provided XPath
		WebElement element1 = driver.findElement(By.xpath("(//*[contains(text(),'Control & Electrical Component Type')])[1]/following-sibling::div[3]"));

		// Get the text value of the WebElement
		String value1 = element1.getText();

		// Verify that the value is "Test"
		if (value1.equals(" Test ")) {
		    System.out.println("The value ' Test ' is present in the Vertical view.");
		} else {
		    System.out.println("The value ' Test ' is present in the Vertical view. The actual value is: " + value1);
		}
		
		// Locate the horizontal scrollable element
		WebElement scrollableElement = driver.findElement(By.xpath("(//div[@class='ag-body-horizontal-scroll-viewport'])[1]"));

		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll the element horizontally by a specific number of pixels
		// For example, scroll right by 500 pixels
		js.executeScript("arguments[0].scrollLeft += 300;", scrollableElement);
		Thread.sleep(1000);
		// Locate the vertical scrollable element
		WebElement scrollableElement1 = driver.findElement(By.xpath("(//div[@class='ag-body-vertical-scroll-viewport'])[1]"));

		// Cast WebDriver to JavascriptExecutor
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		// Scroll the element vertically by a specific number of pixels
		// For example, scroll down by 300 pixels
		js1.executeScript("arguments[0].scrollTop += 300;", scrollableElement1);
		Thread.sleep(1000);
		//User Navigate Horizontal view
		// Locate the input element that the switch is controlling
		WebElement inputElement1 = driver
				.findElement(By.xpath("(//input[@class='PrivateSwitchBase-input MuiSwitch-input css-1m9pwf3'])[1]"));
		// Click the input element directly
		inputElement1.click();
		Thread.sleep(2000);
		//Verify the data 
		// Locate the WebElement using the provided XPath
		WebElement element11 = driver.findElement(
				By.xpath("(//span[@sx='[object Object]'][normalize-space()='Test'])[1]"));

		// Get the text value of the WebElement
		String value11 = element11.getText();

		// Verify that the value is " Test "
		if (value11.equals(" Test ")) {
			System.out.println("The value ' Test ' is present in the Horizontal view.");
		} else {
			System.out.println("The value ' Test ' is present in the Horizontal view. The actual value is: " + value11);
		}
		Thread.sleep(2000);
		//Click on the save button
		//Click on the save button
		WebElement nodeTextElement111 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='save'])[1]")));
		nodeTextElement111.click();
		Thread.sleep(2500);
		// verify text
		WebElement successMessage1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
		String text1 = successMessage1.getText();
		System.out.println(text1);
		Thread.sleep(3000);
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
