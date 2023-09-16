package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class day4 {

	@BeforeMethod
	public void beforemethod() {
		System.out.println("always on time, before every method in day 4 class");
	}
	
	@Test
	public void Mobilelogin2() {
		System.out.println("i know it might sound cray");
	}
	
	@Test
	public void MobileLogin() {
		System.out.println("but i don't know what i did");
	}
	
	@BeforeSuite
	public void bfsuite() {
		System.out.println("can we do that can we");
	}
	
	@Test
	public void MobileLogin1() {
		System.out.println("notes");
		Assert.assertTrue(false);
	}
	
	@Test
	public void APILogin() {
		System.out.println("to make you wanna leave");
	}
}
