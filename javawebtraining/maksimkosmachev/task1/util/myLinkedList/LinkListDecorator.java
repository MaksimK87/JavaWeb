package by.epam.javawebtraining.maksimkosmachev.task1.util.myLinkedList;

import by.epam.javawebtraining.maksimkosmachev.task1.entity.Car;

public abstract class LinkListDecorator implements ILinkList {

    ILinkList linkList;
    LinkListDecorator(ILinkList linkList){
        this.linkList=linkList;
    }

    @Override
    abstract public void add(Car car);

}
