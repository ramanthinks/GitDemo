
package automationTest;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class HomePageTest extends Base {
public static Logger log = LogManager.getLogger(HomePageTest.class.getName());


	@BeforeTest
	public void browser() throws IOException {
		driver= initializeDriver();
		log.info("driver is initalized");
		driver.get(prop.getProperty("url"));
		log.info("Broswer navigate to Bristol home page");
	}
	
	@Test
	public void homePageNaviagation() throws IOException {
	

		HomePage hp=new HomePage(driver);
		Assert.assertTrue(hp.getLogo().isDisplayed());
		log.info("company logo confirmed");

		Assert.assertEquals(hp.pageTitle().getText(), "IMPORTANT MESSAGE – WE REMAIN OPEN AS AN ESSENTIAL SERVICE");
		log.info("covid message");
		

	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
