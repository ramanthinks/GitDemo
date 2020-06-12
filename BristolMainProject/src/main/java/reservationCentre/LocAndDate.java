package reservationCentre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocAndDate {
public WebDriver driver;
public WebDriverWait wait;

	
	public LocAndDate (WebDriver driver)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,5);
		PageFactory.initElements(driver, this);
	}
	By PageTitle=By.xpath("//div[@id='page_title']");

	By RentelLocation = By.xpath("//select[@name='reservation_info[loc_id_pickup]']");
	By Month = By.xpath("//select[@name='pickup_date[month]']");
	By Day = By.xpath("//select[@name='pickup_date[day]']");
	By Year = By.xpath("//select[@name='pickup_date[year]']");
	By PickupTime = By.xpath("//select[@name='pickup_date[time]']");
	//
	By DropMonth = By.xpath("//select[@name='dropoff_date[month]']");
	By DropDate = By.xpath("//select[@name='dropoff_date[day]']");
	By DropYear = By.xpath("//select[@name='dropoff_date[year]']");
	By DropTime= By.xpath("//select[@name='dropoff_date[time]']");
	By VehiclePreference = By.cssSelector("select[name='reservation_info[choose_vehicles_id]']");
	By DriversAge = By.cssSelector("select[id*='drivers_age']");
	//
	By searchRates=By.cssSelector("input[class='rates_action_button']");
	
	//explicit wait works 
	public WebElement Title()
	{
	wait.until(ExpectedConditions.visibilityOfElementLocated(PageTitle));
	return driver.findElement(PageTitle);		
	}
	
	public WebElement RentelLocation()
	{
		return driver.findElement(RentelLocation);		
	}
	public WebElement getMonth()
	{
		return driver.findElement(Month);		
	}
	public WebElement getDay()
	{
		return driver.findElement(Day);		
	}
	public WebElement getYear()
	{
		return driver.findElement(Year);		
	}
	public WebElement getPickupTime()
	{
		return driver.findElement(PickupTime);		
	}
	//
	public WebElement getDropMonth()
	{
		return driver.findElement(DropMonth);		
	}
	public WebElement getDropDate()
	{
		return driver.findElement(DropDate);		
	}
	public WebElement getDropYear()
	{
		return driver.findElement(DropYear);		
	}
	public WebElement getDropTime()
	{
		return driver.findElement(DropTime);		
	}
	public WebElement VehiclePreference()
	{
		return driver.findElement(VehiclePreference);		
	}
	public WebElement DriversAge()
	{
		return driver.findElement(DriversAge);		
	}
	public WebElement searchRates()
	{
		return driver.findElement(searchRates);		
	}
	
	public void SelectRentalLocation(String location)
	{
		RentelLocation().click();
		Select rentalLocation = new Select(RentelLocation());
		rentalLocation.selectByVisibleText(location);
	}
	public void SelectMonth(String month)
	{
		getMonth().click();
		Select monthdrp = new Select(getMonth());
		monthdrp.selectByVisibleText(month);
	}
	public void SelectgetDay(String day)
	{
		getDay().click();
		Select daydp = new Select(getDay());
		daydp.selectByVisibleText(day);
	}
	public void SelectgetYear(String year)
	{
		getYear().click();
		Select yeardp = new Select(getYear());
		yeardp.selectByVisibleText(year);
	}
	//
	public void SelectPickupTime(String pickupTime)
	{
		getPickupTime().click();
		Select pickuptime = new Select(getPickupTime());
		pickuptime.selectByValue(pickupTime);
	}
	//
	public void SelectgetDropMonth(String month)
	{
		getDropMonth().click();
		Select monthdrp = new Select(getDropMonth());
		monthdrp.selectByVisibleText(month);
	}
	public void SelectgetDropDate(String day)
	{
		getDropDate().click();
		Select daydp = new Select(getDropDate());
		daydp.selectByVisibleText(day);
	}
	public void SelectgetDropYear(String year)
	{
		getDropYear().click();
		Select yeardp = new Select(getDropYear());
		yeardp.selectByVisibleText(year);
	}
	public void SelectgetDropTime(String time)
	{
		getDropTime().click();
		Select drpTime = new Select(getDropTime());
		drpTime.selectByValue(time);
	}
	
	public void SelectVehiclePreference(String preference)
	{
		VehiclePreference().click();
		Select vehiclePreference = new Select(VehiclePreference());
		vehiclePreference.selectByVisibleText(preference);
	}
	
	public void SelectDriversAge(String age)
	{
		DriversAge().click();
		Select driversAge = new Select(DriversAge());
		driversAge.selectByVisibleText(age);		
	}
	
	
	
}
