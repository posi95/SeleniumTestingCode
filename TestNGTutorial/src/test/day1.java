package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day1 {
	@Test(dependsOnMethods= {"Demo2"})
	public void Demo() {
		System.out.println("hello");
	}
	
	@Test
	public void Demo2() {
		System.out.println("what up");
	}
	
	@BeforeTest
	public void prerequisite() {
		System.out.println("I'm first bruh");
	}

	@AfterSuite
	public void aftersuite() {
		System.out.println("na everybody go chop breakfast");
	}
}
