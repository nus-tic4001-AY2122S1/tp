package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortCommandTest {

    @Test
    public void sortByAmountAsc() throws InputErrorException {
        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ItemList actualList = new ItemList(arrayListExpLst);

        AddExpenseCommand addFirstExpense = new AddExpenseCommand("expense lunch /Meal /40 /1-12-2021");
        AddExpenseCommand addSecondExpense = new AddExpenseCommand("expense lunch /Meal /20 /1-12-2021");
        AddIncomeCommand addFirstIncome = new AddIncomeCommand("income salary /OctSalary /4000 /1-12-2021");

        addFirstExpense.run(actualList);
        addSecondExpense.run(actualList);
        addFirstIncome.run(actualList);

        SortCommand sort = new SortCommand("sort /asc /amount");
        sort.run(actualList);

        List<String> expected = List.of("[E] [Meal] lunch ($20.0) (2021-Dec-01), "
                                + "[E] [Meal] lunch ($40.0) (2021-Dec-01), "
                                + "[I] [OctSalary] salary ($4000.0) (2021-Dec-01)");
        assertEquals(expected.toString(), actualList.items.toString());
    }

    @Test
    public void sortByDateAsc() throws InputErrorException {
        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ItemList actualList = new ItemList(arrayListExpLst);

        AddExpenseCommand addFirstExpense = new AddExpenseCommand("expense lunch /Meal /40 /3-12-2021");
        AddExpenseCommand addSecondExpense = new AddExpenseCommand("expense lunch /Meal /20 /2-12-2021");
        AddIncomeCommand addFirstIncome = new AddIncomeCommand("income salary /OctSalary /4000 /1-12-2021");

        addFirstExpense.run(actualList);
        addSecondExpense.run(actualList);
        addFirstIncome.run(actualList);

        SortCommand sortByAsc = new SortCommand("sort /asc /date");

        sortByAsc.run(actualList);

        List<String> expectedSortByAsc = List.of("[I] [OctSalary] salary ($4000.0) (2021-Dec-01), "
                                        + "[E] [Meal] lunch ($20.0) (2021-Dec-02), "
                                        + "[E] [Meal] lunch ($40.0) (2021-Dec-03)");

        assertEquals(expectedSortByAsc.toString(), actualList.items.toString());
    }

    @Test
    public void sortByDateDesc() throws InputErrorException {
        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ItemList actualListDesc = new ItemList(arrayListExpLst);

        AddExpenseCommand addFirstExpense = new AddExpenseCommand("expense lunch /Meal /40 /3-12-2021");
        AddExpenseCommand addSecondExpense = new AddExpenseCommand("expense lunch /Meal /20 /2-12-2021");
        AddIncomeCommand addFirstIncome = new AddIncomeCommand("income salary /OctSalary /4000 /1-12-2021");

        addFirstExpense.run(actualListDesc);
        addSecondExpense.run(actualListDesc);
        addFirstIncome.run(actualListDesc);

        SortCommand sortByDesc = new SortCommand("sort /desc /date");

        sortByDesc.run(actualListDesc);

        List<String> expectedSortByDesc = List.of("[E] [Meal] lunch ($40.0) (2021-Dec-03), "
                                            + "[E] [Meal] lunch ($20.0) (2021-Dec-02), "
                                            + "[I] [OctSalary] salary ($4000.0) (2021-Dec-01)");

        assertEquals(expectedSortByDesc.toString(), actualListDesc.items.toString());
    }
}
