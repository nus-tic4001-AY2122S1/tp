package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.module.NusModList;
import seedu.duke.parser.Parser;
import seedu.duke.ui.Ui;


import java.io.IOException;

public class Duke {

    private Ui ui;
    private NusModList allModules;

    public static void main(String[] args) throws IOException {
        new Duke().run();
    }

    public void run() throws IOException {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    private void start() throws IOException {
        ui = new Ui();
        ui.welcome();
        Api api = new Api();
        allModules = api.getAllModulesDetailed();
    }

    private void runCommandLoopUntilExitCommand() throws IOException {
        Command command;
        do {
            String userInstruction = ui.readCommand();
            command = new Parser().parse(userInstruction);
            command.execute();
            ui.lineBreak();
        } while (!ExitCommand.isExit(command));
    }

    private void exit() {
        Ui.exitMsg();
    }
}