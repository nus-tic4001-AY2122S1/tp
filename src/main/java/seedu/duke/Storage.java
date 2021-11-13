package seedu.duke;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Storage {

    public void loadFromStorage(ItemList saveItemList) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("./file/expenses.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                String[] item = s.split("\\|", 0);

                String type = item[0].trim();
                String description = item[2].trim();
                String category = item[1].trim();
                double amount = Double.parseDouble(item[3].trim());
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                Date date = formatter.parse(item[4].trim());

                switch (type) {
                case "I":
                    saveItemList.addIncome(description, category, amount, date);
                    break;
                case "E":
                    saveItemList.addExpense(description, category, amount, date);
                    break;
                default:
                    System.out.println("Load item failed");
                }
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveToStorage(ItemList itemList) {
        try {
            FileWriter fw = new FileWriter("./file/expenses.txt");

            for (int i = 0; i < itemList.items.size(); i++) {
                fw.write(itemList.items.get(i).save_toString() + "\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

}
