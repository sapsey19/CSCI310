/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.roster;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        RosterList roster = new RosterList();
        Athlete jacob = new Athlete("Jacob", "Swimming");
        Athlete kevin = new Athlete("Kevin", "Football");
        roster.add(jacob);
        
        assertTrue(roster.contains(jacob));
        assertEquals(jacob.sport, "Swimming");
        assertThat(jacob.name, is(not("John")));
        
        assertFalse(roster.hasAthlete(kevin));
        roster.add(kevin);
        assertTrue(roster.hasAthlete(kevin));
        
        assertEquals(roster.size(), 2);
        
        roster.remove(jacob);
        
        assertFalse(roster.hasAthlete(jacob));
        
    }
    
}
