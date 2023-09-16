import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");	
		
		// Count the links on a page
		driver.findElements(By.tagName("a")).size();
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		// Count the links on the the footer section
		
		// Limit driver scope to specific section
		
		WebElement footerdriver = driver.findElement(By.id("gf-BIG")); 
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		// click each link in column and check if the link works
		
		for(int i = 1; i < columndriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
		}
			// Navigate through different tabs to retrieve Page Titles
			Thread.sleep(3000);
			Set<String> abc = driver.getWindowHandles();
			Iterator<String> it = abc.iterator();
			while(it.hasNext()) {
				
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
			
			
		
		
		
		
		
		
	}

}
