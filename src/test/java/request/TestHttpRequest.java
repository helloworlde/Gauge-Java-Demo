package request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import model.UserModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.junit.Assert.assertTrue;


public class TestHttpRequest {

    String baseUrl = System.getenv("APP_ROOT_URL");

    @Step("query user")
    public void sendHttpRequest() {

        String url = baseUrl.concat("query");

        String result = sendGetRequest(url);

        JSONArray users = JSON.parseArray(result);
        for (int i = 0; i < users.size(); i++) {
            UserModel user = JSON.parseObject(users.get(i).toString(), UserModel.class);
            Gauge.writeMessage(user.toString());
        }
        assertTrue(users != null && !users.isEmpty());
    }

    private String sendGetRequest(String url) {
        String result = "";
        BufferedReader in = null;

        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();

            connection.connect();

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Step("add users from table <table>")
    public void addUser(Table userTable) {

        boolean result = true;
        String url = baseUrl.concat("add");

        for (TableRow row : userTable.getTableRows()) {
            UserModel userModel = new UserModel();
            userModel.setUsername(row.getCell("username"));
            userModel.setSex(row.getCell("sex"));
            userModel.setAge(Integer.valueOf(row.getCell("age")));
            userModel.setSchool(row.getCell("school"));
            userModel.setMajor(row.getCell("major"));
            userModel.setAddress(row.getCell("address"));

            String requestString = JSON.toJSONString(userModel);

            String response = sendPostRequest(requestString, url);
            JSONObject responseMap = JSON.parseObject(response);
            result = result && responseMap.get("STATE").equals("SUCCESSED");
        }
        assertTrue(result);
    }

    private String sendPostRequest(String requestString, String url) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();

            conn.setRequestProperty("content-type", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());
            out.print(requestString);
            out.flush();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

}
