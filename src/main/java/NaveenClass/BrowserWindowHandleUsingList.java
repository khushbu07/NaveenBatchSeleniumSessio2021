package NaveenClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleUsingList {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		
		Set<String> handles=driver.getWindowHandles();

        List<String> handlesList=new ArrayList<String>(handles);
        String parentWindowID= handlesList.get(0);
		System.out.println("Parent WindowID : "+parentWindowID);
		
		String childWindowID=handlesList.get(1);
		System.out.println("Child WindowID : "+childWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println("Child window Title :"+ driver.getTitle());
		
		driver.close();
		
        driver.switchTo().window(parentWindowID);
	    System.out.println("Parent Window Title :"+ driver.getTitle());
	    
	    driver.quit();

	}


}
