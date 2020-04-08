package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.MainPage;
import Pages.SearchPage;
import Util.Constants;

public class SearchPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	SearchPage searchPage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver=basePage.initialize_driver(prop);
		searchPage = new SearchPage(driver);
		searchPage.getHomePage();
	}
	@Test(priority=1)
	public void verifySecondPageTitle(){
		String title=searchPage.getSecondPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.SEARCH_PAGE_TITLE);
	}
	@Test(priority=2)
	public void fiveStarCloserThanTenMile() throws InterruptedException{
		searchPage.selectFiveStar();
		searchPage.closerThanTenMile();
	}
	@Test(priority=3)
	public void fourStarCloserThanTenMiles() throws InterruptedException{
		searchPage.selectFourStar();
		searchPage.closerThanTenMile();
	}
	@Test(priority=4)
	public void threeStarCloserThanTenMile() throws InterruptedException{
		searchPage.selectThreeStar();
		searchPage.closerThanTenMile();
	}
	@Test
	public void selectHotelCloserThanTenMile() throws InterruptedException{
		searchPage.enterHotelName();
		searchPage.closerThanTenMile();
	}
	@AfterMethod
	public void tearDown(){
		basePage.quitBrowser();
	}

}
