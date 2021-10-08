package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;

import java.io.IOException;

public class Duke {

    private Ui ui;

    public static void main(String[] args) throws IOException {
        new Duke().run();
    }

    public void run() throws IOException {
        start();
        runCommandLoopUntilExitCommand();
        exit();
    }

    private void start() throws IOException {
        this.ui = new Ui();
        ui.welcome();
        Api api = new Api();
        Module[] allModules = api.getAllModules();
    }

    private void runCommandLoopUntilExitCommand() {
        Command command;
        do {
            String userInstruction = ui.readCommand();
            command = new Parser().parse(userInstruction);
            command.execute();
        } while (!ExitCommand.isExit(command));
    }

    private void exit() {
        System.out.println("Good Bye!");
    }
}