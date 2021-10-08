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
            String keyCommand;
            try {
                String userInstruction = ui.readCommand();
                keyCommand = userInstruction.split(" ")[0].toLowerCase();
            } catch (Exception e) {
                keyCommand = "exit";
            }
            switch (keyCommand) {
            case ("add"):
                System.out.println("Do add");
                break;

            case ("list"):
                System.out.println("Do list");
                break;

            case ("view"):
                System.out.println("Do view");
                break;

            case ("delete"):
                System.out.println("Do delete");
                break;

            case ("exit"):
            case ("bye"):
            case ("quit"):
                System.out.println("Do exit");
                isExit = true;
                break;

            default:
                System.out.println("Do nothing");
            }
        }
        System.out.println("Good Bye!");
    }
}