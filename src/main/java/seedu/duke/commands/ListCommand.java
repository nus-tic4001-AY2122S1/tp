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

        current.clear();

        AtomicInteger i = new AtomicInteger(1);
        master.stream()
                .filter(t -> t.getStatus() == stat)
                .forEach(t -> {
                    current.add(t);
                    System.out.println(i.getAndIncrement() + " " + t.toString());
                });


        // For demo only
        System.out.println("++++ ++++");
        current.print();

    }
}
