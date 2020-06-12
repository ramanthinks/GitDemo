package vehicles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Trucks {
	public WebDriver driver;
	public WebDriverWait w;


	public Trucks (WebDriver driver) {
		 this.driver=driver;
		
		 PageFactory.initElements(driver,this);
	 }	

		By title =By.xpath("//h3[@class='av-special-heading-tag']");  

		public WebElement pickuptruckTitle() {
			w= new WebDriverWait(driver,2);
			w.until(ExpectedConditions.elementToBeClickable(title));
			return driver.findElement(title);	
		}
}
