package seedu.duke.storage;

import seedu.duke.project.GTDThought;

import java.util.ArrayList;

public class GTDList {
    private static final String INDEN = "  ";

    ArrayList<GTDThought> list = new ArrayList<>();

    public GTDList() {
    }

    public int size() {
        return list.size();
    }

    public void add(GTDThought thought) {
        list.add(thought);
    }

    public GTDThought get(int index) {
        return list.get(index);
    }

    public GTDThought get(String numbering) {
        String[] indexes = numbering.split("-");
        int index0, index1, index2;
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
        }
        return null;
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void print() {
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getTextRec();
            System.out.println(addNum(text, i));
        }
    }

    public String addNum(String text, int startNum) {
        startNum++;
        int l1Num = 0;
        int l2Num = 0;
        String[] lines = text.split(System.lineSeparator());

        lines[0] = startNum + " " + lines[0];

        for (int i = 1; i < lines.length; i++) {
            if (countINDEN(lines[i]) == 1) {
                lines[i] = INDEN
                        + startNum
                        + "-"
                        + (++l1Num)
                        + " "
                        + lines[i].replaceFirst(INDEN, "");
            }
            if (countINDEN(lines[i]) == 2) {
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
            textWithNum += line + System.lineSeparator() ;
        }

        return textWithNum;
    }

    public int countINDEN(String str) {
        return str.startsWith(INDEN.repeat(2)) ? 2 : 1;
    }
}