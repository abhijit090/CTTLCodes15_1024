package CTT_Demo;

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

public class skuTbFA {

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
		Thread.sleep(4000);
	}

	@Test(priority = 3)
	public void Open_Specific_Project() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Open specific
		WebElement element11 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
		element11.click();
		Thread.sleep(4000);
		// iframe
		WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		driver.switchTo().frame(iframe1z1);
		Thread.sleep(12000);
		WebElement nodeTextElement1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
		nodeTextElement1.click();
		Thread.sleep(2000);

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
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	public void Validte_The_Translation_Condition() throws InterruptedException {

		// Check the translation
		WebElement translate = driver.findElement(By.xpath("(//*[contains(text(),'Collected Description')])[1]"));
		Actions actionstranslate = new Actions(driver);
		actionstranslate.moveToElement(translate).perform();
		Thread.sleep(1000);
		// Wait for the element to be clickable
		driver.findElement(By.xpath("(//span[@class=\"ag-icon ag-icon-menu\"])[2]")).click();
		Thread.sleep(2000);
		// Click on translate option
		driver.findElement(By.xpath("(//span[normalize-space()='Translate'])[1]")).click();
		Thread.sleep(1000);
		// Translate Window open Select sources Language
		driver.findElement(By.xpath("(//button[@title='Open'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul/li[contains(text(), 'English')][1]")).click();
		Thread.sleep(2000);
		// Translate Window open Select Target Language
		driver.findElement(By.xpath("(//button[@title='Open'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Hindi')][1]")).click();
		Thread.sleep(2000);
		// Click on the Save button
		WebElement saveButton = driver.findElement(By.xpath("(//button[normalize-space()='Save'])[1]"));
		saveButton.click();
		Thread.sleep(2000);
		// Wait for the success message to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement successMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'created successfully')][1]")));
		String text = successMessage.getText();
		System.out.println(text);
		Thread.sleep(2500);

	}

	@Test(priority = 5)
	public void Verify_The_QA_Checks_Contains_trailing_spaces() throws InterruptedException {
		// Verify table
		List<WebElement> rowsNumber = driver.findElements(By.xpath("(//div[@class='ag-center-cols-viewport'])[1]"));
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
		Thread.sleep(1000);
		// Finding number of Columns

		List<WebElement> columnsNumber = driver.findElements(By.xpath("(//div[@class='ag-center-cols-viewport'])[1]"));
		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
		Thread.sleep(1000);

		WebElement cellAddress = driver
				.findElement(By.xpath("(//*[contains(text(),'VS18458')])[1]/following-sibling::div[3]"));
		String value = cellAddress.getText();
		System.out.println("The Cell Value is: " + value);
		Thread.sleep(1000);

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing = driver
				.findElement(By.xpath("(//*[contains(text(),'VS18458')])[1]/following-sibling::div[3]"));
		Actions actions1q = new Actions(driver);
		actions1q.contextClick(tralaing).perform();
		Thread.sleep(2000);
		// click on the edits option
		WebElement abc = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("ABC123.000  ");
		Thread.sleep(1000);
		// click on the save button
		WebElement abced = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaing2 = driver
				.findElement(By.xpath("(//*[contains(text(),'VS18458')])[1]/following-sibling::div[3]"));
		Actions actions1q2 = new Actions(driver);
		actions1q2.moveToElement(tralaing2).perform();
		Thread.sleep(2000);
		WebElement elemento1x = driver.findElement(By.xpath("//div[contains(text(),'Contains')][1]"));
		String textcc1x = elemento1x.getText();
		System.out.println(textcc1x);
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void Verify_The_QA_Checks_Contains_trailing_Zeros() throws InterruptedException, TimeoutException {

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'M140025')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("123.000");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'M140025')])[1]/following-sibling::div[3]"));
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

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'FA849-KIT')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys(".123");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'FA849-KIT')])[1]/following-sibling::div[3]"));
		Actions actions1i = new Actions(driver);
		actions1i.moveToElement(tralaingi).perform();
		Thread.sleep(2000);
		WebElement elemento1x = driver.findElement(
				By.xpath("(//div[contains(text(),'Does not contain leading zero before decimal point')])[1]"));
		String textcc1x = elemento1x.getText();
		System.out.println(textcc1x);
		Thread.sleep(3000);

	}

	@Test(priority = 8)
	public void Verify_The_QA_Checks_ContainsSpecialChar() throws InterruptedException, TimeoutException {

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'FA966-63BK')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("ABC@#$%asd");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'FA966-63BK')])[1]/following-sibling::div[3]"));
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

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("10 - 10");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[3]"));
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

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'VS20635')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("abcdf™ [TM]");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'VS20635')])[1]/following-sibling::div[3]"));
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

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'STDA128')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys(" ");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'STDA128')])[1]/following-sibling::div[3]"));
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

		// Right click on the particular node for editing Identify msg Contains trailing
		// spaces
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'VS569307')])[1]/following-sibling::div[3]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		WebElement abcd = driver
				.findElement(By.xpath("(//input[@id='Control_&_Electrical_Component_Typemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("AB   CD12");
		Thread.sleep(1000);
		Thread.sleep(2000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("/html/body/div[5]/div[3]/div/div[2]/button[2]/span[1]"));
		abced1.click();
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'VS569307')])[1]/following-sibling::div[3]"));
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
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", applytrans);
		Actions actionsapply = new Actions(driver);
		actionsapply.moveToElement(applytrans).perform();
		Thread.sleep(3000);
		// Wait for the element to be clickable
		driver.findElement(By.xpath(
				"(//div[@class='ag-header-cell-comp-wrapper']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation'])[9]"))
				.click();
		Thread.sleep(2000);

		// Click on the set new type
		driver.findElement(By.xpath("(//*[contains(text(),'Set New Type')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[contains(text(),'Numeric UOM')])[1]")).click();
		Thread.sleep(3000);
		WebElement elemento1x1 = driver.findElement(By.xpath("(//div[contains(text(),'Column type')])[1]"));
		String textcc1x1 = elemento1x1.getText();
		System.out.println(textcc1x1);
		Thread.sleep(3000);
		// Mouse over to the same node and error verify
		WebElement tralaingi = driver
				.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[7]"));
		Actions actions1i = new Actions(driver);
		actions1i.moveToElement(tralaingi).perform();
		Thread.sleep(2000);
		WebElement elemento1x = driver.findElement(By.xpath("(//div[contains(text(),'Uom')])[1]"));
		String textcc1x = elemento1x.getText();
		System.out.println(textcc1x);
		Thread.sleep(2000);
		// Edit the UOM
		WebElement tralaing1 = driver
				.findElement(By.xpath("(//*[contains(text(),'VS10066')])[1]/following-sibling::div[7]"));
		Actions actions1q1 = new Actions(driver);
		actions1q1.contextClick(tralaing1).perform();
		Thread.sleep(1000);
		// click on the edits option
		WebElement abc1 = driver.findElement(By.xpath("(//span[normalize-space()='Edit Cell(s)'])[1]"));
		abc1.click();
		Thread.sleep(3000);
		// click on the value and enter value
		WebElement abcd = driver.findElement(By.xpath("(//input[@id='valuemodify-multi-col'])[1]"));
		Actions actions1qt = new Actions(driver);
		actions1qt.moveToElement(abcd).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd.sendKeys("12");
		Thread.sleep(1000);

		// remove the checkbox
		driver.findElement(By.xpath("//label[@id='valueChecked']//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		// click on the uom value and enter value
		WebElement abcd1 = driver.findElement(By.xpath("(//input[@id='uommodify-multi-col'])[1]"));
		Actions actions1qt1 = new Actions(driver);
		actions1qt1.moveToElement(abcd1).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
				.sendKeys(Keys.DELETE).perform();
		Thread.sleep(2000);
		abcd1.sendKeys("gm");
		Thread.sleep(1000);
		// remove the checkbox
		driver.findElement(By.xpath("//label[@id='uomChecked']//input[@type='checkbox']")).click();
		Thread.sleep(1000);
		// click on the save button
		WebElement abced1 = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
		abced1.click();
		Thread.sleep(3000);

	}
	@Test(priority = 14)
	public void Verify_The_NumericUOM_into_string() throws InterruptedException, TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// Scroll the parentDiv11t into view
		// Scroll the page to the right
		((JavascriptExecutor) driver).executeScript("window.scrollBy(300, 0)");
		WebElement applytrans = driver.findElement(By.xpath("(//*[contains(text(),'Alpha code')])[1]"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", applytrans);
		Actions actionsapply = new Actions(driver);
		actionsapply.moveToElement(applytrans).perform();
		Thread.sleep(3000);
		// Wait for the element to be clickable
		driver.findElement(By.xpath(
				"(//div[@class='ag-header-cell-comp-wrapper']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation'])[9]"))
				.click();
		Thread.sleep(2000);

		// Click on the set new type
		driver.findElement(By.xpath("(//*[contains(text(),'Set New Type')])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[contains(text(),'String')])[1]")).click();
		Thread.sleep(3000);
		WebElement elemento1x1 = driver.findElement(By.xpath("(//div[contains(text(),'Column type')])[1]"));
		String textcc1x1 = elemento1x1.getText();
		System.out.println(textcc1x1);
		Thread.sleep(3000);
		
		//combine attribute
		// Scroll the page to the right
		((JavascriptExecutor) driver).executeScript("window.scrollBy(300, 0)");
		WebElement applytrans1 = driver.findElement(By.xpath("(//*[contains(text(),'Alpha code')])[1]"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", applytrans);
		Actions actionsapply1 = new Actions(driver);
		actionsapply1.moveToElement(applytrans1).perform();
		Thread.sleep(3000);
		// Wait for the element to be clickable
		driver.findElement(By.xpath(
				"(//div[@class='ag-header-cell-comp-wrapper']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation'])[9]"))
				.click();
		Thread.sleep(2000);

		// Click on the combine attribute option*******************
		driver.findElement(By.xpath("(//*[contains(text(),'Combine Attributes')])[1]")).click();
		Thread.sleep(2000);
		//verify the combine attribute screen open
		// Locate the element using XPath
        WebElement abc = driver.findElement(By.xpath("(//*[contains(text(),'Combine Attributes')])[1]"));

        // Assert that the element is present and visible
        assert abc.isDisplayed() : "Element with text 'Combine Attributes' window is not visible.";

        // Print a success message if assertion passes
        System.out.println("Assertion passed: Element with text 'Combine Attributes' is present and visible.");
		Thread.sleep(2000);
		//select att from dropdown
		// Send keys to the input field
		WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.MuiFormControl-root.MuiFormControl-fullWidth.MuiTextField-root.css-e48aov input:nth-of-type(1)")));
		emailInput.sendKeys("Sec._Prod._Desc");	
		Thread.sleep(2000);
		// Locate the dropdown option that contains the text "Control_&_Electrical_Component_Type"
		WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//li[contains(text(), 'Sec._Prod._Desc') and @id='undefinedmerge_attribute-option-0']")));
		dropdownOption.click();
		Thread.sleep(2000);
		//second aatribute choice
		WebElement emailInput1 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//input[@id='undefinedmerge_attribute'])[2]")));
		emailInput1.sendKeys("Alpha_code");	
		Thread.sleep(2000);
		// Locate the dropdown option that contains the text "Control_&_Electrical_Component_Type"
		WebElement dropdownOption1 = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//li[contains(text(), 'Alpha_code') and @id='undefinedmerge_attribute-option-0']")));
		dropdownOption1.click();
		Thread.sleep(2000);
        //click on the excute button
		WebElement excute = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Execute'])[1]")));
		excute.click();	
		Thread.sleep(2000);
		//click on the yes
		WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Yes'])[1]")));
		yes.click();	
		Thread.sleep(2000);
		//verify the message 
		WebElement successMessage11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]/div")));
		String text11 = successMessage11.getText();
		System.out.println(text11);
		Thread.sleep(1000);
		
		WebElement successMessage111 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[2]/div")));
		String text111 = successMessage111.getText();
		System.out.println(text111);
		Thread.sleep(2000);
		// Assert that the message matches the expected text
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(300, 0)");
		WebElement applytrans11 = driver.findElement(By.xpath("(//*[contains(text(),'@@Sec. Prod. Desc-Alpha code')])[1]"));
		Thread.sleep(2000);
		String columnName = applytrans11.getText();
		System.out.println("Column Name: " + columnName);
		Thread.sleep(1000);
	}
	

	@Test(priority = 15)
	public void Verify_The_Apply_Translation() throws InterruptedException, TimeoutException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Click on the save button
		driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
		Thread.sleep(2500);
		// verify text
		WebElement successMessage1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
		String text1 = successMessage1.getText();
		System.out.println(text1);
		Thread.sleep(3000);
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
		Thread.sleep(2500);
		// Scroll the parentDiv11t into view
		// Scroll the page to the right
		((JavascriptExecutor) driver).executeScript("window.scrollBy(300, 0)");
		WebElement applytrans = driver
				.findElement(By.xpath("(//*[contains(text(),'Collected Description Translated')])[1]"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", applytrans);
		Actions actionsapply = new Actions(driver);
		actionsapply.moveToElement(applytrans).perform();
		Thread.sleep(2000);
		// Wait for the element to be clickable
		driver.findElement(By.xpath(
				"//div[@class='ag-header-cell ag-header-cell-sortable custom-header-class ag-focus-managed ag-header-active']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation']"))
				.click();
		Thread.sleep(2000);
		// Click on translate option
		driver.findElement(By.xpath("(//span[normalize-space()='Apply Translation'])[1]")).click();
		Thread.sleep(2000);
		// Wait for the first success message
		WebElement successMessage11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@role='alert'])[1]/div")));
		String text11 = successMessage11.getText();
		System.out.println(text11);
		Thread.sleep(3000);
		
		// Click on the save button
		driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
		Thread.sleep(2000);
		// verify text
		WebElement successMessage111 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
		String text111 = successMessage111.getText();
		System.out.println(text111);
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
