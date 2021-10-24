package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.command.AddExpenseCommand;
import seedu.duke.expense.Expense;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    @Test
    void commandTest() {
        assertEquals("add", Parser.command("add lunch /Monday /SGD12.50"));
    }

    @Test
    void indexTest() {
        assertEquals(3, Parser.index("delete 4"));
    }

    @Test
    void descriptionTest() {
        assertEquals("lunch", Parser.description("add lunch /Monday /SGD12.50"));
    }

    @Test
    void dateTest() throws InputErrorException, ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String d1s = "12-Dec-2021";
        Date d1 = formatter.parse(d1s);
        Date d2 = Parser.date("add lunch /12-Dec-2021 /SGD12.50");

        assertEquals(d1, d2);
    }

    @Test
    void amountTest() {
        assertEquals(12.50, Parser.amount("add lunch /Monday /SGD12.50"));
    }
}
