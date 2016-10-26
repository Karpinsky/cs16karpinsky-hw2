package main.java.ua.edu.ucu.collections;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue extends ImmutableLinkedList {

    public Object peek()
    {
        return this.getFirst();
    }

    public Object dequeue()
    {
        return this.removeFirst();
    }

    public void enqueue(Object e)
    {
        this.add(e);
    }

}
