package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SummaryCommandTest {
    @Test
    void summaryCommand() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        String d1s = "11-12-2021";
        String d2s = "12-12-2021";
        String d3s = "24-01-2021";
        String d4s = "01-01-2021";

        Date d1 = formatter.parse(d1s);
        Date d2 = formatter.parse(d2s);
        Date d3 = formatter.parse(d3s);
        Date d4 = formatter.parse(d4s);

        Item testerExpense1 = new Item("taxi", "Daily", 22, d1, "expense");
        Item testerExpense2 = new Item("dinner", "Dinner", 33, d2, "expense");
        Item testerExpense3 = new Item("buy books", "study", 12.3, d3, "expense");
        Item testerExpense4 = new Item("Jan salary", "salary", 3000, d4, "income");

        ArrayList<Item> arrayListExpLst = new ArrayList<>();

        arrayListExpLst.add(testerExpense1);
        arrayListExpLst.add(testerExpense2);
        arrayListExpLst.add(testerExpense3);
        arrayListExpLst.add(testerExpense4);

        ItemList itemL = new ItemList(arrayListExpLst);

        SummaryCommand sc = new SummaryCommand();

        sc.run(itemL);


    }
}
