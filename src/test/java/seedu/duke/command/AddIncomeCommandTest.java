package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.item.Item;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddIncomeCommandTest {

    @Test
    public void addIncome() throws InputErrorException {

        ArrayList<Item> arrayListExpLst = new ArrayList<>();
        ItemList newIncomeLst = new ItemList(arrayListExpLst);

        AddIncomeCommand addIncome = new AddIncomeCommand("income OctSalary /salary /3000 /15-10-2021");
        addIncome.run(newIncomeLst);

        List<String> expected = List.of("[I] [salary] OctSalary ($3000.0) (2021-Oct-15)");
        assertEquals(expected.toString(), newIncomeLst.items.toString());
    }

}