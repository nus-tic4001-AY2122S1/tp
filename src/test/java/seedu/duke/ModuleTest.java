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
        Module mod = new Module("TIC4001", "Software Eng", semesters, "A description",
                4.0F, "Computing", "Faculty of Comp", "TIC2001",
                "a", "b", semData);
        assertNotNull(mod);
        assertEquals(mod.getModuleCode(), "TIC4001");
    }
}
