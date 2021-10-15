package seedu.duke.commands;

import seedu.duke.project.Stat;
import seedu.duke.exception.InvalidListArgumentException;
import seedu.duke.storage.GtdList;

import java.util.concurrent.atomic.AtomicInteger;

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
    public void execute() throws InvalidListArgumentException {
        System.out.println("this is " + folderType + " list");
        Stat stat;
        switch (folderType) {
        case "inbox":
            stat = Stat.NONE;
            break;
        case "next":
            stat = Stat.NEXT;
            break;
        case "wait":
            stat = Stat.WAIT;
            break;
        case "someday":
            stat = Stat.SOME;
            break;
        //case "proj":
            //break;
        default:
            throw new InvalidListArgumentException();
        }

        GtdList gtdList = GTDLists.get("inbox");
        AtomicInteger i = new AtomicInteger(1);
        gtdList.getList().stream()
                .filter(t -> t.getStatus() == stat)
                .forEach(t -> System.out.println(i.getAndIncrement() + " " + t.toString()));

//        for (int i = 0; i < gtdList.size(); i++) {
//            GTDThought gtdThought = gtdList.get(i);
//            if (gtdThought.getStatus() == stat) {
//                System.out.println((i+1) + ". " + gtdThought.getTextRec());
//            }
//        }

        //if the logic is basically the same then no need switch
        //System.out.println("this is "+folderType+" list");
        //logic to list for the specific folder
        //implementation
    }
}
