import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		String[] items = { "Cucumber", "Brocolli", "Beetroot" };

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int l = 0;
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split(" ");
			// format (trim) to get veggie name as one word
			String value = name[0];

			// check whether name is in array
			// convert to arraylist for .contains method

			List itemsList = Arrays.asList(items);

			if (itemsList.contains(value)) {
				// click add to cart
				// button[.='ADD TO CART']
				driver.findElements(By.xpath("//div[@class='product-action'] //button[@type='button']")).get(i).click();
				l++;
			} else if (l == items.length) {
				break;
			}
		}

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();

		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

}
