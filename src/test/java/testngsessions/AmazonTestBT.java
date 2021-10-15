package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestBT {
	
	
	//AAA rule for unit test
		WebDriver driver;

		@BeforeTest
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
			driver.manage().deleteAllCookies();
			driver.get("https://www.amazon.com");
		}

		@Test
		public void titleTest() {
			String title = driver.getTitle();
			Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
		}

		@Test
		public void searchTest() {
			Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
		}

		@Test
		public void logoTest() {
			Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());
		}

		@AfterTest
		public void tearDown() {
			driver.quit();
		}


}
