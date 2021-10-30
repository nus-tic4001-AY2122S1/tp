package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCommandTest {

    @Test
    public void delete() throws InputErrorException {

        Date recordDate = new Date();
        long time = recordDate.getTime();
        Timestamp timestamp = new Timestamp(time);

        Item tester = new Item("lunch", "F&B", 33, timestamp, "expense");

        ArrayList<Item> arrayListTester = new ArrayList<>();

        arrayListTester.add(tester);
        ItemList newExpLst = new ItemList(arrayListTester);

        DeleteCommand delete = new DeleteCommand("delete 1");
        delete.run(newExpLst);

        List<String> expected = List.of("");
        assertEquals(expected.toString(), newExpLst.items.toString());
    }

}