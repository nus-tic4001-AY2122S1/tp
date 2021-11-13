package helpers;

import constant.ErrorMessage;
import exception.ErrorHandler;

/**
 * Utility class for manipulating strings.
 */

public class StringUtils {

    /**
     * Converts a String array to a singular String.
     * Assumes that the method will be used to construct a sentence
     *
     * @param input an array of String
     * @return Date with zeroed Time.
     */
    public static String convertArrayToString(String[] input) throws ErrorHandler {
        return concatenate(input, 0);
    };

    /**
     * Converts a String array to a singular String.
     * Assumes that the method will be used to construct a sentence
     *
     * @param input an array of String
     * @param isIgnoreCommand determines if method should concatenate array from element 0 or 1 where;
     *                        true -> starts from element 1.
     *                        false -> starts from element 0.
     * @return a concatenated string of the elements in the array.
     */
    public static String convertArrayToString(String[] input, boolean isIgnoreCommand) throws ErrorHandler {
        if (isIgnoreCommand) {
            return concatenate(input, 1);
        };
        return concatenate(input, 0);
    };

    /**
     * Concatenates the elements in a string array and adds a space between each element.
     * Assumes that the method will be used to construct a sentence
     *
     * @param input an array of String
     * @param start index of the first element to be concatenated
     * @return a concatenated string of the elements in the array
     */
    private static String concatenate(String[] input, int start) throws ErrorHandler {
        String output = "";
        if (start > input.length) {
            throw new ErrorHandler(ErrorMessage.INVALID_INDEX);
        }
        for (int i = start; i < input.length; i++) {
            output += input[i] + " ";
        }
        return output.trim();
    };
}
