package seedu.duke;

public class Duke {
    private void run() {
        UI.welcome();
        boolean isExit = false;
        while(!isExit) {
            String fullCommand = UI.readCommand();
            if (fullCommand.equals("exit")) {
                isExit = true;
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}
