package seedu.duke.storage;

import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class GtdList {
    private static final String INDEN = "  ";

    ArrayList<GtdThought> list = new ArrayList<>();

    public GtdList() {
    }

    public Stream<GtdThought> stream() {
        Spliterator<GtdThought> gtdSpliterator = new GtdSpliterator(list);
        Supplier<Stream<GtdThought>> supplier
                = () -> StreamSupport.stream(gtdSpliterator, false);
        return supplier.get();
    }

    public int size() {
        return list.size();
    }

    public void add(GtdThought thought) {
        list.add(thought);
    }

    public void add(ArrayList<GtdThought> thoughts) {
        for (GtdThought thought : thoughts) {
            list.add(thought);
        }
    }

    public GtdThought get(int index) {
        return list.get(index);
    }

    public GtdThought get(String numbering) {
        String[] indexes = numbering.split("-");
        int index0;
        int index1;
        int index2;
        switch (indexes.length) {
        case 1:
            index0 = Integer.parseInt(indexes[0]) - 1;
            return get(index0);
        case 2:
            index0 = Integer.parseInt(indexes[0]) - 1;
            index1 = Integer.parseInt(indexes[1]) - 1;
            return get(index0).getSub().get(index1);
        case 3:
            index0 = Integer.parseInt(indexes[0]) - 1;
            index1 = Integer.parseInt(indexes[1]) - 1;
            index2 = Integer.parseInt(indexes[2]) - 1;
            return get(index0)
                    .getSub().get(index1)
                    .getSub().get(index2);
        default:
            return null;
        }
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getTextRec();
            System.out.print(addNum(text, i));
        }
    }

    // public GtdList filter(Stat status) {
    //     GtdList filtered = new GtdList();
    //
    //     return filtered;
    // }

    public String addNum(String text, int startNum) {
        startNum++;
        int l1Num = 0;
        int l2Num = 0;
        String[] lines = text.split(System.lineSeparator());

        lines[0] = startNum + " " + lines[0];

        for (int i = 1; i < lines.length; i++) {
            if (countInden(lines[i]) == 1) {
                lines[i] = INDEN
                        + startNum
                        + "-"
                        + (++l1Num)
                        + " "
                        + lines[i].replaceFirst(INDEN, "");
            }
            if (countInden(lines[i]) == 2) {
                lines[i] = INDEN.repeat(2)
                        + startNum
                        + "-"
                        + l1Num
                        + "-"
                        + (++l2Num)
                        + " "
                        + lines[i].replaceFirst(INDEN.repeat(2), "");
            }
        }

        String textWithNum = "";
        for (String line : lines) {
            textWithNum += line + System.lineSeparator();
        }

        return textWithNum;
    }

    public int countInden(String str) {
        return str.startsWith(INDEN.repeat(2)) ? 2 : 1;
    }

    public void clear() {
        list.clear();
    }
}

