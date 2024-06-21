package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase1;
import utility.ReadData;

public class LoginPage1 extends TestBase1
{
	//object repository
	@FindBy(xpath="//input[@id='user-name']") private WebElement userTxtBox;
	@FindBy(xpath="//input[@id='password']") private WebElement passWordTxtBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement loginBtn;

	
	public LoginPage1()
	{
		PageFactory.initElements(driver,this);
	}
	public String loginToApplication() throws IOException
	{
		userTxtBox.sendKeys(ReadData.readPropertyFile("Username"));
		passWordTxtBox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyURLOfApplication()
	{
		return driver.getCurrentUrl();	
	}
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	

}//logic


