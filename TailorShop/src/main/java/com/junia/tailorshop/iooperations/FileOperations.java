package com.junia.tailorshop.iooperations;
import static com.junia.tailorshop.utils.Utils.println;
import java.io.*;

public class FileOperations {

    public static void saveToFile(String data, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(data);
        writer.newLine();
        writer.close();
    }

    public static void loadFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            println(line);
        }
        reader.close();
    }
}
