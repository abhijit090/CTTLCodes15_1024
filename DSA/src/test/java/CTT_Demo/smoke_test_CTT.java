package CTT_Demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class smoke_test_CTT {
	private static String iframe;
	public static String screenShotSubFoderName;
	public static WebDriver driver;

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
	}

	@Test(priority = 3)
	public void Navigate_To_The_User_Menu() throws InterruptedException {
		String userName = "NewProjectTset";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		// Click on the user tab
		WebElement userTab = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Users'])[1]")));
		userTab.click();
		Thread.sleep(2500);
		// Click on the "Create User" button
		WebElement createUserButton = driver.findElement(By.xpath("(//button[normalize-space()='Create User'])[1]"));
		createUserButton.click();
		Thread.sleep(2500);
		// Wait until the "Create User" window is displayed
		WebElement createUserWindow = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Create User'])[1]")));
		Thread.sleep(1500);
		// Enter Name
		WebElement fullNameInput = driver.findElement(By.xpath("(//input[@id='FullNamecreate-user'])[1]"));
		fullNameInput.sendKeys(userName);
		Thread.sleep(1500);
		// Enter email
		WebElement emailInput = driver.findElement(By.xpath("(//input[@id='EmailAddresscreate-user'])[1]"));
		emailInput.sendKeys("Aaatest123@pivotree.com");
		Thread.sleep(1500);
		// Click on the "Cancel" button
		WebElement cancel = driver.findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]"));
		cancel.click();
		Thread.sleep(2500);

		// Modified pencil icon check
		// Locate the parent div class that contains all the project email
		WebElement modifyUser = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[@row-index='1']//button[@aria-label='Modify User'])[1]")));
		modifyUser.click();
		Thread.sleep(3000);
		// Verify modifiyed user screen open or not
		WebElement modifyUserscreen = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Modify User'])[1]")));
		String displayName = modifyUserscreen.getText();
		System.out.println("Screen Name: " + displayName);
		Thread.sleep(2500);
		// edit text
		WebElement textedit = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='FullNamecreate-user'])[1]")));
		textedit.sendKeys("TestABCD");
		Thread.sleep(2500);
		// click on the is active button
		WebElement activeclick = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[@id='undefined-create-user-0'])")));
		activeclick.click();
		Thread.sleep(1500);
		// Click on the "Cancel" button
		WebElement cancel1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
		cancel1.click();
		Thread.sleep(2500);

		// Apply filter and check filter works or not***********
		// Full name apply filter
		WebElement fullname = driver.findElement(By.xpath("(//*[contains(text(),'Full Name')])[1]"));
		Actions name = new Actions(driver);
		name.moveToElement(fullname).perform();
		Thread.sleep(2500);
		// Wait for the thumbnil icon
		driver.findElement(By.xpath("(//span[@role='presentation'])[3]")).click();
		Thread.sleep(2500);
		// Click on apply filter button
		driver.findElement(By.xpath("(//span[@aria-label='filter']//span[@role='presentation'])[1]")).click();
		Thread.sleep(2500);
		// Unselect all
		WebElement unselect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'(Select All)')])[1]")));
		unselect.click();
		Thread.sleep(2500);
		// select particular
		WebElement select = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'ABCD')])[1]")));
		select.click();
		Thread.sleep(2500);
		// Selecot another one
		// select particular with search box
		WebElement select2 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-label='Search filter values'])[1]")));
		select2.sendKeys("Christopher Thom");
		Thread.sleep(1000);
		select2.sendKeys(Keys.RETURN);
		Thread.sleep(2500);
		// Click checkbox
		WebElement select12 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"((//*[contains(text(),'Christopher Thompson')])//parent::div//div[@class='ag-wrapper ag-input-wrapper ag-checkbox-input-wrapper ag-checked'])[1]")));
		select12.click();
		Thread.sleep(2000);
		// Clear filter
		WebElement clrfilter = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter.click();
		Thread.sleep(3000);

		// Email apply filter
		WebElement emailname = driver.findElement(By.xpath("(//*[contains(text(),'Email Address')])[1]"));
		Actions name1 = new Actions(driver);
		name1.moveToElement(emailname).perform();
		Thread.sleep(2500);
		// Wait for the thumbnil icon
		driver.findElement(By.xpath("//div[@class='ag-header-cell ag-header-cell-sortable columnHeader ag-focus-managed ag-header-active']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation']")).click();
		Thread.sleep(2500);
		// Unselect all
		WebElement unselect1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'(Select All)')])[1]")));
		unselect1.click();
		Thread.sleep(2500);
		// select particular
		WebElement select1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Shynir@gmail.com')])[1]")));
		select1.click();
		Thread.sleep(2500);
		// Selecot another one
		// select particular with search box
		WebElement select21 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-label='Search filter values'])[1]")));
		select21.sendKeys("minesh.shah");
		Thread.sleep(1000);
		select21.sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		// Clear filter
		WebElement clrfilter1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter1.click();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void Navigate_To_The_Project_Menu() throws InterruptedException {
		String projectName = "AaaaA0901";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Click on the "Projects" button
		WebElement projectsButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Projects'])[1]")));
		projectsButton.click();

		// Wait for the "Create Project" button to be clickable
		WebElement createProjectButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Create Project']")));
		createProjectButton.click();

		// Wait for the "Create Project" screen to be displayed
		WebElement createProjectScreen = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='customized-dialog-title']")));

		// Enter project name
		WebElement projectNameInput = driver.findElement(By.xpath("//input[@id='Namecreate-user']"));
		projectNameInput.sendKeys(projectName);

		// Enter project description
		WebElement projectDescriptionInput = driver.findElement(By.xpath("//input[@id='Descriptioncreate-user']"));
		projectDescriptionInput.sendKeys("AaaaA0901");

		// Select project lead
		WebElement projectLeadInput = driver.findElement(By.cssSelector(
				":nth-child(3) > .MuiAutocomplete-root > .MuiFormControl-root > .MuiInputBase-root > #undefinedcreate-user"));
		projectLeadInput.sendKeys("aarushp123098@gmail.com");
		WebElement projectLeadOption = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li[@id='undefinedcreate-user-option-0' and contains(text(), 'aarushp123098@gmail.com')]")));
		projectLeadOption.click();

		// Enter project domain
		WebElement projectDomainInput = driver.findElement(By.xpath("//*[@name='Domain'][1]"));
		projectDomainInput.sendKeys("AaaaA0901");

		// Click on the "Cancel" button
		WebElement cancel = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
		cancel.click();
		Thread.sleep(3000);
		// Pencil icon***********
		WebElement modifyUser = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@row-index='1']//button[@aria-label='Modify Project'])[1]")));
		modifyUser.click();
		Thread.sleep(3000);
		// Verify modifiyed user screen open or not
		WebElement modifyUserscreen = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Modify Project'])[1]")));
		String displayName = modifyUserscreen.getText();
		System.out.println("Screen Name: " + displayName);
		Thread.sleep(2500);
		// edit client discription
		WebElement disctext = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Descriptioncreate-user']")));
		disctext.clear();
		disctext.sendKeys("ABCDTest");
		Thread.sleep(2500);
		// edit domain
		WebElement disctext1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='undefinedcreate-user'])[2]")));
		disctext1.sendKeys("ABTest");
		Thread.sleep(2500);
		// Click on the "Cancel" button
		WebElement cancel1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
		cancel1.click();
		Thread.sleep(2500);

		// Apply filter**************************
		// Project Name name apply filter
		WebElement fullname = driver.findElement(By.xpath("(//*[contains(text(),'Project Name')])[1]"));
		Actions name = new Actions(driver);
		name.moveToElement(fullname).perform();
		Thread.sleep(2500);
		// Wait for the thumbnil icon
		driver.findElement(By.xpath("(//span[@role='presentation'])[3]")).click();
		Thread.sleep(2500);
		// Click on apply filter button
		driver.findElement(By.xpath("(//span[@aria-label='filter']//span[@role='presentation'])[1]")).click();
		Thread.sleep(2500);
		// Unselect all
		WebElement unselect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'(Select All)')])[1]")));
		unselect.click();
		Thread.sleep(2500);
		// select particular
		WebElement select = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'345-4')])[1]")));
		select.click();
		Thread.sleep(2500);
		// Selecot another one
		// select particular with search box
		WebElement select2 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-label='Search filter values'])[1]")));
		select2.sendKeys("PrpductfamilyMark");
		Thread.sleep(1000);
		select2.sendKeys(Keys.RETURN);
		Thread.sleep(2500);
		// Clear filter
		WebElement clrfilter = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter.click();
		Thread.sleep(3000);

		// Project group apply filter***********************************
		WebElement fullname1 = driver.findElement(By.xpath("(//*[contains(text(),'Project Group')])[1]"));
		Actions name1 = new Actions(driver);
		name1.moveToElement(fullname1).perform();
		Thread.sleep(2500);
		// Wait for the thumbnil icon
		driver.findElement(By.xpath(
				"//div[contains(@class,'ag-header-cell ag-header-cell-sortable columnHeader ag-focus-managed ag-header-active')]//div[contains(@role,'presentation')]//div[contains(@role,'presentation')]//span[contains(@class,'ag-header-icon ag-header-cell-menu-button')]"))
				.click();
		Thread.sleep(2500);
		// Unselect all
		WebElement unselect1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'(Select All)')])[1]")));
		unselect1.click();
		Thread.sleep(2500);
		// select particular
		WebElement select1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'ABC')])[1]")));
		select1.click();
		Thread.sleep(2500);
		// Selecot another one
		// select particular with search box
		WebElement select21 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-label='Search filter values'])[1]")));
		select21.sendKeys("Mark");
		Thread.sleep(1000);
		select21.sendKeys(Keys.RETURN);
		Thread.sleep(2500);
		// Clear filter
		WebElement clrfilter1 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter1.click();
		Thread.sleep(3000);

		// Project Lead name apply filter**************************
		WebElement fullname11 = driver.findElement(By.xpath("(//*[contains(text(),'Project Lead')])[1]"));
		Actions name11 = new Actions(driver);
		name11.moveToElement(fullname11).perform();
		Thread.sleep(2500);
		// Wait for the thumbnil icon
		driver.findElement(By.xpath(
				"//div[contains(@class,'ag-header-cell ag-header-cell-sortable columnHeader ag-focus-managed ag-header-active')]//span[contains(@class,'ag-header-icon ag-header-cell-menu-button')]//span[contains(@role,'presentation')]"))
				.click();
		Thread.sleep(2500);
		// Unselect all
		WebElement unselect11 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'(Select All)')])[1]")));
		unselect11.click();
		Thread.sleep(2500);
		// select particular
		WebElement select11 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'abhishek.mn@pivotree.com')])[1]")));
		select11.click();
		Thread.sleep(2500);
		// Selecot another one
		// select particular with search box
		WebElement select211 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-label='Search filter values'])[1]")));
		select211.sendKeys("alson.dsouza@pivotree.com");
		Thread.sleep(1000);
		select211.sendKeys(Keys.RETURN);
		Thread.sleep(2500);
		// Clear filter
		WebElement clrfilter11 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter11.click();
		Thread.sleep(3000);

		// Created ON apply filter***************************
		WebElement fullname111 = driver.findElement(By.xpath("(//*[contains(text(),'Created On')])[1]"));
		Actions name111 = new Actions(driver);
		name111.moveToElement(fullname111).perform();
		Thread.sleep(2500);
		// Wait for the thumbnil icon
		driver.findElement(By.xpath(
				"//div[contains(@class,'ag-header-cell ag-header-cell-sortable columnHeader ag-focus-managed ag-header-active')]//span[contains(@class,'ag-header-icon ag-header-cell-menu-button')]//span[contains(@role,'presentation')]"))
				.click();
		Thread.sleep(2500);
		// Unselect all
		WebElement unselect111 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'(Select All)')])[1]")));
		unselect111.click();
		Thread.sleep(2500);
		// Dropdown 2024
		WebElement select1111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@aria-label,'2024 Filter Value')]//span[contains(@class,'ag-set-filter-group-closed-icon')]//span[contains(@role,'presentation')]")));
		select1111.click();
		Thread.sleep(2500);

		// Scroll down***************
		// Find the element using the provided XPath
		WebElement element = driver.findElement(
				By.xpath("//div[@class='ag-virtual-list-viewport ag-filter-virtual-list-viewport ag-focus-managed']"));

		// Create a JavascriptExecutor instance
		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		// Scroll to the bottom of the element
		js2.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);
		Thread.sleep(1500);
		// select May
		WebElement select12 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[contains(@aria-label,'May Filter Value')]//span[contains(@class,'ag-set-filter-group-closed-icon')]//span[contains(@role,'presentation')]")));
		// Create an instance of JavascriptExecutor
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		// Execute JavaScript to scroll to the bottom of the element
		js1.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", select12);
		select12.click();
		Thread.sleep(1500);
		// scroll down ******************

		// Find the element using the provided XPath
		WebElement element1 = driver.findElement(
				By.xpath("//div[@class='ag-virtual-list-viewport ag-filter-virtual-list-viewport ag-focus-managed']"));

		// Create a JavascriptExecutor instance
		JavascriptExecutor js21 = (JavascriptExecutor) driver;

		// Scroll to the bottom of the element
		js21.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element1);
		Thread.sleep(1500);

		// select 20 date
		WebElement unselect15 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'20')])[1]")));
		unselect15.click();
		Thread.sleep(2500);

		// select particular with search box
		WebElement select2111 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//input[@aria-label='Search filter values'])[1]")));
		select2111.sendKeys("2022");
		Thread.sleep(1000);
		select2111.sendKeys(Keys.RETURN);
		Thread.sleep(2500);
		// Clear filter
		WebElement clrfilter111 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter111.click();
		Thread.sleep(3000);

		// Click on the "Home" button
		WebElement HomeButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Home'])[1]")));
		HomeButton.click();

	}

	@Test(priority = 5)
	public void Navigate_To_The_Home_Menu_Check_AssignUser_menu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Navigate to assign project and check buttons are work or not
		// Locate the parent div class that contains all the project names
		WebElement parentDiv = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(2500);
		// Find the specific project name within the parent div class
		WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
		Thread.sleep(2500);
		// Assuming the Assign User button is a sibling of the project name, you can use
		// XPath to find it
		WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(
				project.findElement(By.xpath("following::button[@aria-label='Assign Users'][1]"))));
		// Click on the Assign User button
		assignUserButton.click();
		// Wait for the Add User button to be clickable
		WebElement addUserButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add User'])[1]")));
		// Click on the Add User button
		addUserButton.click();
		// Send keys to the input field
		WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div.MuiFormControl-root.MuiFormControl-fullWidth.MuiTextField-root.css-e48aov input")));
		emailInput.sendKeys("niveditha.raguraman@pivotree.com");

		// Click on the dropdown option
		WebElement dropdownOption = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/ul/li[1]")));
		dropdownOption.click();

		// Select role
		WebElement roleInput = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='Role']")));
		roleInput.sendKeys("Analyst");

		// Choose the option from the dropdown
		WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//li[@id='undefinedcreate-user-option-1' and contains(text(), 'Analyst')]")));
		roleOption.click();

		// Click on the cancel button
		WebElement cancelButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
		cancelButton.click();

		// Close the pop-up window
		WebElement closeButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='close'])[1]")));
		closeButton.click();

	}

	@Test(priority = 6)
	public void Navigate_To_The_Home_Menu_Check_Comment_menu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// Locate the parent div class that contains all the project names
		WebElement parentDiv = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(2500);
		// Find the specific project name within the parent div class
		WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
		Thread.sleep(2500);
		// Assuming the Assign User button is a sibling of the project name, you can use
		// XPath to find it
		WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(
				project.findElement(By.xpath("following::button[@aria-label='View Comments'][1]"))));
		// Click on the Assign User button
		assignUserButton.click();
		// Click on the "Home" button
		WebElement HomeButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Home'])[1]")));
		HomeButton.click();
	}

	@Test(priority = 7)
	public void Navigate_To_The_Home_Menu_Check_History_menu() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		// Locate the parent div class that contains all the project names
		WebElement parentDiv = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(2500);
		// Find the specific project name within the parent div class
		WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
		Thread.sleep(2500);
		// Assuming the Assign User button is a sibling of the project name, you can use
		// XPath to find it
		WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(
				project.findElement(By.xpath("following::button[@aria-label='View History'][1]"))));
		// Click on the Assign User button
		assignUserButton.click();

		// Click on the History icon version
		WebElement history = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//button[@class='MuiTypography-root MuiTypography-body1 MuiLink-root MuiLink-underlineHover MuiLink-button css-928f90'][normalize-space()='6.8'])[1]")));
		history.click();
		Thread.sleep(3000);
		// back to same page****************************
		// Get the handle of the original window
		String originalWindow = driver.getWindowHandle();

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

		// Switch to the new window
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Perform actions in the new window
		// For example, you can print the title of the new window
		System.out.println("New window title: " + driver.getTitle());
		Thread.sleep(5000);
		// Close the new window
		driver.close();

		// Switch back to the original window*********************************
		driver.switchTo().window(originalWindow);
		Thread.sleep(3000);

		// Close the pop-up window
		WebElement closeButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='close'])[1]")));
		closeButton.click();
		Thread.sleep(3000);

		// Click on the "Home" button
		WebElement HomeButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Home'])[1]")));
		HomeButton.click();
		Thread.sleep(3000);
	}

	@Test(priority = 8)
	public void Open_Same_Project_Check_All_VIZ_tool_functionality() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

		// Open specific checks heder tab working working or not *****************************
		WebElement element11 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
		element11.click();
		Thread.sleep(5000);
		// iframe
		WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		driver.switchTo().frame(iframe1z1);
		Thread.sleep(2000);
		// Visible buttons checked on VIZ tool screen
		// click on the search off
		WebElement searchOnOffButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SearchOnOff']")));
		searchOnOffButton.click();
		searchOnOffButton.click(); // Double click?
		Thread.sleep(1000);
		// Click on the sort path
		WebElement alphaSortButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='alphaSort']")));
		alphaSortButton.click();
		Thread.sleep(500);
		alphaSortButton.click(); // Double click?
		Thread.sleep(1000);
		// Click on the layout
		WebElement reverseLayoutButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='reverseLayout']")));
		reverseLayoutButton.click();
		Thread.sleep(500);
		reverseLayoutButton.click(); // Double click?
		Thread.sleep(1000);
		// Click on the Auto layout
		WebElement adjustLayoutButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='adjustLayout']")));
		adjustLayoutButton.click();
		Thread.sleep(500);
		adjustLayoutButton.click(); // Double click?
		Thread.sleep(1000);
		// click on the dashboard pop up
		WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dashboard']")));
		dashboard.click();
		Thread.sleep(6000);
		// click on the tree
		WebElement dashboard1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='dashboardreset']")));
		dashboard1.click(); // Double click?
		Thread.sleep(3000);
		// Handel Alert
		System.out.println();
		Alert alert1111q = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println();
		// Get the text of the alert
		String ProjectJZONalertText11q = alert1111q.getText();
		System.out.println("Alert message: " + ProjectJZONalertText11q);
		// Accept the alert (click OK or Yes)
		alert1111q.accept();
		Thread.sleep(5000);

		//Verifyed_Hedaer_Tab_Attribute_SKU_AGGrid************************************************
		// Attribute check tab
				WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//*[contains(text(), 'Controls & Electrical Components')])[1]")));
				nodeTextElement1.click();
				Thread.sleep(2000);
				WebElement infoPopButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
				infoPopButton.click();
				Thread.sleep(2000);
				// Attribute shows
				WebElement rootnode11w = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Controls & Electrical Components')])[1]")));
				Actions actions1sw = new Actions(driver);
				actions1sw.moveToElement(rootnode11w).perform();
				Thread.sleep(2000);
				WebElement nodeTextElement16w = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
				nodeTextElement16w.click();
				Thread.sleep(2000);

				// Shema show*************************
				WebElement rootnode11 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Lights')])[1]")));
				Actions actions1s = new Actions(driver);
				actions1s.moveToElement(rootnode11).perform();
				Thread.sleep(2000);
				WebElement nodeTextElement16 = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
				nodeTextElement16.click();
				Thread.sleep(2000);

				// click on the pop button on the header and Verify SKU
				WebElement infoPopButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
				infoPopButton1.click();
				Thread.sleep(2500);
				// mouse moveover
				WebElement rootnode111 = wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Batteries')])[1]")));
				Actions actions11 = new Actions(driver);
				actions11.moveToElement(rootnode111).perform();
				Thread.sleep(2000);
				// Wait for nodeTextElement16 to be clickable and then click on it to close the
				// SKU table
				WebElement nodeTextElement = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
				nodeTextElement.click();
				Thread.sleep(2000);

				// click on the pop button on the header and Verify AG grid
				WebElement infoPopButton11 = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
				infoPopButton11.click();
				Thread.sleep(2000);
				// Wait for rootnode11 to be visible and then perform mouse hover action
				WebElement root = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Controls & Electrical Components')])[1]")));
				Actions actions12 = new Actions(driver);
				actions12.moveToElement(root).perform();
				Thread.sleep(2000);
				// Wait for nodeTextElement16 to be clickable and then click on it to close the
				// SKU table
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement nodeTextElement19 = wait
						.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='close']")));
				nodeTextElement19.click();
				Thread.sleep(2000);
				//Verify_Open_Old_Created_Project_and_Add_JSON_File_and_AssignNode1************************************	
				
				Thread.sleep(2500);
				// Locate the iframe using CSS selector
				WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				driver.switchTo().frame(iframe);
				Thread.sleep(2000);
				//click on the pop-up 
				WebElement infoPopButtonw = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
				infoPopButtonw.click();
				Thread.sleep(2000);
				WebElement infoPopButtonw1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
				infoPopButtonw1.click();
				Thread.sleep(2000);
				
				// Load the project
				// verified current version
				WebElement element1q = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
				String actualqTextt = element1q.getText();
				System.out.println(actualqTextt);
				Thread.sleep(2000);
				// load json file
				WebElement iframeqq = driver.findElement(By.xpath("//*[@id='jsonfile']"));
				iframeqq.sendKeys("C:\\Users\\Abhijit.Jadhav\\eclipse-workspace1\\CTT_12_6_24\\VSGDoverProduct.jzon");
				Thread.sleep(3000);
				
				// withou saving node assigned
				WebElement nodeTextElement11 = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
				nodeTextElement11.click();
				Thread.sleep(2000);
				WebElement rootnode1 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Motors')])[1]")));
				Actions actionsz1 = new Actions(driver);
				actionsz1.contextClick(rootnode1).perform();
				Thread.sleep(2000);
				WebElement assignNode = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")));
				assignNode.click();
				Thread.sleep(3000);
				WebElement okclick = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				okclick.click();
				Thread.sleep(3000);
				// Save the Job
				WebElement rootnode = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'VSGDoverProduct')])[1]")));
				Actions actionsz = new Actions(driver);
				actionsz.contextClick(rootnode).perform();
				Thread.sleep(2000);
				WebElement saveJob = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Save JZON')]")));
				saveJob.click();
				Thread.sleep(3000);
				WebElement savejzon = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				savejzon.click();
				Thread.sleep(3000);
				// Current version
				WebElement element1 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
				String actualTextt = element1.getText();
				System.out.println(actualTextt);
				Thread.sleep(2000);
				// Wait for the root node to be clickable
				WebElement rootnodes = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Motors')])[1]")));
				// Perform the context click action
				Actions actionsg = new Actions(driver);
				actionsg.contextClick(rootnodes).perform();
				Thread.sleep(2000);
				// Assign node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
				Thread.sleep(2000);
				// Wait for the assign node to analyst window to open
				WebElement assignNodeTitle = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='assignNodeTitle']")));
				String text = assignNodeTitle.getText();
				System.out.println(text);
				Thread.sleep(2000);
				// Click on the drop-down
				WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nodeToAnalyst']")));
				dropDown.click();
				Thread.sleep(2000);
				// Select an option from the drop-down
				WebElement option = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nodeToAnalyst']/option[2]")));
				option.click();
				Thread.sleep(2000);
				// Click on the assigned node button
				WebElement assignButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirmAssignNode']")));
				assignButton.click();
				Thread.sleep(2000);
				// Wait for the alert to be present
				Thread.sleep(3000);
				// Handle the alert
				WebElement assign = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				assign.click();
				Thread.sleep(2000);

				// AFter assign node check color node change or not
				WebElement rootnode111q = driver.findElement(By.xpath("(//*[contains(text(),'Motors')])[1]"));
				String color = rootnode111q.getCssValue("color");
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
				Thread.sleep(3000);
			
//		Verify_the_node_status	*****************************************	
				// verified current version
				WebElement element1q1 = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
				String actualqTextt1 = element1q1.getText();
				System.out.println(actualqTextt1);
				Thread.sleep(2000);
				// node assigned
				WebElement nodeTextElement111 = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
				nodeTextElement111.click();
				Thread.sleep(2000);
				// node assigned
				WebElement nodeTextElement111w = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
				nodeTextElement111w.click();
				Thread.sleep(2000);
				// Wait for the root node to be clickable
				WebElement rootnodes1 = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Motors')])[2]")));
				// Perform the context click action
				Actions actionsg1 = new Actions(driver);
				actionsg1.contextClick(rootnodes1).perform();
				Thread.sleep(2000);

				// Assign node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();

				Thread.sleep(3000);
				WebElement okclick1 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				okclick1.click();

				Thread.sleep(3000);

				// Verify the node is completed then assigned***************
				WebElement rootnodes11 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]")));
				// Perform the context click action
				Actions actionsg11 = new Actions(driver);
				actionsg11.contextClick(rootnodes11).perform();
				Thread.sleep(2000);

				// Assign node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
				Thread.sleep(3000);
				WebElement okclick11 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				okclick11.click();

				Thread.sleep(3000);

				// Verify the node is reintegrtaed then again reintegrted then
				// assigned************
				WebElement rootnodes111 = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Batteries')])[1]")));
				// Perform the context click action
				Actions actionsg111 = new Actions(driver);
				actionsg111.contextClick(rootnodes111).perform();
				Thread.sleep(2000);

				// reintegrted node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Reintegrate Node')]")).click();
				Thread.sleep(3000);
				WebElement okclick2 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				okclick2.click();
				Thread.sleep(2000);

				
				// shfit the node from up & left side*********
				WebElement nodeText1a = driver.findElement(By.xpath("(//*[contains(text(), 'VSGDoverProduct')])[1]"));
				Thread.sleep(1000);
				WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
				Actions actions = new Actions(driver);
				actions.moveToElement(nodeText1a, 52, 107).clickAndHold().perform();
				Thread.sleep(1000);
				actions.dragAndDropBy(nodeText1a, -350, 0).perform();
				Thread.sleep(1000);
				Thread.sleep(4000);

				// Wait until the 'Motors' element is visible
				WebElement node1 = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Batteries')])[1]")));

				// Create an Actions instance
				Actions actions1 = new Actions(driver);

				// Perform the mouse-over action on the 'Motors' element
				actions1.moveToElement(node1).perform();

				// Wait for a few seconds to observe the hover action (not recommended for real
				// test cases)
				Thread.sleep(3000);	
//Search taxnomy functionality************************************************
				Thread.sleep(2000);
				WebElement nodeTextElementagq = driver.findElement(By.xpath("//*[@id=\"menucontainer\"]/div[1]"));
				Actions actions1gd = new Actions(driver);
				actions1gd.doubleClick(nodeTextElementagq).perform();
				Thread.sleep(2000);

				// Click on the rightClick
				WebElement nodeTextElementag1 = driver.findElement(By.xpath("//*[contains(text(), 'Welding Equipment')]"));
				Actions actions1g1 = new Actions(driver);
				actions1g1.contextClick(nodeTextElementag1).perform();
				Thread.sleep(2000);
				// click on child name
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Search Taxonomy in Database')]")).click();
				Thread.sleep(2000);
				// delet&rollup
				driver.findElement(By.xpath("//*[@id=\"menucontainer\"]/div[1]")).click();
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(-200, 0)");
				Thread.sleep(2000);
				WebElement nodeTextElementag1p = driver
						.findElement(By.xpath("//*[contains(text(), 'Results from Natalie Database')]"));
				Actions actions1g1p = new Actions(driver);
				actions1g1p.contextClick(nodeTextElementag1p).perform();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete & roll-up')]")).click();
				Thread.sleep(2000);				
				// Switch back to the default content (main page)
				driver.switchTo().defaultContent();
				// Click on home page
				WebElement homeButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
				homeButton.click();
				Thread.sleep(2000);
				
				
	}

	@Test(priority = 9)
	public void Verify_the_node_status() throws InterruptedException {
		Thread.sleep(2500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		// Verify the node status*****************************************
		WebElement parentDiv11w11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(1000);
		// Find the specific project name within the parent div class
		WebElement project11e = wait.until(ExpectedConditions.visibilityOf(
				parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));
		Thread.sleep(1000);
		// Click on the drop down
		WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e
				.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
		assignUserButton11e.click();
		Thread.sleep(2000);
		// node staus as completd or not
		// Find the "Completed" element near the electrical node using a relative XPath
		WebElement completedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[3]//following::p[1]")));
		Thread.sleep(2000);
		// Get the text of the "Completed" element
		String text11 = completedElement.getText();
		System.out.println("\n" + text11);
		Thread.sleep(2000);

		// Find the "Reintegrtaed"
		WebElement completedElement1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Batteries')])[3]//following::p[1]")));
		Thread.sleep(2000);
		// Get the text of the "Completed" element
		String text111 = completedElement1.getText();
		System.out.println("\n" + text111);
		Thread.sleep(2000);
		// Find the "Assigned" element
		WebElement completedElement11 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Motors')])[3]//following::p[1]")));
		Thread.sleep(2000);
		// Get the text of the "Completed" element
		String text1111 = completedElement11.getText();
		System.out.println("\n" + text1111);
		Thread.sleep(4000);
		// XPath to find it Verify chart bar ********************************************
		WebElement parentDiv = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(1000);
		// Find the specific project name within the parent div class
		WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
		Thread.sleep(1500);
		WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(project.findElement(By.xpath(
			"(//*[name()='rect'][@class='MuiBarElement-root MuiBarElement-series-assigned css-ctme2z'])[3]"))));
				// Click on the Assign User button
				Actions actionsg = new Actions(driver);
				actionsg.moveToElement(assignUserButton).perform();
				Thread.sleep(3000);
				// acess all data and print
				// Find the chart tooltip table element
				WebElement chartTooltipTable = driver
						.findElement(By.xpath("(//table[@class='MuiChartsTooltip-table css-rbnde3'])[1]"));

				// Get all rows in the table
				List<WebElement> rows = chartTooltipTable.findElements(By.tagName("tr"));

				// Iterate through each row and print the text of each cell
				for (WebElement row : rows) {
					// Get all cells in the row
					List<WebElement> cells = row.findElements(By.tagName("td"));

					// Iterate through each cell and print its text
					for (WebElement cell : cells) {
						System.out.print(cell.getText() + "\t");
					}
					System.out.println(); // Print a new line after each row
				}
				Thread.sleep(1000);
		
	}



	@Test(priority =10)
	public void open_Assigne_node_to_verify_Pichart_Functionality() throws InterruptedException {
		// refreshing the page
		Thread.sleep(1500);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		
		WebElement parentDiv11w11 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));

		// Find the specific project name within the parent div class
		WebElement project11e = wait.until(ExpectedConditions.visibilityOf(
				parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));
		Thread.sleep(2500);
//		// Click on the drop down
//		WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e
//				.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
//		assignUserButton11e.click();
//		Thread.sleep(1500);
		
		// Find the specific node (e.g., "Diagnostics & Calibration Systems") within the
		// dropdown
		List<WebElement> nodes = driver
				.findElements(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])"));
		Thread.sleep(1500);
		for (WebElement node : nodes) {
			// Check if the node text matches the desired node name
			if (node.getText().equalsIgnoreCase("Diagnostics & Calibration Systems")) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", node);
		        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", node);
				// Click on the node
//				node.click();
				break; // Exit the loop after clicking on the node
				}
			
			}

				Thread.sleep(2500);
	}

	@Test(priority =11)
	public void Validate_The_Pie_chart_Visbile_Or_Not() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
		Thread.sleep(1000);
		driver.switchTo().frame(iframe);
		Thread.sleep(1000);
		// Node shfit lright to left and up side
				WebElement nodeText1a = driver
						.findElement(By.xpath("(//*[contains(text(), 'Diagnostics & Calibration Systems')])[1]"));
				Thread.sleep(2000);
				Actions actions = new Actions(driver);
				actions.moveToElement(nodeText1a, 80, 150).clickAndHold().perform();
				Thread.sleep(1000);
				actions.dragAndDropBy(nodeText1a, -200, 0).perform();
				Thread.sleep(4000);
		// Mouse over to the swtich node node
		WebElement Node = driver
				.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
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
		// Calibration System Accessories
		WebElement SwitchNode1 = driver
				.findElement(By.xpath("(//*[contains(text(),'Calibration System Accessories')])[1]"));
		Actions actionsA1 = new Actions(driver);
		actionsA1.moveToElement(SwitchNode1).perform();
		Thread.sleep(2500);
		WebElement elementA1 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQ1 = elementA1.getText();
		System.out.println(textQ1);
		Thread.sleep(2000);
		// Calibration System Parts
		WebElement SwitchNode11 = driver.findElement(By.xpath("(//*[contains(text(),'Calibration System Parts')])[1]"));
		Actions actionsA11 = new Actions(driver);
		actionsA11.moveToElement(SwitchNode11).perform();
		Thread.sleep(2500);
		WebElement elementA2 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQ2 = elementA2.getText();
		System.out.println(textQ2);
		Thread.sleep(2000);
		// Computerized Measuring
		WebElement Switc = driver.findElement(By.xpath("(//*[contains(text(),'Computerized Measuring')])[1]"));
		Actions actionsg = new Actions(driver);
		actionsg.moveToElement(Switc).perform();
		Thread.sleep(2500);
		WebElement elementAg = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQg = elementAg.getText();
		System.out.println(textQg);
		Thread.sleep(3000);

	}

	@Test(priority =12)
	public void Remove_the_Node_and_Chek_Datafill_Percentage() throws InterruptedException, AWTException {
		// Click on the Pivotree Logo
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		WebElement nodeTextElementagq = driver.findElement(By.xpath("//*[@id='menucontainer']/div[1]"));
		nodeTextElementagq.click();
		Thread.sleep(3000);
		//Right click on the root node 
				WebElement nodeTextElementag1 = driver
						.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
				Actions actions1g1 = new Actions(driver);
				actions1g1.contextClick(nodeTextElementag1).perform();
				Thread.sleep(2000);
		//Click on the Fix Localities...
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Fix Localities...')]")).click();
				Thread.sleep(2000);
		// 1.Right Click delete node Measuring System.
		WebElement nodeTextElementag11 = driver
				.findElement(By.xpath("//*[contains(text(), 'Measuring System Software & Upgrades')]"));
		Actions actions1g11 = new Actions(driver);
		actions1g11.contextClick(nodeTextElementag11).perform();
		Thread.sleep(2000);
		// click on child name
		WebElement nodeText = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
		Actions actions1gg = new Actions(driver);
		actions1gg.moveToElement(nodeText).perform();
		Thread.sleep(2000);
		// Delete and Delet sku from the root node
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete and delete SKUs')]")).click();
		Thread.sleep(1000);
		//delet confirm
		WebElement okclick1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
		okclick1.click();
		Thread.sleep(1500);
		// Wait for the menu to appear, adjust time as needed

		// 2.Right Click delete node Calibration System Parts.
		WebElement node = driver.findElement(By.xpath("//*[contains(text(), 'Calibration System Parts')]"));
		Actions actionss = new Actions(driver);
		actionss.contextClick(node).perform();
		Thread.sleep(2000);
		// click on child name
		WebElement nodesText = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(nodesText).perform();
		Thread.sleep(2000);
		// Delete and Delet sku from the root node
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete and delete SKUs')]")).click();
		Thread.sleep(1000);
		//delet confirm
		WebElement okclick2 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				okclick2.click();
				Thread.sleep(1500);
		// 3.Right Click delete node Computerized Measuring
		WebElement nodew = driver.findElement(By.xpath("//*[contains(text(), 'Computerized Measuring')]"));
		Actions actionsw = new Actions(driver);
		actionsw.contextClick(nodew).perform();
		Thread.sleep(1000);
		// click on child name
		WebElement nodesTextw = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
		Actions actions1sw = new Actions(driver);
		actions1sw.moveToElement(nodesTextw).perform();
		Thread.sleep(1000);
		// Delete and Delet sku from the root node
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete and delete SKUs')]")).click();
		Thread.sleep(1000);
		//delet confirm
		WebElement okclick3 = wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
				okclick3.click();
				Thread.sleep(1500);
		// Mouse over to Diagnostics & Calibration Systems the node node
		WebElement Node = driver
				.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
		Actions actionsAQ = new Actions(driver);
		actionsAQ.moveToElement(Node).perform();
		Thread.sleep(2500);
		// Printed tool tip data
		WebElement elementA = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
		String textQ = elementA.getText();
		System.out.println(textQ);
		Thread.sleep(2000);
		// Where the SKU data present there not allod load jzon file
		// Right Click on Diagnostics & Calibration Systems
		WebElement nodew11 = driver.findElement(By.xpath("//*[contains(text(), 'Calibration System Accessories')]"));
		Actions actionsw1 = new Actions(driver);
		actionsw1.contextClick(nodew11).perform();
		Thread.sleep(1500);
		// click on child name
		WebElement noTex1 = driver.findElement(By.xpath("//ul/li[contains(text(), 'Add / Create')]"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(noTex1).perform();
		Thread.sleep(2000);

		// Upload file
		Thread.sleep(3000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement fileInput = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Create JSON from SKU Data...')]")));
		// Click on the file input element to trigger the file upload dialog
		fileInput.click();
		// Brief delay to allow the file upload dialog to appear
		Thread.sleep(3000);
		WebElement okclick4 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
		okclick4.click();
		Thread.sleep(2500);
		//double click same node *************
		WebElement node12 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[contains(text(), 'Diagnostics & Calibration Systems')]")));
		node12.click();
		Thread.sleep(1500);
		//double click same node ************
		WebElement node121 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[contains(text(), 'Diagnostics & Calibration Systems')]")));
		node121.click();
		Thread.sleep(2500);
		// clik add child node
		WebElement nodew1 = driver.findElement(By.xpath("//*[contains(text(), 'Diagnostics & Calibration Systems')]"));
		Actions actionsw11 = new Actions(driver);
		actionsw11.contextClick(nodew1).perform();
		Thread.sleep(1500);
		// click on child name
		WebElement noTex = driver.findElement(By.xpath("//ul/li[contains(text(), 'Add / Create')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(noTex).perform();
		Thread.sleep(2000);
		//
		Thread.sleep(3000);
		WebElement addchild = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Add child node...')]")));
		addchild.click();
		//// Wait for the "CreateNodeName" field to be visible and then send keys
		WebElement createNodeNameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CreateNodeName']")));
		createNodeNameField.sendKeys("DemoTest");
		Thread.sleep(2000);
		// Wait for the "Create" button to be clickable and then click on it
		WebElement createButton = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CreateNodeForm']/div[2]/div[2]/a[2]")));
		createButton.click();
		Thread.sleep(3000);
		

		// Right Click on Diagnostics & Calibration Systems
		WebElement nodew11q = driver.findElement(By.xpath("//*[contains(text(), 'DemoTest')]"));
		Actions actionsw1qq = new Actions(driver);
		actionsw1qq.contextClick(nodew11q).perform();
		Thread.sleep(1500);
		// click on child name
		WebElement noTexq1 = driver.findElement(By.xpath("//ul/li[contains(text(), 'Add / Create')]"));
		Actions actionsq1 = new Actions(driver);
		actionsq1.moveToElement(noTexq1).perform();
		Thread.sleep(2000);

		// Upload file
		Thread.sleep(3000);
		WebElement fileInput1 = wait1.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Create JSON from SKU Data...')]")));
		// Click on the file input element to trigger the file upload dialog
		fileInput1.click();
		// Brief delay to allow the file upload dialog to appear
		Thread.sleep(2000);
		// Get the file path
		String filePath = "C:\\Users\\Abhijit.Jadhav\\eclipse-workspace1\\CTT_12_6_24\\File1.txt";
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
		System.out.println("Filelloaded");
		Thread.sleep(500);
		// Get the text of the alert
		Thread.sleep(1500);
		WebElement okclick2a = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
		okclick2a.click();
		Thread.sleep(1500);

		// Mouse over to Burner the node node
		System.out.println("Burners Data fill% ");
		Thread.sleep(2000);
		WebElement Node1 = driver.findElement(By.xpath("(//*[contains(text(),'Burners')])[1]"));
		Actions actionsAQ1 = new Actions(driver);
		actionsAQ1.moveToElement(Node1).perform();
		Thread.sleep(2500);
		// Printed tool tip data
//		WebElement elementA1 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
//		String textQ1 = elementA1.getText();
//		System.out.println(textQ1);
//		Thread.sleep(2000);
		// Mouse over to Diagnostics & Calibration Systems the node node
		System.out.println("Calibration System Accessories Data fill% ");
		WebElement Node11 = driver.findElement(By.xpath("(//*[contains(text(),'Calibration System Accessories')])[1]"));
		Actions actionsAQ11 = new Actions(driver);
		actionsAQ11.moveToElement(Node11).perform();
		Thread.sleep(2500);
//		// Printed tool tip data
//		WebElement elementA12 = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
//		String textQ12 = elementA12.getText();
//		System.out.println(textQ12);
//		Thread.sleep(2000);

		// Mouse over to Diagnostics & Calibration Systems the node node
		System.out.println("Diagnostics & Calibration Systems Data fill% ");
		WebElement Node1c = driver
				.findElement(By.xpath("(//*[contains(text(),'Diagnostics & Calibration Systems')])[1]"));
		Actions actionsAQ1c = new Actions(driver);
		actionsAQ1c.moveToElement(Node1c).perform();
		Thread.sleep(2500);
		// Printed tool tip data
//		WebElement elementA1c = driver.findElement(By.xpath("(//*[@id='barchart'])[1]"));
//		String textQ1c = elementA1c.getText();
//		System.out.println(textQ1c);
//		Thread.sleep(2000);
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
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



//*****Ruf Work*/
//try {
//// Find all nodes with the specified text
//List<WebElement> nodes = driver.findElements(By.xpath("//*[contains(text(),'Diagnostics & Calibration Systems')]"));
//
//Thread.sleep(1500); // Better to use explicit waits
//
//for (WebElement node : nodes) {
//    // Check if the node text matches the desired node name
//    if (node.getText().equalsIgnoreCase("Diagnostics & Calibration Systems")) {
//        // Scroll to the node and click it using JavaScriptExecutor
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", node);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", node);
//        break; // Exit the loop after clicking on the node
//    }
//}
//} catch (org.openqa.selenium.StaleElementReferenceException e) {
//System.out.println("StaleElementException occurred. Refreshing the page.");
//driver.navigate().refresh();
//
//// Optionally, you can retry the action after refreshing the page
//try {
//    List<WebElement> nodes = driver.findElements(By.xpath("//*[contains(text(),'Diagnostics & Calibration Systems')]"));
//    
//    Thread.sleep(1500); // Better to use explicit waits
//    
//    for (WebElement node : nodes) {
//        // Check if the node text matches the desired node name
//        if (node.getText().equalsIgnoreCase("Diagnostics & Calibration Systems")) {
//            // Scroll to the node and click it using JavaScriptExecutor
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", node);
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", node);
//            break; // Exit the loop after clicking on the node
//        }
//    }
//} catch (org.openqa.selenium.StaleElementReferenceException ex) {
//    System.out.println("StaleElementException occurred again.");
//    // Handle the exception or retry again if necessary
//}
//}

