package seedu.duke.commands;

import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;
import seedu.duke.storage.GtdList;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

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

        printSideBySide();

        while (true) {
            input = ui.readCommand().strip();
            if (input.equals("q")) {
                System.out.println("end proj-mode");
                return;
            }
            String[] parts = parse(input); // TODO: pass to @rt for integrad into parser
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

    public void printSideBySide() {
        ArrayList<String> lines = new ArrayList<>();

        init();

        String[] left = inbox.getlines().split(System.lineSeparator());
        String[] right = proj.getlines().split(System.lineSeparator());

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

    }

    private String[] parse(String input) {
        String[] parts = input.split("->");
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
