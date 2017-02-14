package pages;

import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.DriverFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HelloWood
 * @create 2017-02-12 22:31
 * @email hellowoodes@gmail.com
 * @Description
 **/

public class AddUserModal extends BasePage {
    private WebElement addUsername;
    private WebElement addSex;
    private WebElement addAge;
    private WebElement addSchool;
    private WebElement addMajor;
    private WebElement addAddress;
    private WebElement btnAddConfirm;
    private WebElement btnAddCancel;

    private WebDriver driver = DriverFactory.getDriver();
    private MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

    public void addUser(Table userinfoTable) {

        Select sexSelect = new Select(addSex);
        Select schoolSelect = new Select(addSchool);
        Select majorSelect = new Select(addMajor);

        List<String> usernames = new ArrayList<>();
        for (TableRow row : userinfoTable.getTableRows()) {
            usernames.add(row.getCell("username"));
            addUsername.sendKeys(row.getCell("username"));
            sexSelect.selectByValue(row.getCell("sex"));
//            sexSelect.selectByVisibleText(row.getCell("sex"));
            addAge.sendKeys(row.getCell("age"));
            schoolSelect.selectByValue(row.getCell("school"));
            majorSelect.selectByValue(row.getCell("major"));
            addAddress.sendKeys(row.getCell("address"));
            btnAddConfirm.click();
        }
    }
}
