package edu.learning.language.compare;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;

public class Compare {

    public void compareEmployee(Employee[] employees) {
        Arrays.sort(employees);
    }

    public void compareStudent(Student[] students) {
        Comparator<Student> compare = (s1, s2) -> s1.getRollNo() - s2.getRollNo();
        Arrays.sort(students, compare);
    }
}

@Getter
@AllArgsConstructor
@EqualsAndHashCode
class Employee implements Comparable<Employee> {

    private int id;
    private String name;

    @Override
    public int compareTo(Employee employee) {
        return this.id - employee.id;
    }
}

@Getter
@AllArgsConstructor
class Student {
    private int rollNo;
    private String name;
}
