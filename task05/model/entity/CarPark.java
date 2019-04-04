/**
 * @author - Maksim Kosmachev
 */
package by.epam.javawebtraining.maksimkosmachev.task05.model.entity;

import by.epam.javawebtraining.maksimkosmachev.task05.model.exception.CarParkNotFoundException;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CarPark {

    private static Logger logger = Logger.getLogger(CarPark.class);

    private static int counter = 0;
    private int id;
    private CarPark nextCarPark;

    private Semaphore semaphore;
    private Queue<ParkPlace> parkPlaces;


    public CarPark(Queue<ParkPlace> parkPlaces) {
        this.parkPlaces = parkPlaces;
        this.semaphore = new Semaphore(parkPlaces.size(), true);
        this.id = ++counter;
        logger.info("Car park " + this.id + " was created, size: " + parkPlaces.size());
    }

    public ParkPlace getParkPlace(long waitingTime) throws CarParkNotFoundException {
        ParkPlace place;
        try {
            if (this.semaphore.tryAcquire(waitingTime, TimeUnit.MILLISECONDS)) {
                place = parkPlaces.poll();
                return place;
            }
            if (nextCarPark != null) {
                return nextCarPark.getParkPlace(waitingTime);
            }

        } catch (InterruptedException e) {
            logger.error("Error, resource is not available");
        }
        throw new CarParkNotFoundException();
    }


    public void returnParkPlace(ParkPlace place) {
        parkPlaces.add(place);
        this.semaphore.release();
    }

    public CarPark getNextCarPark() {
        return nextCarPark;
    }

    public void setNextCarPark(CarPark nextCarPark) {
        this.nextCarPark = nextCarPark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPark carPark = (CarPark) o;
        return id == carPark.id &&
                Objects.equals(nextCarPark, carPark.nextCarPark) &&
                Objects.equals(semaphore, carPark.semaphore) &&
                Objects.equals(parkPlaces, carPark.parkPlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nextCarPark, semaphore, parkPlaces);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        for(ParkPlace parkPlace:parkPlaces){
            stringBuilder.append(parkPlace.toString());
        }
        return "CarPark{" +
                "id=" + id +
                ", nextCarPark=" + nextCarPark +
                ", semaphore=" + semaphore +
                ", parkPlaces=" + parkPlaces +
                '}'+"\n"+stringBuilder.toString();
    }
}
