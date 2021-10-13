package seedu.duke;

import java.util.Scanner;

public class UI {
    /**
     * Welcome message to be shown when the programme starts.
     */
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
        return in.nextLine();
    }
}
