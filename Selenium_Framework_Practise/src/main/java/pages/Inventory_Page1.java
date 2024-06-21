package pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.devtools.v113.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase1;

public class Inventory_Page1 extends TestBase1
{

	//objest repository 
	@FindBy(xpath ="//button[@name=\"add-to-cart-sauce-labs-backpack\"]") private WebElement backPackBtn;
	@FindBy(xpath = "//button[@name=\"add-to-cart-sauce-labs-bike-light\"]") private WebElement bikeLightsBtn;
	@FindBy(xpath = "//span[text()='Products']") private WebElement productText;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//select[@class=\"product_sort_container\"]") private WebElement dropDown;
	@FindBy(xpath = "//span[@class=\"shopping_cart_badge\"]") private WebElement cartCount;
	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]") private WebElement cartIcon;
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")private WebElement backPackProduct;
    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")private WebElement sauceLabsText;
    @FindBy(xpath = "//span[@class=\"title\"]")private WebElement CartPageTitle;
  

  
	
	//calling
	 public Inventory_Page1()
	 {
		 PageFactory.initElements(driver,this);
	 }
	//methods
	public String verifPageTitle()
	{
		return CartPageTitle.getText();
		
	}
	/*public Boolean verifyTwitterLogo() 
	{
		return twitterLogo.isDisplayed();
		
	}
	public String addProducts()
	{
	
		Select s = new Select(dropDown);
		s.selectByVisibleText("Name (Z to A)");
		backPackBtn.click();
		bikeLightsBtn.click();
		return cartIcon.getText();
		
	}*/
	
	public void ClickOncartIcon()
	{
		cartIcon.click();
	}
	
	
}
