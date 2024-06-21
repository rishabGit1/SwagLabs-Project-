package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase2;
import pages.Inventory_Page2;
import pages.LoginPage2;
import utility.Failed_Tests_Screenshot;
import utility.ReadData;

public class nventory_Page2_Test extends TestBase2
{

	LoginPage2 login;
	Inventory_Page2 invent;
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		driverSetUp();
		login = new LoginPage2();
		invent = new Inventory_Page2();
		login.loginToApplication();
		
	}
	
	@Test(enabled = true)
	public void add2productsTest() throws EncryptedDocumentException, IOException
	{
		String expCount =ReadData.inventoryDataFromExcel(0, 0);
		String actCount = invent.add2products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count = "+ actCount);
		
	}
	@Test(enabled = false)
	public void remove1productTest() throws EncryptedDocumentException, IOException
	{
		String expCount = ReadData.inventoryDataFromExcel(1, 0);//(1,0);
		String actCount = invent.remove1product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count = "+ actCount);
	}
	
	
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		
		if(ITestResult.FAILURE==it.getStatus())
		{
			Failed_Tests_Screenshot.sc(it.getName());
		}
		driver.close();
	}
	
	
	
}
