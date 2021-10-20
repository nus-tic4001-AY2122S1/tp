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
        case "proj":
            stat = Stat.PROJ;
            break;

        //    case "master":
        //    stat =
        //    break;
        default:
            throw new InvalidListArgumentException();
        }

        current.clear();

        AtomicInteger i = new AtomicInteger(1);
        if (stat == Stat.PROJ) {
            master.stream()
                    .filter(lv0 -> lv0.getStatus() == Stat.PROJ)
                    .forEach(proj -> current.add(proj));
        } else {
            master.stream()
                    .forEach(lv0 -> {
                        current.add(lv0.getRec(stat));
                    });
        }

        current.print();

    }
}
