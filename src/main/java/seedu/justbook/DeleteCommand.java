package seedu.justbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DeleteCommand {
    LocalDate startDate;
    int optionNumber;

    public DeleteCommand(String date, String option) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-M-d");
        this.startDate = LocalDate.parse(date, format);
        this.optionNumber = Integer.parseInt(option);
    }

    public void execute(List<Bookings> bookings) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate temp;
        for (Bookings booking : bookings) {
            temp = LocalDate.parse(booking.getStartDate().format(formatter), formatter);
            if (temp.equals(startDate)) {
                optionNumber = optionNumber - 1;
            }
            if (optionNumber == 0) {
                bookings.remove(booking);
                System.out.println("Successfully removed Appointment at " + booking.getStartDateString());
                return;
            }
        }

        System.out.println("Your appointment is not stored in our calendar. Please input a new command");
    }

    public static String getHelp() {
        return "del [Appointment_Start_Date] /o [Option_Number]";
    }
}
