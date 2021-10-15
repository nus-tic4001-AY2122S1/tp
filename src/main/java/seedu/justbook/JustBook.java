package seedu.justbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.System.exit;
import static java.time.LocalDateTime.parse;
import static java.util.Comparator.comparing;

public class JustBook {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    static final List<Bookings> appointments = new ArrayList<>();
    static final HashMap<LocalDate, LocalDate> BLOCKLIST = new HashMap<>(5);
    private static final Logger logger = Logger.getLogger(JustBook.class.getName());

    public static void main(String[] args) {

        try {
            onLoad();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        String userName = in.nextLine();

        System.out.printf("Hello %s,%n", userName);
        // write your code here
        System.out.printf("Welcome back!%n");
        System.out.printf("You can now proceed to do your booking :)%n");

        while (true) {
            System.out.printf("%n%s: ", userName);
            String input = in.nextLine().replace("\\s+", " ").trim();

            if (input.equals("exit") || input.equals("bye")) {
                System.out.println("Bye! See you again!");

                int size = appointments.size();

                logger.log(Level.INFO, "going to start processing");

                try {
                    assert(size != 0) : "database size should not be 0";
                } catch (AssertionError ex) {
                    logger.log(Level.WARNING, "processing error", ex);
                }

                logger.log(Level.INFO, "end of processing");

                int i = 0;
                while (i < size) {
                    onSave();
                    i++;
                }

                in.close();
                exit(0);
            }

            String[] tokens = input.split(" ", 2);
            String command = tokens[0];
            String inputContent = "";
            if (tokens.length >= 2) {
                inputContent = tokens[1];
            }

            switch (command) {
            case "add":
                String[] arguments = inputContent.split("/[s,e] ");

                DateTimeFormatter format = DateTimeFormatter.ofPattern("[yyyy-M-d K:mm a][yyyy-M-d HH:mm]");
                LocalDateTime start = parse(arguments[1].trim().toUpperCase(), format);
                LocalDate startLocalDate = start.toLocalDate();
                Map.Entry<Boolean, Map.Entry<LocalDate, LocalDate>> result = isInRange(startLocalDate);

                if (result.getKey()) {
                    System.out.printf("'%s' denied process by current BLOCKLIST => StartDate: [%s] - EndDate: [%s]%n",
                            startLocalDate, result.getValue().getKey(), result.getValue().getValue());
                    continue;
                }

                LocalDateTime end = parse(arguments[2].toUpperCase(), format);
                String booking = arguments[0].trim();
                appointments.add(new Bookings(booking, start, end));
                System.out.printf("Successfully added \"%s\" from %s to %s%n",
                        booking, start, end);
                break;
            case "edit":
                String[] segments = inputContent.split(" /o ", 2);
                String[] subSeg = segments[0].split(" /s ", 2);
                int optionNum = Integer.parseInt(segments[1]);
                String bookDesc = subSeg[0];
                String chosenDate = subSeg[1];

                edit(bookDesc, chosenDate, optionNum);
                break;
            case "save":
                int size = appointments.size();
                int i = 0;
                while (i < size) {
                    onSave();
                    i++;
                }
                break;
            case "del":
                if (inputContent.contains("all")) {
                    appointments.clear();
                    System.out.println("Successfully deleted all appointment records");
                }

                int index = inputContent.indexOf("/o");
                String inputDate = inputContent.substring(0, index).trim();
                String optionNumber = inputContent.substring(index).replace("/o", "").trim();
                DeleteCommand del = new DeleteCommand(inputDate, optionNumber);
                del.execute(appointments);
                break;
            case "show":
                int listNum = 1;

                if (inputContent.contains("all")) {

                    if (appointments.size() == 0) {
                        System.out.println("Current appointments list is : empty");
                    }
                    // sorts the database in ascending order
                    appointments.sort(comparing(Bookings::getStartDateTime));
                    int total = appointments.size();
                    //displays user's complete list of bookings in the database
                    System.out.println();

                    for (i = 0; i < total; ) {
                        LocalDate startDate = appointments.get(i).getStartDate();
                        String dateHeader = String.valueOf(startDate).replaceAll("-", "/");
                        System.out.printf("Date: %s%n", dateHeader);

                        while (i < total && appointments.get(i).getStartDate().equals(startDate)) {
                            System.out.printf("%d. %s%n", listNum++, appointments.get(i));
                            i++;
                        }
                        // resets ListNum value to 1 for next date header
                        listNum = 1;
                        System.out.println();
                    }
                } else if (inputContent.matches("^(.*)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
                    LocalDate localDate = LocalDate.parse(inputContent, DateTimeFormatter.ofPattern("yyyy-M-d"));
                    String putDate = String.valueOf(localDate).replaceAll("-", "/");

                    //displays the specified date booking(s) of user
                    LocalDate dateIso;
                    System.out.printf("%nDate: %s%n", putDate);

                    if (inputContent.matches("^((2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
                        dateIso = LocalDate.parse(inputContent);
                    } else {
                        dateIso = getLocalDate(inputContent);
                    }

                    for (Bookings item : appointments) {

                        if (dateIso.equals(item.getStartDate())) {
                            System.out.printf("%d. %s%n", listNum++, item);
                        }
                    }
                    System.out.println();
                }
                break;
            case "block":
                String[] parts = inputContent.split(" - ");
                LocalDate commence = getLocalDate(parts[0]);
                LocalDate terminate = getLocalDate(parts[1]);
                String startString = commence.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String endString = terminate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                BLOCKLIST.put(commence, terminate);
                System.out.printf("Date Range: \"%s - %s\" has been successfully blocked out in your scheduler%n",
                        startString, endString);
                break;
            case "unblock":
                String[] items = inputContent.split(" - ");
                LocalDate begin = getLocalDate(items[0]);
                LocalDate stop = getLocalDate(items[1]);
                String beginString = begin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                String stopString = stop.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                BLOCKLIST.remove(begin);
                System.out.printf("Date Range: \"%s - %s\" has been successfully unblocked out in your scheduler%n",
                        beginString, stopString);
                break;
            case "help":
                HelpCommand help = new HelpCommand();
                help.execute();
                break;
            default:
                System.out.println("You have entered an unknown or invalid command, please try again!");
            }
        }
    }

    private static Map.Entry<Boolean, Map.Entry<LocalDate, LocalDate>> isInRange(LocalDate testDate) {
        boolean flag = false;
        Map.Entry<LocalDate, LocalDate> member = null;

        for (Map.Entry<LocalDate, LocalDate> entry : BLOCKLIST.entrySet()) {

            if (!(testDate.isBefore(entry.getKey()) || testDate.isAfter(entry.getValue()))) {
                member = entry;
                flag = true;
                break;
            }
        }
        return new SimpleEntry<>(flag, member);
    }

    private static LocalDate getLocalDate(String date) {
        LocalDate dateIso;
        int[] figures = Arrays.stream(date.split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        dateIso = LocalDate.of(figures[0], figures[1], figures[2]);

        return dateIso;
    }

    public static void edit(String amendDesc, String startDate, int optionNumber) {
        int bookNum = optionNumber;
        LocalDate testDate = getLocalDate(startDate);
        LocalDate temp;

        for (Bookings booking : appointments) {
            temp = booking.getStartDate();

            if (temp.equals(testDate)) {
                --optionNumber;
            }

            if (optionNumber == 0) {
                String bookingDesc = booking.getBookDesc();
                booking.setBookDesc(amendDesc);

                System.out.printf("Successfully changed \"%s\" on %s : book #%d%n", bookingDesc,
                        startDate.replaceAll("-", "/"), bookNum);
                System.out.printf("To \"%s\" on %s : book #%d%n", amendDesc, testDate, bookNum);
                return;
            }
        }
        System.out.println("Your appointment is not stored in our calendar. Pl check the start date.");
    }

    private static void onLoad() throws IOException {
        File directory = new File("data");

        if (!directory.exists()) {
            directory.mkdir();
        }

        File f = new File("justbook.txt");

        if (!f.exists()) {
            f.createNewFile();
        }

        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            //read all lines
            String input = sc.nextLine();
            String[] readData = input.split(" \\| ");
            LocalDateTime start = parse(readData[1]);
            LocalDateTime end = parse(readData[2]);
            appointments.add(new Bookings(readData[0], start, end));
        }

    }

    private static void onSave() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("justbook.txt"));
            //writes all tasks into file
            for (Bookings item : appointments) {
                String description = item.getBookDesc();
                LocalDateTime startDate = item.getStartDateTime();
                LocalDateTime endDate = item.getEndDateTime();
                writer.write(description + " | " + startDate + " | " + endDate);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            //prints exception message.
            System.out.println(e.getMessage());
        }
    }
}
