package CTT_STG;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.bouncycastle.jcajce.provider.asymmetric.EC;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
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

public class navistarNew {

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
		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		passwordField.sendKeys("hiFHM4As");

		// Find and click the login button
		WebElement loginButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
		loginButton.click();
		Thread.sleep(6000);
	}

	@Test(priority = 2)
	public void Verify_Login_Person_Name() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
		String displayName = element.getText();
		System.out.println("Login Person Name: " + displayName);
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void Open_Specific_Project() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Locate the parent div class that contains all the project names
		WebElement parentDiv11t = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(1000);

		// Open specific
		WebElement testAb = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Navistar35')])[1]")));
		testAb.click();
		Thread.sleep(8000);
		// Inside Iframe
		WebElement iframe1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@id='iframeD3'])[1]")));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(5000);
		// Click on the parent node
		WebElement nodeTextElement1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//*[contains(text(), 'Entertainment and Telematics')])[1]")));
		nodeTextElement1.click();
		Thread.sleep(4000);

		// shfit the node from up & left side
//		WebElement nodeText1a = driver.findElement(By.xpath("(//*[@r='4.75'])[8]"));
//		Thread.sleep(1000);
//		WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(nodeText1a, 40, 80).clickAndHold().perform();
//		Thread.sleep(1000);
//		actions.dragAndDropBy(nodeText1a, -450, 0).perform();
//		Thread.sleep(1000);
//		Thread.sleep(4000);
		// Move to chart left side
		// Find the node element
		WebElement nodeText1a = driver.findElement(By.xpath("(//*[@r='4.75'])[8]"));
		Thread.sleep(1000);

		// Find another reference element (not really necessary for this movement but in
		// case you need)
		WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));

		// Get the current location of the node element
		Point nodeLocation = nodeText1a.getLocation();
		int xLocation = nodeLocation.getX();

		// Get the window size for width
		Dimension windowSize = driver.manage().window().getSize();
		int windowWidth = windowSize.getWidth();

		// Create an action to move to the left
		Actions actions = new Actions(driver);

		// Move the node all the way to the left
		actions.moveToElement(nodeText1a, 30, 70).clickAndHold().perform();
		Thread.sleep(1000);

		// Perform drag operation
		actions.dragAndDropBy(nodeText1a, -450, 0).perform();
		Thread.sleep(1000);
		// Wait to observe
		Thread.sleep(4000);

		WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[contains(text(),'Telematics Systems and Components')])[1]")));
		parentDiv11w11.click();
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
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Park Assist Camera')])[2]"));
		Actions actions1s1 = new Actions(driver);
		actions1s1.moveToElement(rootnode11).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
	}

	@AfterSuite
	public void closeBrowser() {
		// Close the WebDriver instance
//		driver.quit();
	}
}
