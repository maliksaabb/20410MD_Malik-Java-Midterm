package sorting;

import java.util.List;
import java.util.Random;

import databases.SharedStepsDatabase;

public class SortEfficiency {


    /**
     * Demonstrate all the different kind of sorting algorithms from the Sorting class. There is an example provided
     *  below to get you started.
     *
     *  You must store all the sorted arrays into their own database table, and retrieve the values and print them
     *  Display the execution time for each sorting. Example in below.
     *
     *  You may use any database, such as MongoDB, Oracle MySql, PostgreSQL, etc, to store data_structures.data and retrieve data_structures.data.
     *
     *  BONUS: Come to a conclusion about which sorting algorithm is the most efficient, given data_structures.data sets with a size of:
     *         10
     *         100
     *         1000
     *         10000
     *         100000
     */



    public static void main(String[] args) throws Exception {
        // Declare and initialize an array of a desired length with random numbers
        int[] numberArray = new int[100];
        insertRandomNumbersIntoArray(numberArray);

        Sorting algo = new Sorting();
        SharedStepsDatabase ssdb = new SharedStepsDatabase();

        // region Selection Sort
        numberArray = algo.selectionSort(numberArray);
        long selectionSortExecutionTime = algo.executionTime;

        System.out.println("***SELECTION SORT***\nArray Length: " + numberArray.length + "\nExecution TIme: "
                + selectionSortExecutionTime + " milliseconds");

        // Insert sorted array into a database table, with the desired table name and column name
        ssdb.insertIntegerArray(numberArray, "selection_sort", "sorted_numbers");

        // Retrieve all elements from the newly created table
        String query = "SELECT * FROM SELECTION_SORT";
        List<String> sorted_numbers = ssdb.executeQueryReadAllSingleColumn(query, "sorted_numbers");
        printValue(sorted_numbers);

        // endregion

        // You must randomize the number array after each sorting algorithm to prepare it for the next sorting algorithm
        randomize(numberArray);

        // region Insertion Sort
        numberArray = algo.insertionSort(numberArray);
        long insertionSortExecutionTime = algo.executionTime;

        System.out.println("Total Execution Time of " + numberArray.length + " numbers in Insertion Sort took: "
                + insertionSortExecutionTime + " milliseconds");

        // endregion

    }

    // region Helper Methods
    /**
     * Inserts random integers into an int[] array. All numbers have an upper bound of 1,000,000
     *
     * @param array Array to insert numbers into
     */
    private static void insertRandomNumbersIntoArray(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000000);
        }
    }

    /**
     * Randomizes the numbers in an int[] array
     *
     * @param array The array to be randomized
     */
    private static void randomize(int[] array) {
        Random r = new Random();
        int n = array.length;

        /*
         Start from the last element and swap one by one. We don't
         need to run for the first element that's why i > 0
         */
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * Prints all values in a List<String>
     *
     * @param list List containing the values to be printed
     */
    private static void printValue(List<String> list) {
        for (String st : list) {
            System.out.println(st);
        }
    }

    // endregion
}
