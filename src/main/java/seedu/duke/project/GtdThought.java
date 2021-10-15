package seedu.duke.project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class GtdThought {
    private static final String INDEN = "  ";

    private Stat status = Stat.NONE;
    private final int[] lv = {0, 1, 2};
    private int level = lv[0];
    private String title;
    private String note;
    private Optional<GtdThought> parent = Optional.empty();
    private ArrayList<GtdThought> children = new ArrayList<>();
    private LocalDateTime creation;
    private LocalDateTime due;
    private LocalDateTime done;

    public GtdThought(String title) {
        this.title = title;
        this.creation = LocalDateTime.now();


    }

    public GtdThought(String title, GtdThought parent) {
        this.title = title;
        this.parent = Optional.of(parent);
    }

    public int checkLevel() {
        int n = 0;
        if (parent.isEmpty()) {
            n = 0;
        }
        return n;
    }

    public int getlevel() {
        return this.level;
    }

    public void setlevel(int n) {
        this.level = lv[n];
    }

    public void addSub(GtdThought sub) {
        try {
            sub.setlevel(this.getlevel() + 1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to nest task further");
            return;
        }

        children.add(sub);
        this.setStatus(Stat.PROJ);
        sub.setStatus(Stat.TODO);
        sub.addParent(this);

        //         for (int i = 0; i < children.size(); i++) {
        //             subprojects.get(i).setID(Integer.toString(i + 1));
        //         }
    }

    public void removeSub(GtdThought thought) {
        children.remove(thought);
    }

    public ArrayList<GtdThought> getSub() {
        return children;
    }

    public void addParent(GtdThought project) {
        this.parent = Optional.of(project);
    }


    public void print() {
        // updateID();
        System.out.println(this.toString());
    }

    public void printRec() {
        // updateID();
        System.out.println(this.toString());

        if (children.isEmpty()) {
            return;
        }
        for (GtdThought sub : children) {
            sub.printRec();
        }
    }

    public String getTextRec() {
        return aux("");
    }

    private String aux(String text) { // this + children
        String indentation = INDEN.repeat(level);

        if (children.isEmpty()) {
            return indentation + this + System.lineSeparator();
        }
        for (GtdThought sub : children) {
            text += sub.aux(text);
        }

        return indentation + this + System.lineSeparator() + text;
    }


    public void setParent(GtdThought thought) {
        this.parent = Optional.of(thought);
    }

    public Stat getStatus() {
        return this.status;
    }

    public void setStatus(Stat status) {
        if (status == Stat.NEXT && !children.isEmpty()) {
            System.out.println("Only actionable tasks can be set to NEXT!");
            return;
        }

        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String title) {
        this.note = note;
    }

    @Override
    public String toString() {
        switch (status) {
        case NONE:
            return this.title;
        default:
            return "[" + this.status + "] " + title;
        }
    }
}
