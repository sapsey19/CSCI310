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
public class BubbleSorterTest {
    
    public BubbleSorterTest() {
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
     * Test of start method, of class BubbleSorter.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        BubbleThread instance = new BubbleThread();
        instance.start();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class BubbleSorter.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        BubbleThread instance = new BubbleThread();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of waitTilFinish method, of class BubbleSorter.
     */
    @Test
    public void testWaitTilFinish() {
        System.out.println("waitTilFinish");
        BubbleThread instance = new BubbleThread();
        instance.waitTilFinish();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
