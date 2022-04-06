package math_problems;

public class FindLowestDifference {

    /**
     * INSTRUCTIONS
     * Write a method to return the lowest number, that is not shared between the 2 arrays
     * HINT: The lowest number that isn't shared between these arrays is 1
     */

    public static void main(String[] args) {


        int[] array1 = {30, 12, 5, 9, 2, 20, 33, 1, -15};
        int[] array2 = {18, 25, 41, 47, 17, 36, 14, 19, -15};

        int[] array3 = new int[array1.length + array2.length];
        boolean n = true;
        while (n) {
            int min_array1 = array1[0];
            int index1 = 0;
            for (int i = 0; i < array1.length; i++) {
                if (min_array1 > array1[i]) {
                    min_array1 = array1[i];
                    index1 = i;
                }
            }

            int min_array2 = array2[0];
            int index2 = 0;
            for (int i = 0; i < array2.length; i++) {
                if (min_array2 > array2[i]) {
                    min_array2 = array2[i];
                    index2 = i;
                }

            }
            if (min_array1 == min_array2) {
                array1[index1] = Integer.MAX_VALUE;
                array2[index2] = Integer.MAX_VALUE;
            } else if (min_array1 < min_array2) {
                System.out.println(min_array1);
                n = false;
            } else {
                System.out.println(min_array2);
                n = false;
            }

        }
    }
}

