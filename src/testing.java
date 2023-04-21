import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class testing extends Before  {
@Test(invocationCount=3,priority=1)
public void AssertCurrencyAndLogo () {
	String [] lagnuage = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	Random rand= new Random ();
	int RandomNumber = rand.nextInt(0,50)%2;
	driver.get(lagnuage[RandomNumber]);
	String actualTitle= driver.getTitle();
	WebElement actualCurrency=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div[1]/div/button"));
	String ExpectedText = "SAR";

	
	WebElement actualLogo=driver.findElement(By.cssSelector("div[class='sc-fihHvN eYrDjb']"));
	if (RandomNumber==0) {
		Assert.assertEquals(actualTitle, "المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيران");
	Assert.assertEquals(true,actualCurrency.isDisplayed());
		Assert.assertEquals(true,actualLogo.isDisplayed());
		Assert.assertEquals(actualCurrency.getText(), ExpectedText);
	}
	else {
		Assert.assertEquals(actualTitle, "Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking");
	
	Assert.assertEquals(true,actualCurrency.isDisplayed());
	Assert.assertEquals(true,actualLogo.isDisplayed());
		Assert.assertEquals(actualCurrency.getText(), ExpectedText);
	}
	Assert.assertAll();}
	

	@Test(priority=2) 
	public void AssertLogo() {
		
		WebElement MyDiv = driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div[3]/div[3]/div[1]/div[2]/div/div[1]"));
		List<WebElement> div=MyDiv.findElements(By.tagName("svg"));
		for(int i =0;i<div.size() ;i++) {
			
			 System.out.println(i);
		 }	 
		String ExpectedVisa="Footer__VisaCardLogo";
		
		String ActualVisa= div.get(2).getAttribute("data-testid");
		Assert.assertEquals(ActualVisa, ExpectedVisa);
		Assert.assertAll();
	}
	@Test (invocationCount=3, priority=3)
	public void SendPlacesRandomly () {
		String [] lagnuage = {"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
		String [] placesEN = {"Dubai","Jeddah","Riyadh"};
		String [] placesAr = {"جدة","دبي"};

		Random rand= new Random ();
		int RandomNumber = rand.nextInt(2);
		int RandomEn = rand.nextInt(3);
		int RandomAr = rand.nextInt(2);
		driver.get(lagnuage[RandomNumber]);
		String actualTitle= driver.getTitle();
		if (RandomNumber==0) {
			Assert.assertEquals(actualTitle, "المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيران");
		driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]")).click();
		
driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input")).sendKeys(placesAr[RandomAr]);
		
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		Assert.assertAll();

		}
		else {
			Assert.assertEquals(actualTitle, "Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking");
			driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]")).click();
			

	driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input")).sendKeys(placesEN[RandomEn]);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

			}

			Assert.assertAll();

	
	} 
	@Test(priority=4) 
	public void chooseHotelRoomRandomly() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]")).click();
		Random rand= new Random ();
		Thread.sleep(3000);
		int RandomOption = rand.nextInt(2);

		Select room= new Select(driver.findElement(By.className("tln3e3-1")));
		List<WebElement> Options =room.getOptions();
		Thread.sleep(3000);
room.selectByIndex(RandomOption);
		Options.get(RandomOption);	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.className("sc-jTzLTM")).click();
		Thread.sleep(3000);

		
	}

	} 
