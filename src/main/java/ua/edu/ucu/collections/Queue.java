package main.java.ua.edu.ucu.collections;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queueData;

    public Object peek()
    {
        return this.queueData.getFirst();
    }

    public Object dequeue()
    {
        return this.queueData.removeFirst();
    }

    public void enqueue(Object e)
    {
        this.queueData.add(e);
    }

}
