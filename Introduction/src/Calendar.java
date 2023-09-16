import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//error

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companion/");
		//September 14
		
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#form-field-travel_comp_date")).click();
		
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();
		
		for(int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();			
			if (text.equalsIgnoreCase("14")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
			
			
		}
		
		
	}

}
