package Expense;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DeletingTest {
    @Test
    void deleteExp(){
        ArrayList<Expense> testList = new ArrayList<Expense>();
        ArrayList<Expense> expectedList = new ArrayList<Expense>();

        Date d1 = new Date(2021, 05,22);
        Date d2 = new Date(2021, 04, 11);
        Expense testExpense1 = new Expense(88, d1, "Dinner");
        Expense testExpense2 = new Expense(11, d2,"Lunch");

        testList.add(testExpense1);
        testList.add(testExpense2);

        expectedList.add(testExpense2);

        Deleting testerList = new Deleting(testList);

        assertEquals(expectedList, testerList.deleteExpense(0));
    }
}
