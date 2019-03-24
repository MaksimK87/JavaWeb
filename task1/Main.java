package by.epam.javawebtraining.maksimkosmachev.task1;


import by.epam.javawebtraining.maksimkosmachev.task1.controller.Controller;
import org.apache.log4j.Logger;

public class Main {
    public static final Logger logger=Logger.getRootLogger();
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.launch();
        logger.info("Model has been lunched");
    }
}