package seedu.duke.command;

import java.util.List;
import java.io.IOException;

public interface Command {
    List<String> run(String[] fullCommand) throws IOException;

    default boolean isExit() {
        return false;
    }
}
