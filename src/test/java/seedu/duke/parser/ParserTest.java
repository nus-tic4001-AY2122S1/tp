package seedu.duke.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.duke.commands.AddCommand;
import seedu.duke.commands.Command;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.DoneCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.commands.SetCommand;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {

    private Parser parser;

    @BeforeEach
    public void setUp() {
        parser = new Parser();
    }

    @Test
    public void test_Parse_ExitCommand() {
        final String[] inputs = {"bye", " bye", "bye ", "  bye   "};
        for (String input : inputs) {
            parseAndAssertCommandType(input, ExitCommand.class);
        }
    }

    @Test
    public void test_Parse_AddCommand() {
        final String input = "add task1";
        parseAndAssertCommandType(input, AddCommand.class);
    }

    @Test
    public void test_Parse_DeleteCommand() {
        final String input = "delete 1 2 4";
        parseAndAssertCommandType(input, DeleteCommand.class);
    }

    @Test
    public void test_Parse_DoneCommand() {
        final String input = "done 4 5 6";
        parseAndAssertCommandType(input, DoneCommand.class);
    }

    @Test
    public void test_Parse_ListCommand() {
        final String input = "list inbox";
        parseAndAssertCommandType(input, ListCommand.class);
    }

    @Test
    public void test_Parse_MoveCommand() {
        final String input = "set 1 2 4 next";
        parseAndAssertCommandType(input, SetCommand.class);
    }


    /**
     * Parses input and asserts the class/type of the returned command object.
     *
     * @param input                to be parsed
     * @param expectedCommandClass expected class of returned command
     * @return the parsed command object
     */
    private <T extends Command> T parseAndAssertCommandType(String input, Class<T> expectedCommandClass) {
        final Command result = parser.parse(input);
        assertTrue(result.getClass().isAssignableFrom(expectedCommandClass));
        return (T) result;
    }
}
