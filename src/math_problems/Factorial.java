package math_problems;

public class Factorial {

    /** INSTRUCTIONS
     * Write a method to return the Factorial of any given number using Recursion, as well as iteration.
     * I have not taught you recursion. Your job is to look it up, learn about it, and use it to find a solution.
     *
     * HINT: Factorial of 5! = 5 x 4 X 3 X 2 X 1 = 120
     */

    static int Recursion_factorial(int num) {
        if (num == 0)
            return 1;

        return num * Recursion_factorial(num - 1);
    }

    static int Iteration_factorial(int n)
    {
        int fac = 1, i;
        for (i = fac; i <= n; i++)
            fac = fac * i;
        return fac;
    }

    public static void main(String[] args) {
        {
            int num = 4;
            System.out.println("Rec Factorial of " + num + " is " + Recursion_factorial(4));
            System.out.println("Ite Factorial of " + num + " is " + Iteration_factorial(4));
        }

    }

}
