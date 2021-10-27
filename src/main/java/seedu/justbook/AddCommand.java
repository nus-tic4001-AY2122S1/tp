package seedu.justbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.LocalDateTime.parse;

public class AddCommand {
    Bookings record;

    public AddCommand(String bookDesc, String begin, String end) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        record = new Bookings(bookDesc, parse(begin, format), parse(end, format));
    }

    public void execute() {
        LocalDateTime begin = record.getStartDateTime();
        LocalDateTime end = record.getEndDateTime();

        if (begin.isBefore(end)) {
            JustBook.appointments.add(record);
            System.out.printf("Successfully added \"%s\" from %s to %s%n",
                    record.getBookDesc(), begin, end);
        } else {
            System.out.println("Invalid entry: the start time is after the end time, retry again?");
        }
    }
}
