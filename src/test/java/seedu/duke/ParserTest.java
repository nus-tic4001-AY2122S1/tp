package seedu.duke;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void commandTest() {
        assertEquals("delete", Parser.command("delete 4"));
    }

    @Test
    void indexTest() throws InputErrorException {
        assertEquals(3, Parser.index("delete 4"));
    }

    @Test
    void descriptionTest() {
        assertEquals("lunch", Parser.description("expense lunch /food /12 /12-12-2021"));
    }

    @Test
    void categoryTest() throws InputErrorException {
        assertEquals("food", Parser.category("expense lunch /food /12 /12-12-2021"));
    }

    @Test
    void amountTest() throws InputErrorException {
        assertEquals(12.0, Parser.amount("expense lunch /food /12 /12-12-2021"));
    }

    @Test
    void dateTest() throws InputErrorException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date d1 = formatter.parse("12-12-2021");
        Date d2 = Parser.date("expense lunch /food /12 /12-12-2021");
        assertEquals(d1, d2);
    }
}
