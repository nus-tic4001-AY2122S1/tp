package seedu.justbook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class SaveCommand extends Command {
    String filepath;

    public SaveCommand(String filepath) {
        this.filepath = filepath;
    }

    public void execute(List<Bookings> appointments) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/justbook.txt"));
            //writes all tasks into file
            for (Bookings item : appointments) {
                String description = item.getBookDesc();
                LocalDateTime startDate = item.getStartDateTime();
                LocalDateTime endDate = item.getEndDateTime();
                writer.write(description + " | " + startDate + " | " + endDate);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            //prints exception message.
            System.out.println(e.getMessage());
        }
    }

    public static String getHelp() {
        return "The appointments will be saved when the application closes";
    }
}
