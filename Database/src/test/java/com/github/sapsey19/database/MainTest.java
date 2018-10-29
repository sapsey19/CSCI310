/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.database;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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

    @Test
    public void testDatabase() {
        DBHelper db = new DBHelper();
        db.createNewDatabase("Menu");
        //db.createNewTable();
        db.delete(1);
        db.delete(2);
        db.delete(3);
        db.delete(4);
        db.delete(5);
        db.insert("Hamburger", 500);
        db.insert("Hotdog", 400);
        db.insert("Salad", 600);
        db.insert("Cheeseburger", 600);
        db.insert("Double Cheeseburger", 750);

        assertEquals(db.getPriceGreaterThan(700), "Double Cheeseburger");
        assertEquals(db.getPriceLessThan(500), "Hotdog");

        db.update(2, "Hotdog", 500);       
        assertThat(db.getPriceLessThan(450), is(not("Hotdog")));

        db.update(5, "Double Cheeseburger", 800);
        assertEquals(db.getPriceGreaterThan(750), "Double Cheeseburger");

        db.delete(5);
        assertThat(db.getPriceGreaterThan(750), is(not("Hotdog")));

    }

}
