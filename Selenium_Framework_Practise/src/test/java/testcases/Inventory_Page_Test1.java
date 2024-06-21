package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base.TestBase1;
import pages.Inventory_Page1;
import pages.LoginPage1;



public class Inventory_Page_Test1 extends TestBase1
{
	LoginPage1 login;
	Inventory_Page1 inventory;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage1();
		inventory =new Inventory_Page1();
		login.loginToApplication();
	}
	@Test
	public void verifyCartPageTitle()
	{
		String expTitle = "Products";
		String actTitle = inventory.verifPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Cart Page Title = "+actTitle);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	

	
}
