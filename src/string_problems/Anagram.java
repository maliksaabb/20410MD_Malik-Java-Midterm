package string_problems;

import java.util.Arrays;

public class Anagram {

    /*
    Write a Java Program, `isAnagram`, to check if any two strings are anagrams

    An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all of the
    original letters exactly once.

        Ex: "CAT" & "ACT",
            "ARMY" & "MARY",
            "FART" & "RAFT"
*/

    static class isAnagram {
        public static void main(String[] args) {
            String s1 = "TAR";
            String s2 = "RAT";

            // check if length is same
            if (s1.length() == s2.length()) {

                // convert strings to char array
                char[] charArray1 = s1.toCharArray();
                char[] charArray2 = s2.toCharArray();

                // sort the char array
                Arrays.sort(charArray1);
                Arrays.sort(charArray2);

                // if sorted char arrays are same
                // then the string is anagram
                boolean result = Arrays.equals(charArray1, charArray2);

                if (result) {
                    System.out.println(s1 + " and " + s2 + " are anagram.");
                } else {
                    System.out.println(s1 + " and " + s2 + " are not anagram.");
                }
            }
        }
    }
}