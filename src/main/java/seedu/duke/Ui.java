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

    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void exitMsg() {
        System.out.println("Good bye!");
    }

    public static void printListEmpty() {
        System.out.print("List is empty!");
    }

    public static void printRemoveModule() {
        System.out.println("Noted. I've removed this module:");
    }

    public static void printNumberOfModules(ArrayList<Module> userList) {
        System.out.println("Now you have " + (userList.size()) + " modules in the list.");
    }

    public static void printAddedModules(ArrayList<Module> userList) {
        System.out.print(userList.get(userList.size() - 1).getModuleCode() + " - ");
        System.out.println(userList.get(userList.size() - 1).getModuleTitle());
    }

    public static void printModule(ArrayList<Module> userList) {
        System.out.println("Got it. I've added this module:");
        printAddedModules(userList);
        printNumberOfModules(userList);
    }

    public static void printShortModuleInfo(Module module){
        System.out.println(module.getBasicModuleDetails());
    }

    public static void printNumberFormatException() {
        System.out.print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public static void printIndexOutOfRangeException() {
        System.out.print("%s☹ OOPS!!! Out of Range!");
    }

}
