package json.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import json.Employee;

public class JsonReaderUtil {

    /** INSTRUCTIONS
     * An API URL is provided below. This RestAPI will return you a JSON response.
     *
     * Your task is to use the provided code below to help you parse through the API response. You will use the
     * Employee class (within the json package) to create an object for each of the employees listed below and assign
     * the corresponding object attributes with the values being returned from the JSON response.
     *
     *     Your output should be formatted like this:
     *
     *      NAME: "David Lenard"
     *      EMAIL: "Dave@gmail.com"
     *      DEPT: "Engineering"
     *      SALARY: "140k"
     *
     *      NAME: "Rivera Dupp"
     *      EMAIL: "rivera@gmail.com"
     *      DEPT: "Finance"
     *      SALARY: "150k"
     *
     *    NOTE: Try to understand what is going on with the provided code below. Maybe try running it to see what is
     *          going on. If you don't know what something is, such as a JSON Object or a JSON Array, or even what
     *          JSON is... look it up!
     **/

    public static void main(String[] args) throws IOException {
        String sURL = "http://info.venturepulse.org:8080/service-webapp/api/AllEmployeeResources";
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        Employee emp = null;
        String empName;
        String empEmail;
        String empDept;
        String empSalary;
        List<Employee> empList = new ArrayList<>();
        JsonObject rootObj;
        JsonArray jsonArray = null;
        JsonParser jp = new JsonParser();

        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

        if (root instanceof JsonObject) {
            rootObj = root.getAsJsonObject();
        } else if (root instanceof JsonArray) {
            jsonArray = root.getAsJsonArray();
        }

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size() - 1; i++) {
                try {
                    JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();
                    // Your code implementation starts here
                    empEmail = jsonobject.get("empEmail").toString();

                    System.out.println(empEmail);

                } catch (NullPointerException np) {
                    System.out.println("NO EMAIL EXISTS FOR STUDENT AT INDEX " + i);
                }
            }
        }

        for (Employee entry : empList) {
            System.out.println(entry.getEmpName() + entry.getEmpEmail() + entry.getDepartment() + entry.getSalary());
        }
    }

}
