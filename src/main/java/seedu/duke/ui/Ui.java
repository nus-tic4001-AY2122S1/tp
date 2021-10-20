package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private Scanner in;
    private PrintStream out;
    private static final String SEPARATE_LINE = "_________________________________________________";

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /**
     * read command from the userInput.
     *
     * @return the string of user input
     */
    public String readCommand() {
        out.print("Enter Command:\n");
        String line = in.nextLine();
        return line;
    }

    public String readPut() {
        out.print("Put:\n");
        String line = in.nextLine().strip();
        return line;
    }

    /**
     * show the divider line.
     */
    public void showLine() {
        out.println(SEPARATE_LINE);
    }

    /**
     * show the error message.
     *
     * @param message the passed message to show
     */
    public void showError(String message) {
        out.println(message);
    }
}
