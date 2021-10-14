package seedu.duke;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private static Scanner in;
    
    public Ui() {
        this.in = new Scanner(System.in);
    }


    public static void welcome() {
        System.out.println("Welcome to NUS module tracker \n"
                +          "What can I do for you?\n");
    }

    public static String readCommand() {
        System.out.print("Type something: ");
        String line = in.nextLine();
        return line;
    }

    public static void exitMsg() {
        System.out.println("Good bye!");
    }

    public static void printListEmpty() {
        System.out.print("List is empty!");
    }

    public static void printRemoveTask() {
        System.out.print("Noted. I've removed this task:");
    }

    public static void printNumberOfTasks(ArrayList<Module> userList) {
        System.out.print("Now you have " + (userList.size()) + " tasks in the list.");
    }

    public static void printNumberFormatException() {
        System.out.print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void printIndexOutOfRangeException() {
        System.out.print("%s☹ OOPS!!! Out of Range!");
    }

}
