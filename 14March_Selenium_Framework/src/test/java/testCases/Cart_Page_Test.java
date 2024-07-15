package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{
	
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart =new CartPage();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
	}
	@Test
	public void verifyPageURLTest()
	{
		String expURL = "https://www.saucedemo.com/cart.html";
		String actURL = cart.verifyPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("cart page URL = "+actURL);
	}
	@Test
	public void verifyPageTitleTest()
	{
		String expTitle = "Your Cart";
		String actTitle = cart.verifyPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("cart page title = "+actTitle);
	}
	@Test
	public void clickonCheckOutBtnTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-one.html";
		String actURL = cart.clickonCheckOutBtn();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkpage step one URL = "+actURL);
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close();
	}

}
