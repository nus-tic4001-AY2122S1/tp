package seedu.duke;

import seedu.duke.expense.Expense;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    public static void welcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I help you?");
    }

    public static String readCommand() {
        Scanner in = new Scanner(System.in);
        assert !in.toString().isEmpty(): "Input is blank";
        return in.nextLine();
    }

    public static void addMessage(Expense expense, int size) {
        System.out.println("Got it. I've added this expense: ");
        System.out.println("  " + expense.toString());
        System.out.println("Now you have " + size + " expenses in the list.");
    }

    public static void listMessage(ArrayList<Expense> expenses) {
        System.out.println("Here are the expenses in your list:");
        for (int i = 0; i < expenses.size(); i++) {
            System.out.println(i + 1 + "." + expenses.get(i).toString());
        }
    }

    public static void deleteMessage(Expense expense, int size) {
        System.out.println("Noted. I've removed this expense: ");
        System.out.println("  "  + expense);
        System.out.println("Now you have " + size + " expenses in the list.");
    }

    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
