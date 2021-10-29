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
    public static final String INVALID_CATEGORY_COMMAND = "OOPS!!! Please specify a valid category command.";
    public static final String INVALID_CATEGORY_NUMBER = "OOPS!!! Please specify a valid category number.";
    public static final String EMPTY_CATEGORY_NAME = "OOPS!!! Please specify a category name.";
    public static final String EMPTY_CATEGORY_NUMBER = "OOPS!!! Please specify a category number.";
    public static final String CATEGORY_STILL_IN_USE = "OOPS!!! The category is still being tagged to some task.";
    public static final String CATEGORY_DOES_NOT_EXIST = "OOPS!!! The category you specified does not exist.";
    public static final String INVALID_CATEGORY_TAG = "OOPS!!! Please specify a task number and a category name. e.g. category tag 1 homework";
    public static final String EMPTY_TIME_DESCRIPTION = "OOPS!!! The appointment time cannot be empty.";
    public static final String INVALID_APPOINTMENT_TIME = "OOPS!!! The appointment time format is invalid, please "
        + "refer to these formats:\n"
        + "'22-09-2018 1:23:43 pm'\n"
        + "'TODAY 1:23:43 pm'\n"
        + "'YESTERDAY 1:23:43 pm'\n"
        + "'TOMORROW 1:23:43 pm'\n"
        + "'THIS-MON 1:23:43 pm'\n"
        + "'THIS-TUE 1:23:43 pm'\n"
        + "'THIS-WED 1:23:43 pm'\n"
        + "'THIS-THU 1:23:43 pm'\n"
        + "'THIS-FRI 1:23:43 pm'\n"
        + "'THIS-SAT 1:23:43 pm'\n"
        + "'THIS-SUN 1:23:43 pm'\n"
        + "'NEXT-MON 1:23:43 pm'\n"
        + "'NEXT-TUE 1:23:43 pm'\n"
        + "'NEXT-WED 1:23:43 pm'\n"
        + "'NEXT-THU 1:23:43 pm'\n"
        + "'NEXT-FRI 1:23:43 pm'\n"
        + "'NEXT-SAT 1:23:43 pm'\n"
        + "'NEXT-SUN 1:23:43 pm'\n";
    public static final String INVALID_APPOINTMENT_TASK = "OOPS!!! Set location fail, the task is not of Appointment "
        + "type.";
    public static final String EMPTY_APPOINTMENT_DESCRIPTION = "OOPS!!! The appointment description cannot be empty.";
    public static final String EMPTY_APPOINTMENT_TIME = "OOPS!!! The appointment time is missing, missing '/at'";
    public static final String EMPTY_APPOINTMENT_LOCATION = "OOPS!!! The appointment location is missing, missing "
        + "'/l'";
}
