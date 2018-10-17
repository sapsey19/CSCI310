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
public class BubbleSort {

    static final int maxNum = 100000;
    double arr[] = new double[maxNum];

    void go() {
        initArr(arr);
        bubbleSort(arr);       
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
