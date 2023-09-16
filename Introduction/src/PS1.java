import org.testng.annotations.Test;

public class PS1 extends PS {
	
	@Test
	public void testRun() {
		
		int a = 3;
		doThis();
		PS2 ps = new PS2(a);
		System.out.println(ps.increment());
		System.out.println(ps.decrement());
		
		//PS3 ps3 = new PS3(a);
		System.out.println(ps.multiplyby2());
	}

	
}
