package seedu.duke.command;

import seedu.duke.ItemList;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveCommand extends Command {

    public SaveCommand(String fullCommand) {
        super(fullCommand);
    }

    @Override
    public void run(ItemList itemList) {
        try {
            FileWriter fw = new FileWriter("./file/expenses.txt");

            if (itemList.size != 0) {
                fw.write("Here are the items in your list:" + "\n");
            }

            for (int i = 0; i < itemList.items.size(); i++) {
                fw.write(i + 1 + "." + itemList.items.get(i).toString() + "\n");
            }
            System.out.println("Expenses file save successfully to file/expenses.txt");
            fw.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something went wrong" + e.getMessage());
        }
    }
}
