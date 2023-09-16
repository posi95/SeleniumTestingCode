import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Invoking Browser
		//Chrome -> ChromeDriver -> Methods
		//chromedriver.exe -> Chrome Browser
		
		//webdriver.chrome.driver -> localpath to chrome driver
		//For FireFox, use Gecko driver
		//
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://myspace.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

}
