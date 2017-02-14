package pages;

import com.thoughtworks.gauge.Gauge;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author HelloWood
 * @create 2017-02-11 15:58
 * @email hellowoodes@gmail.com
 * @Description main page of test web app
 **/
public class MainPage extends BasePage {

    public static String MainPageURL = Url;

    private WebDriver driver = DriverFactory.getDriver();

    public WebElement btnAddUser;
    public WebElement btnQueryUser;
    public WebElement btnDeleteUser;
    public WebElement btnUpdateUser;

    public List<WebElement> userInfoTrs;
    public List<WebElement> tdUsernames;

    public void query() {
        btnQueryUser.click();

        //for wait query user info from server
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //print all data after queryed
        userInfoTrs = driver.findElements(By.name("trUserinfo"));
        for (WebElement tr : userInfoTrs) {
            Gauge.writeMessage(tr.getText());
        }
        Assert.assertTrue(!userInfoTrs.isEmpty());
    }

    public void btnAddUserClick() {
        btnAddUser.click();
    }

    public void queryByUsername(String username) {
        List<String> actualUsernames = new ArrayList<>();
        tdUsernames = driver.findElements(By.name("tdUsername"));
        for (WebElement td : tdUsernames) {
            actualUsernames.add(td.getText());
        }
        Assert.assertTrue(actualUsernames.contains(username));
    }
}
