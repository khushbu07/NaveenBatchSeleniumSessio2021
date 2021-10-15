package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

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

		// driver.findElement(By.xpath("//a[text()='Indra
		// Nanj']/parent::td/preceding-sibling::td/input[@type='checkbox']")).click();

		selectContact("Anand D");
		System.out.println(getCompName("Indra Nanj"));
		System.out.println(getCompName("Harshitha Deepak"));
		System.out.println(getCompName("Anand D"));

	}

	public static void selectContact(String contactName) {

		String chkboxXpath = "//a[text()='" + contactName+ "']/parent::td/preceding-sibling::td/input[@type='checkbox']";
	    driver.findElement(By.xpath(chkboxXpath)).click();
	}

	public static String getCompName(String contactName) {

		String compNameXpath = "//a[text()='" + contactName+ "']/parent::td/following-sibling::td/a[@context='company']";
		return driver.findElement(By.xpath(compNameXpath)).getText();
	}
}