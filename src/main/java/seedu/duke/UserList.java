package seedu.duke;

import seedu.duke.exceptions.ListEmptyException;
import seedu.duke.exceptions.IndexOutOfRangeException;

import java.util.ArrayList;

public class UserList {

    private ArrayList<Module> userList;

    public boolean add(Module m) {
        return userList.add(m);
    }

    public void list() {
        try {
            checkListEmpty(userList);
            printOutput(userList);
        } catch (ListEmptyException e) {
            Ui.printListEmpty();
        }
    }

    public void deleteTask(String line) {
        try {
            checkListEmpty(userList);
            String theStrIndex = line.substring(7);
            String[] theStrIndexArr = theStrIndex.split(",");
            int[] intArr = new int[theStrIndexArr.length];
            for (int i = 0; i < theStrIndexArr.length; i++) {
                String num = theStrIndexArr[i];
                intArr[i] = Integer.parseInt(num);
                checkIndexOutOfRange(userList.size(), intArr[i]);
            }

            Ui.printRemoveTask();
            for (int i = 0; i < intArr.length; i++) {
                Module m = userList.get(intArr[i]-(i + 1));
                System.out.print(m.toString());
                userList.remove(intArr[i]-(i + 1));
            }

            Ui.printNumberOfTasks(userList);

        } catch (NumberFormatException e) {
            Ui.printNumberFormatException();
        } catch (IndexOutOfRangeException e) {
            Ui.printIndexOutOfRangeException();
        } catch  (ListEmptyException e) {
            Ui.printListEmpty();
        }
    }

    public void printOutput(ArrayList<Module> userList) {
        System.out.print("Here are the modules in your list: ");
        for (int i = 0; i < userList.size(); i++) {
            System.out.print((i + 1) + ". " + userList.get(i).toString());
        }
    }

    static void checkListEmpty(ArrayList<Module> userList) throws ListEmptyException {
        if (userList.isEmpty()) {
            throw new ListEmptyException();
        }
    }

    static void checkIndexOutOfRange(int size,  int number) throws IndexOutOfRangeException {
        if (number > size || number < 0) {
            throw new IndexOutOfRangeException();
        }
    }
}
