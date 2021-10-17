package NaveenClass;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserHandle {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		String parentWindowID=it.next();
		System.out.println("Parent WindowID : "+parentWindowID);
		
		String childWindowID=it.next();
		System.out.println("Child WindowID : "+parentWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child window Title :"+ driver.getTitle());
		
		driver.close();
		
        driver.switchTo().window(parentWindowID);
	    System.out.println("Parent Window Title :"+ driver.getTitle());
	    
	    driver.quit();

	}

}
