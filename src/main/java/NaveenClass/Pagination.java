package NaveenClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		Thread.sleep(5000);

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.linkText("CONTACTS")).click();
		List<WebElement> pages=driver.findElements(By.xpath("(//div[@class='pagination'])[position()=1]/a"));
		
		int i=0;
		while(true) {
		if(driver.findElements(By.linkText("The Dictator11")).size()>0){//isdisplayed can also used 
          selectContact("The Dictator");
		break;
		}
		else
		{
			try {
			//pagination logic
			pages.get(i).click();
			}
			catch(Exception e){
				System.out.println("Pagination over..cant find contact here..");
				break;
			}
			pages=driver.findElements(By.xpath("(//div[@class='pagination'])[position()=1]/a"));//due to staleelement ref exception,need to update
		}
		i++;
	}
		
	
}
	public static void selectContact(String contactName) {

		String chkboxXpath = "//a[text()='" + contactName
				+ "']/parent::td/preceding-sibling::td/input[@type='checkbox']";
		driver.findElement(By.xpath(chkboxXpath)).click();
	}
}