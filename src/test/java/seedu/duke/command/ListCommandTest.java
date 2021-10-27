/*
package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.ItemList;
import seedu.duke.InputErrorException;
import seedu.duke.item.Item;

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

        Item testerExpense1 = new Item(d1, "taxi", 22, timestamp);
        Item testerExpense2 = new Item(d2, "dinner", 33, timestamp);

        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ArrayList<Item> expectedArrayLst = new ArrayList<>();

        arrayListExpLst.add(testerExpense1);
        arrayListExpLst.add(testerExpense2);

        expectedArrayLst.add(testerExpense1);
        expectedArrayLst.add(testerExpense2);

        ItemList newExpLst = new ItemList(arrayListExpLst);
        ItemList expect = new ItemList(expectedArrayLst);

        ListCommand listCommand = new ListCommand("list");

        listCommand.run(newExpLst);

        assertEquals(expect.expenses, newExpLst.expenses);
    }
}

 */