package datastructure;

import databases.SharedStepsDatabase;

import java.util.HashMap;
import java.util.List;

public class UseMap {

    public static void main(String[] args) throws Exception {
        /*
         * Demonstrate how to use Map that includes storing and retrieving elements.
         * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
         * Use For-Each loop and While-loop with Iterator to retrieve data.
         *
         * Store and retrieve data from/to a database table.
         */

        HashMap<Object, Object> map = new HashMap<>();

        map.put(8454, "lamia");
        map.put(4567, "azar");
        map.put(7898, "rahim");

        // "Keys"  +  "Values"

        for (Object key : map.keySet()){
            System.out.print("KEY: " + key + "\t");
            System.out.print("VALUE: " + map.get(key));
            System.out.println();
        }

        String tableName = "`test_hash_map`";
        SharedStepsDatabase sql = new SharedStepsDatabase();
        sql.insertFromMap(tableName, map);

        List<String> result = sql.executeQueryReadAllSingleColumn("SELECT * FROM TEST_HASH_MAP", "", 1);

        for (String r : result) {
            System.out.println(r);
        }
    }

}
