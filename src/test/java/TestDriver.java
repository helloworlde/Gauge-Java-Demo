import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by viche on 2/10/2017.
 */
public class TestDriver {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google/Chrome/Application/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://cwqapp02ind:6120/");
//        driver.quit();
    }
}
