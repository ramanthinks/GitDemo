package automationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public WebDriver driver;
	
	By title=By.xpath("//p[contains(text(),'WE REMAIN OPEN AS AN ESSENTIAL')]");
	By logo=By.cssSelector("img[alt='Bristol Car and Truck Rentals']");

	By rescentretab=By.xpath("//ul[@id='avia-menu']/li[2]/a/span[2]");
		
	By vehicles=By.xpath("(//*[text()='Vehicles'])[2]");	//ul[@id='avia-menu']//span[@class='avia-menu-text'][contains(text(),'Vehicles')]
	
	By cars=By.xpath("(//*[text()='Cars Minivans and SUVs'])[2]"); //Trucks //Cars Minivans and SUVs
	By trucks=By.xpath("(//*[text()='Trucks'])[2]"); 
	By pickuptrucks=By.xpath("(//*[text()='Pickup Trucks'])[2]"); 


		
		public HomePage(WebDriver driver) {
			this.driver=driver;
			 PageFactory.initElements(driver,this);
	     }

		public WebElement reservationPage() {
			return driver.findElement(rescentretab);
		}
		
		public WebElement pageTitle() {
			return driver.findElement(title);
		}
		
		public WebElement getLogo() {
			return driver.findElement(logo);
		}
		
		public WebElement vehiclesTab() {
		return driver.findElement(vehicles);
		}
		public WebElement carTab() {
			return driver.findElement(cars);	
		}
		
		public WebElement truckTab() {
			return driver.findElement(trucks);	
		}
		
		public WebElement pickuptruckTab() {
			return driver.findElement(pickuptrucks);	
		}
		
		public void selectMenu()
		{
			Actions act = new Actions(driver);
			act.moveToElement(vehiclesTab()).build().perform();
		}
}
