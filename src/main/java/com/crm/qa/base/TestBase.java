package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public String excelfile="C:\\Users\\Desktop\\CRM\\ProjectFreeCRM\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx";	

	
     public TestBase(){
		try{
			prop= new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Subhajit\\git\\ProjectThanos\\src\\main\\java\\com\\crm\\qa\\config\\config.propirties");
		prop.load(ip);
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		}
     }
			public static void initialization(){
			String browsername= prop.getProperty("browser");
			
			if (browsername.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Subhajit\\Desktop\\NotePad\\chromedriver.exe");
				driver = new ChromeDriver();
				
				e_driver = new EventFiringWebDriver(driver);
						// Now create object of EventListerHandler to register it with EventFiringWebDriver
						eventListener = new WebEventListener();
						e_driver.register(eventListener);
						driver = e_driver;
			}else
			if (browsername.equals("firefox")){
					System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
					driver = new FirefoxDriver();
					}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}
		
		
}

