package seedu.justbook;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import static java.time.LocalDateTime.parse;

public class LoadCommand extends Command {
    String filepath;

    public LoadCommand(String filepath) {
        this.filepath = filepath;
    }

    public void execute(List<Bookings> appointments) throws IOException {
        File directory = new File("data");
        if (!directory.exists()) {
            directory.mkdir();
        }
        File f = new File(filepath);
        if (!f.exists()) {
            f.createNewFile();
        }
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()) {
            //read all lines
            String input = sc.nextLine();
            String[] readData = input.split(" \\| ");
            LocalDateTime start = parse(readData[1]);
            LocalDateTime end = parse(readData[2]);
            appointments.add(new Bookings(readData[0], start, end));
        }
    }

    public static String getHelp() {
        return "The application loads the appointments from the JustBook text file.";
    }
}
