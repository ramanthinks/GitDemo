package reservationCentre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RateQuote {

public WebDriver driver;
	
	public RateQuote (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By AdditionalDriver = By.xpath("//*[@id='rates_r3_recalculate']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]");
	By CarLossDamgewaiver = By.xpath("//*[@id='rates_r3_recalculate']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]");
	By SelectThisVehicle = By.cssSelector("input[name='r3_button[reserve]']");
	
	public WebElement AdditionalDriver()
	{
		return driver.findElement(AdditionalDriver);		
	}
	public WebElement CarLossDamgewaiver()
	{
		return driver.findElement(CarLossDamgewaiver);		
	}
	public WebElement SelectThisVehicle()
	{
		return driver.findElement(SelectThisVehicle);		
	}
	
}
