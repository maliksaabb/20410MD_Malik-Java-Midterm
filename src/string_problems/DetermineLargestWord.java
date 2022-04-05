package string_problems;

import java.util.HashMap;
import java.util.Map;

public class DetermineLargestWord {

    public static void main(String[] args) {
        /*
         Implement a solution to find the length of the longest word in the given sentence below
         Your solution should return a map containing the length of the word as the key & the word itself as the value
            "10: biological"
         */
        String s = "Human brain is a biological learning machine";
        Map<Integer, String> wordNLength = findTheLargestWord(s);

        System.out.println(wordNLength.keySet());
        System.out.println(wordNLength.values());


    }

    public static Map<Integer, String> findTheLargestWord(String wordGiven) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        String st = "";

        String[] wordsArray = wordGiven.split(" ");

        int maxLength = 0;
        for(int i = 0; i <wordsArray.length; i++){

            if (wordsArray[i].length() > maxLength){
                maxLength = wordsArray[i].length();
                st = wordsArray[i];
            }
        }

        map.put(maxLength, st);

        return map;
    }
}