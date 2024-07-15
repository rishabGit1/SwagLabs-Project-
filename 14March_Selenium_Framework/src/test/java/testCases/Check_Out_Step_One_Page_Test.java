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
import pages.Check_Out_Step_One_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Check_Out_Step_One_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	Check_Out_Step_One_Page check1;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		check1 = new Check_Out_Step_One_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickonCheckOutBtn();
	}
	@Test
	public void inputInformationTest()
	{
		String expURL="https://www.saucedemo.com/checkout-step-two.html";
		String actURL=check1.inputInformation();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Checkout Page 2 URL = "+actURL);
	}
	@Test
	public void verifyCanclebtnTest()
	{
		String expURL="https://www.saucedemo.com/cart.html";
		String actURL=check1.verifyCanclebtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Cancle button url = "+actURL);
	}
	@Test
	public void verifyYourInfoTxtTest()
	{

		String expTxt="Checkout: Your Information";
		String actTxt=check1.verifyYourInfoTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Checkout page 1 txt = "+actTxt);
		
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
