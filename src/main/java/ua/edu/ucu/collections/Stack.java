package main.java.ua.edu.ucu.collections;
import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList stackData;
    public Object peek()
    {
        return this.stackData.getLast();
    }

    public Object pop()
    {
        return this.stackData.removeLast();
    }

    public void push(Object e)
    {
        this.stackData.add(e);
    }

}
