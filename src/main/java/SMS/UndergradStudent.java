package SMS;

public class UndergradStudent extends Student implements Printable {

    public UndergradStudent(int id, String firstName, String lastName, int age, Major major, String email) {
        super(id, firstName, lastName, age, major, email);
    }

    @Override
    public void print() {
        System.out.format("| %-15s | %-15d | %-15s | %-15s | %-15d | %-15s | %-15s |%n",
                "Undergraduate", getId(), getFirstName(), getLastName(), getAge(), major, getEmail(), "");
        System.out.format("+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+-----------------+%n");
    }
}