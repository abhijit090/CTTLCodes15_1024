package CTT_Demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDem{

	private static final String ElementName = null;
	private static String iframe;
	public static String screenShotSubFoderName;
	public static WebDriver driver;
	WebDriverWait wait;
	private By with;
	private WebElement descriptionField;
	static WebDriver browser;
	
    private Properties prop;

	@BeforeSuite

	public void appLaunch() throws InterruptedException {
		try {
            // Load configuration properties
            prop = new Properties();
            String projectPath = System.getProperty("user.dir");
            FileInputStream input = new FileInputStream(projectPath + "/src/config/config.properties");
            prop.load(input);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Abhijit.Jadhav\\Downloads\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("baseURL") + "/login");
//		driver.get("https://development.d36z6oo50ky8dh.amplifyapp.com/login");
		Thread.sleep(2000);
		//Mark  Test  

	}


    @Test(priority = 1)
    public void CTT_Login_Page_Displayed_And_Enters_Login_Details() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        // Load URL dynamically
        driver.get(prop.getProperty("baseURL") + "/login");

        // Wait and verify the title dynamically
        wait.until(ExpectedConditions.titleIs(prop.getProperty("loginPageTitle")));
        Assert.assertEquals(driver.getTitle(), prop.getProperty("loginPageTitle"));

        // Print the title
        System.out.println(driver.getTitle());

        // Enter login details dynamically
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        usernameField.sendKeys(prop.getProperty("username"));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
        passwordField.sendKeys(prop.getProperty("password"));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='button']")));
        loginButton.click();
        Thread.sleep(8000);
    }

    @Test(priority = 2)
    public void Verify_Login_Person_Name() throws InterruptedException {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='MuiTypography-root MuiTypography-subtitle2 MuiTypography-noWrap css-1dqgwp4'])[1]")));
        String displayName = element.getText();
        System.out.println("Login Person Name: " + displayName);
        Thread.sleep(4000);
    }

    @Test(priority = 3)
    public void open_Specific_Project() throws InterruptedException {
        WebElement parent = driver.findElement(By.xpath("//div[@id='panel1bh-header']"));

        // Use dynamic project name from configuration
        WebElement projectName = parent.findElement(By.xpath("//*[contains(text(), '" + prop.getProperty("projectName") + "')]"));
        projectName.click();
        Thread.sleep(4000);
    }

    @Test(priority = 4)
    public void Open_AGGrid_Screen() throws InterruptedException {
        WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@id='iframeD3'])[1]"));

        // Switch to the iframe
        driver.switchTo().frame(iframe1);
        Thread.sleep(3000);

        // Use dynamic grid node name from configuration
        WebElement nodeTextElement1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), '" + prop.getProperty("gridNode") + "')]")));
        nodeTextElement1.click();
        Thread.sleep(2000);

        // Handle UI elements dynamically
        driver.findElement(By.xpath("//*[@id='infoPop']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='infoPop']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='infoPop']")).click();
        Thread.sleep(2000);

        // Hover over and perform actions dynamically
        WebElement rootnode11 = driver.findElement(By.xpath("//*[contains(text(), '" + prop.getProperty("gridNode") + "')]"));
        Actions actions1s = new Actions(driver);
        actions1s.moveToElement(rootnode11).perform();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(4000);

        // Click and save dynamically
        WebElement closetab11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-label='Save']")));
        closetab11.click();
    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
    }
}
