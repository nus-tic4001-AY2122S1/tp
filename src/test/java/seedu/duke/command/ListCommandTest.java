package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.ExpenseList;
import seedu.duke.InputErrorException;
import seedu.duke.expense.Expense;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListCommandTest {

    @Test
    public void getCommandTest() throws ParseException, InputErrorException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String d1s = "11-Dec-2021";
        String d2s = "12-Dec-2021";
        Date d1 = formatter.parse(d1s);
        Date d2 = formatter.parse(d2s);

        Date recordDate = new Date();
        long time = recordDate.getTime();
        Timestamp timestamp = new Timestamp(time);

        Expense testerExpense1 = new Expense(d1, "taxi", 22, timestamp);
        Expense testerExpense2 = new Expense(d2, "dinner", 33, timestamp);

        ArrayList<Expense> arrayListExpLst = new ArrayList<>();
        ArrayList<Expense> expectedArrayLst = new ArrayList<>();

        arrayListExpLst.add(testerExpense1);
        arrayListExpLst.add(testerExpense2);

        expectedArrayLst.add(testerExpense1);
        expectedArrayLst.add(testerExpense2);

        ExpenseList newExpLst = new ExpenseList(arrayListExpLst);
        ExpenseList expect = new ExpenseList(expectedArrayLst);

        ListCommand listCommand = new ListCommand("list");

        listCommand.run(newExpLst);

        assertEquals(expect.expenses, newExpLst.expenses);
    }
}