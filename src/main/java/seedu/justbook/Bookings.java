package seedu.justbook;

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



    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public LocalDateTime getStartDateTime() {
        return start;
    }

    public LocalDate getStartDate() {
        return start.toLocalDate();
    }

    public String getStartDateString() {
        return start.toLocalDate().format(DateTimeFormatter.ofPattern("yyyy-M-d"));
    }

    @Override
    public String toString() {
        return String.format("%s %s - %s", bookDesc, start.toLocalTime(), end.toLocalTime());
    }

    public LocalDateTime getEndDateTime() {
        return end;
    }
}
