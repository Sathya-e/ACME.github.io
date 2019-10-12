package acme_Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ACME{
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		
		Actions actions = new Actions(driver);
		WebElement Target = driver.findElementByXPath("(//div[@class='dropdown']//button)[5]");
		actions.moveToElement(Target).perform();
		driver.findElementByLinkText("Search for Vendor").click();
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementByXPath("//button[text()='Search']").click();
		
		WebElement VendorName = driver.findElementByXPath("//td[text()='Blue Lagoon']");
		String name = VendorName.getText();
		if (name== "Blue Lagoon");
		{
			WebElement Country = driver.findElementByXPath("//td[text()='Blue Lagoon']/following-sibling::td[last()]");
			System.out.println(Country.getText());
		}
		driver.findElementByLinkText("Log Out").click();
		driver.close();
	}	
}	
			

	