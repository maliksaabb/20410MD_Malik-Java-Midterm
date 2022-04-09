package data_structures;

import com.mongodb.connection.Connection;
import databases.SharedStepsDatabase;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static databases.SharedStepsDatabase.insertList;

public class DataReader {


    /**
     * Create an API to read the .txt file and print it to the console.
     *      HINT: Use BufferedReader class
     * Use try-catch block to handle any exceptions
     *
     * Store and retrieve the file to/from a database table.
     *
     * After reading from file using BufferedReader API, store each word, first into a LinkedList. Each word
     * should construct a node in LinkedList. Second, do the same, but with a Stack.
     * Finally, traverse through the list\stack & retrieve each item in `FIFO` order and `FILO` order, respectively
     *
     * Demonstrate how to use a stack using push, peek, search & pop methods.
     * Use For-Each & While-loop with Iterator to retrieve/print data.
     **/
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        String textFilePath = System.getProperty("user.dir") + "/src/data_structures/data/self-driving-car";
        String fileContents = "";
        LinkedList<String> wordList = new LinkedList<>();
        SharedStepsDatabase ssdb = new SharedStepsDatabase();


//        Part One.
        try {
            BufferedReader reader = new BufferedReader(new FileReader(textFilePath));
            String line;

            while ((line = reader.readLine()) != null)
                System.out.println(line);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(textFilePath);

//        Part Two.

        String tableName = "dataReader";
        String columnName = "dataReader";
        List<Object> fileUpload = Collections.singletonList(System.getProperty("user.dir") +
                "\\src\\data_structures\\data\\self-driving-car\\");


        ssdb.insertList(tableName, columnName, fileUpload);

        String query = "SELECT * FROM dataReader";
        String dataReader = null;

        dataReader = String.valueOf(ssdb.executeQueryReadAll(query));

        System.out.println(dataReader);


//        Part Three.

        try {
            BufferedReader reader = new BufferedReader(new FileReader(textFilePath));
            String line;
            while ((line = reader.readLine()) != null)
                fileContents += line;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        wordList.add((fileContents));
        System.out.println(wordList);


        File file = new File(textFilePath);
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        wordList = new LinkedList<>();
        while (scan.hasNextLine()) {
            fileContents = fileContents.concat(scan.nextLine() + "\n");
        }
        wordList.add(fileContents);
        System.out.print(wordList);




    }




}