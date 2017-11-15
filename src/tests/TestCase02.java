/**
 * 
 */
package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Pages.TakeAwayLaunchPage;



/**
 * @author Kiran Nandarapalli
 * Test Case to validate the suggested values listed as option in search field
 */
public class TestCase02 {

	@Test
	public void TC02(){
		System.setProperty("webdriver.chrome.driver", "C:\\Automation\\BankInternet\\libs\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		
		WebDriver driver = new ChromeDriver(options);
		
		TakeAwayLaunchPage LaunchPg = new TakeAwayLaunchPage(driver);
		
		LaunchPg.LaunchURL("https://www.lieferando.de/");
		
		LaunchPg.enterVal("Berl");
		
		LaunchPg.verifyOptionsPopulated("Berl");
		
		LaunchPg.enterVal("Berlin");
		
		LaunchPg.clickEnterAfterPassingVal();
		
		LaunchPg.verifyRestaurantsPage("Berlin");
		
		LaunchPg.close();
		
	}
	
}
