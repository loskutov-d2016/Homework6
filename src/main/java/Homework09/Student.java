package Homework09;

import java.util.Iterator;
import java.util.List;

public class Student {
    private String name;
    private int course;

    public Student() {}

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    public String getName(){
        return this.name;
    }
    public int getCourse(){
        return this.course;
    }

    public void printStudent(List students, int course) {
        System.out.println("курс "+course);
        Iterator<Homework09.Student> iter = students.iterator();
        while (iter.hasNext()) {
            Homework09.Student student = iter.next();
            if (course == student.getCourse()) System.out.println(student.getName());
        }
    }
}