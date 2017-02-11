package pages;

import com.thoughtworks.gauge.Gauge;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by viche on 2/10/2017.
 */
public class MainPage extends BasePage {
    public static String MainPageURL = Url;

    private WebDriver driver = DriverFactory.getDriver();

    public WebElement queryButton = driver.findElement(By.id("btnQueryUser"));

    public void query() {
        queryButton.click();

        //for wait query user info from server
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        List<WebElement> userInfoTrs = driver.findElements(By.name("userTr"));
        for (WebElement tr : userInfoTrs) {
            Gauge.writeMessage(tr.getText());
        }

        Assert.assertTrue(!userInfoTrs.isEmpty());

    }
}
