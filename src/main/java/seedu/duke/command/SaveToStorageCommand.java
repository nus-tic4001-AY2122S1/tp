package seedu.duke.command;

import seedu.duke.Storage;
import seedu.duke.UserList;

import java.io.IOException;


public class SaveToStorageCommand extends Command {

    public SaveToStorageCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() throws IOException {
        Storage storage = new Storage();
        storage.saveUserList(UserList.sharedInstance());
        System.out.println("Saved modules to user_modules.json");
    }
}
