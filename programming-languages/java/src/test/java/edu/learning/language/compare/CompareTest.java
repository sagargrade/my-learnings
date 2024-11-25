package edu.learning.language.compare;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CompareTest {

    @InjectMocks
    private Compare compare;

    @Test
    void compareEmployee() {
        //arrange
        Employee[] employees = new Employee[]{
                new Employee(10, "Ramesh"),
                new Employee(5, "Mahesh"),
                new Employee(15, "Piyush")
        };
        //act
        compare.compareEmployee(employees);
        //assert
        assertEquals(5, employees[0].getId());
    }

    @Test
    void compareStudent() {
        //arrange
        Student[] students = new Student[]{
                new Student(25, "Raghav"),
                new Student(15, "Gopal"),
                new Student(10, "Anand")
        };
        //act
        compare.compareStudent(students);
        //assert
        assertEquals(10, students[0].getRollNo());
    }
}