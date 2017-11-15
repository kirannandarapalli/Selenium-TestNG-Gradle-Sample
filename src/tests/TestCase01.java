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
public class TestCase01 {

	@Test
	public void TC01(){
		
		String filePath = System.getProperty("user.dir") + "\\libs\\chromedriver.exe";
				
		System.setProperty("webdriver.chrome.driver", filePath);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extenstions");
		
		WebDriver driver = new ChromeDriver(options);
		
		TakeAwayLaunchPage LaunchPg = new TakeAwayLaunchPage(driver);
		
		LaunchPg.LaunchURL("https://www.lieferando.de/");
		
		LaunchPg.enterVal("707");
		
		LaunchPg.verifyOptionsPopulated("707");
		
		LaunchPg.enterVal("70771");
		
		LaunchPg.clickEnterAfterPassingVal();
		
		LaunchPg.verifyRestaurantsPage("70771");
		
		LaunchPg.close();
		
	}
	
}
