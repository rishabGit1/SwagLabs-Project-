package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase1;
import pages.CartPage1;
import pages.Inventory_Page1;
import pages.LoginPage1;

public class CartPage_Test1 extends TestBase1
{
	LoginPage1 login;
	Inventory_Page1 inventory;
	CartPage1 cart;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage1();
		inventory =new Inventory_Page1();
		cart =new CartPage1();
		login.loginToApplication();
		inventory.ClickOncartIcon();
	}
	
	@Test
	public void verifyCartPageURLTest()
	{
		String expURL = "https://www.saucedemo.com/cart.html";
		String actURL = cart.verifyCartPageURL();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Cart Page URL = "+actURL);
	}
	@Test
	public void verifyCartTitleTest()
	{
		 Reporter.log(driver.getTitle());
		
	}
	@Test
	
	public void clickonCheckOutBtnTest()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-one.html";
		String actURL = cart.ClickOnCheckout();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Checkpage step one URL = "+actURL);
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	
}
