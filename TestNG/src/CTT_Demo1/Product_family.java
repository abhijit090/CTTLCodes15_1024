package CTT_Demo1;

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

public class Product_family {

	private static final String ElementName = null;
	private static String iframe;
	public static String screenShotSubFoderName;
	public static WebDriver driver;
	WebDriverWait wait;
	private By with;
	private WebElement descriptionField;
	static WebDriver browser;

	@BeforeSuite

	public void applaunch() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login");
		Thread.sleep(2000);
		//Mark  Test  

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
	public void Open_Specific_Project_and_set_the_fix_Localities_And_Create_Families() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
		// Locate the parent div class that contains all the project names
		WebElement parentDiv11t = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
		Thread.sleep(1000);

		// Open specific
		WebElement testAb = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Productfamily')])[1]")));
		testAb.click();
		Thread.sleep(8000);
		// Inside Iframe
		WebElement iframe1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@id='iframeD3'])[1]")));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(5000);
		//Click on the parent node 
		WebElement nodeTextElement1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Bed Canopies')]")));
		nodeTextElement1.click();
		Thread.sleep(4000);
		// Click on the Pivotree Logo
		WebElement nodeTextElementagq = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menucontainer']/div[1]")));
		nodeTextElementagq.click();
		Thread.sleep(2000);
		// Right click on the root node
		WebElement nodeTextElementag1 = driver
				.findElement(By.xpath("(//*[contains(text(),'Bedding, Pillows and Blankets 2024530 155805 2024610 180908')])[1]"));
		Actions actions1g1 = new Actions(driver);
		actions1g1.contextClick(nodeTextElementag1).perform();
		Thread.sleep(2000);
		// Click on the Fix Localities...
		WebElement nodeTextElement= wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li[contains(text(), 'Fix Localities...')]")));
		nodeTextElement.click();
		Thread.sleep(2000);
//		//Click on the parent node 
//		WebElement nodeTextElement1 = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
//		nodeTextElement1.click();
//		Thread.sleep(2000);
		//shfit the node from up & left side
//		WebElement nodeText1a = driver.findElement(By.xpath("(//*[contains(text(), 'Bedding, Pillows and Blankets 2024530 155805 2024610 180908')])[1]"));
//		Thread.sleep(1000);
//		WebElement nodeText2 = driver.findElement(By.xpath("//*[@class='project-version']"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(nodeText1a, 20, 60).clickAndHold().perform();
//		Thread.sleep(1000);
//		actions.dragAndDropBy(nodeText1a, -350, 0).perform();
//		Thread.sleep(1000);
//		Thread.sleep(4000);
		//right click on the Bed Canopies
		//Click on the parent node 
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(), 'Bed Canopies')]")));
		nodeTextElement11.click();
		Thread.sleep(4000);
		
		// Right click on the root node
		WebElement badcan = driver.findElement(
				By.xpath("(//*[contains(text(),'Bed Canopies')])[1]"));
		Actions actions1 = new Actions(driver);
		actions1.contextClick(badcan).perform();
		Thread.sleep(2000);
		//Slect the the product families
		// click on child name
		WebElement nodeText = driver.findElement(By.xpath("//ul/li[contains(text(), 'Add / Create')]"));
		Actions actions1gg = new Actions(driver);
		actions1gg.moveToElement(nodeText).perform();
		Thread.sleep(2000);
		// Delete and Delet sku from the root node
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Create Families...')]")).click();
		Thread.sleep(1000);
		//Verify the Product family window open or not
		WebElement family_window = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='modalTitle' and contains(text(), 'Create Families')][1]")));
		String afamilywinname = family_window.getText();
		System.out.println("\n Create Families Window open Name:" + afamilywinname);
		Thread.sleep(2000);
		//Click on the dropdown and select the Parent SKU option from the dropdown
		WebElement selectdropdown = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='familyattributeselect'])[1]")));
		selectdropdown.click();
		Thread.sleep(3000);
		//Select the option
		WebElement selectdropdown2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@value='Parent SKU' and contains(text(), 'Parent SKU')])[1]")));
		selectdropdown2.click();
		Thread.sleep(3000);
		//click on the create families
		WebElement createfamiles = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='button success' and contains(text(), 'Create Families')])[1]")));
		createfamiles.click();
		Thread.sleep(3000);
		//Print the data 
		WebElement dataprint = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='swal2-popup swal2-modal swal2-icon-info swal2-show'])[1]")));
		String adataprint = dataprint.getText();
		System.out.println("\n" + adataprint);
		Thread.sleep(1500);
		// delet confirm
		WebElement okclick1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
		okclick1.click();
		Thread.sleep(1500);

	}

	@Test(priority = 4)
	public void Open_AGGrid_Screen_and_GroupBy_FamilyId() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
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
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), 'Bed Canopies')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Clcik on the coloumn selction 
		WebElement columnclick = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Columns'])[1]")));
		columnclick.click();
		Thread.sleep(1500);
		//search faimly name 
		WebElement searchdata = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div//input[@class='ag-input-field-input ag-text-field-input'])[2]")));
		searchdata.sendKeys("Family ID");
		Thread.sleep(1500);
		//Drag nd drop
//		# Locate the first element (the draggable element)
		WebElement columnclick1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ag-icon ag-icon-grip ag-drag-handle ag-column-select-column-drag-handle'])[1]")));

//		# Locate the second element (the drop target)
		WebElement columnclick11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ag-column-drop-empty-message ag-column-drop-vertical-empty-message'][normalize-space()='Drag here to set row groups'])[1]")));

//		# Perform the drag-and-drop action
		Actions actions1s1 = new Actions(driver);
		actions1s1.dragAndDrop(columnclick1, columnclick11).perform();
		Thread.sleep(1500);
		
		//click on the column table
		WebElement columnclick111 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Columns'])[1]")));
		columnclick111.click();
		Thread.sleep(1500);

	}
	
	@Test(priority = 4)
	public void Open_any_family_ID() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Thread.sleep(2000);
		//Click on the drop down*************************
		WebElement dropdown = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(), '200087')])/preceding-sibling::span[2]/span")));
		dropdown.click();
		Thread.sleep(1500);
		
		// Wait for the element to be clickable
        WebElement editdata = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ag-row-odd ag-row-no-focus ag-row ag-row-level-1 ag-row-position-absolute ag-row-not-inline-editing'][1]/div[3]")));

        // Double-click the element to enable editing
        Actions actions = new Actions(driver);
        actions.doubleClick(editdata).perform();

        // Optional: wait for the edit mode to activate
        Thread.sleep(1500);

        // Send keys to the element
        try {
            editdata.sendKeys(" Test ");
        } catch (Exception e) {
            // Re-identify the element and send keys again
            editdata = driver.findElement(By.xpath("//div[@class='ag-row-odd ag-row-no-focus ag-row ag-row-level-1 ag-row-position-absolute ag-row-not-inline-editing'][1]/div[3]"));
            editdata.sendKeys(" Test ");
            Thread.sleep(1500);
        }
		//click on the Yes
		WebElement clickyes = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(), 'Yes')])[1]")));
		clickyes.click();
		Thread.sleep(1500);
		
		//Open same ***************************************
		//Click on the drop down
		WebElement dropdown1 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//*[contains(text(), '200087')])/preceding-sibling::span[2]/span")));
		dropdown1.click();
		Thread.sleep(1500);
//		// Wait for the element to be clickable
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@col-id='Parent_SKU' and contains(text(), '200087')])[1]")));
//
//        // Double-click the element to enable editing
//        Actions actions1 = new Actions(driver);
//        actions1.doubleClick(element).perform();
//
//        // Optional: wait for the edit mode to activate
//        Thread.sleep(1500);
//
//        // Send keys to the element (if required)
//        try {
//            element.sendKeys(" 200087 ");
//           
//        } catch (Exception e) {
//            System.out.println("Initial sendKeys failed. Re-identifying the element...");
//            // Re-identify the element and send keys again
//            element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@col-id='Parent_SKU' and contains(text(), '200087')])[1]")));
//            element.sendKeys(" 200087 ");
//            Thread.sleep(1500);
//        }
//      //click on the Yes
//		WebElement clickyes1 = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(), 'Yes')])[1]")));
//		clickyes1.click();
//		Thread.sleep(1500);
		
		// Click on the Save button
		WebElement saveButton = driver.findElement(By.xpath("(//*[name()='svg'][@aria-label='Save'])[1]"));
		saveButton.click();
		Thread.sleep(2000);
		// Wait for the success message to appear
		WebElement successMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'SKU')][1]")));
		String text = successMessage.getText();
		System.out.println("\n" + text);
		Thread.sleep(1500);
		//open ag grid agian*************************************
		// Inside Iframe
		WebElement iframe1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@id='iframeD3'])[1]")));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(1500);
		//  Mouse over bad
		WebElement rootnode112 = driver.findElement(By.xpath("(//*[contains(text(), 'Bed Canopies')])[1]"));
		rootnode112.click();
		Thread.sleep(1500);
		
		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(), 'Bed Canopies')])[1]"));
		Actions actions1s = new Actions(driver);
		actions1s.moveToElement(rootnode11).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		//mouse over Item Id
		WebElement item = driver.findElement(By.xpath("(//span[contains(text(), 'Item ID')])[1]"));
		Actions actions1 = new Actions(driver);
		actions1.moveToElement(item).perform();
		Thread.sleep(2000);
		//click itemid
		WebElement itemid = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='ag-header-cell ag-header-cell-sortable custom-header-class ag-focus-managed ag-header-active']//span[@class='ag-header-icon ag-header-cell-menu-button']//span[@role='presentation']")));
		itemid.click();
		Thread.sleep(1500);
		//click on the filter 
		WebElement filter = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@aria-label='filter']//span[@role='presentation']")));
		filter.click();
		Thread.sleep(1500);
		//unselect all
		WebElement unselect = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(), '(Select All)')])[1]")));
		unselect.click();
		Thread.sleep(1500);
		//search and hit enter button
		WebElement select = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[5]")));
		select.sendKeys("997605" + Keys.RETURN);
		Thread.sleep(1500);
		//removed filter
		WebElement clrfilter = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//input[@class='ag-input-field-input ag-text-field-input'])[5]")));
		clrfilter.click();		
		Thread.sleep(1500);
		//clear filter
		WebElement clrfilter1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Clear Filters'])[1]")));
		clrfilter1.click();		
		Thread.sleep(1500);
		// Click on the save button
		driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
		Thread.sleep(2000);
		// verify text
		WebElement successMessage111 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
		String text111 = successMessage111.getText();
		System.out.println(text111);
		Thread.sleep(2000);
		
	}
		
		@Test(priority = 5)
		public void Remove_the_created_families() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		//removed family******************************************
		//Ag grid of 
		// Inside Iframe
		WebElement iframe1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//iframe[@id='iframeD3'])[1]")));
		// Switch to the iframe
		driver.switchTo().frame(iframe1);
		Thread.sleep(1500);
		// click on the pop button on the header and Verify SKU
		WebElement infoPopButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='infoPop'])")));
		infoPopButton1.click();
		Thread.sleep(1500);
		
		WebElement infoPopButton11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
		infoPopButton11.click();
		Thread.sleep(1500);
		
		// Click on the parent node
		WebElement nodeTextElement11 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(), 'Bed Canopies')])[1]")));
		nodeTextElement11.click();
		Thread.sleep(4000);

		// Right click on the root node
		WebElement badcan = driver.findElement(By.xpath("(//*[contains(text(),'Bed Canopies')])[1]"));
		Actions actions11 = new Actions(driver);
		actions11.contextClick(badcan).perform();
		Thread.sleep(2000);
		// Slect the the product families
		// click on child name
		WebElement nodeText = driver.findElement(By.xpath("//ul/li[contains(text(), 'Delete')]"));
		Actions actions1gg = new Actions(driver);
		actions1gg.moveToElement(nodeText).perform();
		Thread.sleep(2000);
		// Delete and Delet sku from the root node
		driver.findElement(By.xpath("//ul/li[contains(text(), 'Remove Families...')]")).click();
		Thread.sleep(1000);
		// clicK on ok button
		
		//Print the data 
		WebElement dataprint = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='swal2-popup swal2-modal swal2-icon-info swal2-show'])[1]")));
		String adataprint = dataprint.getText();
		System.out.println(adataprint);
		Thread.sleep(1500);
		// delet confirm
		WebElement okclick1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'OK')])[1]")));
		okclick1.click();
		Thread.sleep(1500);
		
	//open again AG grid *******************************************
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
		WebElement rootnode111 = driver.findElement(By.xpath("(//*[contains(text(), 'Bed Canopies')])[1]"));
		Actions actions1s1 = new Actions(driver);
		actions1s1.moveToElement(rootnode111).perform();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		//Clcik on the coloumn selction 
		WebElement columnclick = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Columns'])[1]")));
		columnclick.click();
		Thread.sleep(1500);
		//search faimly name 
		WebElement searchdata = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div//input[@class='ag-input-field-input ag-text-field-input'])[2]")));
		searchdata.sendKeys("Family ID");
		Thread.sleep(1500);
		System.out.println(" \n Families Id not avilabel \n" );
		System.out.println();
		//close ag grid 
		// Click on the save button
		driver.findElement(By.xpath("(//*[@aria-label='Save'])[1]")).click();
		Thread.sleep(2000);
		// verify text
		WebElement successMessage111 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'SKU modified successfully')])[1]")));
		String text111 = successMessage111.getText();
		System.out.println(text111);
		Thread.sleep(3000);
		//Click home
		// Switch back to the default content (main page)
		driver.switchTo().defaultContent();
		// Click on home page
		WebElement homeButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Home'][1]")));
		homeButton.click();
		Thread.sleep(2000);
		
		
		}
	
	
	@AfterSuite
	public void closeBrowser() {
		// Close the WebDriver instance
		driver.quit();
	}
}




 
