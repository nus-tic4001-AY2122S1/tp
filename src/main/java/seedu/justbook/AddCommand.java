package seedu.justbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import static java.time.LocalDateTime.parse;

public class AddCommand {
    Bookings record;

    public AddCommand (String bookDesc, String begin, String end) throws DateTimeParseException {
        // ensures correct Phase 2 resolution of parsed text fields
        DateTimeFormatter format = DateTimeFormatter
                .ofPattern("yyyy-M-d HH:mm")
                .withResolverStyle(ResolverStyle.STRICT);
        // adds assertions to check for null objects
        assert begin != null : "begin cannot be null for parse method";
        assert end != null : "end cannot be null for parse method";

        record = new Bookings(bookDesc, parse(begin, format), parse(end, format));
    }

    public void execute() {
        LocalDateTime begin = record.getStartDateTime();
        LocalDateTime end = record.getEndDateTime();
        // checks that 'start' time is before the 'end' time
        if (begin.isBefore(end)) {
            JustBook.appointments.add(record);
            System.out.printf("Successfully added \"%s\" from %s to %s%n",
                    record.getBookDesc(), begin, end);
        } else {
            System.out.println("Invalid entry: 'start' time is after the 'end' time? Retry again?");
        }
    }
}
