package CTTAutoDemo;


	import java.time.Duration;
	import java.util.List;
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


	public class devsmoke {
		private static String iframe;
		public static String screenShotSubFoderName;
		public static WebDriver driver;
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
	        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
	        passwordField.sendKeys("OLOtx095");

	        // Find and click the login button
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
	        loginButton.click();

	    }
		@Test(priority = 2)
		public void Verify_Login_Person_Name() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
			String displayName = element.getText();
			System.out.println("Login Person Name: " + displayName);	
		}
		@Test(priority = 3)
		public void Navigate_To_The_User_Menu() throws InterruptedException {
			String userName = "NewProjectTset";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
			// Click on the user tab
			WebElement userTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Users'])[1]")));
			userTab.click();
			 // Click on the "Create User" button
	        WebElement createUserButton = driver.findElement(By.xpath("(//button[normalize-space()='Create User'])[1]"));
	        createUserButton.click();

	        // Wait until the "Create User" window is displayed
	        WebElement createUserWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2[normalize-space()='Create User'])[1]")));

	        // Enter Name
	        WebElement fullNameInput = driver.findElement(By.xpath("(//input[@id='FullNamecreate-user'])[1]"));
	        fullNameInput.sendKeys(userName);

	        // Enter email
	        WebElement emailInput = driver.findElement(By.xpath("(//input[@id='EmailAddresscreate-user'])[1]"));
	        emailInput.sendKeys("Aaatest123@pivotree.com");

	        // Click on the "Cancel" button
	        WebElement cancel = driver.findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]"));
	        cancel.click();
	        
	        //Modified pencil icon check
	     // Locate the parent div class that contains all the project email
	        WebElement parentDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[1]")));
	        // Find the specific project email name within the parent div class
	        WebElement project = parentDiv.findElement(By.xpath("(//div[@aria-label='row'])[1]"));
	        // Wait until project element is visible
	        wait.until(ExpectedConditions.visibilityOf(project));

	        // Locate and click on the "Modify User" button
	        WebElement assignUserButton = project.findElement(By.xpath("(//button[@aria-label='Modify User'])[1]"));
	        assignUserButton.click();

	        // Click on the "Cancel" button
	        WebElement cancel1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
	        cancel1.click();

	    }
		
		@Test(priority =4)
		public void Navigate_To_The_Project_Menu() throws InterruptedException {
			String projectName = "AaaaA0901";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			// Click on the "Projects" button
	        WebElement projectsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Projects'])[1]")));
	        projectsButton.click();

	        // Wait for the "Create Project" button to be clickable
	        WebElement createProjectButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Create Project']")));
	        createProjectButton.click();

	        // Wait for the "Create Project" screen to be displayed
	        WebElement createProjectScreen = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@id='customized-dialog-title']")));

	        // Enter project name
	        WebElement projectNameInput = driver.findElement(By.xpath("//input[@id='Namecreate-user']"));
	        projectNameInput.sendKeys(projectName);

	        // Enter project description
	        WebElement projectDescriptionInput = driver.findElement(By.xpath("//input[@id='Descriptioncreate-user']"));
	        projectDescriptionInput.sendKeys("AaaaA0901");

	        // Select project lead
	        WebElement projectLeadInput = driver.findElement(By.cssSelector(":nth-child(3) > .MuiAutocomplete-root > .MuiFormControl-root > .MuiInputBase-root > #undefinedcreate-user"));
	        projectLeadInput.sendKeys("aarushp123098@gmail.com");
	        WebElement projectLeadOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='undefinedcreate-user-option-0' and contains(text(), 'aarushp123098@gmail.com')]")));
	        projectLeadOption.click();

	        // Enter project domain
	        WebElement projectDomainInput = driver.findElement(By.xpath("//*[@name='Domain'][1]"));
	        projectDomainInput.sendKeys("AaaaA0901");

	        // Click on the "Cancel" button
	        WebElement cancel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
	        cancel.click();
	        
	        //Pencil icon
	        WebElement parentDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[1]")));
	        // Find the specific project email name within the parent div class
	        WebElement project = parentDiv.findElement(By.xpath("(//div[@aria-label='row'])[1]"));
	        // Wait until project element is visible
	        wait.until(ExpectedConditions.visibilityOf(project));

	        // Locate and click on the "Modify User" button
	        WebElement assignUserButton = project.findElement(By.xpath("(//*[name()='svg'][@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-11fo197'])[10]"));
	        assignUserButton.click();

	        // Click on the "Cancel" button
	        WebElement cancel1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
	        cancel1.click();
	     // Click on the "Home" button
		     WebElement HomeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Home'])[1]")));
		     HomeButton.click();
	        
		}
		
		@Test(priority =5)
		public void Navigate_To_The_Home_Menu_Check_AssignUser_menu() throws InterruptedException {	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
		
	    //Navigate to assign project and check buttons are work or not 
	  // Locate the parent div class that contains all the project names
			WebElement parentDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(2500);
			// Find the specific project name within the parent div class
			WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
			Thread.sleep(2500);
			//Assuming the Assign User button is a sibling of the project name, you can use XPath to find it
			WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(project.findElement(By.xpath("following::button[@aria-label='Assign Users'][1]"))));
	        // Click on the Assign User button
	        assignUserButton.click();
			// Wait for the Add User button to be clickable
	        WebElement addUserButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add User'])[1]")));
	        // Click on the Add User button
	        addUserButton.click();
	     // Send keys to the input field
            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.MuiFormControl-root.MuiFormControl-fullWidth.MuiTextField-root.css-e48aov input")));
            emailInput.sendKeys("niveditha.raguraman@pivotree.com");

            // Click on the dropdown option
            WebElement dropdownOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/ul/li[1]")));
            dropdownOption.click();

            // Select role
            WebElement roleInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='Role']")));
            roleInput.sendKeys("Analyst");

            // Choose the option from the dropdown
            WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='undefinedcreate-user-option-1' and contains(text(), 'Analyst')]")));
            roleOption.click();

            // Click on the cancel button
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Cancel'])[1]")));
            cancelButton.click();

            // Close the pop-up window
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='close'])[1]")));
            closeButton.click();
		
		}
		@Test(priority =6)
		public void Navigate_To_The_Home_Menu_Check_Comment_menu() throws InterruptedException {	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			// Locate the parent div class that contains all the project names
			WebElement parentDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(2500);
						// Find the specific project name within the parent div class
			WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
			Thread.sleep(2500);
						//Assuming the Assign User button is a sibling of the project name, you can use XPath to find it
			WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(project.findElement(By.xpath("following::button[@aria-label='View Comments'][1]"))));
				        // Click on the Assign User button
			assignUserButton.click();			
			// Click on the "Home" button
		     WebElement HomeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Home'])[1]")));
		     HomeButton.click();
	}
		@Test(priority =7)
		public void Navigate_To_The_Home_Menu_Check_History_menu() throws InterruptedException {	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			// Locate the parent div class that contains all the project names
			WebElement parentDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(2500);
						// Find the specific project name within the parent div class
			WebElement project = parentDiv.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"));
			Thread.sleep(2500);
						//Assuming the Assign User button is a sibling of the project name, you can use XPath to find it
			WebElement assignUserButton = wait.until(ExpectedConditions.elementToBeClickable(project.findElement(By.xpath("following::button[@aria-label='View History'][1]"))));
				        // Click on the Assign User button
			assignUserButton.click();
			// Close the pop-up window
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='close'])[1]")));
            closeButton.click();
			// Click on the "Home" button
		     WebElement HomeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Home'])[1]")));
		     HomeButton.click();
	}
		
		@Test(priority = 8)
		public void Open_Same_Project_Check_Header_Tab() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			//iframe
			WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe1z1);

			//Visible buttons checked on VIZ tool screen
			//click on the search off
			WebElement searchOnOffButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='SearchOnOff']")));
			searchOnOffButton.click();
			searchOnOffButton.click(); // Double click?

			//Click on the sort path 
			WebElement alphaSortButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='alphaSort']")));
			alphaSortButton.click();
			alphaSortButton.click(); // Double click?

			//Click on the layout
			WebElement reverseLayoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='reverseLayout']")));
			reverseLayoutButton.click();
			reverseLayoutButton.click(); // Double click?

			//Click on the Auto layout
			WebElement adjustLayoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='adjustLayout']")));
			adjustLayoutButton.click();
			adjustLayoutButton.click(); // Double click?
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			//Thread.sleep(3000); // You can replace this with WebDriverWait

			// Click on home page
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();

	
		}		
		@Test(priority =9)
		public void Verifyed_Hedaer_Tab_Attribute_SKU_AGGrid() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(350));

			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();

			// Locate the iframe using CSS selector
			WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe1z1);
			Thread.sleep(3000);
			
			// Visible buttons checked on VIZ tool screen
			// Attribute check tab
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), 'Controls & Electrical Components')])[1]")));
			nodeTextElement1.click();
			Thread.sleep(3000);
			WebElement infoPopButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
			infoPopButton.click();
			Thread.sleep(3000);
			WebElement rootnode11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Controls & Electrical Components')])[1]")));
			Actions actions1s = new Actions(driver);
			actions1s.moveToElement(rootnode11).perform();
			Thread.sleep(3000);
			WebElement nodeTextElement16 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
			nodeTextElement16.click();
			Thread.sleep(3000);
			
			// click on the pop button on the header and Verify SKU
			WebElement infoPopButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
			infoPopButton1.click();
			Thread.sleep(3500);
			//mouse moveover 
			WebElement rootnode111 = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//*[contains(text(),'Batteries')])[1]")));
			Actions actions11 = new Actions(driver);
			actions11.moveToElement(rootnode111).perform();
			Thread.sleep(2000);
			// Wait for nodeTextElement16 to be clickable and then click on it to close the SKU table
			WebElement nodeTextElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='closeicon']/img")));
			nodeTextElement.click();
			Thread.sleep(2000);
			
			// click on the pop button on the header and Verify AG grid
			WebElement infoPopButton11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='infoPop']")));
			infoPopButton11.click();
			Thread.sleep(3000);
			// Wait for rootnode11 to be visible and then perform mouse hover action
			WebElement root = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Controls & Electrical Components')])[1]")));
			Actions actions12 = new Actions(driver);
			actions12.moveToElement(root).perform();
			Thread.sleep(3000);
			// Wait for nodeTextElement16 to be clickable and then click on it to close the
			// SKU table
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			WebElement nodeTextElement19 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='close']")));
			nodeTextElement19.click();
			Thread.sleep(3000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
			// Click on home page
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
		}		
		
		@Test(priority = 10)
		public void Verify_Open_Old_Created_Project_and_Add_JSON_File_and_AssignNode1() throws InterruptedException {
				//Locate the parent div class that contains all the project names
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			Thread.sleep(3000);
			// Locate the iframe using CSS selector
			WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			//Load the project 
			// verified current version
			WebElement element1q = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
			String actualqTextt = element1q.getText();
			System.out.println(actualqTextt);
			Thread.sleep(2000);
			//load json file
			WebElement iframeqq = driver.findElement(By.xpath("//*[@id='jsonfile']"));
			iframeqq.sendKeys("C:\\Users\\Abhijit.Jadhav\\eclipse-workspace\\VSGDoverProduct.jzon");
			Thread.sleep(3000);
			//withou saving node assigned
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
			nodeTextElement1.click();
			Thread.sleep(2000);
			WebElement rootnode1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]")));
			Actions actionsz1 = new Actions(driver);
			actionsz1.contextClick(rootnode1).perform();
			Thread.sleep(2000);
			WebElement assignNode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")));
			assignNode.click();
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(2000);
			Alert alert11 = driver.switchTo().alert();
			String AssignedNode11 = alert11.getText();
			System.out.println("Alert message: " + AssignedNode11);
			String expectedAlertText111 = "Save the project before assigning a node";
			alert11.accept();
			Thread.sleep(2000);
			//Save the Job
			WebElement rootnode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'VSGDoverProduct')])[1]")));
			Actions actionsz = new Actions(driver);
			actionsz.contextClick(rootnode).perform();
			Thread.sleep(2000);
			WebElement saveJob = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Save JZON')]")));
			saveJob.click();
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(2000);
			Alert alert1z1 = driver.switchTo().alert();
			String ProjectJZONalertText16 = alert1z1.getText();
			System.out.println("Alert message: " + ProjectJZONalertText16);
			String expectedAlertText14 = "Project JZON saved successfully";
			alert1z1.accept();
			Thread.sleep(2000);
			//Current version 
			WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
			String actualTextt = element1.getText();
			System.out.println(actualTextt);
			Thread.sleep(2000);
			// Wait for the root node to be clickable
			WebElement rootnodes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]")));
			// Perform the context click action
			Actions actionsg = new Actions(driver);
			actionsg.contextClick(rootnodes).perform();
			Thread.sleep(2000);
			//Assign node
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
			Thread.sleep(2000);
			// Wait for the assign node to analyst window to open
			WebElement assignNodeTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='assignNodeTitle']")));
			String text = assignNodeTitle.getText();
			System.out.println(text);
			Thread.sleep(2000);
			// Click on the drop-down
			WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nodeToAnalyst']")));
			dropDown.click();
			Thread.sleep(2000);
			// Select an option from the drop-down
			WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nodeToAnalyst']/option[2]")));
			option.click();
			Thread.sleep(2000);
			// Click on the assigned node button
			WebElement assignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirmAssignNode']")));
			assignButton.click();
			Thread.sleep(2000);
			// Wait for the alert to be present
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(2000);
			// Handle the alert
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			System.out.println("Alert message: " + alertMessage);
			String expectedAlertText = "Successfully assigned node to the Analyst";
			alert.accept();
			Thread.sleep(2000);
		
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
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
			Thread.sleep(2000);	
	}
		@Test(priority = 11)
		public void open_Assigne_node() throws InterruptedException {
			
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

			WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));

			// Find the specific project name within the parent div class
			WebElement project11e = wait.until(ExpectedConditions.visibilityOf(parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));

			// Click on the drop down
			WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
			assignUserButton11e.click();
			Thread.sleep(1000);
			// Find the specific node (e.g., "Diagnostics & Calibration Systems") within the dropdown
			List<WebElement> nodes = driver.findElements(By.xpath("//*[contains(text(),'Electrical Cables & Wires')]"));

			for (WebElement node : nodes) {
			    // Check if the node text matches the desired node name
			    if (node.getText().equalsIgnoreCase("Electrical Cables & Wires")) {
			        // Click on the node
			        node.click();
			        break; // Exit the loop after clicking on the node
			    }
			}
			Thread.sleep(2500);
			
			//Add child node and Save Jzon and the save and close
			//Right-click on root node
			WebElement iframe111 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			//   Switch to the iframe
			driver.switchTo().frame(iframe111);
			Thread.sleep(2000);
			// Wait for the node text element to be visible within the iframe
			WebElement nodeTextElement1b = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nodeText")));
			Thread.sleep(2000);
			// Perform a right-click using the Actions class
			Actions actionsc = new Actions(driver);
			actionsc.contextClick(nodeTextElement1b).perform();
			Thread.sleep(2000);
			// Wait for the "Add child node" option to be clickable and then click on it
			WebElement addChildNodeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Add child node...')]")));
			addChildNodeOption.click();
			Thread.sleep(2000);
			// Wait for the "CreateNodeName" field to be visible and then send keys
			WebElement createNodeNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='CreateNodeName']")));
			createNodeNameField.sendKeys("DemoTest");
			Thread.sleep(2000);
			// Wait for the "Create" button to be clickable and then click on it
			WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CreateNodeForm']/div[2]/div[2]/a[2]")));
			createButton.click();
			Thread.sleep(2000);
			// Perform a right-click again to save and close JZON
			WebElement nodeTextElement1bc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nodeText")));
			Actions actions1c = new Actions(driver);
			actions1c.contextClick(nodeTextElement1bc).perform();
			Thread.sleep(2000);
			// Wait for the "Save & Close JZON" option to be clickable and then click on it
			WebElement saveAndCloseJZONOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Save & Close JZON')]")));
			saveAndCloseJZONOption.click();
			Thread.sleep(2000);
			// Verify the current version
			WebElement element111q = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
			String actualText1 = element111q.getText();
			Thread.sleep(1000);
			// Expected text
			System.out.println(actualText1);
			Thread.sleep(1000);
			// Switch back to the default content (main page)
			driver.switchTo().defaultContent();
		 // Click on home page
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
			Thread.sleep(2000);			
		}
		@Test(priority = 12)
		public void Verified_Node_As_Completed_Or_Not() throws InterruptedException {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

			WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(1000);
			// Find the specific project name within the parent div class
			WebElement project11e = wait.until(ExpectedConditions.visibilityOf(parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));
			Thread.sleep(1000);
			// Click on the drop down
			WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
			assignUserButton11e.click();
			Thread.sleep(2000);
			//node staus as completd or not 
			// Find the "Completed" element near the electrical node using a relative XPath
			WebElement completedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')]/following::p[contains(text(),'Completed')])[3]")));
			Thread.sleep(2000);
			// Get the text of the "Completed" element
			String text11 = completedElement.getText();
			System.out.println(text11);
			Thread.sleep(2000);

		
		}
		@Test(priority = 13)
		public void Verify_Open_Old_Created_Project_and_Add_JSON_File_and_AssignNode() throws InterruptedException {
				//Locate the parent div class that contains all the project names
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			Thread.sleep(3000);
			// Locate the iframe using CSS selector
			WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			//Load the project 
			// verified current version
			WebElement element1q = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
			String actualqTextt = element1q.getText();
			System.out.println(actualqTextt);
			Thread.sleep(2000);
			//withou saving node assigned
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
			nodeTextElement1.click();
			Thread.sleep(2000);
			WebElement rootnode1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]")));
			Actions actionsz1 = new Actions(driver);
			actionsz1.contextClick(rootnode1).perform();
			Thread.sleep(2000);
			WebElement assignNode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul/li[contains(text(), 'Reintegrate Node')]")));
			assignNode.click();
			Thread.sleep(2000);
			//Handel alert
			System.out.println();
			Alert alert11s = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println();
			// Get the text of the alert
			String ProjectJZONalertText1s = alert11s.getText();
			System.out.println("Alert message: " + ProjectJZONalertText1s);
			String expectedAlertText1s = "All data in the node including SKUs will be lost";
			// Accept the alert (click OK or Yes)
			alert11s.accept();
			Thread.sleep(4000);

			// Handel Alert
			System.out.println();
			Alert alert1d = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println();
			// Get the text of the alert
			String ProjectJZONalertText11d = alert1d.getText();
			System.out.println("Alert message: " + ProjectJZONalertText11d);
			String expectedAlertText11f = "Node Reintegrated Successfully";
			//Accept the alert (click OK or Yes)
			alert1d.accept();
			Thread.sleep(4000);

			// Handel Alert
			System.out.println();
			Alert alert1111 = wait.until(ExpectedConditions.alertIsPresent());
			System.out.println();
			// Get the text of the alert
			String ProjectJZONalertText11 = alert1111.getText();
			System.out.println("Alert message: " + ProjectJZONalertText11);
			String expectedAlertText1011 = "Project JZON saved successfully";
			// Accept the alert (click OK or Yes)
			alert1111.accept();
			Thread.sleep(4000);
			// Mouse over to the battery node
			WebElement batteryNode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]")));
			Actions actionsA = new Actions(driver);
			actionsA.moveToElement(batteryNode).perform();
			Thread.sleep(3000); // Wait for the menu to appear, adjust time as needed
			// Scroll to the right (if needed)
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(-200, 0)");
			Thread.sleep(4000);
			// Now perform the actions you need after the mouse hover
			WebElement element11A = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Node status: Reintegrated')]")));
			String text111 = element11A.getText();
			System.out.println(text111);
			Thread.sleep(2000);

			//Current version 
			WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
			String actualTextt = element1.getText();
			System.out.println(actualTextt);
			Thread.sleep(2000);
		
		  // Switch back to the default content (main page)
				driver.switchTo().defaultContent();
		 // Click on home page
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
			Thread.sleep(2000);	
	}
		@Test(priority = 14)
		public void Verified_Node_As_Reintegrtaed_Or_Not() throws InterruptedException {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

			WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(1000);
			// Find the specific project name within the parent div class
			WebElement project11e = wait.until(ExpectedConditions.visibilityOf(parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));
			Thread.sleep(1000);
			// Click on the drop down
			WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
			assignUserButton11e.click();
			Thread.sleep(2000);
			//node staus as completd or not 
			// Find the "Completed" element near the electrical node using a relative XPath
			WebElement completedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')]/following::p[contains(text(),'Reintegrated')])[3]")));
			Thread.sleep(2000);
			// Get the text of the "Completed" element
			String text11 = completedElement.getText();
			System.out.println(text11);
			Thread.sleep(2000);
		
		}
		@Test(priority = 15)
		public void Reintegrted_Node_Reassigned_To_The_Analyst() throws InterruptedException {
				//Locate the parent div class that contains all the project names
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
			// Open specific
			WebElement element11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]")));
			element11.click();
			Thread.sleep(3000);
			// Locate the iframe using CSS selector
			WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			driver.switchTo().frame(iframe);
			Thread.sleep(2000);
			//Load the project 
			// verified current version
			WebElement element1q = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='project_version']")));
			String actualqTextt = element1q.getText();
			System.out.println(actualqTextt);
			Thread.sleep(2000);
			//Assign node under this node
			WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
			nodeTextElement1.click();
			Thread.sleep(2000);
			// Wait for the root node to be clickable
			WebElement rootnodes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')])[1]")));
			// Perform the context click action
			Actions actionsg = new Actions(driver);
			actionsg.contextClick(rootnodes).perform();
			Thread.sleep(2000);
			//Assign node
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
			Thread.sleep(2000);
			// Wait for the assign node to analyst window to open
			WebElement assignNodeTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='assignNodeTitle']")));
			String text = assignNodeTitle.getText();
			System.out.println(text);
			Thread.sleep(2000);
			// Click on the drop-down
			WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nodeToAnalyst']")));
			dropDown.click();
			Thread.sleep(2000);
			// Select an option from the drop-down
			WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='nodeToAnalyst']/option[2]")));
			option.click();
			Thread.sleep(2000);
			// Click on the assigned node button
			WebElement assignButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='confirmAssignNode']")));
			assignButton.click();
			Thread.sleep(2000);
			// Wait for the alert to be present
			wait.until(ExpectedConditions.alertIsPresent());
			Thread.sleep(2000);
			// Handle the alert
			Alert alert = driver.switchTo().alert();
			String alertMessage = alert.getText();
			System.out.println("Alert message: " + alertMessage);
			String expectedAlertText = "Successfully assigned node to the Analyst";
			alert.accept();
			Thread.sleep(2000);
		
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
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
			Thread.sleep(2000);	
	 }	
		@Test(priority = 16)
		public void Verified_Node_As_Reassigned_Or_Not() throws InterruptedException {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));

			WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(1000);
			// Find the specific project name within the parent div class
			WebElement project11e = wait.until(ExpectedConditions.visibilityOf(parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'NewProjectTset')])[2]"))));
			Thread.sleep(1000);
			// Click on the drop down
			WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
			assignUserButton11e.click();
			Thread.sleep(2000);
			//node staus as completd or not 
			// Find the "Completed" element near the electrical node using a relative XPath
			WebElement completedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Electrical Cables & Wires')]/following::p[contains(text(),'Assigned')])[11]")));
			Thread.sleep(2000);
			// Get the text of the "Completed" element
			String text11 = completedElement.getText();
			System.out.println(text11);
			Thread.sleep(2000);
			// Click on home page
			WebElement homeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Home'][1]")));
			homeButton.click();
			Thread.sleep(2000);
		}
		
		
	@AfterSuite
	    public void closeBrowser() {
	        // Close the WebDriver instance
	        driver.quit();
		}
}


