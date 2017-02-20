package page;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import utils.DriverFactory;

/**
 * @author HelloWood
 * @create 2017-02-11 15:58
 * @email hellowoodes@gmail.com
 * @Description basic step for cycle use
 **/

public class BasicStep {

    private final WebDriver driver = DriverFactory.getDriver();

    @Step("Navigate to main page")
    public void navigateToMainPage() {
        driver.get(MainPage.MainPageURL);
    }
}
