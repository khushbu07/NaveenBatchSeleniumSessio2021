package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitle {

	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");

		
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		if (wait.until(ExpectedConditions.titleContains("Login"))) {
//			System.out.println(driver.getTitle());
//         }

		String title=waitForTitleContains(5,"Login");
		System.out.println(title);
		
		driver.findElement(By.linkText("Register")).click();
		
		String title1=waitForTitleToBe(10,"Register Account");
		System.out.println(title1);
		
	}

	public static String waitForTitleContains(int timeOut,String titleFraction) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
		 return driver.getTitle();
		 }
		return null;
}
	public static String waitForTitleToBe(int timeOut,String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		if (wait.until(ExpectedConditions.titleIs(title))) {
		 return driver.getTitle();
		 }
		return null;
}
}