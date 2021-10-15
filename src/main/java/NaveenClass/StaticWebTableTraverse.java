package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticWebTableTraverse {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		//table[@id="customers"]/tbody/tr[2]/td[1]
		//table[@id="customers"]/tbody/tr[3]/td[1]
		//table[@id="customers"]/tbody/tr[4]/td[1]
		//table[@id="customers"]/tbody/tr[7]/td[1]
		
		
	  
		
//		String beforeXpath="//table[@id=\"customers\"]/tbody/tr[";
//		String afterXpath="]/td[1]";
		
//		int rowCount=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
//		System.out.println(rowCount);
//		for(int row=2;row<=rowCount;row++) {
//			String compXpath=beforeXpath+row+afterXpath;
//			//System.out.println(compXpath);
//			String compText=driver.findElement(By.xpath(compXpath)).getText();
//			System.out.println(compText);
//			}
		
	       getTableData(1); 
	       
	       System.out.println("======================");
	       
	       getTableData(2); 
	       
	       System.out.println("======================");
	       
	       getTableData(3); 
		
	}	
		public static void getTableData(int columnNum) {
			
			String beforeXpath="//table[@id=\"customers\"]/tbody/tr[";
			String afterXpath="]/td["+columnNum+"]";
			
			int rowCount=driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
			//System.out.println(rowCount);
			for(int row=2;row<=rowCount;row++) {
				String compXpath=beforeXpath+row+afterXpath;
				//System.out.println(compXpath);
				String compText=driver.findElement(By.xpath(compXpath)).getText();
				System.out.println(compText);
				}
			
		}
		

}
