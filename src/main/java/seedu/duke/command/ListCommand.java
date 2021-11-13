package seedu.duke.command;

import seedu.duke.module.NusModList;
import seedu.duke.ui.Ui;
import seedu.duke.module.Module;
import seedu.duke.exceptions.NusModException;

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
        try {
            // Get Data
            NusModList modData = NusModList.sharedInstance();

            List<Module> filterList = new ArrayList<>();

            // Check user Instruction, to refactor
            if (userInstruction.equalsIgnoreCase("all")) {
                filterList = new ArrayList<>(Arrays.asList(modData.getModListForYear()));
            } else if (userInstruction.toLowerCase().contains("Semester")) {
                List<Module> finalFilterList = filterList;
                IntStream.range(0, modData.getSize()).filter(index -> modData.getMod(index)
                                .getModuleSemester().toLowerCase().contains(userInstruction.toLowerCase()))
                                .forEach(index -> finalFilterList.add(modData.getMod(index)));
                filterList = finalFilterList;
            } else {
                List<Module> finalFilterList1 = filterList;
                IntStream.range(0, modData.getSize()).filter(index -> modData.getMod(index)
                                .getModuleCode().toLowerCase().contains(userInstruction.toLowerCase()))
                                .forEach(index -> finalFilterList1.add(modData.getMod(index)));
                filterList = finalFilterList1;
            }


            int size = 20;
            if (filterList.size() == 0) {
                throw new NusModException("There are no matches");
            } else if (filterList.size() < size) {
                size = filterList.size();
            }
            //List and Format Data - List 15 Modules tbc
            Ui.printMsg("Here are the list of available Modules (Limit to 20) : ");
            for (int i = 0; i < size; i++) {
                Module module = filterList.get(i);
                Ui.printShortModuleInfo(module);
            }
            Ui.printMsg("* Data was retrieved using NUS MODS API. *");
        } catch (NusModException e) {
            Ui.printError(e.getMessage());
        }
    }
}