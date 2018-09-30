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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sapse
 */
public class ClassroomTest {
    
    public ClassroomTest() {
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
     * Test of addStudent method, of class Classroom.
     */
    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        String name = "";
        int ID = 0;
        char letterGrade = 'F';
        Classroom instance = new Classroom();
        instance.addStudent(name, ID, letterGrade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testClassroom() {
        Classroom math = new Classroom();
        Student John = new Student("John", 1554, 'B');
        math.StudentList.add(John);
        
    }

    /**
     * Test of removeStudent method, of class Classroom.
     */
    @Test
    public void testRemoveStudent() {
        System.out.println("removeStudent");
        int ID = 0;
        Classroom instance = new Classroom();
        instance.removeStudent(ID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
