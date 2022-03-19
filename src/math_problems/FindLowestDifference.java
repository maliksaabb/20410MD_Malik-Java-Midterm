package math_problems;

public class FindLowestDifference {

    public static void main(String[] args) {
        /*
         Write a method to return the the lowest difference between these two arrays
            HINT: The lowest difference between these arrays is 1
        */

        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};

        System.out.println(findLowestDiff(array1, array2));

    }

    public static int findLowestDiff(int[] array1, int[] array2) {

        int lowestDifference = 0;
        int lowestInArray1;
        int lowestInArray2;

        do {
            lowestInArray1 = findLowestNumberInArray(array1);
            lowestInArray2 = findLowestNumberInArray(array2);
        } while (lowestInArray1 == lowestInArray2);

        if (lowestInArray1 < lowestInArray2) {
            lowestDifference = lowestInArray1;
        } else {
            lowestDifference = lowestInArray2;
        }

        return lowestDifference;
    }

    public static int findLowestNumberInArray(int[] array) {
        int lowestInArray = array[0];

        for (int x : array) {
            if (x < lowestInArray) {
                lowestInArray = x;
            }
        }

        return lowestInArray;
    }




}
