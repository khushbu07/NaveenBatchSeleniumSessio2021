package NaveenClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CrossBrowserTest {
	static WebDriver driver;

	public static void main(String[] args) {

		String browser = "Chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\mona\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "/Users/naveenautomationlabs/Downloads/geckodriver");
			driver = new ChromeDriver();

		}

		else {
			System.out.println("please pass the right browser..." + browser);
		}

		driver.get("http://www.google.com");// NPE

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}
}