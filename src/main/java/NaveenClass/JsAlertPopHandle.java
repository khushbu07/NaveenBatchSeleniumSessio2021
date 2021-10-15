package NaveenClass;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopHandle {
	
	
	//JS alert
	//Modal Dialogue pop up
	//switchTo,accept,dismiss,getText,sendKeys
	//4 imp method of alert:accept,dismiss,getText,sendKeys
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

//		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//        driver.findElement(By.name("proceed")).click();
        
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       // driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
       //driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(5000);
        Alert alrt=driver.switchTo().alert();
        String text=alrt.getText();
        System.out.println(text);
        alrt.sendKeys("Testing");
        
        alrt.accept(); //click on ok
        //alrt.dismiss();//cancel the alert
        
      driver.switchTo().defaultContent();
        

}
}