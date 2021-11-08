package seedu.justbook;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class DeleteCommand {
    LocalDate startDate;
    LocalDate endDate;
    int optionNumber;
    String type;

    public DeleteCommand(String date, String option, String type) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-M-d");
        this.startDate = LocalDate.parse(date, format);
        this.optionNumber = Integer.parseInt(option);
        this.type = type;
    }

    public DeleteCommand(LocalDate startDate, LocalDate endDate, String type) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }

    public DeleteCommand(String type) {
        this.type = type;
    }

    public void execute(List<Bookings> appointments) {
        switch (type) {
        case "single":
            try {
                deleteSingle(appointments);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index out of bounds exception. Please input the delete command again.");
            }

            break;

        case "range":
            deleteRange(appointments);
            break;

        case "all":
            deleteAll(appointments);
            break;

        default:
            System.out.println("Incorrect Delete type. Please Input again");

        }
    }

    public void deleteSingle(List<Bookings> appointments) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate temp;

        for (Bookings booking : appointments) {
            temp = LocalDate.parse(booking.getStartDate().format(formatter), formatter);
            if (temp.equals(startDate)) {
                optionNumber = optionNumber - 1;
            }
            if (optionNumber == 0) {
                appointments.remove(booking);
                System.out.println("Successfully removed Appointment at " + booking.getStartDateString());
                return;
            }
        }

        System.out.println("Your appointment is not stored in our calendar. Please input a new command");
    }

    public static String getHelp() {
        return "del [Appointment_Start_Date] /o [Option_Number]";
    }

    public void deleteRange(List<Bookings> appointments) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        LocalDate temp;

        for (Iterator<Bookings> i = appointments.iterator(); i.hasNext();) {
            Bookings b = i.next();
            temp = LocalDate.parse(b.getStartDate().format(formatter), formatter);
            if (temp.compareTo(startDate) >= 0 && temp.compareTo(endDate) <= 0) {
                i.remove();
            }
        }
        System.out.println("Successfully removed all appointments between " + startDate + " to " + endDate + ".");
    }

    public void deleteAll(List<Bookings> appointments) {
        appointments.clear();
        System.out.println("Successfully deleted all appointment records");
    }

}
