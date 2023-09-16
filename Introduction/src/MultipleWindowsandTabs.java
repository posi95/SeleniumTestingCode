import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsandTabs {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowID = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com/");
		
		String coursename = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindowID);
		WebElement name = driver.findElement(By.cssSelector("[name= 'name']"));
		name.sendKeys(coursename);
		Thread.sleep(2000);
		//driver.quit();
		
		//File file = name.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(file, new File("C:\\Users\\Posi\\Pictures\\elementScreenshot.png"));
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		

	}

}
