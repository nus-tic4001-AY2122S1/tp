package seedu.justbook;

import java.time.LocalDate;
import java.util.List;

public class EditCommand {
    private String amendDesc;
    LocalDate startDate;
    int optionNumber;

    public EditCommand(String bookDesc, LocalDate chosenDate, int optionNum) {
        this.amendDesc = bookDesc;
        this.startDate = chosenDate;
        this.optionNumber = optionNum;
    }
    public void execute(List<Bookings> appointments) {
        int bookNum = optionNumber;
        LocalDate testDate = startDate;
        LocalDate temp;

        for (Bookings booking : appointments) {
            temp = booking.getStartDate();

            if (temp.equals(testDate)) {
                --optionNumber;
            }
            if (optionNumber == 0) {
                String bookingDesc = booking.getBookDesc();
                booking.setBookDesc(amendDesc);

                System.out.printf("Successfully changed \"%s\" on %s : book #%d%n", bookingDesc,
                        startDate.toString().replaceAll("-", "/"), bookNum);
                System.out.printf("To \"%s\" on %s : book #%d%n", amendDesc, testDate, bookNum);
                return;
            }
        }
        System.out.println("Your appointment is not stored in our calendar. Pl check the start date.");
    }
}
