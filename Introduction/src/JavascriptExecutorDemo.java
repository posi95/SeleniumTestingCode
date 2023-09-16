import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.testng.Assert;

public class JavascriptExecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0, 600)");
		
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");
		
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			int total = Integer.parseInt(values.get(i).getText());
			sum += total;
		}
		System.out.println(sum);
		
		String endCheck = driver.findElement(By.className("totalAmount")).getText().split(": ")[1];
		int finale = Integer.parseInt(endCheck);
		
		Assert.assertEquals(sum, finale);
	}

}