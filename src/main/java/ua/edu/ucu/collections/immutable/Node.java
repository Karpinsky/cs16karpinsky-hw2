package main.java.ua.edu.ucu.collections.immutable;

public class Node {

    public Object data;
    public Node next = null;
    public Node previous = null;

    public Node(Object dataC)
    {
        this.data = dataC;
    }

}
