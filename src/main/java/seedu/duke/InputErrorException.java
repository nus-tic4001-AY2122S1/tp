package seedu.duke;

public class InputErrorException extends Exception {
    String errorType;

    /**
     * To initialize InputErrorException
     * @param errorType the error type
     */
    InputErrorException(String errorType){
        this.errorType = errorType;
    }

    static void toPrintDateFormatError() {
        System.out.println("OOPS!!! The input date format wrong. Please try again.");
    }

    static void toPrintListFormatError() {
        System.out.println("OOPS!!! The list input format wrong. Please try again. ");
    }

    static void toPrintInValidListTypeCode() {
        System.out.println("OOPS!!! The list type code invalid. Please try again. ");
    }
}
