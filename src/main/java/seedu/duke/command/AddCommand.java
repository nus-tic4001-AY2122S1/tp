package seedu.duke.command;

import seedu.duke.NusModList;
import seedu.duke.Ui;
import seedu.duke.UserList;


public class AddCommand extends Command {

    public AddCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        UserList userData = UserList.sharedInstance();
        userData.addModule(userInstruction);
    }
}
