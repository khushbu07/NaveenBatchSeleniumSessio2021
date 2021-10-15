package NaveenClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandling {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.findElement(By.id("datepicker")).click();
		// driver.findElement(By.xpath("//a[text()='22']")).click();
		// selectDay("30");

//		String actMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//		System.out.println(actMonthYear);
//		String expMonthYear="December 2025";
//		while(!actMonthYear.equals(expMonthYear)) {
//			// click on next:
//			driver.findElement(By.xpath("//span[text()='Next']")).click();
//	        actMonthYear=driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
//			}
//		selectDay("30");

		selectFutureDate("February 2022", "28");
		//selectPastDate("February 2018", "25");
	}

	public static void selectFutureDate(String expMonthYear, String day) {
		
		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date passed....please pass the correct day/date....");
			return;
		}
		if(expMonthYear.contains("February") && Integer.parseInt(day)>29 ) {
			System.out.println("wrong feb date passed....please pass the correct day/date....");
			return;
		}

		String actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		//System.out.println(actMonthYear);
		while (!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			// click on next:
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
		selectDay(day);
	}

	
       public static void selectPastDate(String expMonthYear, String day) {
		
		if(Integer.parseInt(day)>31) {
			System.out.println("wrong date passed....please pass the correct day/date....");
			return;
		}
		if(expMonthYear.contains("February") && Integer.parseInt(day)>=29 ) {
			System.out.println("wrong feb date passed....please pass the correct day/date....");
			return;
		}

		String actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		//System.out.println(actMonthYear);
		while (!actMonthYear.equalsIgnoreCase(expMonthYear)) {
			// click on next:
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			actMonthYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		}
		selectDay(day);
	}
	public static void selectDay(String day) {
		driver.findElement(By.xpath("//a[text()='" + day + "']")).click();

	}
}