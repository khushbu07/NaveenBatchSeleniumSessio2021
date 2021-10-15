package NaveenClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElements {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		// *[local-name()='svg']//*[name()='g']
		// *[local-name()='svg']//*[name()='g' and contains(@fill-rule,'evenodd')]
		// *[name()='g' and contains(@fill-rule,'evenodd')]

		WebDriverManager.chromedriver().setup();
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
		
		driver=new ChromeDriver();
		driver.get("https://emicalculator.net/");
		
		Thread.sleep(3000);
		String VerticalXpath="//*[local-name()='svg']//*[name()='g' and @class='highcharts-series-group']//*[name()='rect']";
		
		String toolTipXpath="//*[local-name()='svg']//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']";
		List<WebElement> barList=driver.findElements(By.xpath(VerticalXpath));
		System.out.println(barList.size());
		
		Actions act=new Actions(driver);
		for(WebElement e:barList){
			act.moveToElement(e).perform();
			
			//Thread.sleep(500);
			String text = driver.findElement(By.xpath(toolTipXpath)).getText();
			System.out.println(text);
		}

}
}