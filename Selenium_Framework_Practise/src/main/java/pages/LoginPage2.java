package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase2;
import utility.ReadData;

public class LoginPage2 extends TestBase2
{

	@FindBy(xpath = "//input[@id=\"user-name\"]")private WebElement usernameTxtBox;
	@FindBy(xpath = "//input[@id=\"password\"]") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@id=\"login-button\"]") private WebElement loginBtn;
	
	
	
	public LoginPage2()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyPageURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public String multiCredLogin(String un ,String pass)
	{
		usernameTxtBox.sendKeys(un);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String loginToApplication() throws EncryptedDocumentException, IOException
	{
		usernameTxtBox.sendKeys(ReadData.loginDataFromExcel(0, 0));
		passwordTxtBox.sendKeys(ReadData.loginDataFromExcel(0, 1));
		loginBtn.click();
		
		return driver.getCurrentUrl();
		
	}
	

	
}
