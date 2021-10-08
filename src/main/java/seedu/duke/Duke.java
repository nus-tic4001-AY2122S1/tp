package seedu.duke;

import java.io.IOException;
import java.util.Scanner;

public class Duke {


    public static void main(String[] args) throws IOException {
        Ui ui = new Ui();
        ui.welcome();
        Api api = new Api();
        Module[] allModules = api.getAllModules();
        Boolean isExit = false;
        while (!isExit) {
            String userInstruction = ui.readCommand();
            String keyCommand = userInstruction.split(" ")[0].toLowerCase();
            switch (keyCommand) {
            case ("add"):
                System.out.print("Do add");
                break;

            case ("list"):
                System.out.print("Do list");
                break;

            case ("view"):
                System.out.print("Do view");
                break;

            case ("delete"):
                System.out.print("Do delete");
                break;

            case ("exit"):
            case ("bye"):
            case ("quit"):
                System.out.print("Do exit");
                isExit = true;
                break;

            default:
                System.out.print("Do nothing");
            }
        }

    }
}
