package seedu.justbook;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit 5 Testing")
public class JustBookTest {
    private static List<Bookings> bookings;

    @BeforeAll
    static void setup() {
        bookings = JustBook.appointments;

        try {
            JustBook.onLoad();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("`del a` (formula code test)")
    public void delAllFormulaTest() {
        bookings.clear();
        assertEquals(0, bookings.size());
    }

    @Test
    @DisplayName("`undel a` (formula code test)")
    public void unDelAllFormulaTest() {
        bookings.clear();

        try {
            JustBook.onLoad();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(18, bookings.size());
    }

    @AfterAll
    static void tearDown() {
        bookings = null;
    }
}
