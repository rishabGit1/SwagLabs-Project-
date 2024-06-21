package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase2;
import net.bytebuddy.asm.MemberSubstitution.Substitution.Chain.Step.ForField.Read;
import pages.LoginPage2;
import utility.Failed_Tests_Screenshot;
import utility.ReadData;

public class LoginPage2_Test extends TestBase2
{
	LoginPage2 login;
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		driverSetUp();
		login = new LoginPage2();
	}
	
	
  @Test
  public void verifyPageURLTest() throws EncryptedDocumentException, IOException
  {
	  String expURL = ReadData.getDataFromExcel(0, 0);//(0,0)
	  String actURL = login.verifyPageURL();
	  Assert.assertEquals(expURL, actURL);
	  Reporter.log("Page URL =" + actURL);
	  
  }
  @Test
  public void verifyPageTitleTest() throws EncryptedDocumentException, IOException
  {
	  String expTitle =ReadData.loginDataFromExcel(0, 2);
	  String actTitle = login.verifyPageTitle();
	  Assert.assertEquals(expTitle, actTitle);
	  Reporter.log("Page Title =" + actTitle);
	  
  }
  @Test
  public void loginToApplicationTest() throws EncryptedDocumentException, IOException
  {
	  String expURL = ReadData.loginDataFromExcel(0, 3);//(0,3)
	  String actURL = login.loginToApplication();
	  Assert.assertEquals(expURL, actURL);
	  Reporter.log("After Login URL =" + actURL);
	  
  }
  @DataProvider(name="Validation")
  public Object[][] getData()
  {
	  return new Object [][]
			  {
		  {"standard_user","secret_sauce"},
		  {"locked_out_user","secret_sauce"},
		  {"problem_user","secret_sauce"},
		  {"performance_glitch_user","secret_sauce"},
		  {"error_user","secret_sauce"},
		  {"visual_user","secret_sauce"}
		  
			  };

  };
  
  @Test(dataProvider = "Validation")
  public void multiCredLoginTest(String un ,String pass)
  {
	  SoftAssert s= new SoftAssert();
	  String expURL="https://www.saucedemo.com/inventory.html";
	  String actURL=login.multiCredLogin(un, pass);
	  s.assertEquals(expURL, actURL);
	  s.assertAll();
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
