package seedu.duke.commands;


import seedu.duke.project.GtdThought;

public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    private String taskname;


    public AddCommand(String taskname) {
        this.taskname = taskname;
    }

    @Override
    public void execute() {
        System.out.println("This is an add command, the added task is:" + System.lineSeparator() + taskname);
        master.add(new GtdThought(taskname));
    }


}
