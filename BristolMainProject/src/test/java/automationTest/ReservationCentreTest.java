package automationTest;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import reservationCentre.LocAndDate;
import reservationCentre.RateQuote;
import reservationCentre.YourInfo;
import resources.Base;

public class ReservationCentreTest extends Base {
	
	public static Logger log = LogManager.getLogger(ReservationCentreTest.class.getName());

	public WebDriver driver;
	public WebDriverWait w;
	HomePage hp;
	LocAndDate lad;
	RateQuote rq;
	YourInfo yi;
	@BeforeTest
	public void BrowserSetup() throws IOException
	{
		driver=initializeDriver();
		
	}
	@Test(dataProvider="getData")
	public void reservation(String fname, String lname, String mail, String cmail,
			String cno, String hno,String cdname, String ccno) throws InterruptedException, IOException{
		driver.get(prop.getProperty("url"));
		log.info("WebPage open for reservation");
		//Thread.sleep(3000);
		w=new WebDriverWait(driver,5);
		w.until(ExpectedConditions.urlContains("bristoltruckrentals"));
						
		hp = new HomePage(driver);
		hp.reservationPage().click();
		//Thread.sleep(8000);
		lad= new LocAndDate(driver);
		//Thread.sleep(5000);
		Assert.assertEquals(lad.Title().getText(), "Rental Center");
		lad.SelectRentalLocation("Milton");
		lad.SelectMonth("Jun");
		lad.SelectgetDay("16");
		lad.SelectgetYear("2020");
		
		lad.SelectPickupTime("18");
	
		lad.SelectgetDropMonth("Jun");
		lad.SelectgetDropDate("17");
		lad.SelectgetDropYear("2020");
	
		lad.SelectgetDropTime("18");
		lad.SelectVehiclePreference("Compact");
		lad.SelectDriversAge("21 - 24");
		
		lad.searchRates().click();
		
		// Request Quote 
		rq=new RateQuote(driver);
		rq.AdditionalDriver().click();
		rq.CarLossDamgewaiver().click();
		rq.SelectThisVehicle().click();
		
		//YourInfo
		yi=new YourInfo(driver);
		yi.Firstname().sendKeys(fname);
		yi.Lastname().sendKeys(lname);
		yi.Email().sendKeys(mail);
		yi.ConfirmEmail().sendKeys(cmail);
		yi.HomePhone().sendKeys(cno);
		yi.CellPhone().sendKeys(hno);
		// Credit card details
	//	Thread.sleep(5000);
	//	w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator))
	
		yi.NameonCard().clear();
		
		yi.NameonCard().sendKeys(cdname);		
		driver.switchTo().frame(yi.iframe());
		yi.CreditcardNumber().sendKeys(ccno);
		driver.switchTo().defaultContent();
		yi.SelectExpDate("Jul");
		yi.SelectExpYear("2024");
		yi.SelectCardType("VISA");
		// Terms & Conditions agree 
		yi.agree().click();
		yi.receiveemail().click();
		// Submit
		Thread.sleep(2000);
		yi.Submitreservation().click();
		Thread.sleep(2000);
		System.out.println(yi.ConfrimMessage().getText());
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data=new Object[1][8];
		data[0][0]="ee";
		data[0][1]="ee";
		data[0][2]="sdds@f.com";
		data[0][3]="sdds@f.com";
		data[0][4]="1234";
		data[0][5]="1234";
		data[0][6]="ee";
		data[0][7]="4111111111111111";
		
		/*data[1][0]="eee";
		data[1][1]="eee";
		data[1][2]="abc@abcd.com";
		data[1][3]="abc@abcd.com";
		data[1][4]="4567";
		data[1][5]="4567";
		data[1][6]="eee";
		data[1][7]="4012888888881881";
		*/
		
		return data;
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
