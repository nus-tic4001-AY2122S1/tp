package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCommandTest {

    @Test
    public void getCommandTest() {

        Date recordDate = new Date();
        long time = recordDate.getTime();
        Timestamp timestamp = new Timestamp(time);

        Item testerIncome = new Item("lunch", "F&B", 30, timestamp, "expense");
        Item testerExpense = new Item("dinner", "F&B", 33, timestamp, "expense");

        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ArrayList<Item> expectedArrayLst = new ArrayList<>();

        arrayListExpLst.add(testerIncome);
        arrayListExpLst.add(testerExpense);

        expectedArrayLst.add(testerIncome);
        expectedArrayLst.add(testerExpense);

        ItemList newExpLst = new ItemList(arrayListExpLst);
        ItemList expect = new ItemList(expectedArrayLst);
        ListCommand listCommand = new ListCommand("list");
        listCommand.run(newExpLst);
        assertEquals(expect.items, newExpLst.items);
    }
}

