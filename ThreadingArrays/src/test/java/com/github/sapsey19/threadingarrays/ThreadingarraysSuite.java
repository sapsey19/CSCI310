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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author sapse
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.github.sapsey19.threadingarrays.MainTest.class, com.github.sapsey19.threadingarrays.BubbleSorterTest.class, com.github.sapsey19.threadingarrays.SelectSortTest.class, com.github.sapsey19.threadingarrays.SelectSorterTest.class, com.github.sapsey19.threadingarrays.BubbleSortTest.class})
public class ThreadingarraysSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
