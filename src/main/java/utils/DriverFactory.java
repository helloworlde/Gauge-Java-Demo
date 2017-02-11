package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author HelloWood
 * @create 2017-02-11 15:58
 * @email hellowoodes@gmail.com
 * @Description for init WebDriver by different environment
 **/

public class DriverFactory {

    private static final String DRIVERNAME = System.getenv("drivername");
    private static final String DRIVERPATH = System.getenv("driverpath");

    private static final String CHROME = "chrome";
    private static final String EDGE = "edge";
    private static final String IE = "ie";
    private static final String DEFAULT = "chrome";
    private static final String FIREFOX = "firefox";

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * init WebDriver before begin test
     */
    @BeforeSuite
    public void setUp() {

        String browser = System.getenv("BROWSER");
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.toLowerCase().equals(CHROME)) {
            System.setProperty(DRIVERNAME, DRIVERPATH);
            driver = new ChromeDriver();
        } else if (browser.toLowerCase().equals(EDGE)) {
            System.setProperty(DRIVERNAME, DRIVERPATH);
            driver = new EdgeDriver();
        } else {
            System.setProperty(DRIVERNAME, DRIVERPATH);
            driver = new InternetExplorerDriver();
        }
    }

    /**
     * close browser after tests
     */
    @AfterSuite
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
