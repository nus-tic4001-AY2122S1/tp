package seedu.justbook;

import java.util.List;

public class HelpCommand extends Command {
    public void execute(List<Bookings> appointments) {
        String instructions = "Currently, you have " + appointments.size() + "appointments."
                + "\n"
                + "Here is the help section. For each command, their inputs will be in the square brackets[]. "
                + "The format will follow Command [Input]. "
                + "Dates follow the format [yyyy-M-d] eg. 2020-10-10 for the 10th of October 2020."
                + "\n"
                + "Commands: "
                + "\n"
                +  AddCommand.getHelp()
                + "\n"
                +  DeleteCommand.getHelp()
                + "\n"
                +  EditCommand.getHelp()
                + "To Undelete a previously deleted appointment: undel all"
                + "\n"
                + "To block a range of dates: block [Appointment_Start_Date] [Appointment_End_Date]"
                + "\n"
                + "To unblock a range of dates: unblock [Appointment_Start_Date] [Appointment_End_Date]"
                + "\n"
                + "Showing a specific date's list of bookings: show [Appointment_Start_Date]"
                + "\n"
                + "Showing all weekends bookings (current month): show we"
                + "\n"
                + "To exit the application: exit";


        System.out.println(instructions);
    }

    public static String getHelp() {
        return "The help command guides and provides help instructions for the user.";
    }
}
