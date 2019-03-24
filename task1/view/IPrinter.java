package by.epam.javawebtraining.maksimkosmachev.task1.view;

import java.io.IOException;

public interface IPrinter {
    void print(Object o) throws  IOException;
    void print (String explanation, Object o) throws IOException;
}