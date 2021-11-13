package seedu.duke.command;

import seedu.duke.module.UserList;


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
