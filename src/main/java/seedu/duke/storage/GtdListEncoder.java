package seedu.duke.storage;

import seedu.duke.project.GtdThought;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Encodes the {@code gtdThought} object into a data file for storage.
 */
public class GtdListEncoder {

    /**
     * Encodes all the {@code GtdThought} in the {@code toSave} into
     * a list of decodable and readable string presentation for storage.
     */
    public static List<String> encodeGtdList(GtdList toSave) {
        List<String> encodedGtdThoughts = new ArrayList<>();
        for (int i = 0; i < toSave.size(); i++) {
            encodedGtdThoughts.add(encodeGtdThoughtToString(toSave.get(i)));
        }
        return encodedGtdThoughts;

    }

    /**
     * Encodes the {@code gtdThought} into a decodable and readable string representation.
     */
    private static String encodeGtdThoughtToString(GtdThought gtdThought) {
        StringBuilder encodedGtdThoughtBuilder = new StringBuilder();

        encodedGtdThoughtBuilder.append(gtdThought.getId());
        encodedGtdThoughtBuilder.append("|");
        encodedGtdThoughtBuilder.append(gtdThought.getStatus());
        encodedGtdThoughtBuilder.append("|");
        encodedGtdThoughtBuilder.append(gtdThought.getTitle());
        encodedGtdThoughtBuilder.append("|||");
        encodedGtdThoughtBuilder.append(gtdThought.getLevelNo());
        encodedGtdThoughtBuilder.append("|");
        encodedGtdThoughtBuilder.append(gtdThought.getParentID());


        return encodedGtdThoughtBuilder.toString();


    }


}
