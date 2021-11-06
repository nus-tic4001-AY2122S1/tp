
package seedu.duke.command;

import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.item.Item;

import java.lang.reflect.Parameter;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SortCommand extends Command implements Comparable<Item> {

    public static Comparator<Item> expenseAscComparator = new Comparator<Item>() {
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

    public static Comparator<Item> expenseDateAscComparator = new Comparator<Item>() {
        public int compare(Item e1, Item e2) {
            Date expenseDate1 = e1.getDate();
            Date expenseDate2 = e2.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
            return sdf.format(expenseDate1).compareTo(sdf.format(expenseDate2));
        }
    };

    public static Comparator<Item> expenseDateDescComparator = new Comparator<Item>() {
        public int compare(Item e1, Item e2) {
            Date expenseDate1 = e1.getDate();
            Date expenseDate2 = e2.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
            return sdf.format(expenseDate2).compareTo(sdf.format(expenseDate1));
        }
    };

    public SortCommand(String fullCommand) {
        super(fullCommand);
    }

    public void run(ItemList itemList) throws InputErrorException {

        if (itemList.size == 0) {
            throw new InputErrorException("SortByEmptyFileList");
        }

        ItemList sortingItemList = itemList;

        String[] sortDescription = Parser.sortDesc(fullCommand);

        String sortingByDescription = sortDescription[1];
        assert sortingByDescription != " " : "Sorting by Description should not be empty";
        String sortingByCategory = sortDescription[2];
        assert sortingByCategory != " " : "Sorting by Category should not be empty";


        switch (sortingByDescription) {
        case "asc": {
            if (sortingByCategory.equals("amount")) {
                Collections.sort(sortingItemList.items, expenseAscComparator);
            } else if (sortingByCategory.equals("date")) {
                Collections.sort(sortingItemList.items, expenseDateAscComparator);
            } else {
                System.out.println("Please key in valid sorting command!");
            }
            break;
        }
        case "desc": {
            if (sortingByCategory.equals("amount")) {
                Collections.sort(sortingItemList.items, expenseDescComparator);
            } else if (sortingByCategory.equals("date")) {
                Collections.sort(sortingItemList.items, expenseDateDescComparator);
            } else {
                System.out.println("Please key in valid sorting command!");
            }
            break;
        }
        default:
            System.out.println("Please key in valid sorting command!");
        }

        UI.listSortingResult(sortingItemList.items);
    }

    @Override
    public int compareTo(Item o) {
        return 0;
    }
}
