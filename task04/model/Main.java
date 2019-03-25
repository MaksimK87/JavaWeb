package by.epam.javawebtraining.maksimkosmachev.task04.model;

import by.epam.javawebtraining.maksimkosmachev.task04.model.controller.Controller;
import org.apache.log4j.Logger;

public class Main {
    private final Logger logger=Logger.getRootLogger();
    public static void main(String[] args) {

        Controller.launch();

    }
}
