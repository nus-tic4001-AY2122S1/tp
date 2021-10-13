package seedu.duke;

public class HelpCommand {
    public HelpCommand() {

    }

    public void execute() {
        String instructions = "Commands: "
                + "\n"
                + DeleteCommand.getHelp()
                + "\n"
                + "add [Appointment_Description] /s [Start_Time] /e [End_Time]";
        System.out.println(instructions);
    }
}
