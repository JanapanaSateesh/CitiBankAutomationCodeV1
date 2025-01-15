package com.citibank.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.citibank.pages.LoginPageObjects;
import com.citibank.utilities.ReadDataDataprovider;

public class CitiBank_LoginTest extends Base {
	
	LoginPageObjects loginpage;

	@Test(enabled = true, priority = 1,dataProviderClass = ReadDataDataprovider.class,dataProvider = "TC001_TestData",groups = {"regression","smoke"})
	public void TC001_LoginTest_LoginWithValidCredentials(String username, String password) {
		 loginpage=new LoginPageObjects(driver.get());
		loginpage.LoginWithValidCredentials(username, password);
		
	}
	
	@Test(enabled = true,priority = 2, dataProviderClass = ReadDataDataprovider.class,dataProvider = "TC002_TestData",groups = {"regression"},dependsOnMethods = "TC001_LoginTest_LoginWithValidCredentials")
	public void TC002_LoginTest_LoginWithValidUsernameAndInValidPassword(String username, String invalidpwd) {
		 loginpage=new LoginPageObjects(driver.get());
		loginpage.LoginWithValidUserNameAndInValidPassword(username, invalidpwd);
	}
	
	@Test(enabled = true, priority = 3, dataProviderClass = ReadDataDataprovider.class,dataProvider = "TC003_TestData",groups = {"regression"} )
	public void TC003_LoginTest_LoginWithInValidUserNameAndValidPassword(String invaliduname, String pwd) {
		loginpage=new LoginPageObjects(driver.get());
		loginpage.LoginWithInValidUserNameAndValidPassword(invaliduname, pwd);
	}
	
	@Test(enabled = true, priority = 4,groups = {"regression"})
	public void TC004_LoginTest_LoginWithOutCredentials() {
		loginpage=new LoginPageObjects(driver.get());
		loginpage.LoginWithOutCredentials();
	}
	
	@Test(enabled = true, priority = 5,dataProviderClass = ReadDataDataprovider.class,dataProvider = "TC005_TestData",groups = {"regression","sanity"})
	public void TC005_LoginTest_LoginWithWrongCredentials(String wronguname, String wrongpwd) {
		loginpage=new LoginPageObjects(driver.get());
		loginpage.LoginWithWrongCredentials(wronguname, wrongpwd);
	}
	
	@Test(enabled = true, priority = 6, dataProviderClass = ReadDataDataprovider.class,dataProvider = "TC006_TestData",groups = {"regression","smoke"})
	public void TC006_LoginTest_LoginWithValidCredentialsUsingEnter(String uname, String pwd) {
		loginpage=new LoginPageObjects(driver.get());
		loginpage.LoginWithValidCredentialsUsingEnter(uname, pwd);
	}
	

}
