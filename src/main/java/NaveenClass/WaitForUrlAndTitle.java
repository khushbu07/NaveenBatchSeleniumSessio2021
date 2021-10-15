package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForUrlAndTitle {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		driver.findElement(By.linkText("Register"));
		WebDriverWait wait = new WebDriverWait(driver,10);
//		if(wait.until(ExpectedConditions.urlContains("account/login"))){
//			System.out.println(driver.getCurrentUrl());
//		}

//		if(wait.until(ExpectedConditions.urlToBe("https://demo.opencart.com/index.php?route=account/login"))){
//			System.out.println(driver.getCurrentUrl());
//		}
		if(waitForUrlContains("account/login",5)) {
			System.out.println("Register URL is correct");
		}
		
		if(waitForUrlToBe("https://demo.opencart.com/index.php?route=account/login",5)) {
			System.out.println("Register URL is correct");
		}
		
	}
		public static Boolean waitForUrlContains(String urlFraction,int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.urlContains(urlFraction));
				
		}
		public static Boolean waitForUrlToBe(String urlValue,int timeOut) {
			WebDriverWait wait = new WebDriverWait(driver,timeOut);
			return wait.until(ExpectedConditions.urlContains(urlValue));
				
		}
	
	

}