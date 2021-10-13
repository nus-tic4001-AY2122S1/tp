package seedu.duke.command;

public class ListCommand extends Command {

    public ListCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        System.out.println("Do " + userInstruction);
    }
}