package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class DriverFactory {

    public enum BrowserType {
        FIREFOX("firefox"),
        CHROME("chrome");

        private String value;

        BrowserType(String value) {this.value = value;}

        public String getBrowserName () {return this.value;}
    }

    public static WebDriver getDriver(BrowserType type, boolean useGrid) throws Exception {
        WebDriver driver = null;

        if(useGrid){
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setBrowserName(type.getBrowserName());
            desiredCapabilities.setPlatform(Platform.WINDOWS);
            return new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), desiredCapabilities);
        }

        switch (type) {
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                return new FirefoxDriver();
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                return new ChromeDriver();
            default:
                return new ChromeDriver();
        }
    }
}