package datastructure;

import databases.ConnectToSqlDB;

import java.util.HashMap;

public class UseMap {

    public static void main(String[] args) {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        HashMap<Object, Object> h = new HashMap<>();

        h.put(8454, "lamia");
        h.put(4567, "azar");
        h.put(7898, "rahim");

//        System.out.println(h.get(8454));
//
//        System.out.println(h);
//
//        System.out.println();
//
//        System.out.println(h.keySet());

        // "Keys"  +  "Values"

//        for (Object k : h.keySet()){
//            System.out.print("KEY: " + k + "\t");
//            System.out.print("VALUE: " + h.get(k));
//            System.out.println();
//        }

        ConnectToSqlDB sql = new ConnectToSqlDB();

        String tableName = "`test_schema_1`.`test_hash_map`";
        sql.insertDataFromHashMapToSqlTable(h, tableName);

    }

}
