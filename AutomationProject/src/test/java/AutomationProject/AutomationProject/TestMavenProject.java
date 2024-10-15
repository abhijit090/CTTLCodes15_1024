package AutomationProject.AutomationProject;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMavenProject {

	@Test
	public void DataTest1() {
	System.out.println("SUM");
	int a= 10;
	int b =20;
	Assert.assertEquals(30, a+b);
	}

	@Test
	public void DataTest2() {
	System.out.println("SUB");
	int a= 70;
	int b =20;
	Assert.assertEquals(50, a-b);
	}

	@Test
	public void DataTest3() {
	System.out.println("MUL");
	int a= 10;
	int b =20;
	Assert.assertEquals(200, a*b);
	}

	@Test
	public void DataTest4() {
	System.out.println("DIV");
	int a= 80;
	int b =20;
	Assert.assertEquals(4, a/b);
	}
}
