package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@BeforeClass
	public void beforeclass() {
		System.out.println("before any execution of this class");
	}
	
	@Test(groups = ("Smoke"))
	public void Weblogin() {
		System.out.println("since you been gone");
	}
	
	@Test(dataProvider= "dataPro")
	public void datatest(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	
	@Parameters({"URL"})
	@Test
	public void MobileLogin(String urlname) {
		System.out.println("i just can't seem to get right");
		System.out.println(urlname);
	}
	
	@Test(enabled=false)
	public void APILogin() {
		System.out.println("and i miss you more than you ever know");
	}
	
	@AfterTest
	public void lastexecution() {
		System.out.println("I'm last bruh");
	}
	
	@DataProvider
	public Object[][] dataPro() {
		Object[][] data = new Object[3][2];
		//first set
		data[0][0] = "firstusername";
		data[0][1] = "firstpassword";
		
		data[1][0] = "secondusername";
		data[1][1] = "secondpassword";
		
		data[2][0] = "thirdusername";
		data[2][1] = "thirdpassword";
		return data;
	}
}
