package seedu.duke.parser;

import seedu.duke.commands.Command;
import seedu.duke.commands.AddCommand;
import seedu.duke.commands.ProjModeCommand;
import seedu.duke.commands.ListCommand;
import seedu.duke.commands.SetCommand;
import seedu.duke.commands.DeleteCommand;
import seedu.duke.commands.DoneCommand;
import seedu.duke.commands.ExitCommand;
import seedu.duke.commands.IncorrectCommand;
import seedu.duke.commands.DueCommand;

import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.DateTimeException;

public class Parser {

    public static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("\\s*(?<commandWord>\\S+)(?<arguments>[^|]*)");
    // need comment out this line below
    public static final Pattern INDEX_ARGS_FORMAT = Pattern.compile("(?<targetIndex>\\d+(?:\\s+\\d+)*)");
    public static final Pattern INDEX_FORMAT = Pattern.compile("(\\d+(?:[-]\\d+)*)");
    public static final Pattern CHK_INDEX_FORMAT_STEP_1 = Pattern.compile("^[\\s\\d-]*$");
    public static final Pattern CHK_INDEX_FORMAT_STEP_2 = Pattern.compile("-\\s+|\\s+-");

    public static final Pattern SET_CMD_FORMAT = Pattern.compile("(?<targetIndex>.*)\\s(?<folderType>.*)");
    public static final Pattern SET_CMD_FORMAT_OPTIONAL =
            Pattern.compile(
            "(?<folderType>inbox|next|wait|proj|someday|some|done)\\s+(?<targetIndex>\\d+.*)",
                    Pattern.CASE_INSENSITIVE
            );

    public static final Pattern DUE_CMD_FORMAT = Pattern.compile("(?<targetIndex>.*)\\s(?<dueYear>\\d{4})-(?<dueMonth>\\d{2})-(?<dueDay>\\d{2})");

    public static final String[] LIST_FOLDER_TYPE = {"inbox", "next", "wait", "proj", "someday","some",
                                                     "current", "master", "all", "done", "due"};

    /**
     * Parses user input into command for execution.
     *
     * @param inputCommand full user input string
     * @return the command based on the user input
     */
    public Command parse(String inputCommand) {
        Matcher matcher = BASIC_COMMAND_FORMAT.matcher(inputCommand.trim());
        if (!matcher.matches()) {
            return new IncorrectCommand("This is a incorrect format, "
                    + " you may type the list to see all the commands."
                    + " the command should not contain the separator '|'");
        }

        String commandWord = matcher.group("commandWord");
        String arguments = matcher.group("arguments");

        switch (commandWord) {
        case AddCommand.COMMAND_WORD:
            return prepareAdd(arguments);
        case ListCommand.COMMAND_WORD:
            return prepareList(arguments);

        case DoneCommand.COMMAND_WORD:
            return prepareDone(arguments);
        case DueCommand.COMMAND_WORD:
            return prepareDue(arguments);
        case DeleteCommand.COMMAND_WORD:
            return prepareDelete(arguments);

        case SetCommand.COMMAND_WORD:
            return prepareSet(arguments);

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case ProjModeCommand.COMMAND_WORD:
            return new ProjModeCommand();

        // case HelpCommand.COMMAND_WORD:
        // default:
        //     return new HelpCommand();

        default:
            return new IncorrectCommand("IncorrectCommand");
        }

    }

    private Command prepareAdd(String args) {
        String argsTrim = args.trim();
        assert argsTrim.length() > 0 : "Can not add empty task";
        return argsTrim.length() > 0
                ? new AddCommand(argsTrim) :
                  new IncorrectCommand("Can not add empty task");
    }

    private Command prepareList(String args) {
        return Arrays.stream(LIST_FOLDER_TYPE).anyMatch(args.trim().toLowerCase()::equals)
                ? new ListCommand(args.trim()) :
                  new IncorrectCommand("This is a list command but you enter a incorrect folder,"
                          + " the second word should be one of " + String.join(",", LIST_FOLDER_TYPE));
    }

    private Command prepareDone(String args) {
        try {
            List<String> targetIndex = parseArgsAsIndexParam(args);
            return new DoneCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(pe.getMessage());
        }

    }

    private Command prepareDue(String args) {
        try {
            Matcher matcher = DUE_CMD_FORMAT.matcher(args.trim());
            if (matcher.matches()) {
                List<String> targetIndex = parseArgsAsIndexParam(matcher.group("targetIndex"));
                int dueYear = Integer.parseInt(matcher.group("dueYear"));
                int dueMonth = Integer.parseInt(matcher.group("dueMonth"));
                int dueDay = Integer.parseInt(matcher.group("dueDay"));
                LocalDate due = (dueYear == 0 && dueMonth == 0 && dueDay == 0) ? null : LocalDate.of(dueYear, dueMonth, dueDay);
                return new DueCommand(targetIndex, due);
            } else {
                return new IncorrectCommand("This is a incorrect due command format, "
                        + " you may type 'help' to see all the commands.");
            }
        } catch (ParseException pe) {
            return new IncorrectCommand(pe.getMessage());
        } catch (DateTimeException dte) {
            return new IncorrectCommand("Incorrect due date format");
        }

    }

    private Command prepareDelete(String args) {
        try {
            List<String> targetIndex = parseArgsAsIndexParam(args);
            //int[] targetIndex = parseArgsAsIndex(args);
            return new DeleteCommand(targetIndex);
        } catch (ParseException pe) {
            return new IncorrectCommand(pe.getMessage());
        }
    }

    private Command prepareSet(String args) {

        try {
            List<String> targetIndex;
            //int[] targetIndex;
            String folderType;
            Matcher matcher = SET_CMD_FORMAT.matcher(args.trim());
            Matcher matcher1 = SET_CMD_FORMAT_OPTIONAL.matcher(args.trim());
            if (matcher.matches()) {
                targetIndex = parseArgsAsIndexParam(matcher.group("targetIndex"));
                //targetIndex = parseArgsAsIndex(matcher.group("targetIndex"));
                folderType = matcher.group("folderType").trim().toLowerCase();
            } else if (matcher1.matches()) {
                targetIndex = parseArgsAsIndexParam(matcher1.group("targetIndex"));
                // targetIndex = parseArgsAsIndex(matcher1.group("targetIndex"));
                folderType = matcher1.group("folderType").trim().toLowerCase();
            } else {
                return new IncorrectCommand("This is a incorrect set command format, "
                        + " you may type 'help' to see all the commands.");
            }
            return Arrays.stream(LIST_FOLDER_TYPE).anyMatch(folderType::equals)
                    ? new SetCommand(targetIndex, folderType) :
                      new IncorrectCommand("This is a set command but you enter a incorrect folder,"
                            + " the folder name behind -f= should be one of " + String.join(",", LIST_FOLDER_TYPE));

        } catch (ParseException pe) {
            return new IncorrectCommand(pe.getMessage());
        }

    }

    //the part no need
    /**
     * Parses the given arguments string as index numbers.
     *
     * @param args arguments string to parse as index numbers
     * @return the parsed index array
     */
    private int[] parseArgsAsIndex(String args) throws ParseException {

        Matcher matcher = INDEX_ARGS_FORMAT.matcher(args.trim());
        if (!matcher.matches()) {
            throw new ParseException("Could not match to the correct index.");
        }
        return Stream.of(matcher.group("targetIndex").split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }


    /**
     * Parses the given arguments string as index params.
     *
     * @param args arguments string to parse as index params
     * @return the parsed object list that contain both index and index string
     */
    private List<String> parseArgsAsIndexParam(String args) throws ParseException {
        Matcher stp1 = CHK_INDEX_FORMAT_STEP_1.matcher(args.trim());
        if (!stp1.matches()) {
            throw new ParseException("Couldn't match the index, the index part should only contain integer and '-',"
                    + " e.g. 1 or 1-1-1");
        }
        Matcher stp2 = CHK_INDEX_FORMAT_STEP_2.matcher(args.trim());
        if (stp2.find()) {
            throw new ParseException("Couldn't match the index, please check your '-' position, "
                    + "can not have any space at its side, e.g can not type 2- or -1");
        }
        Matcher matcher = INDEX_FORMAT.matcher(args.trim());
        List<String> matches = matcher.results().map(MatchResult::group).collect(Collectors.toList());
        return matches;
        //return Stream.of(matcher.group("targetIndex").split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }



    /**
     * Signals that the user input could not be parsed.
     */
    public static class ParseException extends Exception {
        ParseException(String message) {
            super(message);
        }
    }
}
