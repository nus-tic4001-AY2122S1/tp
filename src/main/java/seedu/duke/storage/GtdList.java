package seedu.duke.storage;

import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class GtdList {
    private static final String INDEN = "  ";

    ArrayList<GtdThought> list = new ArrayList<>();
    Spliterator<GtdThought> gtdSpliterator = new GtdSpliterator(list);
    Stream<GtdThought> gtdStream = StreamSupport.stream(gtdSpliterator, false);

    public GtdList() {
    }

    /**
     * Constructs a gtdList from the items in the given collection.
     *
     * @param gtdThoughts a collection of GtdThought
     */
    public GtdList(Collection<GtdThought> gtdThoughts) {
        list.addAll(gtdThoughts);
    }

    /**
     * Constructs a shallow copy of the list.
     */
    public GtdList(GtdList source) {
        list.addAll(source.list);
    }

    public Stream<GtdThought> stream() {
        return gtdStream;
    }

    public int size() {
        return list.size();
    }

    public void add(GtdThought thought) {
        list.add(thought);
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

    public void remove(int[] index, GtdList current) {
        List<GtdThought> toRemove = IntStream.range(0, current.size())
                .filter(i -> Arrays.stream(index).anyMatch(idx -> idx == i + 1))
                .mapToObj(i -> current.get(i))
                .collect(Collectors.toList());
        list.removeAll(toRemove);
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getTextRec();
            System.out.print(addNum(text, i));
        }
    }

    public GtdList filter(Stat status) {
        GtdList filtered = new GtdList();


        return filtered;
    }

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


}

