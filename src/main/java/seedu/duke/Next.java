package seedu.duke;

import seedu.duke.storage.GtdList;
import seedu.duke.commands.Command;
import seedu.duke.commands.ExitCommand;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.Ui;
import seedu.duke.exception.InvalidListArgumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Next {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    Ui ui = new Ui();
    Storage storage;
    static ArrayList<GtdList> lists = new ArrayList<>();
    GtdList master;
    GtdList current = new GtdList();

    public Next(String filePath) {
        try {
            storage = new Storage(filePath);
            master = new GtdList(storage.load());
            lists.add(master);
            lists.add(current);
        } catch (Storage.StorageOperationException | Storage.InvalidStorageFilePathException | IOException e) {
            ui.showLoadingError();
        }
    }

    public static void main(String[] args) {

        new Next(System.getProperty("user.dir") + "/data/next.txt").run();

    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine(); // show the divider line ("_______")
                Command c = new Parser().parse(fullCommand);
                c.setData(lists);
                c.execute();
                storage.save(master);
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
