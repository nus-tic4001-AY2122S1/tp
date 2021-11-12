package seedu.duke;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ModuleTest {
    @Test
    public void testModule() {
        System.out.println("Module constructor should work with args, and getters return correct data");
        Semesterdata[] semData = new Semesterdata[1];
        Integer[] semesters = {1,2};
        semData[0] = new Semesterdata(1, new Date(), 100);
        Module module = new Module("TIC4001", "Software Eng", semesters, "A description",
                4.0F, "Computing", "Faculty of Comp", "TIC2001",
                "a", "b", semData);
        assertNotNull(module);
        assertEquals(module.getModuleCode(), "TIC4001");
    }

    @Test
    public void testPrettyPrint() {
        System.out.println("should return a pretty print");
        Semesterdata[] semData = new Semesterdata[1];
        Integer[] semesters = {1,2};
        semData[0] = new Semesterdata(1, new Date(120, 12, 20, 9, 30), 100);
        Module module = new Module("TIC4001", "Software Eng", semesters, "A description",
                4.0F, "Computing", "Faculty of Comp", "TIC2001",
                "a", "b", semData);
        String expected = "TIC4001 | Software Eng | Semesters: Semester:1 | Exam date:Wed Jan 20 09:30:00 SGT 2021 "
                + "| Exam duration:100" + "\n" + "A description" + "\n" + "Module credit: 4.0 "
                + "| Department: Computing | Faculty: Faculty of Comp | Prerequisites: TIC2001 | Corequisites: b";

        assertEquals(module.getPrettyPrint(), expected);
    }
}
