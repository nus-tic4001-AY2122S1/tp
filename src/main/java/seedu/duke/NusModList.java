package seedu.duke;

public class NusModList {

    private static Module[] ModListForYear;

    public NusModList(Module[] modules) {
        ModListForYear = modules;
    }

    public int getSize() {
        return ModListForYear.length;
    }

    public Module getMod(String moduleCode) {

        Module module = new Module();
        for(int i = 0; i < getSize(); i++ ) {
            if(ModListForYear[i].getModuleCode() == moduleCode){
                module = ModListForYear[i];
                return module;
            }
        }
        return module;

    }

    public boolean hasMod(String moduleCode) {
        for(int i = 0; i < getSize(); i++ ) {
            if(ModListForYear[i].getModuleCode() == moduleCode){
                return true;
            }
        }
        return false;
    }

    public int moduleIndex(String moduleCode) {
        for(int i = 0; i < getSize(); i++ ) {
            if(ModListForYear[i].getModuleCode() == moduleCode){

                return i;
            }
        }
        return -1;
    }

    public Module getMod(int moduleIndex) {
        return ModListForYear[moduleIndex];
    }

}
