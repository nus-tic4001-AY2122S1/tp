package constant;

/**
 * Constants for error messages.
 */
public class ErrorMessage {
    public static final String INVALID_COMMAND = "OOPS!!! I'm sorry, but I don't know what that means.";
    public static final String INVALID_TASK_NUMBER = "OOPS!!! I'm sorry, you have provided a invalid task number.";
    public static final String EMPTY_TASK_NUMBER = "OOPS!!! The task number cannot be empty.";
    public static final String EMPTY_TODO = "OOPS!!! The description of a todo cannot be empty.";
    public static final String EMPTY_LOCATION_DESCRIPTION = "OOPS!!! The appointment location cannot be empty.";
    public static final String INVALID_APPOINTMENT_TASK = "OOPS!!! Set location fail, the task is not of Appointment " +
            "type.";
    public static final String EMPTY_APPOINTMENT_DESCRIPTION = "OOPS!!! The appointment description cannot be empty.";
    public static final String EMPTY_APPOINTMENT_TIME = "OOPS!!! The appointment time is missing, missing '/at'";
    public static final String EMPTY_APPOINTMENT_LOCATION = "OOPS!!! The appointment location is missing, missing " +
            "'/l'";
}