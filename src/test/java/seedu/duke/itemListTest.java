/*
package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.item.Item;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class itemListTest {

    @Test
    public void addExpense() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        String d1s = "11-Dec-2021";
        Date d1 = formatter.parse(d1s);

        Date recordDate = new Date();
        long time = recordDate.getTime();
        Timestamp timestamp = new Timestamp(time);
        Item tester = new Item(d1, "lunch", 12.0, timestamp);

        assertEquals("[2021-Dec-11] lunch ($12.0) (System datetime: " + timestamp + ")",
                new Item(d1, "lunch", 12.0, timestamp).toString());
    }
}

 */