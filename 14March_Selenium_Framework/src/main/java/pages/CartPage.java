package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	//object repository
		@FindBy(xpath = "//div[text()='Swag Labs']")private WebElement SwagLabsTitle;
		@FindBy(xpath = "//span[text()='Your Cart']")private WebElement yourCartTitle;
		@FindBy(xpath = "//div[text()='QTY']")private WebElement qtyTxtCartPage;
		@FindBy(xpath = "//div[text()='Description']")private WebElement discriptionTxtCartPage;
		@FindBy(xpath =  "//button[@id=\"checkout\"]")private WebElement checkoutBtn;
		
		
		public CartPage()
		{
			PageFactory.initElements(driver,this);
		}
		public String verifyPageURL()
		{
			return driver.getCurrentUrl();
			
		}
		
		public String verifyPageTitle()
		{
			return yourCartTitle.getText();
			
		}
		public String clickonCheckOutBtn()
		{
			checkoutBtn.click();
			return driver.getCurrentUrl();
			
		}
		
		 
		
		
		
}
