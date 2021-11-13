package seedu.duke;

public class InputErrorException extends Exception {
    private String errorType;

    public InputErrorException(String errorType) {
        this.errorType = errorType;
    }

    /**
     * The function to return error type.
     * @return error type
     */
    public String getErrorType() {
        return errorType;
    }

    /**
     * The function to print input data format error message to user.
     */
    static void toPrintDateFormatError() {
        System.out.println("OOPS!!! The input date format wrong. Please try again.\n");
    }

    /**
     * The function to print input list format error message to user.
     */
    static void toPrintListFormatError() {
        System.out.println("OOPS!!! The list input format wrong. Please try again.\n");
    }

    /**
     * The function to print input sort format error to user.
     */
    static void toPrintSortFormatError() {
        System.out.println("OOPS!!! The sort input format wrong. Please try again.\n");
        System.out.println("[Help] Command: \n sort /asc /amount \n"
                            + " sort /desc /amount \n");
    }

    /**
     * The function to print empty file error message to user.
     */
    static void toPrintEmptyFileError() {
        System.out.println("OOPS!!! The list is empty. Please read the file or add expenses.\n");
    }

    /**
     * The function to print invalid command error message to user.
     */
    static void toPrintInvalidCommand() {

        System.out.println("OOPS!!! Invalid command input. Please try again.\n");
    }

    /**
     * The function to print index not integer error message to user.
     */
    static void toPrintIndexNotInt() {
        System.out.println("OOPS!!! The index you typed is not an integer. Please try again.\n");
    }

    /**
     * The function to print index out of range error message to user.
     */
    static void toPrintIndexOutOfRange() {

        System.out.println("OOPS!!! The index out of range. Please try again.\n");
    }

    /**
     * The function to print amount not a number error message to user.
     */
    static void toPrintAmountNotNumber() {
        System.out.println("OOPS!!! The amount is not a number. Please try again.\n");
    }

    /**
     * The function to print input information not enough error message to user.
     */
    static void toPrintInputInfoShortage() {
        System.out.println("OOPS!!! The input information not enough. Please try again.\n");
    }
}
