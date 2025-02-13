package SMS;

import java.util.List;

public class FileStudentRepository implements StudentRepository {
    private String fileName;

    public FileStudentRepository(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> loadStudents() {
        return Utility.loadStudentsFromFile(fileName);
    }

    @Override
    public void saveStudents(List<Student> students) {
        Utility.saveStudentsToFile(students, fileName);
    }
}