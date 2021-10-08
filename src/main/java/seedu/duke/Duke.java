package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.exit;
import static java.time.LocalDateTime.parse;

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
            String input = in.nextLine().replace("\\s+", " ").trim();

            if(input.equals("exit")){
                System.out.println("Bye! See you again!");
                exit(0);
            }

            String[] tokens = input.split(" ", 2);
            String command = tokens[0];

            switch(command) {
            case "add":
                String[] param = tokens[1].split("/[s,e] ");
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");

                LocalDateTime start = parse(param[1].trim(), format);
                LocalDateTime end = parse(param[2], format);

                appointments.add(new Bookings(param[0].trim(), start, end));
                break;
            case "edit":

                break;
            case "save":

                break;
            case "del":

                break;
            case "show":
                if(tokens[1].contains("--")){

                }
                if(tokens[1].contains(" - ")){

                }

                String date = tokens[1];
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
