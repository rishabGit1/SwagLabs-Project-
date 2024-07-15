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
import pages.CheckOut_Step_Two_Page;
import pages.Check_Out_Step_One_Page;
import pages.Checkout_Complete_Page;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class Checkout_Complete_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	Check_Out_Step_One_Page check1;
	CheckOut_Step_Two_Page check2;
	Checkout_Complete_Page complete;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		check1 = new Check_Out_Step_One_Page();
		check2 =new CheckOut_Step_Two_Page();
		complete =new Checkout_Complete_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickonCheckOutBtn();
		check1.inputInformation();
		check2.clickOnFinishBtn();
		}
	
	@Test
	public void verifyCompletepageURL()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=complete.verifyCompletepageURL();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Complete page URL = "+actURL);
	}
	@Test
	public void verifyCompletePageTitle()
	{
		String expTitle="Checkout: Complete!";
		String actTitle=complete.verifyCompletePageTitle();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("CompletePage Title = "+actTitle);
	}
	@Test
	public void verifyImage()
	{
		boolean image = complete.verifyImage();
		Assert.assertEquals(image,true);
		Reporter.log("image is present = " + image);
	}
	@Test
	public void verifyThankYouTxt()
	{
		String expTxt="Thank you for your order!";
		String actTxt=complete.verifyThankYouTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("text = "+actTxt);	
	}
	@Test
	public void verifyParagraphTxt()
	{
		String expTxt="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actTxt=complete.verifyParagraphTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("paragraph text = "+actTxt);	
	}
	@Test
	public void verifyBackHomebtn()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=complete.verifyBackHomebtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("after clicking backhome btn  redricted to URL = "+actURL);
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
