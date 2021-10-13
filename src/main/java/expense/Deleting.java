package expense;

import java.util.ArrayList;

public class Deleting {
    //private int expenseIndex;
    private ArrayList<Expense> expList;

    Deleting(ArrayList expList) {

        this.expList = expList;
    }

    ArrayList deleteExpense(int index) {
        this.expList.remove(index);

        return this.expList;
    }
}
