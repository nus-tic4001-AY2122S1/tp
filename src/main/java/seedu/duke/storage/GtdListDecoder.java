package seedu.duke.storage;

import seedu.duke.exception.IllegalValueException;
import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Decodes the storage data file into an {@code gtdList} object.
 */
public class GtdListDecoder {

    public static final Pattern GTD_THOUGHT_TXT_FILE_FORMAT = Pattern.compile(
            "(?<id>\\d+)[|](?<status>.*)[|](?<title>.*)[|][|][|](?<parents>[|\\d]*)"
    );

    /**
     * Decodes {@code encodedGtdList} into an {@code GtdList} containing the decoded GtdThought.
     *
     * @throws IllegalValueException if any of the fields in any encoded GtdThought string is invalid.
     */
    public static GtdList decodeTaskList(List<String> encodedGtdList) throws IllegalValueException {

        List<GtdThought> decodedGtdThoughts = new ArrayList<>();
        for (String encodedGtdThought : encodedGtdList) {
            HashMap<String, Object> elements = decodeGtdThoughtFromString(encodedGtdThought);
            GtdThought gtdThought = new GtdThought((int)elements.get("id"), (Stat)elements.get("status"),
                    (String)elements.get("title"));

            String parents = (String)elements.get("parents");
            if (parents.equals("")) {
                decodedGtdThoughts.add(gtdThought);
            } else {
                getParent_GtdList(decodedGtdThoughts, parents).addSub(gtdThought);
            }
        }
        return new GtdList(decodedGtdThoughts);
    }

    private static GtdThought getParent_GtdList(List<GtdThought> gtdList, String parents) {
        String[] split = parents.split("\\|", 2);
        int parentId = Integer.parseInt(split[0]);
        int matchIdx = -1;
        for (int i = 0; i < gtdList.size(); i++) {
            if (gtdList.get(i).getId() == parentId) {
                matchIdx = i;
            }
        }
        assert matchIdx > -1;
        if (split[1].equals("")) {
            return gtdList.get(matchIdx);
        }
        return getParent_GtdThought(gtdList.get(matchIdx), split[1]);
    }

    private static GtdThought getParent_GtdThought(GtdThought gtdThought, String parents) {
        String[] split = parents.split("\\|", 2);
        int parentId = Integer.parseInt(split[0]);
        int matchIdx = -1;
        for (int i = 0; i < gtdThought.getSub().size(); i++) {
            if (gtdThought.getSub().get(i).getId() == parentId) {
                matchIdx = i;
            }
        }
        assert matchIdx > -1;
        if (split[1].equals("")) {
            return gtdThought.getSub().get(matchIdx);
        }
        return getParent_GtdThought(gtdThought.getSub().get(matchIdx), split[1]);
    }

    /**
     * Decodes {@code encodedGtdThought} into a {@code GtdThought}.
     *
     * @throws IllegalValueException if any field in the {@code encodedGtdThought} is invalid.
     */
    private static HashMap<String, Object> decodeGtdThoughtFromString(String encodedGtdThought)
            throws IllegalValueException {
        HashMap<String, Object> elements = new HashMap<>();
        Matcher matcher = GTD_THOUGHT_TXT_FILE_FORMAT.matcher(encodedGtdThought.trim());
        if (matcher.matches()) {
            int id = Integer.parseInt(matcher.group("id"));
            Stat status = Stat.valueOf(matcher.group("status"));
            String title = matcher.group("title");
            String parents = matcher.group("parents");

            elements.put("id", id);
            elements.put("status", status);
            elements.put("title", title);
            elements.put("parents", parents);
            return elements;

        } else {
            throw new IllegalValueException("No match, please check your txt file format");
        }

    }
}
