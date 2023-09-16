import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;



public class RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(nameEditBox)).click();
		WebElement checkbox = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(checkbox)).click();
		
		WebElement radio = driver.findElement(By.cssSelector("#inlineRadio1"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
		
	}

}
