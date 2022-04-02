package sorting;

import org.testng.Assert;

public class UnitTestSorting {

    /*
      This class is used to help with unit testing of sorting algorithms from the Sort class
     */
    public static void main(String[] args) {
        // You will use these arrays to validate whether your sorting algorithm functions as expected
        int[] unSortedArray = {6, 9, 2, 5, 1, 0, 4};
        int[] sortedArray = {0, 1, 2, 4, 5, 6, 9};

        // Create instance of Sort class
        Sorting sorting = new Sorting();

        // Pass the unsorted array to selectionSort() method (or any method you want to unit test) from Sort class
        sorting.selectionSort(unSortedArray);

        // Verify if the unsorted array is sorted by the desired method
        Assert.assertEquals(unSortedArray, sortedArray, "ARRAY IS NOT SORTED... YET!");

    }
}
