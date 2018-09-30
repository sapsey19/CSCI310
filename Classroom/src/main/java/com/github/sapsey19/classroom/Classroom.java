package com.github.sapsey19.classroom;


public class Classroom {
    
StudentList students = new StudentList();   

    
    void addStudent(String name, int ID, char letterGrade) {
       students.add(new Student(name, ID, letterGrade));
    }

    void removeStudent(int ID) {
        for(Student student: students) {
            if(ID == student.ID)
                students.remove(student);
        }
    }
        
}
