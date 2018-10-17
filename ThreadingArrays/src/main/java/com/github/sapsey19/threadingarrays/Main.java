package com.github.sapsey19.threadingarrays;

public class Main {

    BubbleThread bubble = new BubbleThread();
    SelectThread select = new SelectThread();
    QuickThread quick = new QuickThread();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        bubble.start();
        select.start();
        quick.start();
        bubble.waitTilFinish();
        select.waitTilFinish();
        quick.waitTilFinish();
        System.out.println("Bubble Time: " + bubble.ms);
        System.out.println("Select Time: " + select.ms);
        System.out.println("Quick Time: " + quick.ms);        
    }
}
