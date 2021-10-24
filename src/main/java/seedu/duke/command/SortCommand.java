package seedu.duke.command;

import seedu.duke.ExpenseList;
import seedu.duke.Parser;
import seedu.duke.UI;
import seedu.duke.expense.Expense;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class SortCommand extends Command implements Comparable<Expense> {

    public static Comparator<Expense> expenseComparator = new Comparator<Expense>() {
        public int compare(Expense e1, Expense e2) {
            int expense1 = (int)e1.getAmount();
            int expense2 = (int)e2.getAmount();
            return expense1 - expense2;
        }
    };

    public static Comparator<Expense> expenseDescComparator = new Comparator<Expense>() {
        public int compare(Expense e1, Expense e2) {
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

    public void run(ExpenseList expenseList) {

        String sortingIndex = Parser.sortingIndex(fullCommand);
        switch (sortingIndex) {
        case "asc": {
            Collections.sort(expenseList.expenses, expenseComparator);
            break;
        }
        case "desc": {
            Collections.sort(expenseList.expenses, expenseDescComparator);
            break;
        }
        default:
            System.out.println("Please key in valid sorting command!");
        }

        UI.listMessage(expenseList.expenses);
    }

    @Override
    public int compareTo(Expense o) {
        return 0;
    }
}
