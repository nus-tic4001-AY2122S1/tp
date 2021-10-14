package seedu.duke.command;

import seedu.duke.UserList;

public class DeleteCommand extends Command {

    public DeleteCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        UserList userData = UserList.sharedInstance();
        userData.deleteModule(userInstruction);
    }
}
