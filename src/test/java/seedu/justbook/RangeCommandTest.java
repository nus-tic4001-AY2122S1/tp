package seedu.justbook;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangeCommandTest {
    @Test
    public void getDeleteRangeTest() {
        LocalDateTime startDate = LocalDateTime.parse("2021-06-07T10:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2021-06-07T11:00:00");
        LocalDate expected = LocalDate.of(2021, 6, 7);
        Bookings testModel = new Bookings("Meeting@Hall One", startDate, endDate);
        LocalDateTime startDate2 = LocalDateTime.parse("2021-06-08T10:00:00");
        LocalDateTime endDate2 = LocalDateTime.parse("2021-06-08T11:00:00");
        Bookings testModel2 = new Bookings("Meeting@Hall Two", startDate, endDate);
        LocalDateTime startDate3 = LocalDateTime.parse("2021-06-09T10:00:00");
        LocalDateTime endDate3 = LocalDateTime.parse("2021-06-09T11:00:00");
        Bookings testModel3 = new Bookings("Meeting@Hall Three", startDate, endDate);
        List<Bookings> appointments = new ArrayList<>();
        appointments.add(testModel);
        appointments.add(testModel2);
        appointments.add(testModel3);
        LocalDate deleteStartDate = LocalDate.parse("2021-06-08", DateTimeFormatter.ofPattern("yyyy-M-d"));
        LocalDate deleteEndDate = LocalDate.parse("2021-06-09", DateTimeFormatter.ofPattern("yyyy-M-d"));
        DeleteCommand delRange = new DeleteCommand(deleteStartDate, deleteEndDate, "range");
        delRange.execute(appointments);
        assertEquals(expected, testModel.getStartDate());
    }
}
