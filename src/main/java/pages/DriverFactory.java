package pages;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * Created by viche on 2/10/2017.
 */
public class DriverFactory {

    private static final String DRIVERNAME = System.getenv("drivername");
    private static final String DRIVERPATH = System.getenv("driverpath");

    private static final String CHROME = "chrome";
    private static final String IE = "ie";
    private static final String DEFAULT = "chrome";
    private static final String FIREFOX = "firefox";
    private static WebDriver driver;


    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void setUp() {


        String browser = System.getenv("BROWSER");
        if (browser == null) {
            browser = DEFAULT;
        }

        if (browser.toLowerCase().equals(FIREFOX)) {
//            driver = new FirefoxDriver();
        } else if (browser.toLowerCase().equals(CHROME)) {
            System.setProperty(DRIVERNAME, DRIVERPATH);
            driver = new ChromeDriver();
        } else {
//            driver = new InternetExplorerDriver();
        }

    }

    @AfterSuite
    public void tearDown() {

        driver.close();
        driver.quit();
    }

}
