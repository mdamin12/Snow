package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.ReadProperties;

public class Driver extends ReadProperties{
	
	public static WebDriver driver;
	
	public void setDriver(){
		
		if(getProperty("browser").equalsIgnoreCase("firefox")){
			initFirefox();
		}else{
			initFirefox();	
		}
		
		setDriverProperties();
	}
	
	
		
		public void initFirefox(){
			
			driver = new FirefoxDriver();
			
		
	}
		public void initChrome(){
			System.setProperty("webdriver.chrome.driver", "chrome driver path");
			
			driver = new ChromeDriver();
		}
		public void setDriverProperties(){
			driver.manage().window().maximize();
			driver.get(getProperty("appUrl"));
			
		}

}
