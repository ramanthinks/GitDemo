package reservationCentre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YourInfo {
	public WebDriver driver;
	public WebDriverWait waits;

	public YourInfo(WebDriver driver)
	{
		this.driver=driver;
		waits = new WebDriverWait(driver,15);
		PageFactory.initElements(driver, this);
	}
	
	By Firstname = By.xpath("//input[@name='customer_info[1]']");
	By Lastname = By.xpath("//input[@name='customer_info[2]']");
	By Email = By.xpath("//input[@name='customer_info[3]']");
	By ConfirmEmail = By.xpath("//input[@name='customer_info[103]']");
	By HomePhone = By.xpath("//input[@name='customer_info[4]']");
	By CellPhone = By.xpath("//input[@name='customer_info[62]']");
	// Credit card details
	By NameonCard = By.xpath("//input[@name='customer_info[41]']");
	//By CreditcardNumber = By.xpath("//input[@name='customer_info[28]']");
	By CreditcardNumber = By.xpath("//input[@name='PAN']");
	By iframe = By.cssSelector("iframe[id='tx_iframe']");
	By ExpDate= By.xpath("//select[@name='customer_info[cc_exp_month]']");
	By ExpYear = By.xpath("//select[@name='customer_info[cc_exp_year]']");
	By CardType = By.xpath("//select[@name='customer_info[27]']");
	By agree = By.xpath("//input[@name='customer_info[710]']");
	By receiveemail = By.xpath("//input[@name='format']");
	By SubmitReservation = By.xpath("//*[@id='reservation_submit']/div[2]/input");
	
	By ConfrimMessage = By.xpath("//div[@class='modify_header']/p");
	
	public WebElement Firstname()
	{
		return driver.findElement(Firstname);		
	}
	public WebElement Lastname()
	{
		return driver.findElement(Lastname);		
	}
	public WebElement Email()
	{
		return driver.findElement(Email);		
	}
	public WebElement ConfirmEmail()
	{
		return driver.findElement(ConfirmEmail);		
	}
	public WebElement HomePhone()
	{
		return driver.findElement(HomePhone);		
	}
	public WebElement CellPhone()
	{
		return driver.findElement(CellPhone);
	}
	//
	public WebElement NameonCard()
	{
		return driver.findElement(NameonCard);		
	}
	public WebElement CreditcardNumber()
	{
		return driver.findElement(CreditcardNumber);		
	}
	//explicit wait doesnt work
	public WebElement iframe()
	{
	//	waits.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
		return driver.findElement(iframe);	
	}
	public WebElement ExpDate() {
		return driver.findElement(ExpDate);			
	}
	public WebElement ExpYear() {
		return driver.findElement(ExpYear);			
	}
	
	public void SelectExpDate(String month)
	{
		ExpDate().click();
		Select driversAge = new Select(ExpDate());
		driversAge.selectByVisibleText(month);		
	}
	public void SelectExpYear(String year)
	{
		ExpYear().click();
		Select driversAge = new Select(ExpYear());
		driversAge.selectByVisibleText(year);		
	}
	public WebElement CardType()
	{
		return driver.findElement(CardType);			
	}
	public void SelectCardType(String card)
	{
		CardType().click();
		Select driversAge = new Select(CardType());
		driversAge.selectByVisibleText(card);		
	}
	public WebElement agree() {
		return driver.findElement(agree);		
	}
	//receiveemail
	public WebElement receiveemail() {
		return driver.findElement(receiveemail);		
	}
	public WebElement Submitreservation() {
		return driver.findElement(SubmitReservation);		
	}
	
	public WebElement ConfrimMessage() {
		return driver.findElement(ConfrimMessage);		
	}
	
	public void confrimation()
	{
		ConfrimMessage().getText();
	}

}
