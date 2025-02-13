package SMS;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepository;
    private List<Student> students;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.students = studentRepository.loadStudents();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void saveStudents() {
        studentRepository.saveStudents(students);
    }
}