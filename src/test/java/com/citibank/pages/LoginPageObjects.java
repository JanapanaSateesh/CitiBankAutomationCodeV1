package com.citibank.pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.citibank.commands.UICommands;
import com.citibank.utilities.ExtentListner;

import junit.framework.Assert;

public class LoginPageObjects {

	WebDriver ldriver;
	public final static Logger logger=LogManager.getLogger("rootLogger");
	
	public  LoginPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath = "//input[@name='uid']") WebElement object_username;
	// WebElement username= driver.findelement(By.xpath(""));
	
	@FindBy(xpath = "//input[@name='password']") WebElement object_password;
	
	@FindBy(xpath = "//input[@name='btnLogin']") WebElement object_login;
	
	
	public void enterUserName(String uname) {
		try {
			UICommands.ExplicitWait(ldriver, object_username);
			
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			object_username.sendKeys(uname);
			test.log(Status.PASS, "Username entered:"+uname);
			logger.info("Entered Username: "+uname);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			 //It prints description + the line number it got failed
			logger.error(e.getMessage()); //It prints only error decrptipn
			throw e;
			//Assert.fail();
			
		}
		
	}
	
	public void enterPassword(String pwd) {
		try {
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			object_password.sendKeys(pwd);
			test.log(Status.PASS, "Password entered:"+"****");
			logger.info("Entered Username: "+pwd);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw e;
		}
		
	}
	
	public void loginButton() {
		try {
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			object_login.click();
			test.log(Status.PASS, "Clicked on login button");
			logger.info("Clicked on login ");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw e;
		}
		
	}
	
	public void hitEnterButton() {
		try {
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			object_password.sendKeys(Keys.ENTER);
			test.log(Status.PASS, "Hit Enter");
			logger.info("Hit enter ");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			throw e;
		}
		
	}
	
	public void LoginWithValidCredentials(String uname, String pwd) {
		enterUserName(uname);
		enterPassword(pwd);
		loginButton();
	}
	
	public void LoginWithValidUserNameAndInValidPassword(String uname, String pwd) {
		enterUserName(uname);
		enterPassword(pwd);
		loginButton();
	}
	
	public void LoginWithInValidUserNameAndValidPassword(String uname, String pwd) {
		enterUserName(uname);
		enterPassword(pwd);
		loginButton();
	}
	
	public void LoginWithOutCredentials() {
		loginButton();
	}
	
	public void LoginWithWrongCredentials(String uname, String pwd) {
		enterUserName(uname);
		enterPassword(pwd);
		loginButton();
	}
	
	public void LoginWithValidCredentialsUsingEnter(String uname, String pwd) {
		enterUserName(uname);
		enterPassword(pwd);
		hitEnterButton();
	}
	
	
	
	
	
}
