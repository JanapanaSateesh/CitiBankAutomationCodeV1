package com.citibank.testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.citibank.utilities.ReadConfigData;

public class Base {

	//public WebDriver driver;
	ReadConfigData configdata;
	
	public  ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	//PR Raising
	
	
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void SetUp(ITestContext context, String browser) throws IOException {
		
		//Read the Confog.properties data
		configdata=new ReadConfigData();
		String url=configdata.getUrl();
        System.out.println("Browser Value from testng.xml:"+browser);
      
        switch(browser.toUpperCase()) 
        {
        case "CHROME":driver.set(new ChromeDriver());
        break;
        
        case "EDGE":driver.set(new EdgeDriver());
        break;
        
        default:throw new IllegalArgumentException("Enter the correct browser");
        }
			
		
		
		context.setAttribute("driver", driver);
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get().manage().window().maximize();
		driver.get().get(url);
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void TearDown() {
		driver.get().quit();
		
	}
	
	
	
}
