package seedu.duke.command;

import seedu.duke.InputErrorException;
import seedu.duke.ItemList;
import seedu.duke.UI;
import seedu.duke.item.Expense;
import seedu.duke.item.Item;

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
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

        long intervalDays = latestDate.getTime() - earliestDate.getTime();

        if (itemList.size <= 0) {
            UI.printEmptyListMessage();
            return;
        }

        double mean = overallExpenseAmount / intervalDays;
        double remaining = overallIncomeAmount - overallExpenseAmount;
        long useDays = currentDate.getTime() - earliestDate.getTime();

        UI.printSummaryMessage(mean, remaining,overallIncomeAmount, overallExpenseAmount, useDays, earliestDate);
    }
}
