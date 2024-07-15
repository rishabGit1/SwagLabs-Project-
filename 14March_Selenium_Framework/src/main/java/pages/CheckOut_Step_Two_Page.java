package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Step_Two_Page extends TestBase

{
	public CheckOut_Step_Two_Page()
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='QTY']") private WebElement qtyPageTxt;
	@FindBy(xpath = "//span[text()='Checkout: Overview']") private WebElement checkOutPageTwoTitle;
	@FindBy(xpath = "//div[text()='Description']")private WebElement descriptionText;
	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']")private WebElement bikeLightProductText;
	@FindBy(xpath = "(//div[@class=\"inventory_item_desc\"])[1]")private WebElement bikeLightParaText;
	@FindBy(xpath = "//div[text()='9.99']")private WebElement itemPriceText;
	@FindBy(xpath = "//div[text()='Payment Information:']")private WebElement paymentInfoText;
	@FindBy(xpath = "//div[text()='SauceCard #31337']")private WebElement sauceCardText;
	@FindBy(xpath = "//button[text()='Finish']")private WebElement finishButton;
	@FindBy(xpath = "//button[text()='Cancel']")private WebElement cancelhButton;
	@FindBy(xpath = "//a[text()='Twitter']")private WebElement twitterLogo;
	@FindBy(xpath ="//a[text()='Facebook']" )private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']")private WebElement linkdinLogo;
	

	
	public String verifyQTYText()
	{
		return qtyPageTxt.getText();
		
	}
	public String verifyCheckOutTwoTitle()
	{
		return checkOutPageTwoTitle.getText();
		
	}
	public String verifyDescripTxt()
	{
		return descriptionText.getText();
		
	}
	public String verifyProductTxt()
	{
		return bikeLightProductText.getText();
		
	}
	public String verifybikeLightParatxt()
	{
		return bikeLightParaText.getText();
		
	}
	public String veriftItemPrice()
	{
		return itemPriceText.getText();
		
	}
	public String verifyPaymentTxt()
	{
		return paymentInfoText.getText();
	}
	public String verifySauceTxt()
	{
		return sauceCardText.getText();
	}
	public String VerifyClickOnCancelbtn()
	{
		 cancelhButton.click();
		return driver.getCurrentUrl();
		
	}
	public String verifyClickOnFinishBtn()
	{
		finishButton.click();
		return driver.getCurrentUrl();
	}
	public boolean verifyTwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	public boolean verifyFacebooklogo()
	{
		return facebookLogo.isDisplayed();
	}
	public boolean verifyLinkdinLogo()
	{
		return linkdinLogo.isDisplayed();
	}
	public String clickOnFinishBtn()
	{
		finishButton.click();
		return driver.getCurrentUrl();
	}
	
}

