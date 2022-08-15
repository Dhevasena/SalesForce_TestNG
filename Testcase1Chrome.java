package indepencedaymarathon;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week6.day1.classroomactivity.ReadExcelSheet;

public class Testcase1Chrome extends ProjectSpecific{
	String  browsername="chrome";
	 @DataProvider(name="tc1")
	 public String[][] getData() throws IOException
	 {
		 String[][] data =ReadExcelSheet.getExceldata("tc1data");
		 return data;
	 }
	
    @Test(dataProvider="tc1")
	public void caseOne(String Q1,String Q2) throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content");
		//click content link
		driver.findElement(By.xpath("//p/mark[text()='Content']")).click();
		//Click on Chatter Tab-java script to handle the page
		WebElement chatter = driver.findElement(By.xpath("//span[text()='Chatter']"));
		driver.executeScript("arguments[0].click();", chatter);
		//Verify Chatter title on the page
		String title = driver.getTitle();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleContains("chatter"));
		if (title.contains("chatter")) {
			System.out.println("The page title contains Chatter:"+title);	
		}
		//Click Question tab
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		//Type the question
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(Q1);
		String Question=driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).getText();
		System.out.println(Question);
		//Type the answer
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank slds-rich-text-area__content slds-text-color_weak slds-grow']")).sendKeys(Q2);
		//Click ask
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		//Confirm the question appears
		String confirm=driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText();
		if (Question.equalsIgnoreCase(confirm))
		{
			System.out.println(confirm);
		}
		System.out.println(confirm);	

	}

}
