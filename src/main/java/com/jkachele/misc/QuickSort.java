package com.jkachele.personal;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        //create an array of 10 random ints from 0 to 99
        Random random = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }


        System.out.print("Before: ");
        System.out.println(Arrays.toString(numbers));

        quicksort(numbers, 0, numbers.length - 1);

        System.out.print("After: ");
        System.out.println(Arrays.toString(numbers));
    }

    private static void quicksort(int[] numbers, int lowIndex, int highIndex) {
        if(lowIndex < highIndex) {
            int partitionIndex = partition(numbers, lowIndex, highIndex);

            quicksort(numbers, lowIndex, partitionIndex - 1);
            quicksort(numbers, partitionIndex + 1, highIndex);
        }
    }

    //partitions array section and returns index of pivot
    private static int partition(int[] numbers, int lowIndex, int highIndex) {
        //pivot is the last number in the array
        int pivot = numbers[highIndex];

        int lowPointer = lowIndex;
        int highPointer = highIndex;

        while(lowPointer < highPointer) {
            //increments low pointer until the element is greater than the pivot or until it reaches the high pointer
            while(numbers[lowPointer] <= pivot && lowPointer < highPointer){
                lowPointer++;
            }
            //increments high pointer until the element is less than the pivot or until it reaches the low pointer
            while(numbers[highPointer] >= pivot && lowPointer < highPointer){
                highPointer--;
            }
            swapElements(numbers, lowPointer, highPointer);
        }
        //once the pointers are pointing at the same number, that number is swapped with the pivot placing
        //it in its final position
        swapElements(numbers, lowPointer, highIndex);

        //the pointers are now pointing at the pivot so its index is returned
        return lowPointer;
    }

    private static void swapElements(int[] numbers, int lowIndex, int highIndex) {
        int temp = numbers[lowIndex];
        numbers[lowIndex] = numbers[highIndex];
        numbers[highIndex] = temp;
    }

}
