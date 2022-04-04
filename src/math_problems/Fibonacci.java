package math_problems;

public class Fibonacci {

    /** INSTRUCTIONS
     * Write a method that will print or return at least 40 Fibonacci numbers
     *
     * e.g. - 0,1,1,2,3,5,8,13
     **/
    //By using For Loop
    public static void main(String[] args) {

        // Setting the maxNumber to 40 Fibonacci numbers
        int maxNumber = 40;
        int previousNumber = 0;
        int nextNumber = 1;

        System.out.print("Printing atleast "+maxNumber+" Fibonnacci numbers:");

        for (int i = 1; i <= maxNumber; ++i)
        {
            System.out.print(previousNumber+" ");
            /* On each iteration, we are assigning second number
             * to the first number and assigning the sum of last two
             * numbers to the second number
             */


            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }

    }

}
