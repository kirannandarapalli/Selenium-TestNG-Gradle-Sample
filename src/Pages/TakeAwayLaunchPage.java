package Pages;


/**
 * @author Kiran Nandarapalli
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TakeAwayLaunchPage {
	
	WebDriver driver;
	
	By searchField = By.xpath("//input[@name='mysearchstring']");
	By errorMsg = By.xpath("//div[@id='ideliveryareaerror']");
	By itemList = By.xpath("//a[contains(@class,'item')]");
	By btnShow = By.xpath("//a[@id='submit_deliveryarea']");
	By randomPg = By.xpath("//div[@class='headline-xl-raised headline']");
	
	
	
	public TakeAwayLaunchPage(WebDriver driver){
		this.driver=driver;
	}
	
	// Method to launch TakeAway URL
	public void LaunchURL(String url){			
		
		driver.get(url);		
	}	
	
	
	// Method to enter the complete data in the search field	
	public void enterVal(String compval){
		
		driver.findElement(searchField).clear();
		driver.findElement(searchField).sendKeys(compval);		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	//Click enter button after passing the value in the search field
	public void clickEnterAfterPassingVal() {
		
		
		driver.findElement(searchField).sendKeys(Keys.ENTER);	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Verify the error message displayed when wrong Post Code is entered
	public void verifyErrorMsgforWrongPostCode(){
			
			String val = driver.findElement(errorMsg).getText();			
			Assert.assertEquals(val, "Die eingegebene Postleitzahl besteht nicht oder ist falsch. Bitte kontrolliere Deine Eingabe und versuche es erneut.","Error Message has been verified");
	}
	
	
	// Verify the error message displayed when wrong Address is entered
	public void verifyErrorMsgforWrongAddress(){
				
				String val = driver.findElement(errorMsg).getText();			
				Assert.assertEquals(val, "Die eingegebene Adresse/Postleitzahl ist ungültig. Bitte versuche es noch einmal.","Error Message has been verified");
	}
	
	
	// Verify the total number suggestions populated
	public void verifyOptionsPopulated(String Value) {		
		
		
		int size = driver.findElements(itemList).size();
		System.out.println("Validate the Number Values Populated : "+ size);
		
		for (int i=0; i<size; i++){
			
			String popValues = driver.findElements(itemList).get(i).getText();
			if (popValues.contains(Value)){
				
				System.out.println("Related search value is populated in field position : " +i + "and the populated value is : " + popValues);
			}else {
				
				System.out.println("Related values are not getting populated");
				Assert.assertEquals("True", "False");
			}
			
			
		}
	}
	
	// Verify the Attributes of Search Field
	public void verifySearchField(){	
			
			Assert.assertEquals(driver.findElement(searchField).getAttribute("placeholder"), "Adresse, z.B. Kirchstraße 1");
			Assert.assertEquals(driver.findElement(searchField).getAttribute("maxlength"), "100");
			
	}
			
	
	// Verify the Restaurants Page which has been displayed
	public void verifyRestaurantsPage(String val){
		
		System.out.println("Print the page Title displayed : " + driver.getTitle());
		
	}
	
	// Click on Submit button
	public void clickSubmit() throws Throwable{		
		
		
		
		Actions acton = new Actions(driver);
		acton.doubleClick(driver.findElement(randomPg));
		driver.findElement(btnShow).click();		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	// Close Browser
	public void close(){
		driver.close();
	}
	
	
		
}


