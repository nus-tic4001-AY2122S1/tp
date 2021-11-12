package seedu.duke.command;

import seedu.duke.NusModList;
import seedu.duke.Ui;
import seedu.duke.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ListCommand extends Command {

    public ListCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        // System.out.println("Do " + userInstruction);

        // Get Data
        NusModList modData = NusModList.sharedInstance();

        ArrayList<Module> filterList = new ArrayList<>(Arrays.asList(modData.getModListForYear()));

        // Check user Instruction, to refactor
        if (userInstruction.equals("all")) {

        } else if (userInstruction.contains("Semester")) {
            // TODO: Make Search non-case sensitive.

            IntStream.range(0, modData.getSize()).filter(index -> modData.getMod(index)
                    .getModuleSemester().contains(userInstruction))
                    .forEach(index -> filterList.add(modData.getMod(index)));
        } else {
            IntStream.range(0, modData.getSize()).filter(index -> modData.getMod(index)
                    .getModuleCode().contains(userInstruction))
                    .forEach(index -> filterList.add(modData.getMod(index)));
        }

        //List and Format Data - List 15 Modules tbc
        Ui.printMsg("Here are the list of available Modules (Limit to 10) : ");
        for (int i = 0; i < 10; i++) {
            Module module = filterList.get(i);
            Ui.printShortModuleInfo(module);
        }
        Ui.printMsg("* Data was retrieved using NUS MODS API. *");
    }
}