package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		//initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//pagefactory
	@FindBy(css =".mb-3")
	List<WebElement> products;
	
	@FindBy(css =".ng-animating")
	 WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addtoCart = By.cssSelector(".card-body button:last-child");
	By toastMessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElementtoAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String prodname) {
		WebElement prod = getProductList().stream().filter(product -> 
		product.findElement(By.tagName("b")).getText().equals(prodname)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProducttoCart(String productName) {
		
		WebElement prod = getProductByName(productName);
		prod.findElement(addtoCart).click();
		waitForElementtoDisappear(spinner);
		waitForElementtoAppear(toastMessage);
		
	}
	
	
}
