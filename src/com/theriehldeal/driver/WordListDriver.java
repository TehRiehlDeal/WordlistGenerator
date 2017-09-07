package com.theriehldeal.driver;

import com.theriehldeal.object.WordList;

import java.lang.reflect.Array;
import java.time.LocalTime;

public class WordListDriver {
    private static char[] characters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
                                        'u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N',
                                        'O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7',
                                        '8','9','!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<',
                                        '=','>','?','@','[','\\',']','^','_','`','{','|','}','~'};
    private static String[] words;
    public static void main(String[] args) {
        WordList test = new WordList(4,5);
        //System.out.println(test.getTotalWords());
        //System.out.println(characters.length);
        genList(test);



    }

    public static void genList(WordList test){
        long count = 0;
        LocalTime startTime = LocalTime.now();
        int stepCount = 0;
        int radix = characters.length;
        for(int i = test.getMinLength(); i <= test.getMaxLength(); i++){
            long maxWords = (long) Math.pow(characters.length, i);
            for (long j = 0; j < maxWords; j++){
                int[] indices = convertToRadix(radix,j,i);
                char[] word = new char[i];
                for (int k = 0; k < i; k++){
                    word[k] = characters[indices[k]];
                }
                System.out.println(word);
                count++;

            }
        }
        LocalTime endTime = LocalTime.now();
        System.out.println("Start time:" + startTime);
        System.out.println("End time:" + endTime);
        System.out.println("Generated " + count + " words.");
    }

    private static int[] convertToRadix(int radix, long number, int wordlength) {
        int[] indices = new int[wordlength];
        for (int i = wordlength - 1; i >= 0; i--) {
            if (number > 0) {
                int rest = (int) (number % radix);
                number /= radix;
                indices[i] = rest;
            } else {
                indices[i] = 0;
            }

        }
        return indices;
    }
}
