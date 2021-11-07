package seedu.justbook;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCommandTest {
    @Test
    @DisplayName("Deleting ")
    public void getStartDateTest() {
        LocalDateTime startDate = LocalDateTime.parse("2021-06-07T10:00:00");
        LocalDateTime endDate = LocalDateTime.parse("2021-06-07T11:00:00");

        LocalDate expected = LocalDate.of(2021, 6, 7);
        Bookings testModel = new Bookings("Meeting@Hall One", startDate, endDate);
        assertEquals(expected, testModel.getStartDate());
    }
}
