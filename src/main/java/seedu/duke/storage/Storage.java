package seedu.duke.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import seedu.duke.exception.IllegalValueException;

public class Storage {

    /**
     * Default file path used if the user doesn't provide the file name.
     */
    public static final String DEFAULT_STORAGE_FILEPATH = "next.txt";

    public Path path;

    /**
     * @throws InvalidStorageFilePathException if the given file path is invalid
     */
    public Storage(String filePath) throws InvalidStorageFilePathException {
        path = Paths.get(filePath);
        if (!isValidPath(path)) {
            throw new InvalidStorageFilePathException("Storage file should end with '.txt'");
        }
    }

    /**
     * Returns true if the given path is acceptable as a storage file.
     * The file path is considered acceptable if it ends with '.txt'
     */
    private static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }

    /**
     * Saves the {@code gtdList} data to the storage file.
     *
     * @throws StorageOperationException if there were errors converting and/or storing data to file.
     */
    public void save(GtdList gtdList) throws StorageOperationException {
        try {
            List<String> encodedGtdList = GtdListEncoder.encodeGtdList(gtdList);
            Files.write(path, encodedGtdList);
        } catch (IOException ioe) {
            throw new StorageOperationException("Saving went wrong");
        }

    }

    /**
     * Loads the {@code GtdList} data from this storage file, and then returns it.
     * Returns an empty {@code GtdList} if the file does not exist, or is not a regular file.
     *
     * @throws StorageOperationException if there were errors reading and/or converting data from file.
     */
    public GtdList load() throws StorageOperationException, IOException {

        if (!Files.exists(path) || !Files.isRegularFile(path)) {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
            return new GtdList();
        }
        try {
            return GtdListDecoder.decodeTaskList(Files.readAllLines(path));
        } catch (IOException ioe) {
            throw new StorageOperationException("Loading went wrong");
        } catch (IllegalValueException ive) {
            throw new StorageOperationException("File contains incorrect format.");
        }

    }

    /**
     * Signals that the given file path does not fulfill the storage filepath constraints.
     */
    public static class InvalidStorageFilePathException extends IllegalValueException {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }


    /**
     * Signals that some error has occurred while trying to convert and read/write data between the application
     * and the storage file.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }


}
