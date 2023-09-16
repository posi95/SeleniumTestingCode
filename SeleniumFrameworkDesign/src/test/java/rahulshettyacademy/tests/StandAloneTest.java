package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.landingpage;

public class StandAloneTest {
	
	@Test
	public void submitOrder() throws InterruptedException {
		// TODO Auto-generated method stub
		String prodname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("kennyposi@yahoo.com");
		driver.findElement(By.id("userPassword")).sendKeys("October3!");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product -> 
		product.findElement(By.tagName("b")).getText().equals(prodname)).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-child")).click();
		
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		
		//ng-animating
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("[routerLink*= 'cart']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
		List<WebElement> cartProducts =  driver.findElements(By.cssSelector(".cartSection h3"));
		
		Boolean match = cartProducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(prodname));
		Assert.assertTrue(match);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li[class='totalRow']")));
		Thread.sleep(1500);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions a = new Actions(driver);
		
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-item")));
		
		driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
		
		js.executeScript("window.scrollBy(0, 500)");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btnn.action__submit")));
		driver.findElement(By.cssSelector(".btnn.action__submit")).click();
		String confirm = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		Assert.assertTrue(confirm.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
