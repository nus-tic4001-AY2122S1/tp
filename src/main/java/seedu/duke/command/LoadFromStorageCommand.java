package seedu.duke.command;

import seedu.duke.Storage;
import seedu.duke.UserList;

import java.io.IOException;


public class LoadFromStorageCommand extends Command {

    public LoadFromStorageCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() throws IOException {
        Storage storage = new Storage();
        storage.loadUserlist();
        System.out.println("Loaded modules from user_modules.json");
    }
}
