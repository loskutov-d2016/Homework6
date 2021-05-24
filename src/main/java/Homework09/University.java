package Homework09;

import java.util.ArrayList;
import java.util.List;

public class University {
    public static void main(String[] args) {
        Homework09.Student student = new Homework09.Student();
        List<Homework09.Student> list = new ArrayList<>();
        list.add(new Homework09.Student("Сидоров", 2 ));
        list.add(new Homework09.Student("Иванов", 5));
        list.add(new Homework09.Student("Петров", 3));
        list.add(new Homework09.Student("Волков", 3));
        list.add(new Homework09.Student("Лоскутов", 1));
        list.add(new Homework09.Student("Январцев", 2));
        list.add(new Homework09.Student("Воронцов", 4));
        list.add(new Homework09.Student("Ветошкин", 5));

        student.printStudent(list, 5);
    }
}