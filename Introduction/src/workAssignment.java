import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class workAssignment {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://httpbin.org");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='/forms/post']")).click();
		driver.findElement(By.cssSelector("input[name='custname']")).sendKeys("Posi");
		driver.findElement(By.cssSelector("input[name='custtel']")).sendKeys("716849051");
		driver.findElement(By.cssSelector("input[name='custemail']")).sendKeys("kennyposi@yahoo.com");
		driver.findElement(By.cssSelector("input[value='large']")).click();
		driver.findElement(By.cssSelector("input[value='bacon']")).click();
		driver.findElement(By.cssSelector("input[name='delivery']")).sendKeys("1230p");
		driver.findElement(By.cssSelector("textarea[name='comments']")).sendKeys("please hire me");
		driver.findElement(By.xpath("//button[normalize-space()='Submit order']")).click();
		
		
	}

}
