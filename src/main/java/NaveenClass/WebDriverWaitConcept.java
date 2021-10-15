package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		// exp wait:
		// custom wait -- can be applied for a specific element on the basis of some exp
		// conditions
		// isPresent, isVisible, isClickable,
		// its not a global wait
		// can be used for non web elements: frames, alerts, url, titles

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoauto.xyz/signin");

		driver.findElement(By.id("email")).sendKeys("admin02@mailinator.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("//span[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()=' Add lead']")).click();

//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement compName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("company_name")));
//		compName.sendKeys("FISERV");
//		WebElement VatNum = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vat_number")));
//		VatNum.sendKeys("123");

		By compName=By.id("company_name");
		By VatNum=By.id("vat_number");
		
		 waitForElement(compName,10).sendKeys("ggg");
		 waitForElement(VatNum,30,2).sendKeys("ggg123");

	}

	public static WebElement waitForElement(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public static WebElement waitForElement(By locator, long timeOut,long intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut,intervalTime);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
}