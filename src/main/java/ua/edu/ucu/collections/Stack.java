package main.java.ua.edu.ucu.collections;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack<T> {

    private ImmutableLinkedList<T> queueData;

    public Stack()
    {
        this.queueData = new ImmutableLinkedList<T>();
    }

    public Stack(T[] initialDataArray)
    {
        this.queueData = new ImmutableLinkedList<T>(initialDataArray);
    }

    public T peek()
    {
        return this.queueData.getLast();
    }

    public T pop()
    {
        T removedData = this.peek();
        this.queueData = this.queueData.removeLast();
        return removedData;
    }

    public void push(T e)
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
