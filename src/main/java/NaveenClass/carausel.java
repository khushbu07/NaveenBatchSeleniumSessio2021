package NaveenClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class carausel {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		/*  //h2[text()='Deals of the Day']//parent::div//parent::div//parent::div//div[contains(@class,'_31Mq1b ')]  */
		//    _1tKnHb
		
		String carouselXpath = "//h2[text()='Deals of the Day']//parent::div//parent::div//parent::div//div[@class='_1oHPGm']//div[@class='_3LU4EM']";
		String carouselButtonXpath = "//h2[text()='Deals of the Day']//parent::div//parent::div//parent::div//div[contains(@class,'_31Mq1b')]";
		String carouselSVGNextButtonXpath = "(//*[local-name()='svg' and contains(@class,'_1xtBwk')])[1]";
		List<WebElement> productList = driver.findElements(By.xpath(carouselXpath));
		System.out.println(productList.size());
		
		List<String> allProducts = new ArrayList<String>();
		
		while(!driver.findElement(By.xpath(carouselButtonXpath)).getAttribute("class").contains("_1tKnHb"))
		{
			//logic for carousel Next Button
			for(WebElement e : productList)
			{
				String products = e.getText();
					if(!products.isEmpty())
					{
						allProducts.add(products);
					}
			}
			
			//click on carousel Next Button
			WebElement SVGButton = driver.findElement(By.xpath(carouselSVGNextButtonXpath));
			Actions act = new Actions(driver);
			act.moveToElement(SVGButton).click().build().perform();
			productList = driver.findElements(By.xpath(carouselXpath));
			
		}
		
		//traverse the allProducts list:
		for(String e : allProducts)
		{
			System.out.println(e);
		}
		
		

}
}
