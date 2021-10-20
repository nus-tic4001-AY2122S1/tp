package seedu.justbook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.LocalDateTime.parse;

public class AddCommand {
    String bookDesc;
    LocalDateTime begin;
    LocalDateTime end;

    public AddCommand(String bookDesc, String begin, String end) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("[yyyy-M-d K:mm a][yyyy-M-d HH:mm]");
        this.begin = parse(begin.toUpperCase(), format);
        this.bookDesc = bookDesc;
        this.end = parse(end.toUpperCase(), format);
    }

    public void execute() {
        JustBook.appointments.add(new Bookings(bookDesc, begin, end));
    }
}
