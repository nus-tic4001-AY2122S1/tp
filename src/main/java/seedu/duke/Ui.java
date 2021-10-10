package seedu.duke;

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

}
