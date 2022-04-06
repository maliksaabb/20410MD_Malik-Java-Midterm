package math_problems;

public class PrimeNumber {

    /** INSTRUCTIONS
     * Write a method to print a list of all prime numbers from 2 to 1,000,000.
     *  Print out the prime numbers in the given range.
     *
     * BONUS: Figure out how to improve algorithmic efficiency
     */

    public static void primeNumber(){
        for(int i=2; i<=1000000; i++){
            int count=0;
            for(int j=2; j<i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if(count==0){
                System.out.print(i+" " );
            }

        }
    }

    public static void main(String[] args) {
        PrimeNumber.primeNumber();
    }

}