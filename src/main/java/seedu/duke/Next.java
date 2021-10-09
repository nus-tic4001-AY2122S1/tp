package seedu.duke;

import seedu.duke.project.Project;
import seedu.duke.project.Stat;

import java.util.Scanner;

public class Next {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo =
                          " _   _           _   \n"
                        + "| \\ | | _____  _| |_ \n"
                        + "|  \\| |/ _ \\ \\/ / __|\n"
                        + "| |\\  |  __/>  <| |_ \n"
                        + "|_| \\_|\\___/_/\\_\\\\__|\n";

        System.out.println("PROJECT\n" + logo);
































        String title = "This is my very first task";
        Project p1 = new Project(title);

        p1.print();

        Project sub1 = new Project("sub task a");
        Project sub2 = new Project("sub task b");
        Project subsub1 = new Project("sub task a.1");

        p1.addSub(sub1);
        p1.addSub(sub2);
        sub1.addSub(subsub1);

        subsub1.setStatus(Stat.NEXT);

        p1.printRec();


    }
}
