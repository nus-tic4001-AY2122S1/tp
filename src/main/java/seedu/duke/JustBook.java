package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.time.LocalDateTime.parse;


public class JustBook {
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
        String userName = in.nextLine();
        System.out.printf("Hello " + userName);

        // write your code here
        System.out.printf("Welcome back!" + userName);
        System.out.printf("You can now proceed to do your booking :)%n");

        while (true) {
            System.out.printf(userName + ": ");
            String input = in.nextLine().replace("\\s+", " ").trim();

            if (input.equals("exit")) {
                System.out.println("Bye! See you again!");
                exit(0);
            }

            String[] tokens = input.split(" ", 2);
            String command = tokens[0];

            switch (command) {
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
                int index = tokens[1].indexOf("/o");
                String inputDate = tokens[1].substring(0, index).trim();
                String optionNumber = tokens[1].substring(index).replace("/o", "").trim();
                DeleteCommand del = new DeleteCommand(inputDate, optionNumber);
                del.execute(appointments);
                break;
            case "show":


                String date = tokens[1];
                System.out.printf("Date: %s\n", date.replaceAll("-", "/"));
                int counter = 1;

                for (Bookings item : appointments) {
                    if (date.equals(item.getStartDateString())) {
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
                HelpCommand help = new HelpCommand();
                help.execute();
                break;
            default:

            }
        }
    }
}
