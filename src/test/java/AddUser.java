import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AddUserModal;
import pages.MainPage;
import utils.DriverFactory;

/**
 * @author HelloWood
 * @create 2017-02-12 22:25
 * @email hellowoodes@gmail.com
 * @Description
 **/

public class AddUser {

    private WebDriver driver = DriverFactory.getDriver();
    private MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
    private AddUserModal addUserModel = PageFactory.initElements(driver, AddUserModal.class);

    @Step("click add user button")
    public void clickAddUserButton() {
        mainPage.btnAddUserClick();
    }

    @Step("add user <table>")
    public void addUser(Table userinfoTable) {
        addUserModel.addUser(userinfoTable);
    }

    @Step("check add result <table>")
    public void checkAddUser(Table table) {
        mainPage.query();

        for (TableRow row : table.getTableRows()) {
            mainPage.queryByUsername(row.getCell("username").toString());
        }

    }
}
