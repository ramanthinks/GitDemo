package automationTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;
import vehicles.Cars;
import vehicles.Trucks;

public class VTruckTest extends Base {
    public static Logger log = LogManager.getLogger(VTruckTest.class.getName());

	public WebDriver driver;
	HomePage hp;
	Trucks t;

	@BeforeTest
	public void BrowserSetups() throws IOException
	{
		driver=initializeDriver();
		log.info("WebPage opens for Truck Tab");
		driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void vTruckTab() throws InterruptedException {
		
		hp = new HomePage(driver);
		hp.selectMenu();
		hp.truckTab().click();
		hp.pickuptruckTab().click();
		
		
		t=new Trucks(driver);
	
		Assert.assertEquals(t.pickuptruckTitle().getText(),"Light Duty & Heavy Duty F150 – F350 or Similar");
		log.info("Light Duty & Heavy Duty F150 – F350 or Similar is printed");
		

	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
