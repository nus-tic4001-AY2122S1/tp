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
        expect.add(gtdThought1.getId() + "|PROJ|task1|0000-00-00|||");
        expect.add(gtdThought2.getId() + "|PROJ|task2|0000-00-00|||" + gtdThought1.getId() + "|");
        expect.add(gtdThought3.getId() + "|TODO|task3|0000-00-00|||" + gtdThought1.getId() + "|" + gtdThought2.getId() + "|");

        assertEquals(expect, GtdListEncoder.encodeGtdList(gtdList));
    }
}
