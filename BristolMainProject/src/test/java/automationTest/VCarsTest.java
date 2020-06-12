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

public class VCarsTest extends Base {
    public static Logger log = LogManager.getLogger(VCarsTest.class.getName());

	public WebDriver driver;
	HomePage hpp;
	Cars c;

	@BeforeTest
	public void BrowserSetupss() throws IOException
	{
		driver=initializeDriver();
		log.info("WebPage opens for Car Tab");
		driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void vCarTab() throws InterruptedException {
		
		hpp = new HomePage(driver);
		hpp.selectMenu();
		hpp.carTab().click();
		
		
		c=new Cars(driver);
		c.CompactCars().click();
		Assert.assertEquals(c.CompText().getText(),"HYUNDAI ACCENT OR SIMILAR");
		log.info("HYUNDAI ACCENT OR SIMILAR is printed");
		

		c.MidsizeCars().click();
		Assert.assertEquals(c.MidText().getText()," TOYOTA COROLLA OR SIMILAR");
		log.info("TOYOTA COROLLA OR SIMILAR is printed");
		
		c.FullsizeCars().click();
		Assert.assertEquals(c.FullText().getText(),"FORD FUSION OR SIMILARS");
		log.info("FORD FUSION OR SIMILAR is printed");
		
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
