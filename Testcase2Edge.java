package indepencedaymarathon;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week6.day1.classroomactivity.ReadExcelSheet;


public class Testcase2Edge extends ProjectSpecific {
	String  browsername="edge";
	 @DataProvider(name="tc2")
	 public String[][] getData() throws IOException
	 {
		 String[][] data =ReadExcelSheet.getExceldata("tc2data");
		 return data;
		 
	 }
	
   @Test(dataProvider="tc2")
	public void CaseTwo(String salutation) throws InterruptedException {
		
		//Type  Individuals  on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
		//click Individuals link
		driver.findElement(By.xpath("//p/mark[text()='Individuals']")).click();
		//Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Select Salutation with data 
		driver.findElement(By.xpath("//a[@class='select']")).click();
        //String salutation = "Ms.";
        driver.findElement(By.xpath("//a[text()='"+salutation+"']")).click();
		//Type Last name
		driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Ravikumar");
		String customer=driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).getText();
		//Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		//Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click on view all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Type Customers on the Search box
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Customers");
		//click Individuals link
		driver.findElement(By.xpath("//p/mark[text()='Customers']")).click();
		Thread.sleep(2000);
		//Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Type the same name provided in step 8 and confirm it appears
		String Confirm=driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']")).getText();
		if(customer.equalsIgnoreCase(Confirm))
		{
			System.out.println("Same content");
		}
	}

}
