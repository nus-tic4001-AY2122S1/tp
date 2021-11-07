package seedu.justbook;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit 5 JustBook Testing")
public class JustBookTest {
    static HashMap<LocalDate, LocalDate> POLICE = JustBook.BLOCKLIST;
    private static final PrintStream stdOut = System.out;
    private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeAll
    static void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        POLICE.put(LocalDate.of(2021,6,8), LocalDate.of(2021, 6, 30));
    }

    @Test
    @DisplayName("`block` CLI Command output test")
    public void setBlockRulesTest() {
        JustBook.setBlockRules("block", "2021-6-6 2021-6-5");

        assertEquals("Start date cannot be equal to or after the end date. Try again?",
                outputStreamCaptor.toString()
                .trim());
        outputStreamCaptor.reset();
    }

    @Test
    @DisplayName("`unblock` CLI Command test")
    public void setBlockRulesTest_2() {
        JustBook.setBlockRules("unblock", "2021-6-8 2021-6-30");

        assertEquals("Date Range: \"08/06/2021 - 30/06/2021\" has been successfully unblocked out in your scheduler",
                outputStreamCaptor.toString()
                        .trim());
        outputStreamCaptor.reset();
        // tests successful removal of block entry in POLICE
        assertEquals(0,POLICE.size());
    }

    @AfterAll
    static void tearDown() {
        System.setOut(stdOut);
        POLICE.clear();
        POLICE = null;
    }
}
