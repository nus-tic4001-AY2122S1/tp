package seedu.duke.module;

import java.util.Arrays;

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

    public Float getModuleCredit() {
        return moduleCredit;
    }

    public String getModuleSemester() {
        String semesterDataString = "";
        if (semesterData.length == 0) {
            return "Semester: Information unavailable";
        }
        for (int i = 0; i < semesterData.length; i++) {
            semesterDataString += semesterData[i].getPrettyString();
            if (i < semesterData.length - 1) {
                semesterDataString += " | ";
            }
        }
        return semesterDataString;
    }

    public String getPrettyPrint() {
        String semesterString = "";
        if (semesters != null) {
            for (int i = 0; i < semesters.length; i++) {
                semesterString += semesters[i].toString();
                if (i < semesters.length - 1) {
                    semesterString += ", ";
                }
            }
        }

        String semesterDataString = "";
        for (Semesterdata sem : semesterData) {
            semesterDataString += sem.getPrettyString();
        }

        String result = "";
        result += moduleCode + " | ";
        result += title + " | ";
        result += "Semesters: " + semesterDataString + "\n";
        result += description + "\n";
        result += "Module credit: " + moduleCredit + " | ";
        result += "Department: " + department + " | ";
        result += "Faculty: " + faculty + " | ";
        result += "Prerequisites: " + prerequisite + " | ";
        result += "Corequisites: " + corequisite;

        return result;
    }

    public String getBasicModuleDetails() {
        return getModuleCode() + " | "
                + getModuleTitle() + " | "
                + getModuleSemester();
    }
}
