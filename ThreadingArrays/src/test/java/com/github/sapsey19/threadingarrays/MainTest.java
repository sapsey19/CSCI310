/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.threadingarrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sapse
 */
public class MainTest {

    public MainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        BubbleThread bubble = new BubbleThread();
        SelectThread select = new SelectThread();
        QuickThread quick = new QuickThread();

        bubble.start();
        select.start();
        quick.start();
        bubble.waitTilFinish();
        select.waitTilFinish();
        quick.waitTilFinish();
        
        assertTrue(bubble.ms > select.ms);
        assertTrue(bubble.ms > quick.ms);
        assertTrue(select.ms > quick.ms);
    }

}
