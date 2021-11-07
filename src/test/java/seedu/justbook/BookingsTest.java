package seedu.justbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;

class BookingsTest {
    @Test
    @DisplayName("get LocalDate from start LocalDateTime")
    public void getStartDateTest() {
        LocalDateTime startDate = LocalDateTime.parse("2021-06-07T10:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2021-06-07T11:00:00");

        LocalDate expected = LocalDate.of(2021, 6, 7);
        Bookings testModel = new Bookings("Meeting@Hall One", startDate, endDate);
        assertEquals(expected, testModel.getStartDate());
    }

    @Test
    @DisplayName("get Booking's description")
    public void getBookDescTest() {
        LocalDateTime startDate = LocalDateTime.parse("2021-06-07T10:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2021-06-07T11:00:00");

        String expected = "Meeting@Hall One";
        Bookings testModel = new Bookings("Meeting@Hall One", startDate, endDate);
        assertEquals(expected, testModel.getBookDesc());
    }





}
