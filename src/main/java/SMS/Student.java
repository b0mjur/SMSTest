package SMS;

import java.util.regex.Pattern;

public abstract class Student implements Printable {
    private int id;
    private String firstName;
    private String lastName;
    public String email;
    private int age;
    protected Major major;

    private static int nextId = 1;

    public Student(int id, String firstName, String lastName, int age, Major major, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.major = major;
        setEmail(email);
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public int getAge() { return age; }

    public Major getMajor() { return major; }

    public String getEmail() { return email; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public void setAge(int age) {
        if (age >= 18 && age <= 150) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age must be between 18 and 150.");
        }
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }

    public void setMajor(Major major) { this.major = major; }

    public static void setNextId(int nextId) {
        Student.nextId = nextId;
    }

    public static void validateEmail(String email) {
        String emailRegex = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
    }

    @Override
    public abstract void print();
}