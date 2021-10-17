package seedu.duke;

import seedu.duke.storage.GtdList;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.parser.Parser;
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
                   " _   _           _\n"
                + "| \\ | | _____  _| |_\n"
                + "|  \\| |/ _ \\ \\/ / __|\n"
                + "| |\\  |  __/>  <| |_\n"
                + "|_| \\_|\\___/_/\\_\\\\__|\n";

        System.out.println("PROJECT\n" + logo);

        GtdList master = new GtdList();
        GtdList current = new GtdList();
        ArrayList<GtdList> lists = new ArrayList<>();
        lists.add(master);
        lists.add(current);

        Ui ui = new Ui();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.setData(lists);
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
    }
}
