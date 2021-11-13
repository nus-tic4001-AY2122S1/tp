package seedu.duke.commands;

import seedu.duke.project.Stat;
import seedu.duke.exception.InvalidListArgumentException;
import seedu.duke.storage.GtdList;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.ArrayList;

/**
 * List all the tasks in the taskList.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    private String target;

    public ListCommand(String target) {
        this.target = target;
    }

    @Override
    public void execute() throws InvalidListArgumentException {
        System.out.println("this is " + target + " list");
        boolean excludeChildren = false;
        Stat stat;
        switch (target) {
        case "due":
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
        case "done":
            stat = Stat.DONE;
            break;

        case "current":
            current.print();
            return;
        case "master":
        case "all":
            current.clear();
            try {
                master.print();
                master.stream()
                        .forEach(t -> current.add(t));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Let's get started");
            }
            return;

        default:
            throw new InvalidListArgumentException();
        }

        current.clear();

        // AtomicInteger i = new AtomicInteger(1);
        if (stat == Stat.PROJ) {
            master.stream()
                    .filter(lv0 -> lv0.getStatus() == Stat.PROJ)
                    .forEach(proj -> current.add(proj));
        } else if (target.equals("due")) {
            excludeChildren = true;
            master.stream()
                    .forEach(lv0 -> {
                        current.add(lv0.getDueList(new ArrayList<>()));
                    });
            current.sortDue();
        } else {
            master.stream()
                    .forEach(lv0 -> {
                        current.add(lv0.getRec(stat));
                    });
        }

        if (stat == Stat.NONE && current.size() == 0) {
            System.out.println("Empty inbox! Dump some thoughts");
        }
        current.print(excludeChildren);

    }
}
