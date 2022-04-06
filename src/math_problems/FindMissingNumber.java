package math_problems;

import java.util.*;
import java.util.Arrays;
class  FindMissingNumber {

    public static int findMissingNumber(int[] array)
    {
        int n=array.length;
        int sum=((n+1)*(n+2))/2;
        for(int i=0;i<n;i++)

            sum-=array[i];
        return sum;
    }
    public static void main(String[] args)
    {
        int[] a = {10, 2, 1, 4, 5, 3, 7, 8, 6};
        System.out.println(findMissingNumber(a));
    }
}