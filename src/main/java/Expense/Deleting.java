package Expense;

import java.util.ArrayList;

public class Deleting {
    private int expenseIndex;
    private ArrayList<Expense> expList;

    Deleting(int index, ArrayList expList) {
        this.expenseIndex = index;
    }

    ArrayList deleteExpense(int index){
        this.expList.remove(expenseIndex);

        return this.expList;
    }
}
