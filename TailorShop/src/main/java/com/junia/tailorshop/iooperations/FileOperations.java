package com.junia.tailorshop.iooperations;

import java.io.*;

/**
 * The FileOperations class provides methods for file handling operations.
 * It includes functionality to save data to a file, load data from a file,
 * and check if a file exists in the specified directory.
 */
public class FileOperations {

    /**
     * Saves the provided data to a file with the specified filename.
     * If the file already exists, it will be overwritten.
     *
     * @param data     The data to be written to the file.
     * @param fileName The name of the file to save the data.
     * @throws IOException If an error occurs during file writing.
     */
    public static void saveToFile(String data, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        writer.write(data);
        writer.newLine();
        writer.close();
    }

    /**
     * Loads the contents of a file with the specified filename.
     * Reads the file line by line and concatenates it into a single string.
     *
     * @param fileName The name of the file to be read.
     * @return A string containing the contents of the file.
     * @throws IOException If an error occurs during file reading.
     */
    public static String loadFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        String outText = "";
        
        // Read the file line by line until the end
        while ((line = reader.readLine()) != null) {
            outText += line;  
        }
        reader.close();
        return outText;
    }

    /**
     * Checks if a file with the specified filename exists in the filesystem.
     *
     * @param fileName The name of the file to check.
     * @return true if the file exists, false otherwise.
     */
    public static boolean isFileExists(String fileName) {
        return new File(fileName).exists();
    }
}
