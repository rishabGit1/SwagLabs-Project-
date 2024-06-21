package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import base.TestBase1;
import pages.LoginPage;
import pages.LoginPage1;

public class LoginTest_Page1 extends TestBase1
{
	LoginPage1 login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage1();
	}
	@Test
	public void loginToApplicationTest() throws IOException
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=login.loginToApplication();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Login Successful= " + actURL);
	}
	@Test
	public void verifyURLOfApplicationTest()
	{
		String expURL="https://www.saucedemo.com/";
		String actURL=login.verifyURLOfApplication();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("The URL of SWag lab = " +actURL);
	}
	@Test
	public void verifyTitleOfApplicationTest()
	{
		String expTitle="Swag Labs";
		String actTitle=login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Tilte of application = " +actTitle);
		
	}
	
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
		
	}
}

