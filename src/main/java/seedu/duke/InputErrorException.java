package seedu.duke;

public class InputErrorException extends Exception {
    String errorType;

    public InputErrorException(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorType() {
        return errorType;
    }

    public static void toPrintDateFormatError() {
        System.out.println("OOPS!!! The input date format wrong. Please try again.\n");
    }

    static void toPrintListFormatError() {
        System.out.println("OOPS!!! The list input format wrong. Please try again.\n");
    }

    static void toPrintInvalidCommand() {

        System.out.println("OOPS!!! Invalid command input. Please try again.\n");
    }

    public static void toPrintIndexNotInt() {
        System.out.println("OOPS!!! The index you typed is not an integer. Please try again.\n");
    }

    public static void toPrintIndexOutOfRange() {

        System.out.println("OOPS!!! The index out of range. Please try again.\n");
    }

    public static void toPrintAmountNotNumber() {
        System.out.println("OOPS!!! The amount is not a number. Please try again.\n");
    }
}
