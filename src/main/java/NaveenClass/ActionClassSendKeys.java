package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassSendKeys {

	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");

		By name = By.id("Form_submitForm_Name");
		By email = By.id("Form_submitForm_Email");
		By privacyPolicy = By.linkText("Privacy Policy");

//		Actions act=new Actions(driver);
//		act.sendKeys(driver.findElement(name), "Monalika").perform();
//		act.sendKeys(driver.findElement(email), "Monalika@gmail.com").perform();
		// ElementNotInteractableException -- Actions send Keys

		// act.click(driver.findElement(privacyPolicy)).perform();

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionSendKeys(By locator, String Value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), Value).perform();

	}
	public static void doActionClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();

	}
	
	
}