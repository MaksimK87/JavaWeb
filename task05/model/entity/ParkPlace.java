/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task05.util.DataConfiguration;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Random;

public class ParkPlace {

    private static Logger logger = Logger.getLogger(ParkPlace.class);
    private final static int USING_TIME = DataConfiguration.getProperty("USING_TIME");
    private static int counter = 0;

    private int id;


    public ParkPlace() {
        this.id = ++counter;
        logger.info("park place number " + id + " was created");

    }

    public int getNumber() {
        return id;
    }

    public void usePlace() {
        try {
            Thread.sleep(new Random().nextInt(USING_TIME));
        } catch (InterruptedException e) {
            logger.error("Thread was interrupted in method \"usePlace\"" +e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkPlace parkPlace = (ParkPlace) o;
        return id == parkPlace.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ParkPlace{" +
                "id=" + id +
                '}';
    }
}
