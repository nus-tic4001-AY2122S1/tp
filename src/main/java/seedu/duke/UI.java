package seedu.duke;

import seedu.duke.item.Item;

import java.util.ArrayList;
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
        System.out.println("Here are the items in your list:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + "." + items.get(i).toString());
        }
    }

    public static void deleteMessage(Item item, int size) {
        System.out.println("Noted. I've removed this item: ");
        System.out.println("  " + item);
        System.out.println("Now you have " + size + " items in the list.");
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

    public static void byeMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
