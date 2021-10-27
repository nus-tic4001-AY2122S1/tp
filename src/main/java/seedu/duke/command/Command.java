package seedu.duke.command;

import java.io.IOException;

public abstract class Command {

    protected String userInstruction;

    public Command() {

    }

    public Command(String userInstruction) {
        this.userInstruction = userInstruction;
    }

    public void execute() throws IOException {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

}
