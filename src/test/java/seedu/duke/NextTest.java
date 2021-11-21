package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;
import seedu.duke.storage.GtdList;

import java.util.stream.Stream;

class NextTest {
    private GtdThought p1 = new GtdThought("This is my very first task");
    private GtdThought p2 = new GtdThought("Second level 0 task");

    private GtdThought sub1 = new GtdThought("sub task a");
    private GtdThought sub2 = new GtdThought("sub task b");
    private GtdThought subsub1 = new GtdThought("sub sub task a.1");

    private GtdList proj = new GtdList();

    public NextTest() {
        p1.addSub(sub1);
        p1.addSub(sub2);
        sub1.addSub(subsub1);

        subsub1.setStatus(Stat.NEXT);

        proj.add(p1);
        proj.add(p2);
    }

    @Test
    public void testgetTextRec() {
        String actual = p1.getTextRec();

        String expected = "[PROJ] This is my very first task"
                + System.lineSeparator()
                + "  [PROJ] sub task a"
                + System.lineSeparator()
                + "    [NEXT] sub sub task a.1"
                + System.lineSeparator()
                + "  [TODO] sub task b"
                + System.lineSeparator();

        assertEquals(expected, actual);
    }

    @Test
    public void testgetWithString() {
        String actual1 = proj.get("2").toString();
        String expected1 = "Second level 0 task";

        String actual2 = proj.get("1-2").toString();
        String expected2 = "[TODO] sub task b";

        String actual3 = proj.get("1-1-1").toString();
        String expected3 = "[NEXT] sub sub task a.1";

        assertEquals(expected1, actual1);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);

    }

    @Test
    public void testListPrint() {
        GtdThought subsub2 = new GtdThought("sub sub task b.1");
        sub2.addSub(subsub2);

        proj.print();

        System.out.println("*".repeat(10));

        System.out.print(p1.getTextRec());

        System.out.println("*".repeat(10));

        proj.stream().forEach(t -> System.out.print(t.getTextRec()));

        System.out.println("*".repeat(10));

        proj.stream().filter(c -> c.getStatus() == Stat.PROJ)
                .forEach(GtdThought::print);

        System.out.println("*".repeat(10));

        proj.get("2").setStatus(Stat.NEXT);

        proj.stream().forEach(l0 -> l0.getRec(Stat.NEXT)
                .stream()
                .forEach(t -> t.print()));

    }

}
