package seedu.justbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {
    @Test
    @DisplayName("AddCommand - Test Correct Description")
    public void descriptionTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("uuuu-M-d HH:mm");
        add.execute(appointments);
        Bookings expected = new Bookings("meet@Sports Hall One lvl 3", LocalDateTime.parse("2021-6-7 09:00",pattern), LocalDateTime.parse("2021-6-7 10:30",pattern));

        assertEquals( expected.getBookDesc(),appointments.get(0).getBookDesc());
    }

    @Test
    @DisplayName("AddCommand - Test Correct Start Time")
    public void startTimeTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("uuuu-M-d HH:mm");
        add.execute(appointments);
        Bookings expected = new Bookings("meet@Sports Hall One lvl 3", LocalDateTime.parse("2021-6-7 09:00",pattern), LocalDateTime.parse("2021-6-7 10:30",pattern));
        assertEquals( expected.getStartDateTime(),appointments.get(0).getStartDateTime());
    }

    @Test
    @DisplayName("AddCommand - Test Correct End Time")
    public void endTimeTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        add.execute(appointments);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("uuuu-M-d HH:mm");
        Bookings expected = new Bookings("meet@Sports Hall One lvl 3", LocalDateTime.parse("2021-6-7 09:00",pattern), LocalDateTime.parse("2021-6-7 10:30",pattern));
        assertEquals( expected.getEndDateTime(),appointments.get(0).getEndDateTime());
    }

}
