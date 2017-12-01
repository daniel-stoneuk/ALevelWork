package com.danielstone.alevels;

public class SelectionSort {


    public static void main(String[] args) {
        int[] data = new int[] {1,7,4,9,26,14,7,19,3,5,7};

        for (int lastSortedIndex = 0; lastSortedIndex < data.length; lastSortedIndex++) {
            int largestIndex = lastSortedIndex;
            for (int lastUnsortedIndex = lastSortedIndex + 1; lastUnsortedIndex < data.length; lastUnsortedIndex++) {
                if (data[lastUnsortedIndex] > data[largestIndex]) {
                    largestIndex = lastUnsortedIndex;
                }
            }

            int previousNumber = data[lastSortedIndex];
            int newNumber = data[largestIndex];
            data[lastSortedIndex] = newNumber;
            data[largestIndex] = previousNumber;
        }

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ", ");
        }

    }

}
