package seedu.justbook;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.format.TextStyle;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import static java.lang.System.exit;
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
            LoadCommand firstLoad = new LoadCommand("data/justbook.txt");
            firstLoad.execute(appointments);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AssertionError ex) {
            logger.log(Level.WARNING, "loading error", ex);
        }

        String logo = "     ____.               __ __________               __\n"
                + "    |    |__ __  _______/  |\\______   \\ ____   ____ |  | __\n"
                + "    |    |  |  \\/  ___/\\   __\\    | / /  _ \\ /  _ \\|  |/  /\n"
                + "/\\__|    |  |  /\\___ \\  |  | |    |   (  <_> |  <_> )    <\n"
                + "\\________|____//____  > |__| |______  /\\____/ \\____/|__|_ \\\n"
                + "                    \\/              \\/                   \\/\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        String userName = in.nextLine();

        System.out.printf("Hello %s,%n", userName);
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
                    assert (size != 0) : "database size should not be 0";
                } catch (AssertionError ex) {
                    logger.log(Level.WARNING, "processing error", ex);
                }

                logger.log(Level.INFO, "end of processing");
                // does a backup save before program exits
                SaveCommand backupSave = new SaveCommand("data/justbook.txt");
                backupSave.execute(appointments);
                in.close();
                exit(0);
            }

            String[] tokens = input.split(" ", 2);
            String commandWord = tokens[0];
            String inputContent = "";

            if (tokens.length >= 2) {
                inputContent = tokens[1];
            }

            switch (commandWord) {
            case "add":
                String[] arguments = inputContent.split(" /[s,e] ");
                String booking = arguments[0];
                String start = arguments[1];
                String date = start.substring(0, start.indexOf(" "));
                String end = arguments[2];

                if (isBlocked(date)) {
                    continue;
                }

                try {
                    AddCommand add = new AddCommand(booking, start, end);
                    add.execute(appointments);
                } catch (DateTimeParseException err) {
                    System.out.println("Input date is invalid! Retry again?");
                }
                break;
            case "edit":
                String[] segments = inputContent.split(" /o ", 2);
                String[] subSeg = segments[0].split(" /s ", 2);
                int optionNum;

                try {
                    optionNum = Integer.parseInt(segments[1]);
                } catch (NumberFormatException ex) {
                    System.out.println("User No. input was not a number.");
                    continue;
                }

                String bookDesc = subSeg[0];
                String chosenDate = subSeg[1];

                EditCommand edit = new EditCommand(bookDesc, formLocalDate(chosenDate), optionNum);
                edit.execute(appointments);
                break;
            case "save":
                SaveCommand save = new SaveCommand("data/justbook.txt");
                save.execute(appointments);
                break;
            case "del":
                if (inputContent.equals("a") || inputContent.contains("all")) {
                    DeleteCommand delAll = new DeleteCommand("all");
                    delAll.execute(appointments);

                } else if (inputContent.contains("/b")) {
                    String[] dateRange = inputContent.split(" ",3);
                    LocalDate startDate = LocalDate.parse(dateRange[1], DateTimeFormatter.ofPattern("yyyy-M-d"));
                    LocalDate endDate = LocalDate.parse(dateRange[2], DateTimeFormatter.ofPattern("yyyy-M-d"));

                    DeleteCommand delRange = new DeleteCommand(startDate, endDate, "range");
                    delRange.execute(appointments);
                } else {
                    int index = inputContent.indexOf("/o");
                    String inputDate = inputContent.substring(0, index).trim();
                    String optionNumber = inputContent.substring(index).replace("/o", "").trim();
                    DeleteCommand del = new DeleteCommand(inputDate, optionNumber, "single");
                    del.execute(appointments);
                }
                break;
            case "show":
                // sorts the database in ascending order
                appointments.sort(comparing(Bookings::getStartDateTime));
                int listNum = 1;
                int totalRecords = appointments.size();

                if (inputContent.equals("a") || inputContent.contains("all")) {
                    //displays user's complete list of bookings in the database
                    displayRecords(listNum, totalRecords);
                } else if (inputContent.contains("/b")) {
                    String[] dateRange = inputContent.split(" ",3);
                    LocalDate startDate = LocalDate.parse(dateRange[1], DateTimeFormatter.ofPattern("yyyy-M-d"));
                    LocalDate endDate = LocalDate.parse(dateRange[2], DateTimeFormatter.ofPattern("yyyy-M-d"));
                    showRange(startDate, endDate);
                } else if (inputContent.matches("^(.*)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
                    //displays user's selected date list of bookings in the database
                    displayDateBookings(inputContent, listNum);
                } else if (inputContent.equals("we") || inputContent.equals("weekends")) {
                    //displays user's current month list of weekend bookings in the database, if any
                    listWeekends();
                } else {
                    System.out.println("You have entered an unknown or invalid date, please try again!");
                }
                break;
            case "block": case "unblock":
                setBlockRules(commandWord, inputContent);
                break;
            case "help":
                HelpCommand help = new HelpCommand();
                help.execute(appointments);
                break;
            case "undel":
                if (inputContent.contains("a")) {
                    try {
                        LoadCommand undel = new LoadCommand("data/justbook.txt");
                        undel.execute(appointments);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Online database status: Fully restored.");
                break;
            default:
                System.out.println("You have entered an unknown or invalid command, please try again!");
            }
        }
    }

    private static void displayDateBookings(String inputDate, int listNum) {
        LocalDate localDate = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-M-d"));
        String putDate = String.valueOf(localDate).replaceAll("-", "/");

        //displays the specified date booking(s) of user
        LocalDate dateIso;
        System.out.printf("%nDate: %s%n", putDate);

        if (inputDate.matches("^((2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$")) {
            dateIso = LocalDate.parse(inputDate);
        } else {
            dateIso = formLocalDate(inputDate);
        }

        for (Bookings item : appointments) {

            if (dateIso.equals(item.getStartDate())) {
                System.out.printf("%d. %s%n", listNum++, item);
            }
        }
        System.out.println();
    }

    private static void displayRecords(int listNum, int totalRecords) {

        if (totalRecords == 0) {
            System.out.println("Current appointments list is : empty");
        }

        System.out.println();

        for (int i = 0; i < totalRecords; ) {
            LocalDate startDate = appointments.get(i).getStartDate();
            String dateHeader = String.valueOf(startDate).replaceAll("-", "/");
            System.out.printf("Date: %s%n", dateHeader);

            while (i < totalRecords && appointments.get(i).getStartDate().equals(startDate)) {
                System.out.printf("%d. %s%n", listNum++, appointments.get(i));
                i++;
            }
            // resets ListNum value to 1 for next date header
            listNum = 1;
            System.out.println();
        }
    }

    private static LocalDate formLocalDate(String date) {
        LocalDate dateIso = null;
        int[] figures = Arrays.stream(date.split("-"))
                .mapToInt(Integer::parseInt)
                .toArray();
        try {
            dateIso = LocalDate.of(figures[0], figures[1], figures[2]);
        } catch (DateTimeException ex) {
            System.out.println("An invalid date entry detected! Try again?");
        }
        return dateIso;
    }

    public static boolean isBlocked(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate startLocalDate = LocalDate.parse(date, formatter);

        Map.Entry<Boolean, Map.Entry<LocalDate, LocalDate>> result = isInRange(startLocalDate);

        if (result.getKey()) {
            System.out.printf("'%s' denied process by current BLOCKLIST => StartDate: [%s] - EndDate: [%s]%n",
                    startLocalDate, result.getValue().getKey(), result.getValue().getValue());
            return true;
        }
        return false;
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

    // displays the full current month's weekends listings
    public static void listWeekends() {
        Set<DayOfWeek> weekEnds = EnumSet.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        Month month = currentDate.getMonth();
        int currentDay = currentDate.getDayOfMonth();
        int daysOfMth = currentDate.lengthOfMonth();

        IntStream.rangeClosed(currentDay, daysOfMth)
                .mapToObj(day -> LocalDate.of(year, month, day))
                .filter(date -> weekEnds.contains(date.getDayOfWeek()))
                .forEach(JustBook::weekendListings);
    }


    protected static void setBlockRules(String command, String inputContent) {
        String[] parts = inputContent.split(" ", 2);
        LocalDate commence = formLocalDate(parts[0]);
        LocalDate terminate = formLocalDate(parts[1]);

        assert commence != null;
        assert terminate != null;

        // checks the dates input is a range and chronologically correct
        if (commence.isAfter(terminate) || commence.isEqual(terminate)) {
            System.out.println("Start date cannot be equal to or after the end date. Try again?");
            return;
        }

        DateTimeFormatter formatStyle = DateTimeFormatter
                .ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        String begin = commence.format(formatStyle);
        String stop = terminate.format(formatStyle);

        if (command.equals("block")) {
            BLOCKLIST.put(commence, terminate);
            System.out.printf("Date Range: \"%s - %s\" has been successfully blocked out in your scheduler%n",
                    begin, stop);
        } else {
            BLOCKLIST.remove(commence);
            System.out.printf("Date Range: \"%s - %s\" has been successfully unblocked out in your scheduler%n",
                    begin, stop);
        }
    }

    private static void showRange(LocalDate startRangeDate, LocalDate endRangeDate) {
        int listNum = 1;

        // sorts the database in ascending order
        appointments.sort(comparing(Bookings::getStartDateTime));
        int total = appointments.size();
        //displays user's complete list of bookings in the database
        System.out.println();

        for (int i = 0; i < total; ) {
            if (appointments.get(i).getStartDate().compareTo(startRangeDate) >= 0
                    && appointments.get(i).getStartDate().compareTo(endRangeDate) <= 0) {
                LocalDate startDate = appointments.get(i).getStartDate();
                String dateHeader = String.valueOf(startDate).replaceAll("-", "/");
                System.out.printf("Date: %s%n", dateHeader);

                while (appointments.get(i).getStartDate().equals(startDate)) {
                    System.out.printf("%d. %s%n", listNum++, appointments.get(i));
                    i++;
                }
                // resets ListNum value to 1 for next date header
                listNum = 1;
                System.out.println();
            } else {
                i++;
            }
        }
    }

    public static void weekendListings(LocalDate date) {
        int serialNo = 1;
        String dateHeader = String.valueOf(date).replaceAll("-", "/");
        String weekendName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toUpperCase();
        System.out.printf("%nDate: %s (%s)%n", dateHeader, weekendName);
        // flag to reduce unneeded extra loop searches
        boolean isWkEnd = false;
        // uses already sorted 'appointments' database here
        for (Bookings entry : appointments) {

            if (date.equals(entry.getStartDate())) {
                System.out.printf("%d. %s%n", serialNo++, entry);
                isWkEnd = true;
                continue;
            }
            if (isWkEnd) {
                break;
            }
        }
        if (!isWkEnd) {
            System.out.println("Status: no bookings yet.");
        }
    }
}
