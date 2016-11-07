package main.java.ua.edu.ucu.collections;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue<T> {

    private ImmutableLinkedList<T> queueData;

    public Queue()
    {
        this.queueData = new ImmutableLinkedList<T>();
    }

    public Queue(T[] initialDataArray)
    {
        this.queueData = new ImmutableLinkedList<T>(initialDataArray);
    }

    public T peek()
    {
        return this.queueData.getFirst();
    }

    public T dequeue()
    {
        T removedData = this.peek();
        this.queueData = this.queueData.removeFirst();
        return removedData;
    }

    public void enqueue(T e)
    {
        this.queueData = this.queueData.add(e);
    }

    public T[] toArray()
    {
        return this.queueData.toArray();
    }

    @Override
    public String toString()
    {
        return this.queueData.toString();
    }

}
