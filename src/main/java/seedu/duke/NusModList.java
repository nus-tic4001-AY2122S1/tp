package seedu.duke;

import java.util.stream.IntStream;

public class NusModList {

    private static Module[] ModListForYear;

    public NusModList(Module[] modules) {
        ModListForYear = modules;
    }

    public int getSize() {
        return ModListForYear.length;
    }

    public Module[] getAllModule() {
        return ModListForYear;
    }

    public Module getMod(String moduleCode) {
        Module module = new Module();
        for (int i = 0; i < getSize(); i++) {
            if (ModListForYear[i].getModuleCode() == moduleCode) {
                module = ModListForYear[i];
                return module;
            }
        }
        return module;
    }

    public Module getMod(int moduleIndex) {
        return ModListForYear[moduleIndex];
    }

    public boolean hasMod(String moduleCode) {
        for (Module m : ModListForYear) {
            if (m.getModuleCode().equals(moduleCode)) {
                return true;
            }
        }
        return false;
    }

    public int moduleIndex(String moduleCode) {
        for (int i = 0; i < this.getSize(); i++) {
            if (ModListForYear[i].getModuleCode().equals(moduleCode)) {
                return i;
            }
        }
        return -1;
    }


}
