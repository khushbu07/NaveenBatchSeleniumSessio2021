package NaveenClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselHandle {

	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.noon.com/uae-en/");
		Thread.sleep(7000);	
		String xpath="//h3[text()='Recommended for you']/parent::div//following-sibling::div//div[@data-qa='product-name']";
		String nextXpath="//h3[text()='Recommended for you']/parent::div//following-sibling::div//div[contains(@class,'swiper-button-next')]";
		
		
		List<WebElement> recommList=driver.findElements(By.xpath(xpath));
		System.out.println(recommList.size());
		List<String> prodList=new ArrayList<String>();
		while(!driver.findElement(By.xpath(nextXpath)).getAttribute("class").contains("swiper-button-disabled")) {
			//logic for next button
			for(WebElement e:recommList) {
				String text=e.getText();
				
				if(!text.isEmpty())
				prodList.add(text);
			}
		
		//Click on next 
		Actions act=new Actions(driver);
		WebElement xp=driver.findElement(By.xpath(nextXpath));
		act.moveToElement(xp).click().perform();
			//driver.findElement(By.xpath(nextXpath)).click();
			recommList=driver.findElements(By.xpath(xpath));
		}	
		
		//traverse the prodList
		for(String e:prodList) {
			System.out.println(e);
		}
		
}
}