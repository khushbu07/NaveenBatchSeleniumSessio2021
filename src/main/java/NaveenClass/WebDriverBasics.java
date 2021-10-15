package NaveenClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {

		// Window
		System.setProperty("webdriver.chromedriver.driver", "C:\\Users\\mona\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch browser

		// driver.get("http://google.com");//can also write
		// driver.get("www.google.com");//without http ,it will not work

		driver.get("http://www.google.com"); // enter url

		String title = driver.getTitle();// get the page title
		System.out.println("page title : " + title);

		// verfication point/checkpoint: act vs exp result
		if (title.equals("Google")) {
			System.out.println("title is correct");
		} else {
			System.out.println("wrong title");
		}

		// Automation Steps + verification point--> Automation Test (testing)

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getPageSource().contains("Copyright"));

		// driver.quit();//close the browser
		driver.close();// close the browser

	}

}
