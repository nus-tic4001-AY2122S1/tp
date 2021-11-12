package seedu.duke.command;

import seedu.duke.NusModList;
import seedu.duke.Ui;
import seedu.duke.Module;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

        List<Module> filterList = new ArrayList<>();

        // Check user Instruction, to refactor
        if (userInstruction.equals("all")) {
            filterList = new ArrayList<>(Arrays.asList(modData.getModListForYear()));
        } else if (userInstruction.contains("Semester")) {
            List<Module> finalFilterList = filterList;
            IntStream.range(0, modData.getSize()).filter(index -> modData.getMod(index)
                    .getModuleSemester().contains(userInstruction))
                    .forEach(index -> finalFilterList.add(modData.getMod(index)));
            filterList = finalFilterList;
        } else {
            List<Module> finalFilterList1 = filterList;
            IntStream.range(0, modData.getSize()).filter(index -> modData.getMod(index)
                    .getModuleCode().contains(userInstruction))
                    .forEach(index -> {
                        finalFilterList1.add(modData.getMod(index));});
            filterList = finalFilterList1;
        }

        //List and Format Data - List 15 Modules tbc
        Ui.printMsg("Here are the list of available Modules (Limit to 10) : ");
        int size = 10;
        if(filterList.size() == 0){
            Ui.printMsg("There are no matches");
        } else if (filterList.size() < size){
            size = filterList.size();
        }

        for (int i = 0; i < size; i++) {
            Module module = filterList.get(i);
            Ui.printShortModuleInfo(module);
        }
        Ui.printMsg("* Data was retrieved using NUS MODS API. *");
    }
}