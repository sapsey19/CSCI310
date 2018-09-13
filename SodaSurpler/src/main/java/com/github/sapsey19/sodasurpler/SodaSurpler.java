package com.github.sapsey19.sodasurpler;

import java.io.PrintStream;
import java.util.Scanner;

public class SodaSurpler {
    public static void main(String [] args) throws Exception 
    {
        SodaSurpler soda = new SodaSurpler();
        soda.go();
    }
    Scanner in;
    PrintStream out;
    int e, f, c;
    void go() throws Exception
    {
        in = new Scanner(System.in);
        out = System.out;
        for(;;)
        {
            haveTestCase();
            readTestCase();
            solve();
        }
    }

    private boolean haveTestCase() {
        return in.hasNextInt();
    }

    private void readTestCase() {
        e = in.nextInt();
        f = in.nextInt();
        c = in.nextInt();
    }

    private void solve() {
        System.out.println(e + "" +  f +  "" + c);
    }
}
