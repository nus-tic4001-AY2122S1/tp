package seedu.duke.storage;

import seedu.duke.project.GTDThought;

import java.util.ArrayList;

public class GTDList {
    ArrayList<GTDThought> list = new ArrayList<>();

    public GTDList() {}

    public int size() {return list.size();}
    public void add(GTDThought thought) {list.add(thought);}
    public GTDThought get(int index) {return list.get(index);}

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getTextRec());
            format();
        }
    }

    public void format() {

    }
}
