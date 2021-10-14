package seedu.duke;

import org.junit.jupiter.api.Test;

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
    void dateTest() {
        assertEquals("Monday", Parser.date("add lunch /Monday /SGD12.50"));
    }

    @Test
    void amountTest() {
        assertEquals(12.50, Parser.amount("add lunch /Monday /SGD12.50"));
    }
}
