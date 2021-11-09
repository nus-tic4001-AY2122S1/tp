package seedu.duke;

import seedu.duke.item.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class UI {
    public static void welcome() {
        System.out.println("Hi, I am Duke!");
        System.out.println("What can I help you?");
    }

    public static String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static void addMessage(Item item, int size) {
        System.out.println("Got it. I've added this item: ");
        System.out.println("  " + item.toString());
        System.out.println("Now you have " + size + " items in the list.");
    }

    public static void listMessage(ArrayList<Item> items) {

        if (items.size() != 0) {
            System.out.println("Here are the items in your list:");
        } else {
            System.out.println("The expense/salary's list is empty.\n");
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + "." + items.get(i).toString());
        }
    }

    public static void listSortingResult(ArrayList<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + "." + items.get(i).toString());
        }
    }

    /**
     * The function to print out the delete message.
     * In the delete message, the message be deleted details and the remaining item amount will be printed
     *
     * @param item the item be deleted
     * @param size the remaining size of the list
     */
    public static void deleteMessage(Item item, int size) {
        System.out.println("Noted. I've removed this item: ");
        System.out.println("  " + item);
        System.out.println("Now you have " + size + " items in the list.");
    }

    public static void editMessage(int index, ArrayList<Item> items, Item oldItem) {
        System.out.println("Noted. I've edited this item: ");
        System.out.println("Old: " + (index + 1) + "." + oldItem.toString());
        System.out.println("New: " + (index + 1) + "." + items.get(index).toString());
    }

    public static void findMessage(ArrayList<Item> items, ArrayList<Integer> findResult) {
        if (findResult.size() == 0) {
            System.out.println("Oops!!! None of item can be found");
        } else {
            System.out.println("Here are the matching items in your list:");
            for (int index : findResult) {
                System.out.println(index + 1 + "." + items.get(index).toString());
            }
        }
    }

    public static void printEmptyListMessage() {
        System.out.println("\nOops!!! There is no record in the system. Please add something first.\n");
    }

    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    /**
     * The function to print user using summary
     * Things to be printed:
     *                         - First day
     *                         - Total income
     *                         - Total expense
     *                         - Balance amount
     *                         - Average Daily Expense (first item to last item)
     *                         - Available remaining
     * @param mean all expense average
     * @param remaining remaining amount ( Total income - total expense )
     * @param totalIncome total income from the first day
     * @param totalExpense total expense from the first day
     * @param days total days using this software
     * @param firstDay the first day to use this software
     */
    public static void printSummaryMessage(double mean,
                                           double remaining,
                                           double totalIncome,
                                           double totalExpense,
                                           long days,
                                           Date firstDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
        String firstDayInfo = sdf.format(firstDay);

        System.out.println("\n   Your Summary:");
        System.out.println("      From '" + firstDayInfo + "' until now, you have use this system " + days + " days");
        System.out.println("      TotalIncome: " + totalIncome);
        System.out.println("      TotalExpense: " + totalExpense);
        System.out.println("      Balance Amount: " + (totalIncome - totalExpense));
        System.out.println("      Average Daily Expense (first item to last item): " + mean);
        System.out.println("      Available Remaining: " + remaining);
    }
}
