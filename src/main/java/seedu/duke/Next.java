package seedu.duke;

import seedu.duke.project.GTDThought;
import seedu.duke.project.Stat;
import seedu.duke.storage.GTDList;

import java.util.ArrayList;

public class Next {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo =
                          " _   _           _   \n"
                        + "| \\ | | _____  _| |_ \n"
                        + "|  \\| |/ _ \\ \\/ / __|\n"
                        + "| |\\  |  __/>  <| |_ \n"
                        + "|_| \\_|\\___/_/\\_\\\\__|\n";

        System.out.println("PROJECT\n" + logo);

































        String title = "This is my very first task";
        GTDThought p1 = new GTDThought(title);

        p1.print();

        GTDThought sub1 = new GTDThought("sub task a");
        GTDThought sub2 = new GTDThought("sub task b");
        GTDThought subsub1 = new GTDThought("sub sub task a.1");

        p1.addSub(sub1);
        p1.addSub(sub2);
        sub1.addSub(subsub1);

        subsub1.setStatus(Stat.NEXT);

        p1.printRec();

        GTDList next = new GTDList();
        GTDList inbox = new GTDList();
        next.add(p1);
        inbox.add(p1);
        p1.setStatus(Stat.NEXT);
        next.get(0).print();
        inbox.get(0).print();

        System.out.println(System.lineSeparator());

        next.print(); // TODO: need to add INDEN and numbering
    }
}
