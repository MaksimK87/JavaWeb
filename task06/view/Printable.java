package by.epam.javawebtraining.maksimkosmachev.task06.view;

import java.io.IOException;

public interface Printable {
    void print(Object o) throws  IOException;
    void print(String explanation, Object o) throws IOException;
}