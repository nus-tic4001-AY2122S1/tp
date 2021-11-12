package seedu.duke;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StorageTest {

    public Module getSampleModule() {
        Semesterdata[] semData = new Semesterdata[1];
        Integer[] semesters = {1,2};
        semData[0] = new Semesterdata(1, new Date(120, 12, 20, 9, 30), 100);
        Module module = new Module("TIC4001", "Software Eng", semesters, "A description",
                4.0F, "Computing", "Faculty of Comp", "TIC2001",
                "a", "b", semData);
        return module;
    }

    public Module getSampleModule(String moduleCode) {
        Semesterdata[] semData = new Semesterdata[1];
        Integer[] semesters = {1,2};
        semData[0] = new Semesterdata(1, new Date(120, 12, 20, 9, 30), 100);
        Module module = new Module(moduleCode, "Software Eng", semesters, "A description",
                4.0F, "Computing", "Faculty of Comp", "TIC2001",
                "a", "b", semData);
        return module;
    }

    public String getSampleModuleArrayJson() {
        return "[{\"moduleCode\":\"TIC1234\",\"title\":\"Software Eng\",\"semesters\":[1,2],"
                + "\"description\":\"A description\",\"moduleCredit\":4.0,\"department\":\"Computing\","
                + "\"faculty\":\"Faculty of Comp\",\"prerequisite\":\"TIC2001\",\"preclusion\":\"a\","
                + "\"corequisite\":\"b\",\"semesterData\":[{\"semester\":1,\"examDate\":\"Jan 20, 2021, 9:30:00 AM\","
                + "\"examDuration\":100}]},{\"moduleCode\":\"TIC4001\",\"title\":\"Software Eng\",\"semesters\":[1,2],"
                + "\"description\":\"A description\",\"moduleCredit\":4.0,\"department\":\"Computing\","
                + "\"faculty\":\"Faculty of Comp\",\"prerequisite\":\"TIC2001\",\"preclusion\":\"a\","
                + "\"corequisite\":\"b\",\"semesterData\":[{\"semester\":1,\"examDate\":\"Jan 20, 2021, 9:30:00 AM\","
                + "\"examDuration\":100}]}]";
    }

    @Test
    public void getJsonStringFromUserList() throws IOException {
        Storage storage = new Storage();
        Module module = getSampleModule();
        Module anotherModule = getSampleModule("TIC1234");
        ArrayList<Module> modules = new ArrayList<Module>();
        modules.add(anotherModule);
        modules.add(module);
        String expected = getSampleModuleArrayJson();
        Gson gson = new Gson();
        String result = gson.toJson(modules);
        assertEquals(expected, result);
    }

}
