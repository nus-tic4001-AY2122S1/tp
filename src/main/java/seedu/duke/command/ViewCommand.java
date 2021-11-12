package seedu.duke.command;

import seedu.duke.Module;
import seedu.duke.NusModList;
import seedu.duke.exceptions.ModuleException;

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
                throw new ModuleException();
            }
            Module module = modData.getMod(moduleIndex);
            System.out.println(module.getPrettyPrint());

        } catch (ModuleException e) {
            System.out.println("module can't find");
        }

    }

}
