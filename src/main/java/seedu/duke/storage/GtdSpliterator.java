package seedu.duke.storage;

import seedu.duke.project.GtdThought;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;

public class GtdSpliterator implements Spliterator<GtdThought> {
    private ArrayList<GtdThought> listToSplit;
    int count = 0;

    public GtdSpliterator(ArrayList<GtdThought> listToSplit) {
        this.listToSplit = listToSplit;
    }

    @Override
    public boolean tryAdvance(Consumer<? super GtdThought> action) {
        if (count < listToSplit.size()) {
            action.accept(listToSplit.get(count));
            count++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<GtdThought> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return listToSplit.size();
    }

    @Override
    public int characteristics() {
        return Arrays.asList(listToSplit).stream()
                .spliterator()
                .characteristics();
    }
}
