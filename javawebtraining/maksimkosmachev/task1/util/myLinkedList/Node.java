package by.epam.javawebtraining.maksimkosmachev.task1.util.myLinkedList;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;

public class Node {
    private Car car;
    Node next;
    Node prev;
    private int index=-1;

    Node(Node prev, Car car, Node next) {
        this.prev = prev;
        this.car = car;
        this.next = next;
        index++;

    }

    void displayNode() {
        System.out.println(car.toString());
    }
}
