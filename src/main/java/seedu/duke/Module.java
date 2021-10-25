package seedu.duke;

import java.util.Arrays;
import java.util.List;

public class Module {

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
    Semesterdata[] semesterData;

    public Module() {

    }

    public Module(String moduleCode, String title, Integer[] semesters, String description, Float moduleCredit,
                  String department, String faculty, String prerequisite, String preclusion, String corequisite,
                  Semesterdata[] semesterData) {
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

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleTitle() {
        return title;
    }

    public String getPrettyPrint() {
        String semesterString = "";
        for (int i = 0; i < semesters.length; i++) {
            semesterString += Integer.toString(semesters[i]);
            if (i < semesters.length - 1) {
                semesterString += ", ";
            }
        }

        String semesterDataString = "";
        for (Semesterdata sem : semesterData) {
            semesterDataString += sem.getPrettyString();
        }

        String result = "";
        result += moduleCode + " | ";
        result += title + " | ";
        result += "Semesters: " + semesterString + " | ";
        result += description + " | ";
        result += "Module credit: " + moduleCredit + " | ";
        result += "Department: " + department + " | ";
        result += "Faculty: " + faculty + " | ";
        result += "Prerequisites: " + prerequisite + " | ";
        result += "Corequisites: " + corequisite + " | ";
        result += "Detailed semester data:" + semesterDataString;

        return result;
    }
}
