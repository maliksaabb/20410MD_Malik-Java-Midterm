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

    /**
     * An API URL is provided below. This RestAPI will return you a JSON response.
     *
     * Your task is to use the provided code below to help you parse through the API response. You will use the
     * Employee class (within the json package) to create an object for each of the employees listed below and assign
     * the corresponding object attributes with the values being returned from the JSON response.
     *
     *     Your output should look like this:
     *
     *     "mrahman@gmail.com" "Matiur Rahman" "400k" "Finance"
     *      "mrahman@gmail.com" "Rohan Rahman" "100k" "Engineering"
     *      "kafil@gmail.com" "Kafil" "200k" "Backend End Team"
     *      "Dave@gmail.com" "David Lenard" "140k" "Engineering"
     *      "rivera@gmail.com" "Rivera Dupp" "150k" "Finance"
     *      "Anand@gmail.com" "Anand Thakkar" "120k" "SDET"
     *      "sumay@gmail.com" "Sumaya Akbar" "200k" "Finance"
     *      "mrahman@gmail.com" "Mizanur Rahman" "400k" "Finance"
     *      "mrahman2@gmail.com" "Mizanur Rahman" "405k" "Finance"
     *      "mdtaque@gmail.com" "rifat taque" "400k" "QA"
     *      "mdtaque@gmail.com" "rifat taque" "400k" "QA"
     *
     *    NOTE: Try to understand what is going on with the provided code below. If you don't know what something is,
     *          such as a JSON Object or a JSON Array, or even what JSON is, look it up!
     **/

    public static void main(String[] args) throws IOException {
        String sURL = "http://info.venturepulse.org:8080/service-webapp/api/AllEmployeeResources";
        Employee emp = null;
        List<Employee> empList = new ArrayList<>();
        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();
        JsonArray jsonArray = null;
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        if (root instanceof JsonObject) {
            JsonObject rootObj = root.getAsJsonObject();
        } else if (root instanceof JsonArray) {
            jsonArray = root.getAsJsonArray();
        }

        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.size() - 1; i++) {
                try {
                    JsonObject jsonobject = jsonArray.get(i).getAsJsonObject();

                    // Your code implementation starts here

                    String empEmail = jsonobject.get("empEmail").toString();
                    System.out.println(empEmail);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


        for (Employee entry : empList) {
            System.out.println(entry.getEmpEmail() + " " + entry.getEmpName() + " " + entry.getSalary() + " "
                    + entry.getDepartment());
        }
    }

}
