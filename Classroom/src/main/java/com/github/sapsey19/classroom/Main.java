/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.sapsey19.classroom;

/**
 *
 * @author sapse
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    void run() {
        Classroom classroom = new Classroom();
        classroom.addStudent("John", 1234, 'B');
        classroom.addStudent("Jack", 1557, 'D');
        classroom.addStudent("Jill", 1337, 'A');
        classroom.removeStudent(1557);
    }
}
