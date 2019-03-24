package by.epam.javawebtraining.maksimkosmachev.task04.model.parser;

import by.epam.javawebtraining.maksimkosmachev.task04.model.entity.IUnit;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser {
   private AbstractParser nextParser;
   List<IUnit> composites=new ArrayList<>();
   abstract List<IUnit> parse();
   abstract  List<IUnit> parse(List<IUnit> composites);

    public AbstractParser getNextParser() {
        return nextParser;
    }

    public void setNextParser(AbstractParser nextParser) {
        this.nextParser = nextParser;
    }
}

