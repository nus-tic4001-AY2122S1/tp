package seedu.duke.storage;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import seedu.duke.project.GtdThought;

public class GtdListEncoderTest {
    @Test
    public void encodeGtdListTest() {
        GtdThought gtdThought1 = new GtdThought("task1");
        GtdThought gtdThought2 = new GtdThought("task2");
        gtdThought1.addSub(gtdThought2);
        GtdThought gtdThought3 = new GtdThought("task3");
        gtdThought2.addSub(gtdThought3);

        GtdList gtdList = new GtdList();
        gtdList.add(gtdThought1);

        List<String> expect = new ArrayList<>();
        expect.add("1|PROJ|task1|||");
        expect.add("2|PROJ|task2|||1|");
        expect.add("3|TODO|task3|||1|2|");

        assertEquals(expect, GtdListEncoder.encodeGtdList(gtdList));
    }
}
