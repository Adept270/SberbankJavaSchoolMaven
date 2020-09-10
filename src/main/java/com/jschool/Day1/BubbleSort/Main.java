package com.jschool.Day1.BubbleSort;

public class Main {

    public static class BubbleSort {
        public static int[] sort(int[] rowArray) {
            for (int i = 0; i < rowArray.length - 1; i++) {
                for (int j = 0; j < rowArray.length - 1 - i; j++) {
                    if (rowArray[j] < rowArray[j + 1]) {
                        int temp = rowArray[j];
                        rowArray[j] = rowArray[j + 1];
                        rowArray[j + 1] = temp;
                    }
                }
            }
            return rowArray;
        }
    }
}
