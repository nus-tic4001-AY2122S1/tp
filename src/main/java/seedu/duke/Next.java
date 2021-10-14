package seedu.duke;

import seedu.duke.storage.GTDList;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.parser.Parser;
import seedu.duke.project.GTDThought;
import seedu.duke.project.Stat;
import seedu.duke.ui.Ui;
import seedu.duke.exception.InvalidListArgumentException;

import java.util.ArrayList;
import java.util.Hashtable;

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

        Hashtable<String, GTDList> GTDLists = new Hashtable<>();
        GTDLists.put("inbox", new GTDList());
        GTDLists.put("proj", new GTDList());
        GTDLists.put("next", new GTDList());
        GTDLists.put("wait", new GTDList());
        GTDLists.put("some", new GTDList());

        Ui ui = new Ui();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.setData(GTDLists);
                c.execute();
                isExit = ExitCommand.isExit(c);
            } catch (InvalidListArgumentException e) {
                ui.showError("Invalid list argument");
            } catch (Exception e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }


        String title = "This is my very first task";
        GTDThought p1 = new GTDThought(title);
        GTDThought p2 = new GTDThought("Second level 0 task");

        p1.print();

        GTDThought sub1 = new GTDThought("sub task a");
        GTDThought sub2 = new GTDThought("sub task b");
        GTDThought subsub1 = new GTDThought("sub sub task a.1");

        p1.addSub(sub1);
        p1.addSub(sub2);
        sub1.addSub(subsub1);

        subsub1.setStatus(Stat.NEXT);

        p1.printRec();

        GTDLists.get("next").add(p1);
        GTDLists.get("next").add(p2);
        GTDLists.get("inbox").add(p1);
        p1.setStatus(Stat.NEXT);
        GTDLists.get("next").get(0).print();
        GTDLists.get("inbox").get(0).print();

        System.out.println(System.lineSeparator());

        GTDLists.get("next").print();

        GTDLists.get("next").get("1-1-1").print();


    }
}
