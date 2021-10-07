package seedu.duke;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;

public class Duke {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    static final List<Bookings> appointments = new ArrayList<>();

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("Hello " + name);

        // write your code here
        System.out.printf("Hello %s! Welcome back.%n", name);
        System.out.println("You can now proceed to do your book\n");

        while (true) {
            System.out.println("User: ");
            String input = in.nextLine().replace("\\s+", " ");

            if(input.trim().equals("exit")){
                System.out.println("Bye! See you again!");
                exit(0);
            }

            String[] tokens = input.split(" /");
            String command = tokens[0].substring(0, tokens[0].indexOf(" "));

            switch(command) {
            case "add":
                appointments.add(new Bookings(tokens[0].substring(4),
                        LocalDateTime.parse(tokens[1].substring(2)),
                        LocalDateTime.parse(tokens[2].substring(2))));
                break;
            case "edit":

                break;
            case "save":

                break;
            case "del":

                break;
            case "show":
                if(tokens[0].contains("--")){

                }
                if(tokens[0].contains(" - ")){

                }

                String date = tokens[0].substring(5);
                System.out.printf("Date: %s\n", date.replaceAll("-", "/"));
                int counter = 1;

                for (Bookings item : appointments) {

                    if (date.equals(item.getStartDate())) {
                        System.out.println(counter + ". " + item);
                        counter++;
                    }

                    System.out.println();
                }
                break;
            case "block":

                break;
            case "unblock":

                break;
            case "help":

                break;
            default:

            }
        }
    }
}
