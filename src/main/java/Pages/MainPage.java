package Pages;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BasePage.BasePage;
import Util.Constants;
import Util.ElementUtil;

    public class MainPage extends BasePage{
    	WebDriver driver;
    	ElementUtil elementUtil;
    	
    	public MainPage (WebDriver driver){
    		this.driver=driver;
    		elementUtil=new ElementUtil(driver);
    	}
    	public String getHomePageTitle(){
    		return elementUtil.waitForGetPageTitle(Constants.MAIN_PAGE_TITLE);
    	}
    	public void reservationDetails() throws InterruptedException{
    		WebElement hotel=driver.findElement(By.id("qf-0q-destination"));
    		hotel.sendKeys("Central New York City, New York, United States of America");
    		WebElement checkInBox=driver.findElement(By.id("qf-0q-localised-check-in"));
    		checkInBox.clear();
    		checkInBox.sendKeys("04/19/20");
    		Thread.sleep(2000);
    		WebElement checkOutBox=driver.findElement(By.id("qf-0q-localised-check-out"));
    		checkOutBox.clear();
    		checkOutBox.sendKeys("04/26/20");
    		
    		By rooms=By.id("qf-0q-rooms");
    		By adult=By.id("qf-0q-room-0-adults");
    		By children=By.id("qf-0q-room-0-children");
    		By child1=By.id("qf-0q-room-0-child-0-age");
    		By child2=By.id("qf-0q-room-0-child-1-age");
    		
    		roomDetails(driver, rooms, "1");
    		roomDetails(driver, adult, "2");
    		roomDetails(driver, children, "2");
    		Thread.sleep(1000);
    		roomDetails(driver, child1, "4");
    		roomDetails(driver, child2, "14");
    		
    		driver.findElement(By.xpath("//button[@class='cta cta-strong']")).click();
    		
    		Thread.sleep(2000);

    	}
    			public static void roomDetails(WebDriver driver, By locator, String value){
    			WebElement element = getElement(driver, locator);
    			Select select=new Select(element);
    			select.selectByValue(value);
    	}
    			public static WebElement getElement(WebDriver driver, By locator){
    			WebElement element = driver.findElement(locator);
    			return element;
    	}
}
