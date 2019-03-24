package by.epam.javawebtraining.maksimkosmachev.task04.model.entity;

import java.util.ArrayList;
import java.util.List;

public class CompositeUnit implements IUnit {
    private List<IUnit> composits=new ArrayList<>();

    @Override
    public String getString() {
        return null;
    }
}
