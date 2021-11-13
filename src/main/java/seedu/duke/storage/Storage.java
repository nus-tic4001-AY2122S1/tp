package seedu.duke.storage;

import com.google.gson.Gson;
import seedu.duke.module.Module;
import seedu.duke.module.UserList;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Storage {
    String filePath;

    public Storage() throws IOException {
        this.filePath = new File("src/main/java/seedu/duke/user_modules.json").getAbsolutePath();
    }

    public void saveUserList(UserList userList) throws IOException {
        Gson gson = new Gson();

        String result = gson.toJson(userList.getUserList());
        FileWriter fw = new FileWriter(filePath);
        gson.toJson(userList.getUserList(), fw);
        fw.close();
    }

    public void getUserListFromFile() throws IOException {
        Gson gson = new Gson();
        Module[] modules = gson.fromJson(new FileReader(this.filePath), Module[].class);
        UserList userList = UserList.sharedInstance();
        userList.deleteAllModules();
        userList.addModule(modules);
    }

    public void loadUserlist() throws IOException {
        getUserListFromFile();
    }
}
