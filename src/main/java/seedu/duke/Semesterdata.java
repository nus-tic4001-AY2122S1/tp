package seedu.duke;

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

    @Override
    public String toString() {
        return "SemesterData{" +
                "semester=" + semester +
                ", examDate='" + examDate + '\'' +
                ", examDuration=" + examDuration +
                '}';
    }
}
