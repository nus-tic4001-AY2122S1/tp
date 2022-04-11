package seedu.duke;

import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FlightList {

    public ArrayList<Flight> list;

    public FlightList() {
        this.list = new ArrayList<Flight>();
    }

    /**
     * Get the current list size.
     *
     * @return The current list size in integer
     */
    public int getSize() {
        return list.size();
    }

    /**
     * Get the current list.
     *
     * @return The current list.
     */
    public ArrayList<Flight> getList() {
        return this.list;
    }

    /**
     * Check whether the list is empty.
     *
     * @return True if list is empty, false if list is not empty.
     */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Air Rec adds a Flight.
     * version 1.0 will be saving the details as string.
     * version 2.0 will be able to process string into data.
     * All index are there to extract the exact data for each parameter.
     *
     * @param message Details of the Flight.
     */
    public void addFlight(String message) {
        int fromIndex = message.indexOf("/from");
        int toIndex = message.indexOf("/to");
        int dateIndex = message.indexOf("/date");
        int priceIndex = message.indexOf("/price");
        String from = message.substring(fromIndex + 6, toIndex);
        String to = message.substring(toIndex + 4, dateIndex);
        String date = message.substring(dateIndex + 6, priceIndex);
        String price = message.substring(priceIndex + 7);
        list.add(new Flight(from, to, date, price));
    }

    /**
     * Air Rec deletes a Flight.
     * version 1.0 will be deleting the flight by index.
     */
    public void deleteFlight(String message) {
        String number = message.substring(7).trim();
        int index = Integer.parseInt(number);
        index = index - 1;
        list.remove(index);
    }


    /**
     * Air Rec sorts the Flight list by price or dateTime, defined by user input.
     */
    public void sortFlight(String message) {
        String code = message.substring(5).trim().toLowerCase();
        if (!code.equals("price") && !code.equals("datetime")) {
            System.out.println("You only can sort by price or datetime, please re-enter your input.");
            return;
        }
        int n = list.size();
        for (int j = 1; j < n; j++) {
            if (code.equals("price")) {
                int key = list.get(j).price;
                Flight flightKey = list.get(j);
                int i = j - 1;
                while ((i > -1) && (list.get(i).price > key)) {
                    list.set(i + 1, list.get(i));
                    i--;
                }
                list.set(i + 1, flightKey);
            }
            if (code.equals("datetime")) {
                LocalDateTime key = list.get(j).dateAndTime;
                Flight flightKey = list.get(j);
                int i = j - 1;
                while ((i > -1) && (list.get(i).dateAndTime.isAfter(key))) {
                    list.set(i + 1, list.get(i));
                    i--;
                }
                list.set(i + 1, flightKey);

            }
        }
        if (code.equals("price")) {
            System.out.println("Your flight has been sorted by price in ascending order.");
        } else {
            System.out.println("Your flight has been sorted by date and time, earliest flight comes first.");
        }
    }


    /**
     * Air Rec search Flight.
     * version 2.0 will be search flight by keyword.
     */
    public ArrayList<Flight> searchFlight(String message) {
        list.indexOf(message.substring(6));
        int i = 0;
        ArrayList<Flight> tempList = new ArrayList<Flight>();
        for (Flight flight : this.list) {
            if (flight.getFullFlightDetails().contains(message.substring(6))) {
                i = i + 1;
                tempList.add(flight);
            }
        }
        return tempList;
    }

    /**
     * Air Rec edit Flight details.
    */
    public void editFlight(String message) {
        String from = "";
        String to = "";
        String date = "";
        String price = "";
        int fromIndex = message.indexOf("/from");
        int toIndex = message.indexOf("/to");
        int dateIndex = message.indexOf("/date");
        int priceIndex = message.indexOf("/price");
        if (message.indexOf('/') == -1) {
            System.out.println("☹ OOPS!!! I'm sorry, Please check the format for edit command :-(");
        } else {
            String number = message.substring(5,message.indexOf('/')).trim();
            int index = Integer.parseInt(number);
            index = index - 1;
            int counter = 0;
            for (Flight flight : this.list) {
                if (counter == index) {
                    from = flight.getFrom();
                    to = flight.getTo();
                    String[] splitDate = flight.getStringDateAndTime().split("\\s+");
                    price = Integer.toString(flight.getPrice());
                    switch (splitDate[1]) {
                    case "Jan":
                        splitDate[1] = "01";
                        break;
                    case "Feb":
                        splitDate[1] = "02";
                        break;
                    case "Mar":
                        splitDate[1] = "03";
                        break;
                    case "Apr":
                        splitDate[1] = "04";
                        break;
                    case "May":
                        splitDate[1] = "05";
                        break;
                    case "Jun":
                        splitDate[1] = "06";
                        break;
                    case "Jul":
                        splitDate[1] = "07";
                        break;
                    case "Aug":
                        splitDate[1] = "08";
                        break;
                    case "Sep":
                        splitDate[1] = "09";
                        break;
                    case "Oct":
                        splitDate[1] = "10";
                        break;
                    case "Nov":
                        splitDate[1] = "11";
                        break;
                    case "Dec":
                        splitDate[1] = "12";
                        break;
                    default:
                        break;
                    }
                    String time = splitDate[3].substring(0,splitDate[3].length() - 1);
                    date = splitDate[2] + "-" + splitDate[1] + "-" + splitDate[0] + " " + time;
                }
                counter++;
            }
            if (fromIndex != -1) {
                from = message.substring(fromIndex + 6) + " ";
            }
            if (toIndex != -1) {
                to = message.substring(toIndex + 4) + " ";
            }
            if (dateIndex != -1) {
                date = message.substring(dateIndex + 6) + " ";
            }
            if (priceIndex != -1) {
                price = message.substring(priceIndex + 7);
            }
            this.list.set(index, new Flight(from, to, date, price));
        }
    }
}
