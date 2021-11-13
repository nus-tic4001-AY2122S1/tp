package seedu.duke.module;

import java.util.Date;

public class Semesterdata {
    Integer semester;
    Date examDate;
    Integer examDuration;

    public Semesterdata(Integer semester, Date examDate, Integer examDuration) {
        this.semester = semester;
        this.examDate = examDate;
        this.examDuration = examDuration;
    }

    public String getPrettyString() {
        String result = "";
        result += "Semester:" + (semester == null ? "NA" : semester) + " | ";
        result += "Exam date:" + (examDate == null ? "NA" : examDate) + " | ";
        result +=  "Exam duration:" + (examDuration == null ? "NA" : examDuration);

        return result;
    }

    @Override
    public String toString() {
        return "SemesterData{"
                + "semester=" + semester
                + ", examDate='" + examDate + '\''
                + ", examDuration=" + examDuration
                + '}';
    }
}
