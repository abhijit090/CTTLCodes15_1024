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


	public class SmokeTesting {
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
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("button[type='button']")).click();// Login
			Thread.sleep(8000);
	    }
		
		@Test(priority = 3)
		public void Verify_Login_with_Person_Name() throws InterruptedException {
			WebElement element = driver.findElement(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]"));
			String displayName = element.getText();
			System.out.println("Login Person Name: " + displayName);
			Thread.sleep(2000);
	    }
				
			@Test(priority = 4)
			public void Verify_the_Open_Old_Created_Project_and_Add_JSON_File() throws InterruptedException {
				// Open specific
				WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
				Thread.sleep(2500);
				WebElement testAb = driver.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				testAb.click();
				Thread.sleep(6000);
				// Right-click on root node
				WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				// Switch to the iframe
				driver.switchTo().frame(iframe1);
				Thread.sleep(5000);
				//Load the project 
				// verified current version
				WebElement element1q = driver.findElement(By.xpath("//*[@id='project_version']"));
				// Get the text content of the element
				String actualqTextt = element1q.getText();
				Thread.sleep(2000);
				// Click on load jsON
				WebElement iframeqq = driver.findElement(By.xpath("//*[@id='jsonfile']"));
				iframeqq.sendKeys("C:\\Users\\Abhijit.Jadhav\\eclipse-workspace\\VSGDoverProduct.jzon");
				Thread.sleep(4000);
				
			}	
		 @Test(priority = 5)
			public void old_Created_Project_Open_and_AssigneNode_To_The_Analyst_WithoutSave_JZON() throws InterruptedException {
				// Locate the node text element within the iframe
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			 WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
			nodeTextElement1.click();
					Thread.sleep(3500);
					
					// Click on the Switches node
					WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
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
		 @Test(priority = 6)
		 public void old_Created_Project_Open_andAssigneNode_To_The_Analyst_After_Save_JZON() throws InterruptedException {

		 	 	WebElement rootnode = driver.findElement(By.xpath("(//*[contains(text(),'VSGDoverProduct')])[1]"));
		 		Actions actionsz = new Actions(driver);
		 		actionsz.contextClick(rootnode).perform();
		 		Thread.sleep(4000);

		 		// click on save job
		 		driver.findElement(By.xpath("//ul/li[contains(text(), 'Save JZON')]")).click();
		 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		 		wait.until(ExpectedConditions.alertIsPresent());
		 		Thread.sleep(3000);
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
		 		WebElement rootnode1 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
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
		 		WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
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
		 		Thread.sleep(3000);	
		  }			 
		 
		
		@Test(priority = 7)
		public void open_Assigne_node() throws InterruptedException {
//			WebElement parentDiv11w11 = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
//			Thread.sleep(3000);
//
//			// Find the specific project name within the parent div class
//			WebElement project11e = parentDiv11w11.findElement(By.xpath("(//*[contains(text(), 'AaaaABC91')])[2]"));
//			Thread.sleep(3000);
//
//			// Click on the drop down
//			WebElement assignUserButton11e = project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
//			assignUserButton11e.click();
//			Thread.sleep(4000);
//
//			// Click on the specific node (e.g., "Switches")
//			List<WebElement> TestAb = driver.findElements(By.xpath("(//*[contains(text(),'Switches')])"));
//
//			for (WebElement ele1 : TestAb) {
//			    if (ele1.getText().equalsIgnoreCase("Switches")) {
//			        ele1.click();
//			    }
//			}

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
			WebElement parentDiv11w11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='panel1bh-header']")));
			Thread.sleep(3000);
			// Find the specific project name within the parent div class
			WebElement project11e = wait.until(ExpectedConditions.visibilityOf(parentDiv11w11.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"))));
			Thread.sleep(3000);
			// Click on the drop down
			WebElement assignUserButton11e = wait.until(ExpectedConditions.elementToBeClickable(project11e.findElement(By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"))));
			assignUserButton11e.click();
			Thread.sleep(3000);
			// Find the specific node (e.g., "Diagnostics & Calibration Systems") within the dropdown
			List<WebElement> nodes = driver.findElements(By.xpath("(//*[contains(text(),'Lights')])"));

			for (WebElement node : nodes) {
			    // Check if the node text matches the desired node name
			    if (node.getText().equalsIgnoreCase("Lights")) {
			        // Click on the node
			        node.click();
			        break; // Exit the loop after clicking on the node
			    }
			}
			Thread.sleep(3500);


		}
		@Test(priority = 8)
		public void Add_Child_Node() throws InterruptedException {
			//Right-click on root node
			WebElement iframe111 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
			Thread.sleep(4000);
			//   Switch to the iframe
			driver.switchTo().frame(iframe111);
			Thread.sleep(4000);
			 //  Locate the node text element within the iframe
			WebElement nodeTextElement1b = driver.findElement(By.className("nodeText"));
			// Perform a right-click using the Actions class
			Actions actionsc = new Actions(driver);
			actionsc.contextClick(nodeTextElement1b).perform();
			Thread.sleep(4000);
			//  click on Add child name
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Add child node...')]")).click();
			Thread.sleep(3000);
			 // add child node name
			driver.findElement(By.xpath("//*[@id=\"CreateNodeName\"]")).sendKeys("DemoTest");
			Thread.sleep(3000);
			// click on the Create button
			driver.findElement(By.xpath("//*[@id=\"CreateNodeForm\"]/div[2]/div[2]/a[2]")).click();
			Thread.sleep(3000);
			//click on Save close name
			WebElement nodeTextElement1bc = driver.findElement(By.className("nodeText"));
			// Perform a right-click using the Actions class
			Actions actions1c = new Actions(driver);
			actions1c.contextClick(nodeTextElement1bc).perform();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//ul/li[contains(text(), 'Save & Close JZON')]")).click();
			Thread.sleep(4000);
			//verified current version
			WebElement element111q = driver.findElement(By.xpath("//*[@id='project_version']"));
			String actualText1 = element111q.getText();
			Thread.sleep(4000);
		   //Switch back to the default content (main page)
			driver.switchTo().defaultContent();

			// Click on home page
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[1]/header/div/div[1]/div[3]/div[1]/p/button[1]"))
					.click();
			Thread.sleep(3000);

		}
		@Test(priority = 9)
		public void Verified_Node_As_Completed_Or_Not() throws InterruptedException {
			// Click on same project and check node as completed
				// Locate the parent div class that contains all the project names
				WebElement parentDiv1 = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
				Thread.sleep(3000);
				// Find the specific project name within the parent div class
				WebElement project1 = parentDiv1.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				Thread.sleep(3000);
				//Click on the drop down
				WebElement assignUserButton1 = project1.findElement(
						By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
				// Click on the Assign User button
				assignUserButton1.click();
				Thread.sleep(4000);
			//node staus as completd or not 
				WebElement element1d = driver.findElement(By.xpath("(//p[contains(text(),'Completed')])"));
				String text11 = element1d.getText();
				System.out.println(text11);
				Thread.sleep(4000);			
		}
		@Test(priority = 10)
		public void Reintegrated_The_Node_as_Completed() throws InterruptedException {
			// Open specific
				WebElement element11z = driver.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				element11z.click();
				Thread.sleep(15000);
				// Right-click on root node
				// Locate the iframe using CSS selector
				WebElement iframe1z = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				driver.switchTo().frame(iframe1z);
				// Locate the node text element within the iframe
				WebElement nodeTextElement1z = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				nodeTextElement1z.click();
				Thread.sleep(5000);
				// Click on the Switches node
				WebElement rootnode11s = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
				Actions actionsq = new Actions(driver);
				actionsq.contextClick(rootnode11s).perform();
				Thread.sleep(3000);
				// click on reintegrated node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Reintegrate Node')]")).click();
				Thread.sleep(4000);
				 // Handel alert
				System.out.println();
				Alert alert11s = driver.switchTo().alert();
				
				System.out.println();
			     // Get the text of the alert
				String ProjectJZONalertText1s = alert11s.getText();
				System.out.println("Alert message: " + ProjectJZONalertText1s);
				String expectedAlertText1s = "All data in the node including SKUs will be lost";
			    // Accept the alert (click OK or Yes)
				alert11s.accept();
				Thread.sleep(8000);

				// Handel Alert
				System.out.println();
				Alert alert1d = driver.switchTo().alert();
				System.out.println();
			   // Get the text of the alert
				String ProjectJZONalertText11d = alert1d.getText();
				System.out.println("Alert message: " + ProjectJZONalertText11d);
				String expectedAlertText11f = "Node Reintegrated Successfully";
				//Accept the alert (click OK or Yes)
				alert1d.accept();
				Thread.sleep(8000);

				// Handel Alert
				System.out.println();
				Alert alert1111 = driver.switchTo().alert();
				System.out.println();
				// Get the text of the alert
				String ProjectJZONalertText11 = alert1111.getText();
				System.out.println("Alert message: " + ProjectJZONalertText11);
				String expectedAlertText1011 = "Project JZON saved successfully";
				// Accept the alert (click OK or Yes)
				alert1111.accept();
				 Thread.sleep(6000);
				// Mouse over to the light node
				WebElement batteryNode = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
				Actions actionsA = new Actions(driver);
				actionsA.moveToElement(batteryNode).perform();
				Thread.sleep(3000); // Wait for the menu to appear, adjust time as needed
				// Scroll to the right (if needed)
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(-200, 0)");
				Thread.sleep(4000);
				// Now perform the actions you need after the mouse hover
				WebElement element11A = driver.findElement(By.xpath("//*[contains(text(),'Node status: Reintegrated')]"));
				String text111 = element11A.getText();
				System.out.println(text111);
				Thread.sleep(2000);
				// verified current version
				WebElement element111n = driver.findElement(By.xpath("//*[@id='project_version']"));
				String actualText1w = element111n.getText();
				Thread.sleep(4000);
				// Switch back to the default content (main page)
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				// Click on home page
				driver.findElement(By.xpath("//button[normalize-space()='Home'][1]")).click();
				Thread.sleep(5000);
		}
		@Test(priority = 11)
		public void Verified_Node_Status_As_Reintegrated_or_Not() throws InterruptedException {
			// Click on the same project dropdown and check node is reintegrtaed or not
				// Locate the parent div class that contains all the project names
				WebElement parentDiv11 = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
				Thread.sleep(4000);
				// Find the specific project name within the parent div class
				WebElement project11 = parentDiv11.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				Thread.sleep(4000);
				 // Click on the drop down
				WebElement assignUserButton11 = project11.findElement(
						By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
				// Click on the Assign User button
				assignUserButton11.click();
				Thread.sleep(4000);
				// node staus as completd or not
				WebElement element1111s = driver.findElement(By.xpath("(//p[contains(text(),'Reintegrated')])"));
				String text11A = element1111s.getText();
				System.out.println(text11A);
				Thread.sleep(4000);			
		}
		@Test(priority = 12)
		public void Reintegrted_Node_Reassigned_To_The_Analyst() throws InterruptedException {
			// Open specific
				WebElement element11z1 = driver.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				element11z1.click();
				Thread.sleep(8000);
				// Right-click on root node
				// Locate the iframe using CSS selector
				WebElement iframe1z1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				driver.switchTo().frame(iframe1z1);
				Thread.sleep(3000);
				// Locate the node text element within the iframe
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]")));
				nodeTextElement1.click();
				Thread.sleep(2000);
				// Click on the Switches node
				WebElement rootnode11s1 = driver.findElement(By.xpath("(//*[contains(text(),'Lights')])[1]"));
				Actions actionsq1 = new Actions(driver);
				actionsq1.contextClick(rootnode11s1).perform();
				Thread.sleep(2000);
				//click on reintegrated node
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Assign Node to the Analyst')]")).click();
				Thread.sleep(4000);
				
				//verified whether assigned node to analyst window open or not
				WebElement elementa2 = driver.findElement(By.xpath("//*[@id=\"assignNodeTitle\"]"));
				String text2 = elementa2.getText();
				System.out.println(text2);
				Thread.sleep(2000);
				// click on the drop-down
				driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"nodeToAnalyst\"]/option[2]")).click();
				Thread.sleep(2000);
		         // click on the assigned node
				driver.findElement(By.xpath("//*[@id=\"confirmAssignNode\"]")).click();
				Thread.sleep(3000);
				// Handel Alert
				System.out.println();
				Alert alert115 = driver.switchTo().alert();
				System.out.println();
				// Get the text of the alert
				String AssignedNode115 = alert115.getText();
				System.out.println("Alert message: " + AssignedNode115);
				String expectedAlertText1115 = "Successfully assigned node to the Analyst";
				// Accept the alert (click OK or Yes)
				alert115.accept();
				Thread.sleep(3000);				
				// Switch back to the default content (main page)
				driver.switchTo().defaultContent();
				Thread.sleep(3000);
				// Click on home page
				driver.findElement(By.xpath("//button[normalize-space()='Home'][1]")).click();
				Thread.sleep(3000);			
		}
		@Test(priority = 13)
		public void Verified_Reintegrted_Status_ChangedTo_Assign() throws InterruptedException {
				//open dropdown
				//Locate the parent div class that contains all the project names
				WebElement parentDiv11t = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));
				Thread.sleep(3000);
				// Find the specific project name within the parent div class
				WebElement project11t = parentDiv11t.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				Thread.sleep(5000);
				 // Click on the drop down
				WebElement assignUserButton11t = project11t.findElement(
						By.xpath("following::div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19']"));
				// Click on the Assign User button
				assignUserButton11t.click();
				Thread.sleep(4000);
				// node staus as completd or not
				WebElement element1111st = driver.findElement(By.xpath("(//p[contains(text(),'Assigned')])"));
				String text11At = element1111st.getText();
				System.out.println(text11At);
				Thread.sleep(4000);
		}
		@Test(priority = 14)
		public void Verifyed_AGGrid_and_Search_Taxonomy() throws InterruptedException {
			// Open specific
				WebElement element11 = driver.findElement(By.xpath("(//button[contains(text(),'AaaDemo')])[2]"));
				element11.click();
				Thread.sleep(8000);
				// Right-click on root node
				WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				// Switch to the iframe
				driver.switchTo().frame(iframe1);
				Thread.sleep(3000);
				//Visible buttons checked on VIZ tool screen
				//click on the  pop button on header and Verify aatribuite
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				WebElement nodeTextElement11 = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				Actions actions1 = new Actions(driver);
				actions1.moveToElement(nodeTextElement11).perform();
				Thread.sleep(4000);
				//Close aatribute screen
				WebElement nodeTextElement12 = driver
						.findElement(By.xpath("//*[@id=\"closeicon\"]/img"));
				nodeTextElement12.click();
				Thread.sleep(2000);
				//Click on the Attribute verify SKU
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				WebElement nodeTextElement1 = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				nodeTextElement1.click();
				Thread.sleep(2000);
				//  Click on the  node 
				WebElement rootnode11 = driver.findElement(By.xpath("(//*[contains(text(),'Electronic Components')])[1]"));
				Actions actions1s = new Actions(driver);
				actions1s.moveToElement(rootnode11).perform();
				Thread.sleep(2000);
				//close sku table 
				WebElement nodeTextElement16 = driver
						.findElement(By.xpath("//*[@id=\"closeicon\"]/img"));
				nodeTextElement16.click();
				Thread.sleep(2000);
				
				//Click on the Sku & verified Ag gridscreen
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				WebElement nodeTextElementag = driver
						.findElement(By.xpath("//*[contains(text(), 'Controls & Electrical Components')]"));
				Actions actions1g = new Actions(driver);
				actions1g.moveToElement(nodeTextElementag).perform();
				Thread.sleep(2000);
				driver.switchTo().defaultContent();
				Thread.sleep(2000);
				WebElement nodeTextElement19 = driver
						.findElement(By.cssSelector("button[aria-label='close']"));
				nodeTextElement19.click();
				Thread.sleep(2000);
//				WebDriverWait wait = new WebDriverWait(driver, 10);
//				WebElement myElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='close']")));
//	             myElement.click();
//				nodeTextElement19.click();
				//Verifyed pivotree logo and add search 
				WebElement iframe = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));
				driver.switchTo().frame(iframe);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"infoPop\"]")).click();
				Thread.sleep(2000);
				//Click on the piovtree 
				WebElement nodeTextElementagq = driver.findElement(By.xpath("//*[@id=\"menucontainer\"]/div[1]"));
				Actions actions1gd = new Actions(driver);
				actions1gd.doubleClick(nodeTextElementagq).perform();
				Thread.sleep(2000);
				//Click on the rightClick
				WebElement nodeTextElementag1 = driver
						.findElement(By.xpath("//*[contains(text(), 'Welding Equipment')]"));
				Actions actions1g1 = new Actions(driver);
				actions1g1.contextClick(nodeTextElementag1).perform();
				Thread.sleep(2000);
			//  click on child name
				driver.findElement(By.xpath("//ul/li[contains(text(), 'Search Taxonomy in Database')]")).click();
				Thread.sleep(2000);
				//delet&rollup
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
				//Switch back to the default content (main page)
				driver.switchTo().defaultContent();
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

