package NaveenClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
//		for (int i = 0; i < choiceList.size(); i++) {
//			String text = choiceList.get(i).getText();
//			System.out.println(text);
//			if (text.equals("choice 2")) {
//				choiceList.get(i).click();
//				break;
//			}
//		}
//		for (WebElement e : choiceList) {
//			String text1 = e.getText();
//			System.out.println(text1);
//			if (text1.equals("choice 2")) {
//				e.click();
//				break;
//			}
//		}
		By choice = By.xpath("//span[@class='comboTreeItemTitle']");
		// TC-01:Single selection
		// selectChoice(choice,"choice 1");

		// TC-02:multi selection
		 selectChoice(choice,"choice 1","choice 2 2","choice 2 3");

		// TC_03: All selection:
		//selectChoice(choice, "all");

	}

	/**
	 * 1. single selection
	 * 2. multi slection
	 * 3.all (please pass the value as all/All/ALL)
	 * @param locator
	 * @param Value
	 */
	public static void selectChoice(By locator, String... Value) {

		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));

		if (!Value[0].equalsIgnoreCase("All")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);
//			if (text.equals("choice 2")) {
//				choiceList.get(i).click();
//				break;
//			}
//		}

//		for (WebElement e : choiceList) {
//			String text1 = e.getText();
//			System.out.println(text1);
//				if (text.equals("choice 2")) {
//					e.click();
//					break;
//				}

				for (int j = 0; j < Value.length; j++) {
					if (text.equals(Value[j])) {
						choiceList.get(i).click();
						break;
					}
				}

			}

		}

		else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {
				System.out.println("All values Selected");
			}

		}
	}

}
