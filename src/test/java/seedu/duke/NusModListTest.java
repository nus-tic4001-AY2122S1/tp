package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NusModListTest {
    @Test
    public void nusModListTest1() {

        Integer[] sem = {1};

        String desTic4001 = "This module is one of the two modules where students get to practice software "
                + "engineering concepts learnt in a team environment to produce a well-designed, well-tested, "
                + "large-scaled software system. This module focuses on software engineering practice of a "
                + "greenfield project, where students will elicit the requirements, design the software architecture "
                + "and interfaces, and implement the software from scratch.";
        String desTic4002 = "This module provides a broad introduction to software engineering approaches specific "
                + "to building a parallel/distributed software system. Such systems are challenging since they are "
                + "concurrent, prone to components failure, and non-deterministic. This module begins by introducing "
                + "students to the basics of concurrent and parallel programming, as well as common middleware and "
                + "tools for building distributed systems. It then covers how behaviours and challenges specific to "
                + "distributed and parallel software can be considered as part of the software engineering processes "
                + "(including requirements, design, and testing).";

        Module module1 = new Module("TIC4001", "Software Engineering Practicum I", sem, desTic4001);
        Module module2 = new Module("TIC4005", "Parallel and Distributed Software Engineering", sem, desTic4002);
        Module[] moduleList = {module1, module2};

        NusModList nusModList = NusModList.createInstance(moduleList);

        assertEquals(2, nusModList.getSize());
        assertEquals(moduleList, nusModList.getAllModule());
        assertEquals(module2, nusModList.getMod("TIC4005"));
        assertEquals(false, nusModList.hasMod("TIC4002"));
        assertEquals(true, nusModList.hasMod("TIC4005"));
        assertEquals(0, nusModList.moduleIndex("TIC4001"));
        assertEquals(module1, nusModList.getMod(0));

    }
}
