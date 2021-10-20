package seedu.duke.storage;

import seedu.duke.exception.IllegalValueException;
import seedu.duke.project.GtdThought;
import seedu.duke.project.Stat;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Decodes the storage data file into an {@code gtdList} object.
 */
public class GtdListDecoder {

    public static final Pattern GTD_THOUGHT_TXT_FILE_FORMAT = Pattern.compile(
            "(?<id>\\d+)[|](?<status>.*)[|](?<title>.*)[|][|][|](?<levelNo>\\d+)[|](?<parentID>\\d+)"
    );

    /**
     * Decodes {@code encodedGtdList} into an {@code GtdList} containing the decoded GtdThought.
     *
     * @throws IllegalValueException if any of the fields in any encoded GtdThought string is invalid.
     */
    public static GtdList decodeTaskList(List<String> encodedGtdList) throws IllegalValueException {

        List<GtdThought> decodedGtdThoughts = new ArrayList<>();
        for (String encodedGtdThought : encodedGtdList) {
            decodedGtdThoughts.add(decodeGtdThoughtFromString(encodedGtdThought));
        }
        return new GtdList(decodedGtdThoughts);
    }

    /**
     * Decodes {@code encodedGtdThought} into a {@code GtdThought}.
     *
     * @throws IllegalValueException if any field in the {@code encodedGtdThought} is invalid.
     */
    private static GtdThought decodeGtdThoughtFromString(String encodedGtdThought) throws IllegalValueException {
        Matcher matcher = GTD_THOUGHT_TXT_FILE_FORMAT.matcher(encodedGtdThought.trim());
        if (matcher.matches()) {
            int id = Integer.parseInt(matcher.group("id"));
            Stat status = Stat.valueOf(matcher.group("status"));
            String title = matcher.group("title");
            int levelNo = Integer.parseInt(matcher.group("levelNo"));
            int parentID = Integer.parseInt(matcher.group("parentID"));

            return new GtdThought(id, status, title, levelNo, parentID);

        } else {
            throw new IllegalValueException("No match, please check your txt file format");
        }

    }
}
