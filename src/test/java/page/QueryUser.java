package page;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;
import utils.DriverFactory;

/**
 * @author HelloWood
 * @create 2017-02-11 15:58
 * @email hellowoodes@gmail.com
 * @Description Query user
 **/

public class QueryUser {

    private final WebDriver driver = DriverFactory.getDriver();

    @Step("click query button")
    public void queryUsers() {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.query();
    }
}
