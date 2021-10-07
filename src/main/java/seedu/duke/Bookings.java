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

        public String getStartDate(){
            return String.valueOf(start.toLocalDate());
        }

        @Override
        public String toString(){
            String begin = start.format(DateTimeFormatter.ISO_DATE_TIME);
            String stop = end.format(DateTimeFormatter.ISO_DATE_TIME);

            return String.format("%s %s - %s", bookDesc, begin, stop);
        }
    }


