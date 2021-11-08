package seedu.justbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCommandTest {
    @Test
    @DisplayName("Delete Command - Test Deleting all appointments")
    public void deleteAllTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        add.execute(appointments);
        AddCommand add1 = new AddCommand("meet@Sports Hall One lvl 4","2021-6-7 09:00", "2021-6-7 10:30");
        add1.execute(appointments);
        AddCommand add2 = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        add2.execute(appointments);

        DeleteCommand delete = new DeleteCommand("all");
        delete.execute(appointments);

        assertEquals(0,appointments.size());
    }

    @Test
    @DisplayName("Delete Command - Test Deleting a single appointment")
    public void deleteSingleTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        add.execute(appointments);

        DeleteCommand delete = new DeleteCommand("2021-6-7", "1" , "single");
        delete.execute(appointments);

        assertEquals(0,appointments.size());
    }

    @Test
    @DisplayName("Delete Command - Test Deleting a range of appointments")
    public void deleteRangeTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        add.execute(appointments);

        AddCommand add1 = new AddCommand("meet@Sports Hall One lvl 4","2021-6-8 09:00", "2021-6-8 10:30");
        add1.execute(appointments);

        AddCommand add2 = new AddCommand("meet@Sports Hall One lvl 5","2021-6-9 09:00", "2021-6-9 10:30");
        add2.execute(appointments);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-M-d");
        LocalDate start = LocalDate.parse("2021-6-7", format);
        LocalDate end = LocalDate.parse("2021-6-8", format);

        DeleteCommand delete = new DeleteCommand(start, end , "range");
        delete.execute(appointments);

        assertEquals(1,appointments.size());
        assertEquals("meet@Sports Hall One lvl 5",appointments.get(1).getBookDesc());
    }
}
