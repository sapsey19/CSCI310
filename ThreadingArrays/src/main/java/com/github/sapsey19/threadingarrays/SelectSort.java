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
public class SelectSort {

    static final int maxNum = 100000;
    double arr[] = new double[maxNum];

    void go() {
        initArr(arr);
        selectSort(arr);
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

    private void selectSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            double temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
