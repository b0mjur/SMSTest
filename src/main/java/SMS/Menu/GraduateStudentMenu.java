package SMS.Menu;

import SMS.GraduateStudent;
import SMS.Student;
import SMS.StudentService;

import java.util.Scanner;

public class GraduateStudentMenu {
    private StudentService studentService;
    private Scanner scanner;

    public GraduateStudentMenu(StudentService service, Scanner scanner) {
        this.studentService = service;
        this.scanner = scanner;
    }

    public void execute() {
        // Prompt for student id
        System.out.println("Enter the student ID to graduate: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Find the student - Check for student existence or graduated
        Student student = studentService.getStudents()
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
        if (student != null && !(student instanceof GraduateStudent)) {
            // Ask for email
            String email;
            while (true) {
                System.out.println("Enter email: ");
                email = scanner.nextLine();
                try {
                    Student.validateEmail(email);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Ask for GPA
            System.out.println("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();

            // Create GraduateStudent
            GraduateStudent graduateStudent = new GraduateStudent(student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getAge(),
                    student.getMajor(),
                    email // Use the collected email
            );
            try {
                graduateStudent.setGPA(gpa);
            } catch (Exception e) {
                System.out.println("Invalid GPA: " + e.getMessage());
            }

            // Delete undergrad student
            studentService.deleteStudent(id);

            // Add graduate student to the student list
            studentService.addStudent(graduateStudent);
            System.out.println("Student graduated.");
        } else {
            System.out.println("Student not found or already graduated");
        }
    }
}