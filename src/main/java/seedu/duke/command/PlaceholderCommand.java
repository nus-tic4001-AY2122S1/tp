package seedu.duke.command;

public class PlaceholderCommand extends Command {

    public PlaceholderCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        System.out.println("Do" + userInstruction);
    }
}
