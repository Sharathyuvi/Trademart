package Com_Para_TestCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import freemarker.log.Logger;
import lombok.extern.log4j.Log4j;

/* A Hybrid Framework in software testing (especially in Selenium automation with Java/TestNG) is a
 * combination of two or more testing frameworks to take advantage of their best features. Instead of relying on just one approach 
 * (like Data-Driven or Keyword-Driven), a hybrid integrates multiple methodologies into a single, flexible framework.
 */
public class Para_BaseClass {
	
	public static WebDriver driver;
	public ResourceBundle rb;
	public Logger log;
	
	@BeforeSuite
	@Parameters({"browser","URL"})
	public void openApplication(String br, String url) {
		
		if(br.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		rb = ResourceBundle.getBundle("Testdata");
			log= Logger.getLogger("EMS_LMS");
		PropertyConfigurator.configure("log4j.properties");
	}
	
public String capturescreenshot(String tname) {
		
	// script for timestamp
		String Timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src =  screenshot.getScreenshotAs(OutputType.FILE);
		String Target = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+Timestamp +".png";
		
		try {
			FileUtils.copyFile(src, new File(Target));
		} catch (Exception e) {
			
			e.getMessage();
		}
		return Target;
}
	
	@AfterSuite
	public void closeApplication() {
		driver.close();
	}

}
