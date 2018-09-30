package com.github.sapsey19.classroom;

public class Student {

    String name;
    int ID;
    char letterGrade;

    Student(String _name, int _ID, char _letterGrade) {
        name = _name;
        ID = _ID;
        letterGrade = _letterGrade;
    }

    Student() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
