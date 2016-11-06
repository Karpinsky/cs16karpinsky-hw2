package main.java.ua.edu.ucu.collections.immutable;

public class Node<T> implements Cloneable{

    public final T data;
    public Node<T> next;
    public Node<T> previous;

    public Node(T dataC)
    {
        this.data = dataC;
        this.next = null;
        this.previous = null;
    }

}
