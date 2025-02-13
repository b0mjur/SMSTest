package SMS.Menu;

import SMS.*;

import java.util.Scanner;

public class AddStudent {
    private StudentService studentService;
    private Scanner scanner;

    public AddStudent(StudentService studentService, Scanner scanner) {
        this.studentService = studentService;
        this.scanner = scanner;
    }

    public void execute() {
        System.out.print("Enter student type (1 for Undergraduate, 2 for Graduate): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter age: ");
            age = scanner.nextInt();
            scanner.nextLine();
            try {
                Student student = new UndergradStudent(0, firstName, lastName, age, Major.ART, "temp@example.com"); // Temporary student to validate age
                student.setAge(age);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        String email;
        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            try {
                Student.validateEmail(email);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Enter major (ART, ECONOMICS, MATH): ");
        String majorStr = scanner.nextLine();
        Major major = Major.valueOf(majorStr.toUpperCase());

        Student student = null;
        if (type == 1) {
            student = new UndergradStudent(studentService.getStudents().size() + 1, firstName, lastName, age, major, email);
        } else if (type == 2) {
            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            scanner.nextLine();
            GraduateStudent gradStudent = new GraduateStudent(studentService.getStudents().size() + 1, firstName, lastName, age, major, email);
            gradStudent.setGPA(gpa);
            student = gradStudent;
        }

        if (student != null) {
            studentService.addStudent(student);
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Invalid student type.");
        }
    }
}