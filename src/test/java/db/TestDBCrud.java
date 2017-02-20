package db;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;

import java.sql.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by viche on 2/6/2017.
 */
public class TestDBCrud {


    private Connection connection;
    private PreparedStatement statement;

    @Step("open connection before crud")
    public void openConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://119.29.99.89:3306/springboot?useSSL=false";
            String username = "victor";
            String password = "Victor123456";

            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("insert new record named <Gauge>,sex is <Male>,age is <25>")
    public void insert(String name, String sex, Integer age) {
        try {
            statement = connection.prepareStatement("insert into user(username,sex,age) values (?,?,?)");
            statement.setString(1, name);
            statement.setString(2, sex);
            statement.setInt(3, age);

            int result = statement.executeUpdate();

            assertTrue(result > 0);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step("query all records")
    public void query() {
        try {
            statement = connection.prepareStatement("SELECT * FROM user");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                StringBuffer userInfo = new StringBuffer();
                userInfo.append("ID:" + resultSet.getString("id"));
                userInfo.append("\t\tUsername:" + resultSet.getString("username"));
                userInfo.append("\t\tSex:" + resultSet.getString("sex"));
                userInfo.append("\t\tAge:" + resultSet.getString("age"));
                userInfo.append("\t\tSchool:" + resultSet.getString("school"));
                userInfo.append("\t\tMajor:" + resultSet.getString("major"));
                userInfo.append("\t\tAddress:" + resultSet.getString("address"));
                Gauge.writeMessage(userInfo.toString());
            }

            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.close();

            assertTrue(rowCount > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step("update record sex to <Female> which named <Gauge>")
    public void update(String sex, String name) {
        try {
            statement = connection.prepareStatement("UPDATE user SET sex=? WHERE username=?");
            statement.setString(1, sex);
            statement.setString(2, name);
            int resultNum = statement.executeUpdate();
            assertTrue(resultNum > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step("delete the record which named <Guage>")
    public void delete(String name) {
        try {
            statement = connection.prepareStatement("DELETE FROM user WHERE username=?");
            statement.setString(1, name);
            int resultNum = statement.executeUpdate();
            assertTrue(resultNum > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Step("close connection after crud")
    public void closeConnection() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
