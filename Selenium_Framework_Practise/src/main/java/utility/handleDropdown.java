package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class handleDropdown 
{

	public static void handleSelect(WebElement el, String value)
	{
		Select s = new Select(el);
		s.selectByVisibleText(value);
	}
	
	
}
