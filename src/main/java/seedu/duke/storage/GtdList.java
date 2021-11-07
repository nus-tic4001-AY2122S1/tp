package seedu.duke.storage;

import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;

import java.util.Iterator;

import java.util.function.Supplier;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class GtdList implements Iterable<GtdThought> {
    private static final String INDEN = "  ";

    ArrayList<GtdThought> list = new ArrayList<>();

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

    public void removeAll(ArrayList<GtdThought> toRemove) {
        //        List<GtdThought> toRemove = IntStream.range(0, current.size())
        //                .filter(i -> Arrays.stream(index).anyMatch(idx -> idx == i + 1))
        //                .mapToObj(i -> current.get(i))
        //                .collect(Collectors.toList());
        List<GtdThought> lv0 = toRemove.stream()
                                .filter(t -> t.getlevel() == 0)
                                .collect(Collectors.toList());
        List<GtdThought> lv1 = toRemove.stream()
                                .filter(t -> t.getlevel() == 1)
                                .collect(Collectors.toList());
        List<GtdThought> lv2 = toRemove.stream()
                                .filter(t -> t.getlevel() == 2)
                                .collect(Collectors.toList());

        list.removeAll(lv0);
    }


    public void print() {
        print(false);
    }

    public void print(boolean excludeChildren) {
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getTextRec(excludeChildren);
            String line = addNum(text, i);
            System.out.print(line);
        }
    }

    public String getlines() {
        String lines = "";
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getTextRec();
            String line = addNum(text, i);
            lines += line;
        }
        return lines;
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
                l2Num = 0;
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

    @Override
    public Iterator<GtdThought> iterator() {
        return list.iterator();
    }
}

