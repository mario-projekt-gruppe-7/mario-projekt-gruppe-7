package UI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AsciiPrinter {

    public static void printColoredFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Replace literal \u001B with the real escape character if needed
                line = line.replace("\\u001B", "\u001B");
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}