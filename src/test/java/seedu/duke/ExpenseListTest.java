package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.expense.Expense;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpenseListTest {

    @Test
    public void addExpense() {
        Date recordDate = new Date();
        long time = recordDate.getTime();
        Timestamp timestamp = new Timestamp(time);

        assertEquals("[Monday] lunch ($12.0) (System datetime:" + timestamp + ")",
                new Expense("Monday", "lunch", 12.0, timestamp).toString());
    }
}