package Tests;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.MainPage;
import Util.Constants;

public class MainPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	MainPage mainPage;
	
	@BeforeMethod
	public void setUp(){
		basePage=new BasePage();
		prop=basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		mainPage=new MainPage(driver);
	}
	@Test(priority=1)
	public void verifyHomePageTitle(){
		String title=mainPage.getHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.MAIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void getReservationDetails() throws InterruptedException{
		mainPage.reservationDetails();
	}
	
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}
	
	
	
	
	
}
