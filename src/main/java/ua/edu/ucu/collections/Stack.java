package main.java.ua.edu.ucu.collections;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack extends ImmutableLinkedList {

    public Object peek()
    {
        return this.getLast();
    }

    public Object pop()
    {
        return this.removeLast();
    }

    public void push(Object e)
    {
        this.add(e);
    }

}
