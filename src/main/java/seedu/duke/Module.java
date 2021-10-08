package seedu.duke;

import java.util.List;

public class Module {

    String moduleCode;
    String title;
    Integer[] semesters;

    public Module() {
    }

    public Module(String moduleCode, String title, Integer[] semesters) {
        this.moduleCode = moduleCode;
        this.title = title;
        this.semesters = semesters;
    }
}
