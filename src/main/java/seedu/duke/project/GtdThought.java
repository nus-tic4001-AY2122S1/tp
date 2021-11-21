package seedu.duke.project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

/**
 * GtdThoughts is the task in GTD flow. <br />
 * Since task could be converted to project,
 * The data struct could have subtasks (children) which is
 * a list of GtdThoughts <br />
 * It supports 2 more layers of nesting at most <br />
 * It also have one status at a time denoted in enum `Stat`
 */
public class GtdThought implements Comparable<GtdThought> {
    private static final String INDEN = "  ";

    private Stat status = Stat.NONE;
    private final int[] lv = {0, 1, 2};
    private int level = lv[0];
    private String title;
    private String note;
    private Optional<GtdThought> parent = Optional.empty();
    private ArrayList<GtdThought> children = new ArrayList<>();
    private LocalDateTime creation;
    private LocalDate due;
    private LocalDateTime done;

    private int id;
    private int parentID = 0;
    private int levelNo = 0;

    public static int maxID = 0;

    public GtdThought(String title) {
        this.title = title;
        this.creation = LocalDateTime.now();
        this.id = maxID + 1;
        maxID++;

    }

    public GtdThought(String title, GtdThought parent) {
        this.title = title;
        this.parent = Optional.of(parent);
    }

    public GtdThought(int id, Stat status, String title, LocalDate due) {
        this.id = id;
        this.status = status;
        this.title = title;
        this.due = due;
        maxID = Math.max(maxID, id);
    }

    public int getId() {
        return id;
    }

    public int getParentID() {
        return parentID;
    }

    public Optional<GtdThought> getParent() {
        return parent;
    }

    public int getLevelNo() {
        return levelNo;
    }

    public String getTitle() {
        return title;
    }

    public String getDueString() {
        return (due == null) ? "0000-00-00" : due.toString();
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
            assert this.level <= 2 : "level should be 0, 1, 2";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Unable to nest task further");
            return;
        }

        children.add(sub);
        this.setStatus(Stat.PROJ);
        if (sub.getStatus() == Stat.NONE) {
            sub.setStatus(Stat.TODO);
        }
        sub.addParent(this);

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
        System.out.println(this.toString());
    }

    public void printRec() {
        System.out.println(this.toString());

        if (children.isEmpty()) {
            return;
        }
        for (GtdThought sub : children) {
            sub.printRec();
        }
    }

    /**
     * getTextRec return String of text of the GtdThought, including children.
     * This is an important and useful method
     * to display a GtdThought
     * It will indent the subtask based on their level
     * e.g.
     * [PROJ] Proj
     *   [PROJ] Subtask A
     *     A.1
     *   Subtask B
     * @return
     */
    public String getTextRec() {
        return getTextRec(false);
    }

    public String getTextRec(boolean excludeChildren) {
        return auxgetTextRec("", excludeChildren);
    }

    private String auxgetTextRec(String text, boolean excludeChildren) { // this + children
        String indentation = INDEN.repeat(level);

        if (children.isEmpty() || excludeChildren) {
            return indentation + this + System.lineSeparator();
        }

        for (GtdThought sub : children) {
            text += sub.auxgetTextRec("", false); // MAGIC!
        }

        return indentation + this + System.lineSeparator() + text;
    }

    public void setParent(GtdThought thought) {
        this.parent = Optional.of(thought);
    }

    public ArrayList<GtdThought> getRec(Stat stat) {
        ArrayList<GtdThought> filtered = new ArrayList<>();
        auxgetRec(stat, filtered);
        return filtered;
    }

    public void auxgetRec(Stat stat, ArrayList<GtdThought> filtered) {
        if (this.getStatus() == stat) {
            filtered.add(this);
        }
        if (!this.children.isEmpty()) {
            children.stream()
                    .forEach(t -> t.auxgetRec(stat, filtered));
        }
    }

    public ArrayList<GtdThought> getDueList(ArrayList<GtdThought> dueList) {
        if (due != null) {
            dueList.add(this);
        }
        if (!this.children.isEmpty()) {
            children.stream()
                    .forEach(t -> t.getDueList(dueList));
        }
        return dueList;
    }

    public Stat getStatus() {
        return this.status;
    }

    public void setStatus(Stat status) {
        if (status == Stat.NEXT && !children.isEmpty()) {
            System.out.println("Only actionable tasks can be set to NEXT!");
            return;
        }
        if (status == Stat.DONE) {
            this.done = LocalDateTime.now();
        }

        this.status = status;
    }

    public boolean hasChildren() {
        return children.size() == 0 ? false : true;
    }

    public ArrayList<GtdThought> getChildren() {
        return children;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String title) {
        this.note = note;
    }

    public void setDue(LocalDate due) {
        this.due = due;
    }

    @Override
    public String toString() {
        String dueOutput = (due == null) ? "" : " [DUE:" + due.toString() + "]";
        switch (status) {
        case NONE:
            return this.title + dueOutput;
        default:
            return "[" + this.status + "] " + title + dueOutput;
        }
    }

    @Override
    public int compareTo(GtdThought e) {
        return this.due.compareTo(e.due);
    }
}
