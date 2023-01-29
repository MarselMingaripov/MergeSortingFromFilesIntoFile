package MergeSorter;

import java.util.*;

public class IntMergeSort {

    public static int[] mergeAriseIntArray(int[] arrayA, int[] arrayB) {
        int[] arrayArise = new int[arrayA.length + arrayB.length];
        int positionA = 0;
        int positionB = 0;
        if (arrayA.length > 1){
            for (int i = 0; i < arrayA.length - 1; i++) {
                if (arrayA[i] > arrayA[i + 1]){
                    System.err.println("File with digits is not sorted in ascending order! Sorting!");
                    Arrays.sort(arrayA);
                    break;
                }
            }
        }

        if (arrayB.length > 1){
            for (int i = 0; i < arrayB.length - 1; i++) {
                if (arrayB[i] > arrayB[i + 1]){
                    System.err.println("File with digits is not sorted in ascending order! Sorting!");
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
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayArise[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayArise[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayArise;
    }

    public static int[] mergeDecreaseIntArray(int[] arrayA, int[] arrayB) {
        int[] arrayDecrease = new int[arrayA.length + arrayB.length];
        int positionA = 0;
        int positionB = 0;

        if (arrayA.length > 1){
            for (int i = 0; i < arrayA.length - 1; i++) {
                if (arrayA[i] < arrayA[i + 1]){
                    System.err.println("File with digits is not sorted in descending! Sorting!");
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < arrayA.length; j++){
                        list.add(arrayA[j]);
                    }
                    Collections.sort(list);
                    Collections.reverse(list);
                    for (int k = 0; k < arrayA.length; k++){
                        arrayA[k] = list.get(k);
                    }
                    break;
                }
            }
        }

        if (arrayB.length > 1){
            for (int i = 0; i < arrayB.length - 1; i++) {
                if (arrayB[i] < arrayB[i + 1]){
                    System.err.println("File with digits is not sorted in descending! Sorting!");
                    List<Integer> list = new ArrayList<>();
                    for (int j = 0; j < arrayB.length; j++){
                        list.add(arrayB[j]);
                    }
                    Collections.sort(list);
                    Collections.reverse(list);
                    for (int k = 0; k < arrayB.length; k++){
                        arrayB[k] = list.get(k);
                    }
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
            } else if (arrayA[positionA] > arrayB[positionB]) {
                arrayDecrease[i] = arrayA[positionA];
                positionA++;
            } else {
                arrayDecrease[i] = arrayB[positionB];
                positionB++;
            }
        }
        return arrayDecrease;
    }
}
