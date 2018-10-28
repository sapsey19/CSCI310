/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.database;

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
public class DBHelperTest {
    
    public DBHelperTest() {
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
     * Test of createNewDatabase method, of class DBHelper.
     */
    @Test
    public void testCreateNewDatabase() {
        System.out.println("createNewDatabase");
        String fileName = "";
        DBHelper.createNewDatabase(fileName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createNewTable method, of class DBHelper.
     */
    @Test
    public void testCreateNewTable() {
        System.out.println("createNewTable");
        DBHelper.createNewTable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAll method, of class DBHelper.
     */
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        DBHelper instance = new DBHelper();
        instance.selectAll();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insert method, of class DBHelper.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String itemName = "";
        int priceInCents = 0;
        DBHelper instance = new DBHelper();
        instance.insert(itemName, priceInCents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriceGreaterThan method, of class DBHelper.
     */
    @Test
    public void testGetPriceGreaterThan() {
        System.out.println("getPriceGreaterThan");
        int priceInCents = 0;
        DBHelper instance = new DBHelper();
        instance.getPriceGreaterThan(priceInCents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPriceLessThan method, of class DBHelper.
     */
    @Test
    public void testGetPriceLessThan() {
        System.out.println("getPriceLessThan");
        int priceInCents = 0;
        DBHelper instance = new DBHelper();
        instance.getPriceLessThan(priceInCents);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBHelper.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        int itemName = 0;
        String name = "";
        double capacity = 0.0;
        DBHelper instance = new DBHelper();
        instance.update(itemName, name, capacity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBHelper.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        int itemName = 0;
        DBHelper instance = new DBHelper();
        instance.delete(itemName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
