package vehicles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cars {
	
public WebDriver driver;
public WebDriverWait w;


public Cars(WebDriver driver) {
	 this.driver=driver;
	
	 PageFactory.initElements(driver,this);
 }	

	By Compact=By.xpath("(//*[text()='Compact'])[1]");  
	By Midsize=By.xpath("(//*[text()=' Midsize'])[1]"); 
	By Fullsize=By.xpath("(//*[text()=' Fullsize'])[1]"); 

	
	By CompactText=By.xpath("//*[text()='Hyundai Accent or Similar']");  
	By MidsizeText=By.xpath("//h2[contains(text(),'Toyota Corolla or Similar')]");  
	By FullText=By.xpath("//*[text()='Ford Fusion or Similar']");  

	

	public WebElement CompactCars() {
		w= new WebDriverWait(driver,2);
		w.until(ExpectedConditions.elementToBeClickable(Compact));
		return driver.findElement(Compact);
	}
	
	
	public WebElement MidsizeCars() {
	//	w= new WebDriverWait(driver,2);
	//  w.until(ExpectedConditions.elementToBeClickable(Midsize));
		return driver.findElement(Midsize);
	}
	
	public WebElement FullsizeCars() {
		
		return driver.findElement(Fullsize);
	}
	
	public WebElement CompText() {
		
		return driver.findElement(CompactText);
	}

	public WebElement MidText() {
		
		return driver.findElement(MidsizeText);
	}
	
	public WebElement FullText() {
		
		return driver.findElement(FullText);
	}
}
