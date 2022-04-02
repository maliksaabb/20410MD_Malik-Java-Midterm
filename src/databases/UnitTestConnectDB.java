package databases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UnitTestConnectDB {

    public static void main(String[] args) throws Exception {
        // region readAllTest
        SharedStepsDatabase ssdb = new SharedStepsDatabase();
        String query = "SELECT * FROM EMPLOYEES.EMPLOYEES E INNER JOIN DEPT_EMP DE ON E.EMP_NO = DE.EMP_NO WHERE E.FIRST_NAME LIKE 'Alain'";

        List<List<String>> data = ssdb.executeQueryReadAll(query);

//        ssdb.executeQuery(query);
//
//        try {
//            data_structures.data = ssdb.readAll();
//        } catch (SQLException sqlException) {
//            sqlException.printStackTrace();
//        }

        if (data != null) {
            for (List<String> row : data) {
                for (String cell : row) {
                    System.out.print(cell + "\t\t\t\t");
                }
                System.out.println();
            }
        }
        // endregion
    }
}
