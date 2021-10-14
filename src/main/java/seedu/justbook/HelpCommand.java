package seedu.justbook;

public class HelpCommand {
    public void execute() {
        String instructions = "For each command, their inputs will be in the square brackets[]. "
                + "The format will follow Command [Input]"
                + "\n"
                + "Commands: "
                + "\n"
                + "Adding an appointment: add [Appointment_Description] /s [Start_Time] /e [End_Time]"
                + "\n"
                + "Deleting an appointment: " + DeleteCommand.getHelp()
                + "\n"
                + "Editing an appointment: edit [description] /s [Appointment_Start_Date] /o [Option_Number]";

        System.out.println(instructions);
    }
}
