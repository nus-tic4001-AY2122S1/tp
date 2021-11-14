package seedu.duke.command;

import seedu.duke.module.UserList;

public class MyListCommand extends Command {

    public MyListCommand() {
    }

    @Override
    public void execute() {
        UserList userData = UserList.sharedInstance();
        userData.list();
    }
}
