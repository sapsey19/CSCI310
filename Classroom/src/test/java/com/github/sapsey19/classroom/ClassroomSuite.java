/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.classroom;

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
@Suite.SuiteClasses({com.github.sapsey19.classroom.StudentListTest.class, com.github.sapsey19.classroom.ClassroomTest.class, com.github.sapsey19.classroom.MainTest.class, com.github.sapsey19.classroom.StudentTest.class})
public class ClassroomSuite {

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
