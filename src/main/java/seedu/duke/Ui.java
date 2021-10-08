package seedu.duke;

import java.util.Scanner;

public class Ui {

    public static void welcome(){
        System.out.println("Welcome to NUS module tracker \n"
                +          "What can I do for you?\n");
    }
    
    public static String readCommand(){
        String line;
        Scanner in = new Scanner(System.in);
        System.out.print("Type something: ");
        line = in.nextLine();
        return line;
    }

}
