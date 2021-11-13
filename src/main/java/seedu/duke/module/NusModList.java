package seedu.duke.module;

public class NusModList {

    private static Module[] moduleListForYear;
    public static NusModList _Final;

    private NusModList(Module[] modules) {
        moduleListForYear = modules;
    }

    public Module[] getModListForYear() {
        return moduleListForYear;
    }

    public static NusModList createInstance(Module[] modules) {
        if (_Final == null) {
            _Final = new NusModList(modules);
        }
        return  _Final; // Converting NusModList to Singleton Class to only have 1 Instance for easier retrieval
    }

    public static NusModList sharedInstance() {
        return  _Final;
    }

    public int getSize() {
        return moduleListForYear.length;
    }

    public Module[] getAllModule() {
        return moduleListForYear;
    }

    public Module getMod(String moduleCode) {
        Module module = new Module();
        for (int i = 0; i < getSize(); i++) {
            if (moduleListForYear[i].getModuleCode() == moduleCode) {
                module = moduleListForYear[i];
                return module;
            }
        }
        return module;
    }

    public Module getMod(int moduleIndex) {
        return moduleListForYear[moduleIndex];
    }

    public boolean hasMod(String moduleCode) {
        for (Module m : moduleListForYear) {
            if (m.getModuleCode().equals(moduleCode)) {
                return true;
            }
        }
        return false;
    }

    public int getModuleIndex(String moduleCode) {
        for (int i = 0; i < this.getSize(); i++) {
            if (moduleListForYear[i].getModuleCode().equals(moduleCode)) {
                return i;
            }
        }
        return -1;
    }

    public static void getFormattedApiModule(NusModList modData, int index) {
        System.out.println(modData.getMod(index).getModuleCode() + " | "
                + modData.getMod(index).getModuleTitle() + " | "
                + modData.getMod(index).getModuleSemester());
    }

}
