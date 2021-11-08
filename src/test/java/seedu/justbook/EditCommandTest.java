package seedu.justbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EditCommandTest {
    @Test
    @DisplayName("Edit Command - Test ")
    public void editCommandTest() {
        List<Bookings> appointments = new ArrayList<>();
        AddCommand add = new AddCommand("meet@Sports Hall One lvl 3","2021-6-7 09:00", "2021-6-7 10:30");
        add.execute(appointments);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("uuuu-M-d");
        LocalDate selectedDate = LocalDate.parse("2021-6-7", format);

        EditCommand edit = new EditCommand("reading books", selectedDate, 1 );
        edit.execute(appointments);

        assertEquals("reading books", appointments.get(0).getBookDesc());
    }
}
