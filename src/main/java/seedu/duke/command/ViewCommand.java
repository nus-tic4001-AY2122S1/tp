package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.NusModList;
import seedu.duke.Ui;
import seedu.duke.exceptions.ModuleException;
import seedu.duke.exceptions.NusModException;

import java.io.IOException;

public class ViewCommand extends Command {

    public ViewCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() throws IOException {
        try {
            NusModList modData = NusModList.sharedInstance();
            int moduleIndex = modData.getModuleIndex(userInstruction);
            if (moduleIndex == -1) {
                throw new NusModException("Unknown module code");
            }
            Module module = modData.getMod(moduleIndex);
            Ui.printMsg(module.getPrettyPrint());

        } catch (NusModException e) {
            Ui.printError(e.getMessage());
        }

    }

}
