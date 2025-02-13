package SMS;

import java.util.Comparator;

public class StudentMajorComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        return s1.major.compareTo(s2.major);
    }
}