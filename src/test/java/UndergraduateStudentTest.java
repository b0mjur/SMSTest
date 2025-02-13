import SMS.Major;
import SMS.UndergradStudent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UndergraduateStudentTest {

    @ParameterizedTest
    @CsvSource({
            "1, Vitalii, Doe, 10, ART",
            "2, Bob, PO, 34, MATH",
            "3, Olga, Doe, 23, MATH"
    })

    public void testUndergraduteStudent(int id, String firstName, String lastName, int age, Major major) {
        UndergradStudent student = new UndergradStudent(id, firstName, lastName, age, major, "example@gmail.com");

        assertEquals(id, student.getId());
        assertEquals(firstName, student.getFirstName());
        assertEquals(lastName, student.getLastName());
        assertEquals(age, student.getAge());
        assertEquals(major, student.getMajor());
    }
}
