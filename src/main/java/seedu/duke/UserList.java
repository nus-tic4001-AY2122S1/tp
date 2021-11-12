package seedu.duke;

import seedu.duke.exceptions.ListEmptyException;
import seedu.duke.exceptions.IndexOutOfRangeException;

import java.util.ArrayList;

public class UserList {

    private ArrayList<Module> userList;
    public static UserList _Final;

    private UserList() {
        this.userList = new ArrayList<Module>();
    }

    public static UserList sharedInstance() {
        if (_Final == null) {
            _Final = new UserList();
        }
        return  _Final;
    }

    public ArrayList<Module> getUserList() {
        return userList;
    }

    public void addModule(String moduleCode) {
        NusModList allModules = NusModList.sharedInstance();
        int index = allModules.getModuleIndex(moduleCode);
        Module m = allModules.getMod(index);
        userList.add(m);
        Ui.printModule(userList);
    }

    public void addModule(Module module) {
        userList.add(module);
    }

    public void addModule(Module[] moduleArray) {
        for (Module mod : moduleArray) {
            userList.add(mod);
        }
    }

    public void list() {
        try {
            checkListEmpty(userList);
            printOutput(userList);
        } catch (ListEmptyException e) {
            Ui.printListEmpty();
        }
    }

    public void deleteModule(String index) {
        try {
            checkListEmpty(userList);
            String[] theStrIndexArr = index.split(",");
            int[] intArr = new int[theStrIndexArr.length];
            for (int i = 0; i < theStrIndexArr.length; i++) {
                String num = theStrIndexArr[i];
                intArr[i] = Integer.parseInt(num);
                checkIndexOutOfRange(userList.size(), intArr[i]);
            }

            Ui.printRemoveModule();

            for (int i = 0; i < intArr.length; i++) {
                Module m = userList.get(intArr[i] - (i + 1));
                System.out.println(m.getModuleCode() + " - " + m.getModuleTitle());

                userList.remove(intArr[i] - (i + 1));
            }

            Ui.printNumberOfModules(userList);

        } catch (NumberFormatException e) {
            Ui.printNumberFormatException();
        } catch (IndexOutOfRangeException e) {
            Ui.printIndexOutOfRangeException();
        } catch (ListEmptyException e) {
            Ui.printListEmpty();
        }
    }

    public void deleteAllModules() {
        userList.clear();
    }

    public void printOutput(ArrayList<Module> userList) {
        System.out.println("Here are the modules in your list: ");
        for (int i = 0; i < userList.size(); i++) {
            System.out.println(userList.get(i).getModuleCode() + " - " + userList.get(i).getModuleTitle());
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
