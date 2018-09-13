package com.github.sapsey19.sodasurpler;

import java.io.PrintStream;
import java.util.Scanner;

public class SodaSurpler {

    public static void main(String[] args) {
        SodaSurpler soda = new SodaSurpler();
        soda.go();
    }
    Scanner in;
    PrintStream out;
    int e, f, c;
    int d = 0;

    void go() {
        in = new Scanner(System.in);
        out = System.out;
        d = 0;
        haveTestCase();
        readTestCase();
        solve();

    }

    private boolean haveTestCase() {
        return in.hasNextInt();
    }

    private void readTestCase() {

        e = in.nextInt();
        f = in.nextInt();
        c = in.nextInt();

    }

    void solve() {
        int temp, r;
        e += f;
        f = 0;
        while (e >= c) {
            temp = e / c;
            r = e % c;
            d += temp;
            e = temp + r;
        }
        System.out.println(d);
    }
}
