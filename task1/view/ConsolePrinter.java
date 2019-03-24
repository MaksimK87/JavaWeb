package by.epam.javawebtraining.maksimkosmachev.task1.view;

import by.epam.javawebtraining.maksimkosmachev.task1.model.exception.TaxiParkIsEmptyException;
import org.apache.log4j.Logger;

public class ConsolePrinter implements IPrinter {
    private static Logger logger = Logger.getLogger(ConsolePrinter.class);

    @Override
    public void print(Object o) {

        if (o != null) {
            System.out.println(o.toString());

        } else {
            logger.error("\n Entity taxi park must be not null \n", new TaxiParkIsEmptyException());
        }
    }

    @Override
    public void print(String explanation, Object o) {
        if(explanation!=null && o!=null){
            System.out.println(explanation+o.toString()+"\n" );
        }
    }
}
