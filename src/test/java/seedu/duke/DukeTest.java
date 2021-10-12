package seedu.duke;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DukeTest {
    @Test
    public void sampleTest() {
        Expense expense = new Expense("1/10/2021","Meal", 10.0 ,"Lunch");
        assertEquals("1/10/2021 Meal Lunch $10.0", expense.toString());
    }
}