package seedu.duke.storage;

import seedu.duke.project.GTDThought;

import java.util.ArrayList;

public class GTDList {
    private static final String INDEN = "  ";

    ArrayList<GTDThought> list = new ArrayList<>();

    public GTDList() {}

    public int size() {return list.size();}
    public void add(GTDThought thought) {list.add(thought);}
    public GTDThought get(int index) {return list.get(index);}

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getTextRec();
            System.out.println(addNum(text));
        }
    }

    public String addNum(String text) {
        String[] lines = text.split(System.lineSeparator());

        return text; // TODO: Unfishied for adding number like 1-2-1
    }
}
