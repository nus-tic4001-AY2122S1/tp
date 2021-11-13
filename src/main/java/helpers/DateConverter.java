package helpers;

import constant.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Calendar;

import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

public class DateConverter {
    public static String convert(String day) {
        switch (day.toUpperCase()) {
        case "TODAY":
            LocalDate today = getToday();
            return today.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "YESTERDAY":
            LocalDate yesterday = getToday().minusDays(1);
            return yesterday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "TOMORROW":
            LocalDate tomorrow = getToday().plusDays(1);
            return tomorrow.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-MON":
            LocalDate monday = getCurrentWeekDay(getToday(), DayOfWeek.MONDAY);
            return monday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-TUE":
            LocalDate tuesday = getCurrentWeekDay(getToday(), DayOfWeek.TUESDAY);
            return tuesday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-WED":
            LocalDate wednesday = getCurrentWeekDay(getToday(), DayOfWeek.WEDNESDAY);
            return wednesday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-THU":
            LocalDate thursday = getCurrentWeekDay(getToday(), DayOfWeek.THURSDAY);
            return thursday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-FRI":
            LocalDate friday = getCurrentWeekDay(getToday(), DayOfWeek.FRIDAY);
            return friday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-SAT":
            LocalDate saturday = getCurrentWeekDay(getToday(), DayOfWeek.SATURDAY);
            return saturday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "THIS-SUN":
            LocalDate sunday = getCurrentWeekDay(getToday(), DayOfWeek.SUNDAY);
            return sunday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-MON":
            LocalDate nexMonday = getNextWeekDay(getToday(), DayOfWeek.MONDAY);
            return nexMonday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-TUE":
            LocalDate nextTuesday = getNextWeekDay(getToday(), DayOfWeek.TUESDAY);
            return nextTuesday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-WED":
            LocalDate nextWednesday = getNextWeekDay(getToday(), DayOfWeek.WEDNESDAY);
            return nextWednesday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-THU":
            LocalDate nextThursday = getNextWeekDay(getToday(), DayOfWeek.THURSDAY);
            return nextThursday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-FRI":
            LocalDate nextFriday = getNextWeekDay(getToday(), DayOfWeek.FRIDAY);
            return nextFriday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-SAT":
            LocalDate nextSaturday = getNextWeekDay(getToday(), DayOfWeek.SATURDAY);
            return nextSaturday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        case "NEXT-SUN":
            LocalDate nextSunday = getNextWeekDay(getToday(), DayOfWeek.SUNDAY);
            return nextSunday.format(DateTimeFormatter.ofPattern(Utils.DATE_FORMAT));
        default:
            return day;
        }
    }

    private static LocalDate getToday() {
        return LocalDate.now();
    }

    private static LocalDate getCurrentWeekDay(LocalDate today, DayOfWeek targetDate) {
        if (today.getDayOfWeek().compareTo(targetDate) == 0) {
            return today;
        } else if (today.getDayOfWeek().compareTo(targetDate) > 0) {
            return today.with(previousOrSame(targetDate));
        } else {
            return today.with(nextOrSame(targetDate));
        }
    }

    private static LocalDate getNextWeekDay(LocalDate today, DayOfWeek targetDate) {
        return getCurrentWeekDay(today, targetDate).plusDays(7);
    }

    /**
     * Checks if the string input is a valid date format.
     *
     * @param inDate Date that user has input as parameter.
     * @return true boolean if input can be parsed as a date.
     */
    public static boolean isValidDate(String inDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(inDate.trim());
            return true;
        } catch (ParseException pe) {
            return false;
        }
    }

    /**
     * Converts string to date.
     *
     * @param inDate Date that user has input as parameter.
     * @return Date in "dd-MM-yyyy" format.
     */
    public static Date convertStringToDate(String inDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        return dateFormat.parse(inDate.trim());

    }

    /**
     * Set time (hour, min, sec and millisec) to 0 .
     * Mainly for comparison of input date and Appointment dates.
     *
     * @param date Date of an existing Appointment.
     * @return Date with zeroed Time.
     */
    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
