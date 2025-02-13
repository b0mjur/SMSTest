package SMS;

import java.util.List;

public interface StudentRepository {
    List<Student> loadStudents();

    void saveStudents(List<Student> students);
}