package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase2;
import utility.handleDropdown;

public class Inventory_Page2 extends TestBase2
{

	@FindBy(xpath = "//span[text()='Products']") private WebElement pageTitle;
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") private WebElement productBagpack;
	//@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']") private WebElement prductBikeLight;
	@FindBy(xpath = "//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']") private WebElement paraTxt; 
	@FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-backpack\"]") private WebElement addToCartBtn;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement TwitterLogo;
    @FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
    @FindBy(xpath = "//a[text()='LinkedIn']") private WebElement LinkedinLogo;
    @FindBy(xpath = "//select[@class=\"product_sort_container\"]") private WebElement dropdown;
    @FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-backpack\"]") private WebElement bagpack ;
    @FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-bike-light\"]") private WebElement bikeLight ;
    @FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]") private WebElement tshirt;
    @FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]") private WebElement jacket ;
    @FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-onesie\"]") private WebElement tshirt2;
    @FindBy(xpath = "//button[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]") private WebElement tshirt3 ;
  
    @FindBy(xpath = "//a[@class=\"shopping_cart_link\"]") private WebElement cartbtn ;
    @FindBy(xpath = "//button[@id=\"remove-sauce-labs-fleece-jacket\"]")private WebElement removeJacket;

    
    
	public Inventory_Page2()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public String add2products()
	{
		handleDropdown.handleSelect(dropdown,"Price (high to low)");
	    jacket.click();
	    bagpack.click();
	    return cartbtn.getText();
		
	}
	public String remove1product()
	{
		add2products();
		removeJacket.click();
		return cartbtn.getText();
		
	}
	

}