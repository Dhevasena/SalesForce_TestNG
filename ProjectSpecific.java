package indepencedaymarathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecific {

	RemoteWebDriver driver;
	String excelName;
	String browserName="chrome";
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void LaunchBrowser(String url,String username,String password )
	{
		if(browserName.equals("chrome"))
		{
			// call webdriver manager
			WebDriverManager.chromedriver().setup();
			//Disable browser notification
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//Launch chrome browser
			driver=new ChromeDriver(options);
			//Open URL
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			//Disable browser notification
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--disable-notifications");
			//Launch Edge browser
			driver=new EdgeDriver(options);
		}
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Open Sales force
		driver.get(url);
		//Maximize
		driver.manage().window().maximize();
		//Username
		driver.findElement(By.id("username")).sendKeys(username);
		//password
		driver.findElement(By.id("password")).sendKeys(password);
		//Click Login
		driver.findElement(By.id("Login")).click();
		//Click on the App Launcher (dots)
		driver.findElement(By.className("slds-icon-waffle")).click();
		//Click on view all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Type Content on the Search box

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
