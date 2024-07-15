package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Inventory_Page;
import pages.LoginPage;
import utility.ReadData;
import utility.Screenshot;

public class Inventory_Page_Test extends TestBase
{
	LoginPage login;
	Inventory_Page invent;
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		initialization();
		login=new LoginPage();
		invent=new Inventory_Page();
		login.loginToApplication();
	}
	@Test(groups = "Sanity",priority = 1)
	public void verifyTwitterLogoTest()
	{
		boolean result = invent.verifyTwitterLogo();
		Assert.assertEquals(result,true);
		Reporter.log("Twitter Logo is present= "+result);
	}
	@Test(groups = "Skip",priority = 2)
	public void add6Products() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExel(0,3);//(0,3)
		String actCount=invent.add6Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products add to the cart = "+actCount);
	}
	@Test(groups = "Skip",priority = 3)
	public void remove2ProductsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readExel(0,4);//4(0,4)
		String actCount=invent.remove2Products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products after removed to the cart = "+actCount);
	}
	@Test(groups = "Skip",priority = 4)
	public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readExel(0,5);//Products(0,5)
		String actTitle=invent.verifyPageTitle();
		Assert.assertEquals(expTitle,actTitle);
		Reporter.log("Inventory page title = "+actTitle);
	}
	@Test( priority = 5)
	public void  verifybagTitleTest()
	{
		String expTitle = "Sauce Labs Backpack";
		String actTitle = invent.verifybagTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Inventory bagpacktitle title = "+actTitle);
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

