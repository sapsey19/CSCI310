/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.threadingarrays;

/**
 *
 * @author sapse
 */
public class QuickSort {

    static final int maxNum = 100000;
    double arr[] = new double[maxNum];

    void go() {
        initArr(arr);
        sort(arr, 0, maxNum - 1);
       // printArr(arr);        
    }

    private void initArr(double[] arr) {
        int i = 0;
        double num;
        double temp;
        while (i < maxNum) {
            num = Math.random() * 100;
            temp = num * Math.sin(num);
            arr[i] = temp;
            i++;
        }
    }

       private void printArr(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    int partition(double arr[], int low, int high) {
        double pivot = arr[high];
        int i = (low - 1); // index of smaller element 
        for (int j = low; j < high; j++) {
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j] 
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot) 
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(double arr[], int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int index = partition(arr, low, high);

            // Recursively sort elements before 
            // partition and after partition 
            sort(arr, low, index - 1);
            sort(arr, index + 1, high);
        }
    }

}
