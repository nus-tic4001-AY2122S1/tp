package seedu.duke;

import java.io.IOException;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the module planner!");
        Api api = new Api();
        Module[] allModules = api.getAllModules();
    }
}
