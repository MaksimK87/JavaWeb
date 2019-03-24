package by.epam.javawebtraining.maksimkosmachev.task04.model.reader;

import org.apache.log4j.Logger;

import java.io.*;

public class TextReader {
    private static final Logger log = Logger.getLogger(TextReader.class);

    private static File fileName = new File("e:/Мои документы/Java courses/IDEA/Workspace/src/by/e" +
            "pam/javawebtraining/maksimkosmachev/task04/Text.txt");


    public static String readFile() {

        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {

            while ((temp = in.readLine()) != null) {

                stringBuilder.append(temp).append("\n");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        log.info("File has been read");

        return stringBuilder.toString();
    }
}
