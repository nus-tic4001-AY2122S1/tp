package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddExpenseCommandTest {

    @Test
    public void AddExpense() throws InputErrorException {

        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ItemList newExpLst = new ItemList(arrayListExpLst);

        AddExpenseCommand addExpense = new AddExpenseCommand("expense lunch /F&B /23 /12-12-2021");
        addExpense.run(newExpLst);

        List<String> expected = List.of("[E] [F&B] lunch ($23.0) (2021-Dec-12)");
        assertEquals(expected.toString(), newExpLst.items.toString());
    }
}