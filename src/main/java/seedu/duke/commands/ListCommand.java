package seedu.duke.commands;


/**
 * List all the tasks in the taskList.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    private String folderType;

    public ListCommand(String folderType) {
        this.folderType = folderType;
    }

    @Override
    public void execute() {

        switch (folderType) {
            case "inbox":
                System.out.println("this is " + folderType + " list");
                break;
                //logic to list for the specific folder
                //implementation
            case "next":
                System.out.println("this is " + folderType + " list");
                break;
                //logic to list for the specific folder
                //implementation
            case "wait":
                System.out.println("this is " + folderType + " list");
                break;
                //logic to list for the specific folder
                //implementation
            case "proj":
                System.out.println("this is " + folderType + " list");
                break;
                //logic to list for the specific folder
                //implementation
            case "someday":
                System.out.println("this is " + folderType + " list");
                break;
                //logic to list for the specific folder
                //implementation
            default:
                System.out.println("");

        }

        //if the logic is basically the same then no need switch
        //System.out.println("this is "+folderType+" list");
        //logic to list for the specific folder
        //implementation
    }
}
