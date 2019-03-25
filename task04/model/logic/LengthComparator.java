package by.epam.javawebtraining.maksimkosmachev.task04.model.logic;

import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;

import java.util.Comparator;

public class LengthComparator implements Comparator<IUnit> {

    @Override
    public int compare(IUnit o1, IUnit o2) {

        return o1.getString().length()-o2.getString().length();
    }

}
