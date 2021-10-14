package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.expense.Expense;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseListTest {

    @Test
    public void addExpense() {
        assertEquals("[Monday] lunch ($12.0)",new Expense("Monday", "lunch", 12.0).toString());
    }

}