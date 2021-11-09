package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

import java.time.LocalDate;
import java.util.Date;

public class SummaryCommand extends Command {
    /**
     * The function to initialize a SummaryCommand type variable
     */
    public SummaryCommand() {
        super("summary");
    }

    /**
     * The function to execute an summary command
     * In this function, summary of the usage will be printed
     * Printed summary:
     *                  - First day
     *                  - Total income
     *                  - Total expense
     *                  - Balance amount
     *                  - Average Daily Expense (first item to last item)
     *                  - Available remaining
     *
     * @param itemList
     */
    @Override
    public void run(ItemList itemList) {
        double overallExpenseAmount = itemList.getExpenseAmount();
        double overallIncomeAmount = itemList.getIncomeAmount();
        Date earliestDate = itemList.getEarliestDate();
        Date latestDate = itemList.getLatestDate();
        Date currentDate =  java.sql.Date.valueOf(LocalDate.now());

        long intervalDays = (latestDate.getTime() - earliestDate.getTime()) / 1000 / 60 / 60 / 24;

        if (itemList.size <= 0) {
            UI.printEmptyListMessage();
            return;
        }

        double mean = Math.round(overallExpenseAmount / intervalDays * 100.0) / 100.0;
        double remaining = overallIncomeAmount - overallExpenseAmount;
        long useDays = (currentDate.getTime() - earliestDate.getTime()) / 1000 / 60 / 60 / 24;

        UI.printSummaryMessage(mean, remaining,overallIncomeAmount, overallExpenseAmount, useDays, earliestDate);
    }
}
