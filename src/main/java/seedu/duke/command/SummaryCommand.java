package seedu.duke.command;

import seedu.duke.ItemList;
import seedu.duke.UI;

import java.time.LocalDate;
import java.util.Date;

public class SummaryCommand extends Command {

    public SummaryCommand() {
        super("summary");
    }

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

        double mean = Math.round(overallExpenseAmount / intervalDays * 1000.0) / 1000.0;
        double remaining = overallIncomeAmount - overallExpenseAmount;
        long useDays = (currentDate.getTime() - earliestDate.getTime()) / 1000 / 60 / 60 / 24;

        UI.printSummaryMessage(mean, remaining,overallIncomeAmount, overallExpenseAmount, useDays, earliestDate);
    }
}
