/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.sodasurpler;

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
public class SodaSurplerTest {
    
    public SodaSurplerTest() {
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
     * Test of main method, of class SodaSurpler.
     */
    @org.junit.Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        SodaSurpler.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of go method, of class SodaSurpler.
     */
    @org.junit.Test
    public void testGo() throws Exception {
        System.out.println("go");
        SodaSurpler instance = new SodaSurpler();
        instance.go();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testCase1() throws Exception {
        SodaSurpler instance = new SodaSurpler();
        instance.e = 9;
        instance.f = 0;
        instance.c = 3;
        
        instance.solve();
        
        assertEquals(4, instance.d);
    }
    
    @Test
    public void testCase2() throws Exception {
        SodaSurpler instance = new SodaSurpler();
        instance.e = 5;
        instance.f = 5;
        instance.c = 2;
        
        instance.solve();
        
        assertEquals(9, instance.d);
    }
    
}
