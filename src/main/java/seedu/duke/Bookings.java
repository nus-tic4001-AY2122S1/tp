package seedu.duke;

import java.time.LocalDate;
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

    public LocalDateTime getStartDateTime() {
        return start;
    }

    public LocalDate getStartDate() {
        return start.toLocalDate();
    }

    @Override
    public String toString() {

        return String.format("%s %s - %s", bookDesc, start.toLocalTime(), end.toLocalTime());
    }
}


