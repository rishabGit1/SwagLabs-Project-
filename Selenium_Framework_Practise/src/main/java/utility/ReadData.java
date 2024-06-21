package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData
{
	public static String readPropertyFile(String value) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\risha\\eclipse-workspace\\14March_Selenium_Framework\\src\\main\\java\\config\\config.properties");
		prop.load(file);
		return prop.getProperty(value);
		
	}//config propertiess
	
	public static String getDataFromExcel(int rowvalue ,int colvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\risha\\eclipse-workspace\\Selenium_Framework_Practise\\Excel_File\\Book6.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = excel.getRow(rowvalue).getCell(colvalue).getStringCellValue();
		return value;
		
	}
	public static String loginDataFromExcel(int rowvalue ,int colvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\risha\\eclipse-workspace\\Selenium_Framework_Practise\\Excel_File\\Book6.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet2");
		String value = excel.getRow(rowvalue).getCell(colvalue).getStringCellValue();
		return value;
		
	}
	public static String inventoryDataFromExcel(int rowvalue ,int colvalue) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\risha\\eclipse-workspace\\Selenium_Framework_Practise\\Excel_File\\Book6.xlsx");
		Sheet excel = WorkbookFactory.create(file).getSheet("Sheet3");
		String value = excel.getRow(rowvalue).getCell(colvalue).getStringCellValue();
		return value;
		
	}
}
