package by.epam.javawebtraining.maksimkosmachev.task1.util.mylinkedlist;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;

public class LinkList implements ILinkList {
    Node first;
    Node last;
    int size;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void add(Car car) {
        Node l = last;
        Node node = new Node(l, car, null);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
            size++;
        }


    }

    public void printList(LinkList linkList) {
        while (linkList.first != null) {
            linkList.first.displayNode();
            linkList.first = linkList.first.next;
        }
    }
}
