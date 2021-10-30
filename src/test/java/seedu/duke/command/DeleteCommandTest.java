package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCommandTest {

    @Test
    public void deleteExpense() throws ParseException, InputErrorException, InputErrorException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String d1s = "11-Dec-2021";
        String d2s = "12-Dec-2021";
        Date d1 = formatter.parse(d1s);
        Date d2 = formatter.parse(d2s);

        Item testerExpense1 = new Item("taxi", "Daily", 22, d1, "income");
        Item testerExpense2 = new Item("dinner", "Dinner", 33, d2, "expense");

        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ArrayList<Item> expectedArrayLst = new ArrayList<>();

        arrayListExpLst.add(testerExpense1);
        arrayListExpLst.add(testerExpense2);

        expectedArrayLst.add(testerExpense2);

        ItemList newExpLst = new ItemList(arrayListExpLst);
        ItemList expect = new ItemList(expectedArrayLst);

        DeleteCommand newDC = new DeleteCommand("Delete 1");

        newDC.run(newExpLst);

        assertEquals(expect.items, newExpLst.items);
    }
}
