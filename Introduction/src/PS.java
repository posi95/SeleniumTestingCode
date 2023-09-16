import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PS {
	
	@BeforeMethod
	public void beforeRun() {
		System.out.println("Dennis Taylor");
	}

	public void doThis() {
		System.out.println("It's over baby");
	}
	
	@AfterMethod
	public void afterRun() {
		System.out.println("Unconditional");
	}

}
