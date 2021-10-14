package seedu.duke.command;

import seedu.duke.NusModList;

public class ListCommand extends Command {

    public ListCommand(String userInstruction) {
        super(userInstruction);
    }

    @Override
    public void execute() {
        System.out.println("Do " + userInstruction);

        // Refactor into UI Class
        // Get Data
        NusModList modData = NusModList.SharedInstance();

        //List and Format Data - List 15 Modules tbc
        System.out.println("Here are the list of available Modules (Limit to 10) : ");
        for (int i = 0; i < 15; i++){
            System.out.println(modData.getMod(i).getModuleCode() + " | "
                                + modData.getMod(i).getModuleTitle());
        }

        System.out.println("Data was retrieved using NUS MODS API.");
    }
}