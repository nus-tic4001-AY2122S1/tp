package seedu.justbook;

import java.io.IOException;
import java.util.List;

public abstract class Command {

    public abstract void execute(List<Bookings> appointments) throws IOException;

    public static String getHelp() {
        return "This is the abstract Command.";
    }
}
