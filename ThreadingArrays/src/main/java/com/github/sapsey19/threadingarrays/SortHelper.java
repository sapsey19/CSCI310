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
public class SortHelper implements Runnable{

    Sorter sorter;
    Thread thread = new Thread(this);
    
    void start() {
        thread.start();
    }
    
    long ms;
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        sorter.sort(arr);
        ms = System.currentTimeMillis() - start;
    }

    void bubbleSort(double[] arr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
