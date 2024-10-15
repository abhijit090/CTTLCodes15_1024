package Testdemo;

import org.testng.annotations.Test;

public class Invocationcount {
	//Continues multiple time show the data
	@Test(invocationCount = 10)
	public void DataTest() {
	int a= 10;
	int b =20;
	int c = a+b;
	System.out.println("sum of the c = " +c);
	}
	
//	
//	//InvocationTimeout...brak the continues loop
//	@Test(invocationTimeOut = 5)
//	public void DataTesta() {
//	int i=1;
//	while(i==1) {
//		System.out.println(i);
//	}
	
//	}
	
	@Test(expectedExceptions =NumberFormatException.class )
	public void DataTest12() {
		String x = "100A";
		Integer.parseInt(x);
		System.out.println(x);
	}
	}
