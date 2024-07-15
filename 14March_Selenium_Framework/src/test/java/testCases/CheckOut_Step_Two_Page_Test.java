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
import pages.Inventory_Page;
import pages.LoginPage;
import utility.Screenshot;

public class CheckOut_Step_Two_Page_Test extends TestBase
{

	LoginPage login;
	Inventory_Page invent;
	CartPage cart;
	Check_Out_Step_One_Page check1;
	CheckOut_Step_Two_Page check2;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException, InterruptedException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		cart=new CartPage();
		check1 = new Check_Out_Step_One_Page();
		check2 =new CheckOut_Step_Two_Page();
		login.loginToApplication();
		invent.add6Products();
		invent.clickOnCart();
		cart.clickonCheckOutBtn();
		check1.inputInformation();
		
	}
	@Test
	public void verifyQTYTextTest()
	{
		String expTxt="QTY";
		String actTxt=check2.verifyQTYText();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Checkout Page 2 Text = "+actTxt);
	}
	@Test
	public void verifyCheckOutTwoTitleTest()
	{
		String expTitle="Checkout: Overview";
		String actTitle=check2.verifyCheckOutTwoTitle();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Checkout Page Two Title = "+actTitle);
	}
	@Test
	public void verifyDescripTxtTest()
	{
		String expTxt="Description";
		String actTxt=check2.verifyDescripTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Checkout Page 2 Desc Text = "+actTxt);
	}
	@Test
	public void verifyProductTxt()
	{
		String expTxt="Sauce Labs Bike Light";
		String actTxt=check2.verifyProductTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Checkout Page 2 Product Text = "+actTxt);
	}
	@Test
	public void verifyPaymentTxtTest() 
	{
		String expTxt="Payment Information:";
		String actTxt=check2.verifyPaymentTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Checkout Page 2 Payment Text = "+actTxt);
	}
	@Test
	public void verifySauceTxtTest()
	{
		String expTxt="SauceCard #31337";
		String actTxt=check2.verifySauceTxt();
		Assert.assertEquals(expTxt,actTxt);
		Reporter.log("Checkout Page 2 SauceCard Text = "+actTxt);
	}
	@Test
	public void VerifyClickOnCancelbtnTest()
	{
		String expURL="https://www.saucedemo.com/inventory.html";
		String actURL=check2.VerifyClickOnCancelbtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Checkout Page 2 AfterClicking Cancelbtn = "+actURL);
	}
	@Test
	public void verifyClickOnFinishBtnTest()
	{
		String expURL="https://www.saucedemo.com/checkout-complete.html";
		String actURL=check2.verifyClickOnFinishBtn();
		Assert.assertEquals(expURL,actURL);
		Reporter.log("Checkout Page 2 AfterClicking finishbtn = "+actURL);
	}
	@Test 
	public void verifyTwitterLogoTest()
	{
		 boolean logo = check2.verifyTwitterLogo();
		 Assert.assertEquals(logo, true);
		 Reporter.log("Twitter logo is Present = "+logo);
	}
	@Test
	public void verifyFacebooklogoTest()
	{
		 boolean logo = check2.verifyFacebooklogo();
		 Assert.assertEquals(logo, true);
		 Reporter.log("Facebook logo is Present = "+logo);
	}
	@Test
	public void verifyLinkdinLogoTest()
	{
		 boolean logo = check2.verifyLinkdinLogo();
		 Assert.assertEquals(logo, true);
		 Reporter.log("Linkdin logo is Present = "+logo);
	}

	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE==it.getStatus())
		{
			Screenshot.cs(it.getName());
		}
		driver.close();
	}
	
}
