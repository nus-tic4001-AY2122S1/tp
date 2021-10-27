/*
package seedu.duke.command;

import seedu.duke.itemList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.item.Item;

import java.util.Collections;
import java.util.Comparator;

public class SortCommand extends Command implements Comparable<Item> {

    public static Comparator<Item> expenseComparator = new Comparator<Item>() {
        public int compare(Item e1, Item e2) {
            int expense1 = (int)e1.getAmount();
            int expense2 = (int)e2.getAmount();
            return expense1 - expense2;
        }
    };

    public static Comparator<Item> expenseDescComparator = new Comparator<Item>() {
        public int compare(Item e1, Item e2) {
            int expense1 = (int)e1.getAmount();
            int expense2 = (int)e2.getAmount();
            return expense2 - expense1;
        }
    };

    //public static Comparator<Expense> expenseDateComparator = new Comparator<Expense>() {
    //public int compare(Expense e1, Expense e2) {
    //String expenseDate1 = e1.getDate();
    //String expenseDate2 = e2.getDate();
    //return expenseDate1.compareTo(expenseDate2);
    //}
    //};

    public SortCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(itemList itemList) {

        String sortingIndex = Parser.sortingIndex(fullCommand);
        switch (sortingIndex) {
        case "asc": {
            Collections.sort(itemList.expenses, expenseComparator);
            break;
        }
        case "desc": {
            Collections.sort(itemList.expenses, expenseDescComparator);
            break;
        }
        default:
            System.out.println("Please key in valid sorting command!");
        }

        UI.listMessage(itemList.expenses);
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }
}
*/