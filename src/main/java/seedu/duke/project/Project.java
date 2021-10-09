package seedu.duke.project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

public class Project {
    private String dynamicID = "1";
    private Stat status = Stat.NONE;
    private String title;
    private String note;
    private Optional<Project> parent = Optional.empty();
    private ArrayList<Project> subprojects = new ArrayList<>();
    private LocalDateTime due;

    public Project(String title) {
        this.title = title;
    }
    public Project(String title, Project parent) {
        this.title = title;
        this.parent = Optional.of(parent);
    }

    public void addSub(Project project) {
        subprojects.add(project);
        this.setStatus(Stat.PROJ);
        project.addParent(this);
        for (int i = 0; i < subprojects.size(); i++) {
            subprojects.get(i).setID(Integer.toString(i + 1));
        }
    }

    public void addParent(Project project) {
        this.parent = Optional.of(project);
    }

    public String getID() {
        return dynamicID;
    }

    public void setID(String id) {
        this.dynamicID = id;
    }

    public String updateID() {
        if(parent.isPresent()) {
            this.dynamicID = parent.get().getID() + "-" + this.getID();
        }
        return this.dynamicID;
    }

    public void print() {
        updateID();

        switch (status) {
            case NONE:
                System.out.println(dynamicID + " " +this.title);
                break;
            default:
                System.out.println(
                        dynamicID + " [" + this.status + "] " + this.title);
        }

    }

    public void printRec() {
        this.print();

        if(subprojects.isEmpty()) {
            return;
        }
        for (Project sub : subprojects) {
            sub.printRec();
        }
    }

    public Stat getStatus() {
        return this.status;
    }

    public void setStatus(Stat status) {
        this.status = status;
    }

}
