package seedu.duke.command;

/**
 * Place holder for command only. Please implement a real class.
 */
public class PlaceholderCommand extends Command {

    public PlaceholderCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        System.out.println("Do " + userInstruction);
    }
}
