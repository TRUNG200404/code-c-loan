/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java20;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class StudentManafement {
 private List<Student> studentList;

    public StudentManafement() {
        studentList = new ArrayList<>();
    }

    // Add a student
    public void addStudent(Student student) {
        studentList.add(student);
    }

    // Display all students sorted by marks using Bubble Sort
    public void displayStudentsSortedByMarks() {
        // Copy studentList to avoid modifying the original list
        List<Student> students = new ArrayList<>(studentList);

        // Bubble Sort based on marks in ascending order
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Swap students[j] and students[j + 1]
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }

        System.out.println("Students sorted by Marks (ascending):");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Display all students
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("The student list is empty.");
        } else {
            studentList.forEach(System.out::println);
        }
    }

    // Delete a student by ID
    public void deleteStudent(String deleteId) {
        boolean removed = studentList.removeIf(student -> student.getId().equals(deleteId));
        if (removed) {
            System.out.println("Student with ID " + deleteId + " has been removed.");
        } else {
            System.out.println("No student found with ID " + deleteId + ".");
        }
    }

    // Edit a student's details by ID
    public void editStudent(String editId, String newName, double newMarks) {
        boolean found = false;
        for (Student student : studentList) {
            if (student.getId().equals(editId)) {
                student.setName(newName);
                student.setMarks(newMarks);
                found = true;
                System.out.println("Student with ID " + editId + " has been updated.");
                break;
            }
        }
        if (!found) {
            System.out.println("No student found with ID " + editId + ".");
        }
    }
    // Placeholder methods for future implementation
}
