package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngAssignment extends BaseTest {
	
	@DataProvider
	public Object[][] getRegistrationData(){
		return new Object[][]{
			
			{"khush1","jain","mar123@gmail.com","1234456","1234","1234"},
			{"khush2","jain","mar12345@gmail.com","1234456","1234","1234"}
			
		};
	}
	
	
	@Test(dataProvider="getRegistrationData")
	public void registation(String fname,String lname,String email,String ph,String password,String cpassword){
		Assert.assertTrue(doRegistration(fname, lname, email, ph, password, cpassword));
	}
	
	public boolean doRegistration(String fname,String lname,String email,String ph,String password,String cpassword){
		
		driver.findElement(By.id("input-firstname")).sendKeys(fname);
		driver.findElement(By.id("input-lastname")).sendKeys(lname);
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-telephone")).sendKeys(ph);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.id("input-confirm")).sendKeys(cpassword);
		driver.findElement(By.xpath("//label[@class='radio-inline']/input[@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		String confmXpth="//h1[contains(text(),'Your Account Has Been Created!')].getText()";
		if(confmXpth.contains("Account Has Been Created!")){
			
		driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Logout']")).click();
		driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Register']")).click();
		
		return true;
		}
		return false;
	}

}
