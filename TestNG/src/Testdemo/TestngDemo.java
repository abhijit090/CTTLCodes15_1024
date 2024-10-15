package Testdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * @BeforeSuite Step-1....System property for chrome
@BeforeTest Step-2.....Launch chrome browser
@BeforeClass Step-3.....LogintoApp
BeforeMethod step-4.....Enter URL
@Test Step-5....Google title  first test cases
@AfterMethod step-6....Logout
@AfterClass step-7...close browser
@AfterTest-step8....Deletallcookies
@AfterSuite step-9....Genrtaetestreport
PASSED: writetestcasesfirst

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================

@AfterSuite step-9....Genrtaetestreport


 */

public class TestngDemo {

	// before conditions
	@BeforeSuite
	public void Systempropertyforchrome() {
		System.out.println("@BeforeSuite Step-1....System property for chrome");
	}
	
	@BeforeTest
	public void LaunchcchromeBrowser() {
		System.out.println("@BeforeTest Step-2.....Launch chrome browser");
	}
	
	@BeforeClass 
	public void LogintoAPP() {
		System.out.println("@BeforeClass Step-3.....LogintoApp");
	}
	
	@BeforeMethod 
	public void enterURL() {
		System.out.println("@BeforeMethod step-4.....Enter URL");
	}
	
	
	/*
	 * @BeforeMethode
	 * @Test-1
	 * @AfterMethod
	 * 
	 * @BeforeMethode
	 * @Test-2
	 * @AfterMethod
	 * 
	 */
	
	
	// Starting test cases
	@Test
	 public void writetestcasesfirst() 
	{
		// TODO Auto-generated method stub
		System.out.println("@Test Step-5....Google title  first test cases");
	}
	
	@Test
	 public void Googlelogoverify2ndtest() 
	{
		// TODO Auto-generated method stub
		System.out.println("Googlelogoverify2ndtest ....Google Logo");
	}
	
	// After condition
	@AfterMethod
	 public void LogoutApp() 
	{
		// TODO Auto-generated method stub
		System.out.println("@AfterMethod step-6....Logout");
	}
	
	@AfterClass
	 public void closebrowser() 
	{
		// TODO Auto-generated method stub
		System.out.println("@AfterClass step-7...close browser");
	}
	
	@AfterTest
	 public void Deletallcookies() 
	{
		// TODO Auto-generated method stub
		System.out.println("@AfterTest-step8....Deletallcookies");
	}
	
	@AfterSuite
	 public void genrtaetestreport() 
	{
		// TODO Auto-generated method stub
		System.out.println("@AfterSuite step-9....Genrtaetestreport");
	}
	
	
	
}
