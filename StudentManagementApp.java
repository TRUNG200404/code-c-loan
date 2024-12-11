/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java20;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class StudentManagementApp {
 public static void main(String[] args) {
        StudentManagement studentManagement = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nStudent Management System:");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Student");
                System.out.println("5. Display All Students");
                System.out.println("6. Display Students Sorted by Marks");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Student ID: ");
                        String id = scanner.nextLine();

                        String name;
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            name = scanner.nextLine();
                            if (name.matches(".*\\d.*")) { // Check if name contains numbers
                                System.out.println("Invalid name. Name should not contain numbers.");
                            } else {
                                break; // Exit loop if the name is valid
                            }
                        }

                        double marks;
                        while (true) {
                            System.out.print("Enter Marks (1 to 10): ");
                            marks = Double.parseDouble(scanner.nextLine());
                            if (marks < 1 || marks > 10) { // Check if marks are outside 1-10 range
                                System.out.println("Invalid marks. Marks should be between 1 and 10.");
                            } else {
                                break; // Exit loop if marks are valid
                            }
                        }

                        studentManagement.addStudent(new Student(id, name, marks));
                    }
                    case 2 -> {
                        System.out.print("Enter Student ID to edit: ");
                        String editId = scanner.nextLine();

                        String newName;
                        while (true) {
                            System.out.print("Enter new name: ");
                            newName = scanner.nextLine();
                            if (newName.matches(".*\\d.*")) { // Check if name contains numbers
                                System.out.println("Invalid name. Name should not contain numbers.");
                            } else {
                                break; // Exit loop if name is valid
                            }
                        }

                        double newMarks;
                        while (true) {
                            System.out.print("Enter new marks (1 to 10): ");
                            newMarks = Double.parseDouble(scanner.nextLine());
                            if (newMarks < 1 || newMarks > 10) { // Check if marks are outside 1-10 range
                                System.out.println("Invalid marks. Marks should be between 1 and 10.");
                            } else {
                                break; // Exit loop if marks are valid
                            }
                        }

                        studentManagement.editStudent(editId, newName, newMarks);
                    }
                    case 3 -> {
                        System.out.print("Enter Student ID to delete: ");
                        String deleteId = scanner.nextLine();
                        studentManagement.deleteStudent(deleteId);
                    }
                    case 4 -> {
                        System.out.print("Enter Student ID to search: ");
                        String searchId = scanner.nextLine();
                        Student foundStudent = studentManagement.searchStudent(searchId);
                        if (foundStudent != null) {
                            System.out.println("Student Found: " + foundStudent);
                        } else {
                            System.out.println("Student not found.");
                        }
                    }
                    case 5 -> {
                        System.out.println("All Students:");
                        studentManagement.displayStudents();
                    }
                    case 6 -> studentManagement.displayStudentsSortedByMarks();
                    case 7 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
