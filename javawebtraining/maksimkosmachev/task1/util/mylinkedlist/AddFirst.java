package by.epam.javawebtraining.maksimkosmachev.task1.util.mylinkedlist;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;

public class AddFirst extends LinkListDecorator {
    Node first;
    Node last;
    int size;

    public AddFirst(ILinkList linkList) {
        super(linkList);
    }

    @Override
    public void add(Car car) {
        Node f = first;
        Node node = new Node(null, car, f);
        first = node;
        if (f == null) {
            last = node;
        } else {
            f.prev = node;

            size++;
        }

    }
    public void printILinkList(AddFirst linkList) {
        while (linkList.first != null) {
            linkList.first.displayNode();
            linkList.first = linkList.first.next;
        }
    }

}
