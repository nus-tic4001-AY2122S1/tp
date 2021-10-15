package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.ExpenseList;
import seedu.duke.expense.Expense;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListCommandTest {

    @Test
    public void getCommandTest() {

        String d1 = "2011/11/22";
        String d2 = "2022/11/12";

        Expense testerExpense1 = new Expense(d1, "taxi", 22);
        Expense testerExpense2 = new Expense(d2, "dinner", 33);

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