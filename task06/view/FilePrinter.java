package by.epam.javawebtraining.maksimkosmachev.task06.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter implements Printable {
    private static final String filePrinter = "D:\\OutputFile.doc";

    @Override
    public void print(Object o) throws IOException {
        File file = new File(filePrinter);
        FileWriter fileWriter = new FileWriter(file, true);
        try {
            fileWriter.write("\n" + o.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.flush();
            fileWriter.close();
        }

    }

    @Override
    public void print(String explanation, Object o) throws IOException {
        File file = new File(filePrinter);
        FileWriter fileWriter = new FileWriter(file, true);
        try {
            fileWriter.write("\n" + explanation);
            fileWriter.write(o.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.flush();
            fileWriter.close();
        }

    }
}

