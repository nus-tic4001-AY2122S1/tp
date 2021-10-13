package seedu.duke;

import java.util.Arrays;
import java.util.List;

public class Module<SemesterData> {

    String moduleCode;
    String title;
    Integer[] semesters;
    String description;
    Float moduleCredit;
    String department;
    String faculty;
    String prerequisite;
    String preclusion;
    String corequisite;
    SemesterData[] semesterData;

  public Module() {}

    public Module(String moduleCode, String title, Integer[] semesters, String description, Float moduleCredit,
                  String department, String faculty, String prerequisite, String preclusion, String corequisite,
                  SemesterData[] semesterData) {
        this.moduleCode = moduleCode;
        this.title = title;
        this.semesters = semesters;
        this.description = description;
        this.moduleCredit = moduleCredit;
        this.department = department;
        this.faculty = faculty;
        this.prerequisite = prerequisite;
        this.preclusion = preclusion;
        this.corequisite = corequisite;
        this.semesterData = semesterData;
    }

    public Module(String moduleCode, String title, Integer[] semesters, String description) {
        this.moduleCode = moduleCode;
        this.title = title;
        this.semesters = semesters;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Module{"
                + "moduleCode='" + moduleCode + '\''
                + ", title='" + title + '\''
                + ", semesters=" + Arrays.toString(semesters)
                + ", description='" + description + '\''
                + ", moduleCredit=" + moduleCredit
                + ", department='" + department + '\''
                + ", faculty='" + faculty + '\''
                + ", prerequisite='" + prerequisite + '\''
                + ", preclusion='" + preclusion + '\''
                + ", corequisite='" + corequisite + '\''
                + ", semesterData='" + semesterData + '\''
                + '}';
    }
}
