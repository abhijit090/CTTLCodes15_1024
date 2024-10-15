package com.ctt.qa.base;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ctt.qa.util.TestUtil;

	public class TestBase {
	    public static WebDriver driver;
	    public static Properties prop;

	    public TestBase(){
	        try {
	            prop = new Properties();
	            FileInputStream ip = new FileInputStream("/Users/Abhijit.Jadhav/eclipse-workspace/AutomationProject/src/main/java/com/ctt" + "/qa/config/config.properties");
	            prop.load(ip);
	        } catch(FileNotFoundException e){
	            e.printStackTrace();
	        }catch(IOException e) {
	        	e.printStackTrace();
	        }
	    }

	    @SuppressWarnings("deprecation")
		public static void initialization() throws InterruptedException{
	    	
	    	String browserName = prop.getProperty("browser");
	    	if (browserName.equals("chrome")){
	    		ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
				 driver = new ChromeDriver(options);
	    	}
	        
	        driver.manage().window().maximize();
	        driver.manage().deleteAllCookies();
	        // Assuming testUtil.load_Page_Time and testUtil.implict_Wait are defined elsewhere
	        driver.manage().timeouts().pageLoadTimeout(TestUtil.load_Page_Time,TimeUnit.SECONDS );
	        driver.manage().timeouts().implicitlyWait(TestUtil.implicit_Wait,TimeUnit.SECONDS);
	        driver.get(prop.getProperty("url"));
	        Thread.sleep(6000);
	        System.out.println("Page title: " + driver.getTitle());
	    }

	    public static void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

