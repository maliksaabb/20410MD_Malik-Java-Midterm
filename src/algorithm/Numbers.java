package algorithm;

import java.util.List;
import java.util.Random;

import databases.SharedStepsDatabase;

public class Numbers {

    /*
     * Show all the different kind of sorting algorithm by applying into (num array).
     * Display the execution time for each sorting.Example in below.
     *
     * Use any databases[MongoDB, Oracle or MySql] to store data and retrieve data.
     *
     * At the end. After running all the sorting algo, come to a conclusion which one is suitable on given data set.
     *
     */

    public static void main(String[] args) throws Exception {

        SharedStepsDatabase ssdb = new SharedStepsDatabase();

        int[] num = new int[100];
        storeRandomNumbers(num);

        // Selection Sort
        Sort algo = new Sort();
        algo.selectionSort(num);
        long selectionSortExecutionTime = algo.executionTime;
        System.out.println("Total Execution Time of " + num.length + " numbers in Selection Sort took: "
                + selectionSortExecutionTime + " milliseconds");

        ssdb.insertIntegerArray(num, "selection_sort", "sorted_numbers");
        String query = "SELECT * FROM SELECTION_SORT";
        SharedStepsDatabase.resultSet = ssdb.executeQuery(query);
        List<String> numbers = ssdb.readAllSingleColumn("sorted_numbers", 1);

        printValue(numbers);

        int n = num.length;
        randomize(num, n);

        // Insertion Sort
//        algo.insertionSort(num);
//        long insertionSortExecutionTime = algo.executionTime;
//        System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort took: "
//                + insertionSortExecutionTime + " milliseconds");

        /*
         By following the same convention we used for Selection Sort, continue to do the same for all remaining sorting
            algorithms
         */


        /*
        Can you come to conclusion about which sorting algorithm is most efficient, given the size of the data set?
         */

    }

    static String path = "this is the path";




    /*
    HELPER METHODS
     */

    public static void storeRandomNumbers(int[] num) {
        Random rand = new Random();
        for (int i = 0; i < num.length; i++) {
            num[i] = rand.nextInt(1000000);
        }
    }

    public static void randomize(int[] arr, int n) {
        Random r = new Random();
        // Start from the last element and swap one by one. We don't
        // need to run for the first element that's why i > 0
        for (int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void printValue(List<String> array) {
        for (String st : array) {
            System.out.println(st);
        }
    }
}
