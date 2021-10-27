package seedu.duke;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void indexTest() {
        assertEquals(3, Parser.index("4"));
    }

    @Test
    void dateTest() throws InputErrorException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = formatter.parse("12-12-2021");
        Date d2 = Parser.date("12-12-2021");

        assertEquals(d1, d2);
    }

    @Test
    void amountTest() {
        assertEquals(12.50, Parser.amount("12.50"));
    }
}
