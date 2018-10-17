/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.threadingarrays;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sapse
 */
public class SelectThread implements Runnable {

    SelectSort sorter = new SelectSort();
    Thread thread = new Thread(this);

    void start() {
        thread.start();
    }

    long ms;

    @Override
    public void run() {
        System.out.println("Begin processing on " + Thread.currentThread().getName() + "(Select Sort)");
        long start = System.currentTimeMillis();
        sorter.go();
        ms = System.currentTimeMillis() - start;
        System.out.println("End processing on " + Thread.currentThread().getName() + "(Select Sort)");
    }

    void waitTilFinish() {
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BubbleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}