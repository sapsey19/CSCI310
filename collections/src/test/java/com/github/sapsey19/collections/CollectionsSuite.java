/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.collections;

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
@Suite.SuiteClasses({com.github.sapsey19.collections.ItemTest.class, com.github.sapsey19.collections.ItemsTest.class, com.github.sapsey19.collections.MainTest.class, com.github.sapsey19.collections.MarketTest.class, com.github.sapsey19.collections.CustomerTest.class})
public class CollectionsSuite {

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
