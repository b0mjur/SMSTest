package SMS;

public class GraduateStudent extends Student {
    private double gpa;

    public GraduateStudent(int id, String firstName, String lastName, int age, Major major, String email) {
        super(id, firstName, lastName, age, major, email);
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
    }

    @Override
    public void print() {
        System.out.format("| %-15s | %-15d | %-15s | %-15s | %-15d | %-15s | %-15s | %-15.2f |%n",
                "Graduate", getId(), getFirstName(), getLastName(), getAge(), getMajor(), getEmail(), getGPA());
    }
}