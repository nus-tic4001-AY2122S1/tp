package seedu.duke;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bookings {
    String bookDesc;
    LocalDateTime start;
    LocalDateTime end;

    public Bookings(String bookDesc, LocalDateTime start, LocalDateTime end) {
        this.bookDesc = bookDesc;
        this.start = start;
        this.end = end;
    }

    public String getStartDate() {
        return start.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-M-d"));
    }

    @Override
    public String toString() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MMM d yyyy HH:mm");
        String begin = start.format(pattern);
        String stop = end.format(pattern);

        return String.format("Event: %s << >> Start: [%s] - End: [%s]", bookDesc, begin, stop);
    }
}


