package MergeSorter;

import java.util.Arrays;
import java.util.Comparator;

public class StringMergeSort {

    public static String[] AriseStringMergeSort(String[] arrayA, String[] arrayB) {

        String[] arrayArise = new String[arrayA.length + arrayB.length];
        int positionA = 0;
        int positionB = 0;

        if (arrayA.length > 1){
            for (int i = 0; i < arrayA. length - 1; i++){
                if (!compareTwoStrings(arrayA[i], arrayA[i + 1])){
                    System.err.println("File with strings is not sorted in ascending order! Sorting!");
                    Arrays.sort(arrayA);
                    break;
                }
            }
        }

        if (arrayB.length > 1){
            for (int i = 0; i < arrayB. length - 1; i++){
                if (!compareTwoStrings(arrayB[i], arrayB[i + 1])){
                    System.err.println("File with strings is not sorted in ascending order! Sorting!");
                    Arrays.sort(arrayB);
                    break;
                }
            }
        }

        for (int i = 0; i < arrayArise.length; i++) {
            if (positionA == arrayA.length) {
                    arrayArise[i] = arrayB[positionB];
                    positionB++;
            } else if (positionB == arrayB.length) {
                    arrayArise[i] = arrayA[positionA];
                    positionA++;
            } else if (compareTwoStrings(arrayA[positionA], arrayB[positionB])) {
                    arrayArise[i] = arrayA[positionA];
                    positionA++;
            } else {
                    arrayArise[i] = arrayB[positionB];
                    positionB++;
            }
        }
        return arrayArise;
    }

    public static String[] DecreaseStringMergeSort(String[] arrayA, String[] arrayB) {
        String[] arrayDecrease = new String[arrayA.length + arrayB.length];
        int positionA = 0;
        int positionB = 0;

        if (arrayA.length > 1){
            for (int i = 0; i < arrayA. length - 1; i++){
                if (compareTwoStrings(arrayA[i], arrayA[i + 1])){
                    System.err.println("File with strings is not sorted in descending order! Sorting!");
                    Arrays.sort(arrayA, Comparator.reverseOrder());
                    break;
                }
            }
        }

        if (arrayB.length > 1){
            for (int i = 0; i < arrayB. length - 1; i++){
                if (compareTwoStrings(arrayB[i], arrayB[i + 1])){
                    System.err.println("File with strings is not sorted in descending order! Sorting!");
                    Arrays.sort(arrayB, Comparator.reverseOrder());
                    break;
                }
            }
        }

        for (int i = 0; i < arrayDecrease.length; i++) {
            if (positionA == arrayA.length) {
                arrayDecrease[i] = arrayB[positionB];
                positionB++;
            } else if (positionB == arrayB.length) {
                arrayDecrease[i] = arrayA[positionA];
                positionA++;
            } else if (!compareTwoStrings(arrayA[positionA], arrayB[positionB])) {
                arrayDecrease[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayDecrease[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayDecrease;
    }

    private static boolean compareTwoStrings(String string, String string1) {
        char[] chars = string.toCharArray();
        char[] chars1 = string1.toCharArray();
        boolean result = false;
        for (int i = 0; i < chars.length || i < chars1.length; i++) {
            if (chars[i] < chars1[i]) {
                result = true;
                break;
            } else {
                if (chars[i] > chars1[i]) {
                    result = false;
                    break;
                } else {
                    if (i == chars.length - 1 || i == chars1.length - 1) {
                        if (chars.length < chars1.length){
                            result = true;
                            break;
                        } else {
                            result = false;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return result;
    }
}
