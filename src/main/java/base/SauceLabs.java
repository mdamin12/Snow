package base;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class SauceLabs extends Driver {
	DesiredCapabilities caps;

	public void setSauceLabs() {

		String USERNAME = getSaucelabesProperty("userName");
		String ACCESS_KEY = getSaucelabesProperty("accessKey");
		String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
		
		setCapabilities();
		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(getProperty("appUrl"));
		 

	}

	private void setCapabilities() {
		if (getSaucelabesProperty("browser").equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		} else if (getSaucelabesProperty("browser").equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		} else if (getSaucelabesProperty("browser").equalsIgnoreCase("ie")) {
			caps = DesiredCapabilities.internetExplorer();
		} else if (getSaucelabesProperty("browser").equalsIgnoreCase("safari")) {
			caps = DesiredCapabilities.safari();
		} else {
			caps = DesiredCapabilities.firefox();
		}

		caps.setCapability("platform",getSaucelabesProperty("platfrom") );
		caps.setCapability("version", "browerVerson");

	}

}
