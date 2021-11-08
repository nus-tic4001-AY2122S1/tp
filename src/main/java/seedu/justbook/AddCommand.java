package seedu.justbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.List;

import static java.time.LocalDateTime.parse;

public class AddCommand extends Command {
    Bookings record;

    public AddCommand(String bookDesc, String begin, String end) throws DateTimeParseException {
        // ensures correct Phase 2 resolution of parsed text fields
        DateTimeFormatter format = DateTimeFormatter
                .ofPattern("uuuu-M-d HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);
        // adds assertions to check for null objects
        assert begin != null : "begin cannot be null for parse method";
        assert end != null : "end cannot be null for parse method";

        record = new Bookings(bookDesc, parse(begin, format), parse(end, format));
    }

    public void execute(List<Bookings> appointments) {
        LocalDateTime begin = record.getStartDateTime();
        LocalDateTime end = record.getEndDateTime();
        String description = record.getBookDesc();
        // checks that 'start' time is before the 'end' time
        if (begin.isBefore(end)) {
            appointments.add(record);
            System.out.printf("Successfully added \"%s\" from %s to %s%n",
                    description, begin, end);
            // appends the new booking entry to the database file
            try (BufferedWriter fAdd = new BufferedWriter(new FileWriter("data/justbook.txt", true))) {
                fAdd.write(description + " | " + begin + " | " + end);
                fAdd.newLine();
                fAdd.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid entry: 'start' time is after the 'end' time? Try again?");
        }
    }


    public static String getHelp() {
        return "Adding an appointment: add [Appointment_Description] /s [Start_Time] /e [End_Time]";
    }
}
