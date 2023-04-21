import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class Before {
	
	WebDriver driver= new ChromeDriver();
	SoftAssert Assert = new SoftAssert ();
	
	
	  

@BeforeTest
	public void before () {

}

}
