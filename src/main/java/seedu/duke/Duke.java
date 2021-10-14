package seedu.duke;

import list.TaskList;
import storage.Storage;
import ui.Ui;

import java.util.Scanner;

public class Duke {
    private final Ui ui;
    private final Storage storage;
    private final TaskList tasklist;

    public Duke() {
        this.ui = new Ui();
        this.storage = new Storage("file_path");
        this.tasklist = new TaskList();
    }

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        new Duke().run();
    }

    public void run() {
        this.ui.welcome();
        Scanner in = new Scanner(System.in);
        boolean isExit = false;

        // exit program
        System.exit(0);
    }
}
