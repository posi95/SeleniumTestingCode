import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id *='SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isSelected());

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id *= 'SeniorCitizenDiscount']")).isDisplayed());

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i += 1;
		}
		driver.findElement(By.id("btnclosepaxoption")).click();

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");

		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

	}

}
