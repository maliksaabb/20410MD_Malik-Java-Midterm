package databases;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * A class to establish a connection to local or remote JDBC provide methods to interact with that connection.
 * The object can be used to execute queries, retrieve query results and various other methods
 *
 * Database configurations are set in the `secret.properties` file
 *
 * @author Sami Sheikh
 */
public class SharedStepsDatabase {

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;
    static String systemPath = System.getProperty("user.dir");
    static String propPath = "\\src\\secret.properties";
    private static final File file = new File(systemPath + propPath);

    public SharedStepsDatabase() {
        Properties prop = null;
        FileInputStream fis = null;

        try {
            prop = loadProperties();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        try {
            fis = new FileInputStream(file);
            if (prop != null) {
                prop.load(fis);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        }

        if (prop != null) {
            String driverClass = prop.getProperty("MYSQLJDBC.driver");
            String host = prop.getProperty("MYSQLJDBC.host");
            String user = prop.getProperty("MYSQLJDBC.userName");
            String password = prop.getProperty("MYSQLJDBC.password");

            try {
                Class.forName(driverClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connect = DriverManager.getConnection(host, user, password);
                System.out.println("CONNECTED TO DATABASE!");
            } catch (SQLException sql) {
                System.out.println("\nUNABLE TO ESTABLISH CONNECTION TO DATABASE:\n" + sql.getMessage() + "\n");
            }
        }
    }

    public static void main(String[] args) throws Exception {
//        List<User> list = readUserProfileFromSqlTable();
//
//        for (User user : list) {
//            System.out.println(user.getStName() + " " + user.getStID() + " " + user.getStDOB());
//        }

        // region readAllTest
//        SharedStepsDatabase ssdb = new SharedStepsDatabase();
//        String query = "SELECT * FROM EMPLOYEES.EMPLOYEES E INNER JOIN DEPT_EMP DE ON E.EMP_NO = DE.EMP_NO WHERE E.FIRST_NAME LIKE 'Alain'";
//        resultSet = ssdb.executeQuery(query);
//        List<List<String>> data = ssdb.readAll();
//
//        for (List<String> row : data) {
//            for (String cell : row) {
//                System.out.print(cell + "\t\t\t\t");
//            }
//            System.out.println();
//        }
        // endregion
    }

    private static Properties loadProperties() throws IOException {
        Properties prop = new Properties();
        InputStream ism = new FileInputStream("src/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public List<String> executeQueryReadAllSingleColumn(String query, String column, int colIndex) throws Exception {
        resultSet = executeQuery(query);
        return readAllSingleColumn(column, colIndex);
    }

    public List<List<String>> executeQueryReadAll(String query) throws Exception {
        resultSet = executeQuery(query);
        return readAll();
    }

    public ResultSet executeQuery(String query) {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sql) {
            System.out.println("UNABLE TO RETRIEVE RESULTS FROM QUERY: " + query);
            System.out.println(sql.getMessage());
        }

        return resultSet;
    }

    public List<String> readAllSingleColumn(String columnName, int colIndex) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        String item;

        while (resultSet.next()) {

            if (columnName.equals("")) {
                item = resultSet.getString(colIndex);
            } else {
                item = resultSet.getString(columnName);
            }
            dataList.add(item);
        }
        return dataList;
    }

    /**
     * Reads & parses an entire resultSet and returns a List containing Lists.
     * The inner lists represent each row of data
     * @return Entire result set as a List<List<String>>
     * @throws SQLException
     */
    public List<List<String>> readAll() throws SQLException {

        List<List<String>> data = new ArrayList<List<String>>();

        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<String> tempRow = new ArrayList<>();

        while (resultSet.next()) {
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getString(i));
            }

            data.add(row);
        }
        return data;
    }

    public static List<User> getStudentList(){
        List<User> list = new ArrayList<>();
        User user;
        String query = "SELECT * FROM Students";

        try {
            // Create the Java statement
            statement = connect.createStatement();

            // Execute the query, and get a java resultSet
            resultSet = statement.executeQuery(query);

            // Iterate through the java resultSet object
            String name;
            String id;
            String dob;

            while (resultSet.next()) {
                name = resultSet.getString("stName");
                id = resultSet.getString("stID");
                dob = resultSet.getString("stDOB");
                //System.out.format("%s, %s\n", name, id);
                user = new User(name, id, dob);
                list.add(user);
            }
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        } finally {
            closeResources();
        }
        return list;
    }

    public void insertIntegerArray(int[] array, String tableName, String columnName) {
        try {
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();

            ps = connect.prepareStatement(
                    "CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`sorted_numbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();

            for (int n = 0; n < array.length; n++) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setInt(1, array[n]);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO - Refactor for re-usability
    public void insertString(String tableName, String columnName, String string) {
        try {
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setString(1, string);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertFromList(String tableName, String columnName, List<Object> list) {
        try {
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement(
                    "CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();

            for (Object st : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setObject(1, st);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertFromMap(String tableName, Map<Object, Object> map) {
        try {
            ps = connect.prepareStatement("DROP TABLE IF EXISTS " + tableName + ";");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE " + tableName + " (`key` VARCHAR(45) DEFAULT 1 NOT NULL, `value` VARCHAR(45) NULL);");
            ps.executeUpdate();

            StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (`key`, `value`)").append(" VALUES (");

            for (Object key : map.keySet()) {
                sql.append("'").append(key).append("', '").append(map.get(key)).append("'), (");
            }
            String sqlString = sql.toString();
            sqlString = sqlString.substring(0, sqlString.length() - 3);;

            ps = connect.prepareStatement(sqlString);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO - Refactor for re-usability
    public void insertProfileToSqlTable(String tableName, String columnName1, String columnName2) {
        try {
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            ps.setString(1, "Ankita Sing");
            ps.setInt(2, 3590);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException sql) {
            System.out.println("UNABLE TO CLOSE RESOURCES");
            System.out.println(sql.getMessage());
        }
    }
}
