package seedu.duke.command;

public class ExitCommand extends Command {

    @Override
    public void execute() {
    }

    public static boolean isExit(Command command) {
        return command instanceof ExitCommand; // instanceof returns false if it is null
    }

}
