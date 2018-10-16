package com.github.sapsey19.threadingarrays;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    static final int maxNum = 10;
    double arr[] = new double[maxNum];
    SortHelper sorter = new SortHelper();
    

    private void run() {
        initArr(arr);
        printArr(arr);
        bubbleSort(arr);
        System.out.println("SORTED:");
        printArr(arr);
        
        sorter.bubbleSort(arr);

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

    private void bubbleSort(double[] arr) {
        int i, j;
        double temp;
        int num = arr.length;
        for (j = 0; j < num - 1; j++) {
            for (i = 0; i < num - 1; i++) {

                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

}
