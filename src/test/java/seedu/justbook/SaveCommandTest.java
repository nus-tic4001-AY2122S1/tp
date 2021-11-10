package seedu.justbook;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveCommandTest {
    @Test
    public void getSaveTest() {
        File file = new File("data/justbook.txt");
        boolean expectedResult = true;
        boolean actualResult = false;
        if (file.exists()) {
            actualResult = true;
        }
        assertEquals(expectedResult, actualResult);
    }
}
