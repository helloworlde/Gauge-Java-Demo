import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import pages.DriverFactory;
import pages.MainPage;

public class QueryUser {

    private final WebDriver driver = DriverFactory.getDriver();

//    public QueryUser(WebDriver driver) {
//        this.driver = pages.DriverFactory.getDriver();
//    }

    @Step("Navigate to main page")
    public void navigateToMainPage() {
        driver.get(MainPage.MainPageURL);
    }

    @Step("click query button")
    public void queryUsers() {
        MainPage mainPage = new MainPage();
        mainPage.query();

    }


}
