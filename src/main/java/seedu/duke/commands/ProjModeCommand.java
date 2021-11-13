package seedu.duke.commands;

import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;
import seedu.duke.storage.GtdList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

/**
 * proj-mode is a mode to display inbox and proj list side by side.
 * so that user can put tasks from LHS -> RHS
 * TODO: Exception Handling V4.0
 */
public class ProjModeCommand extends Command {
    public static final String COMMAND_WORD = "proj-mode";
    public static final String INDEN = " ".repeat(6);


    private Ui ui = new Ui();
    private GtdList inbox = new GtdList();
    private GtdList proj = new GtdList();

    public ProjModeCommand() {

    }

    private void init() {
        inbox.clear();
        proj.clear();
        master.stream()
                .filter(lv0 -> lv0.getStatus() == Stat.NONE)
                .forEach(t -> inbox.add(t));
        master.stream()
                .filter(lv0 -> lv0.getStatus() == Stat.PROJ)
                .forEach(t -> proj.add(t));
    }

    @Override
    public void execute() {
        String input = "";

        String welcome = "begin proj-mode >>>"
                + System.lineSeparator()
                + "use `#no #no .. -> #no` to move from left to right"
                + System.lineSeparator();

        System.out.println(welcome);

        printSideBySide();

        while (true) {
            input = ui.readCommand().strip();
            if (input.equals("q")) {
                System.out.println("end proj-mode <<<");
                return;
            }
            String[] parts = parse(input); // TODO: pass to @rt for integration into parser
            if (parts == null) {
                break;
            }
            String projNo = parts[0];
            for (int i = 1; i < parts.length; i++) {
                proj.get(projNo).addSub(inbox.get(parts[i]));

                // temporary fix
                for (int j = 0; j < master.size(); j++) {
                    if (master.get(j).getlevel() != 0) {
                        master.remove(j);
                    }
                }
            }
            printSideBySide();
        }

    }

    /**
     * this method is to print 2 lists Inbox and Pro in a 2-column text.
     * on the left is inbox, rhs is proj list
     * the lhs longest line add IDEN is the
     * vertical line of rhs
     */
    public void printSideBySide() {
        ArrayList<String> lines = new ArrayList<>();

        init();

        String inboxText = "inbox:" + System.lineSeparator() + inbox.getlines();
        String projText = "proj:" + System.lineSeparator() + proj.getlines();

        String[] left = inboxText.split(System.lineSeparator());
        String[] right = projText.split(System.lineSeparator());

        int vertical = longestWidth(left);

        boolean leftLonger = left.length >= right.length ? true : false;

        if (leftLonger) {
            for (int i = 0; i < right.length; i++) {
                lines.add(left[i]
                        + " ".repeat(vertical - left[i].length())
                        + INDEN
                        + right[i]);
            }
            for (int i = right.length; i < left.length; i++) {
                lines.add(left[i]);
            }
        } else {
            for (int i = 0; i < left.length; i++) {
                lines.add(left[i]
                        + " ".repeat(vertical - left[i].length())
                        + INDEN
                        + right[i]);
            }
            for (int i = left.length; i < right.length; i++) {
                lines.add(" ".repeat(vertical)
                        + INDEN
                        + right[i]);
            }
        }

        lines.stream()
                .forEach(s -> System.out.println(s));
        System.out.print(System.lineSeparator());
    }

    private String[] parse(String input) {
        String[] parts = input.split("->");
        try {
            String projNo = parts[1].strip();

            ArrayList<String> al = new ArrayList<>();
            al.add(projNo);

            String[] todos = parts[0].strip().split(" ");
            for (String todo : todos) {
                al.add(todo);
            }

            String[] res = new String[al.size()];
            res = al.toArray(res);

            return res;

        } catch (Exception e) {
            System.out.println("Invalid Argument");
            return null;
        }

    }

    private int longestWidth(String[] left) {
        int longest = 0;
        for (String line : left) {
            if (line.length() > longest) {
                longest = line.length();
            }
        }
        return longest;
    }
}
