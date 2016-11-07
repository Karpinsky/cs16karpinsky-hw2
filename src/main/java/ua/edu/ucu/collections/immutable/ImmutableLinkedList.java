package main.java.ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList<T> implements ImmutableList<T> {

    private static class Node<T> {

        private final T data;
        private Node<T> next;
        private Node<T> previous;

        private Node(T dataC)
        {
            this.data = dataC;
            this.next = null;
            this.previous = null;
        }

    }

    private final int count;

    private final Node<T> rootNode;
    private final Node<T> pivotNode;


    public ImmutableLinkedList()
    {
        this.rootNode = null;
        this.pivotNode = null;
        this.count = 0;
    }

    public ImmutableLinkedList(T rootData)
    {
        this.rootNode = new Node<T>(rootData);
        this.pivotNode = this.rootNode;
        this.count = 1;
    }

    public ImmutableLinkedList(T[] initialArray)
    {
        if (initialArray.length < 1)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newRootNode;
        Node<T> newPivotNode;

        newRootNode = new Node<T>(initialArray[0]);
        Node<T> newCurrentNode = newRootNode;
        for (int i = 1; i < initialArray.length; ++i)
        {
            newCurrentNode.next = new Node<T>(initialArray[i]);
            newCurrentNode.next.previous = newCurrentNode;
            newCurrentNode = newCurrentNode.next;
        }
        newPivotNode = newCurrentNode;

        this.rootNode = newRootNode;
        this.pivotNode = newPivotNode;
        this.count = initialArray.length;
    }

    private ImmutableLinkedList(Node<T> root, Node<T> pivot, int count)
    {
        this.rootNode = root;
        this.pivotNode = pivot;
        this.count = count;
    }

    public ImmutableLinkedList<T> addFirst(T e)
    {
        return this.add(0, e);
    }

    @Override
    public ImmutableLinkedList<T> add(T e)
    {
        Node<T> newRootNode;
        Node<T> newPivotNode;

        if (this.rootNode == null)
        {
            newRootNode = new Node<T>(e);
            newPivotNode = newRootNode;
        }
        else
        {
            newRootNode = new Node<T>(this.rootNode.data);
            Node<T> newCurrentNode = newRootNode;
            Node<T> currentNode = this.rootNode;

            while (currentNode.next != null)
            {
                currentNode = currentNode.next;
                newCurrentNode.next = new Node<T>(currentNode.data);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }
            newPivotNode = newCurrentNode;
            newPivotNode.next = new Node<T>(e);
            newPivotNode.next.previous = newPivotNode;
            newPivotNode = newPivotNode.next;
        }

        return new ImmutableLinkedList<T>(newRootNode, newPivotNode, this.count + 1);
    }

    @Override
    public ImmutableLinkedList<T> add(int index, T e)
    {
        if (index != 0 && (this.isEmpty() || index >= this.count))
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newRootNode;
        Node<T> newPivotNode;

        if (index == 0) {
            newRootNode = new Node<T>(e);
            Node<T> newCurrentNode = newRootNode;
            Node<T> currentNode = this.rootNode;

            while (currentNode != null)
            {
                newCurrentNode.next = new Node<T>(currentNode.data);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
                currentNode = currentNode.next;
            }
            newPivotNode = newCurrentNode;
        }
        else
        {
            newRootNode = new Node<T>(this.rootNode.data);
            Node<T> newCurrentNode = newRootNode;
            Node<T> currentNode = this.rootNode;

            int ndx = 1;
            while (currentNode.next != null)
            {
                System.out.println(ndx);
                if (ndx == index)
                {
                    newCurrentNode.next = new Node<T>(e);
                    newCurrentNode.next.previous = newCurrentNode;
                    newCurrentNode = newCurrentNode.next;
                }
                ndx++;
                currentNode = currentNode.next;
                newCurrentNode.next = new Node<T>(currentNode.data);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }
            newPivotNode = newCurrentNode;
        }

        return new ImmutableLinkedList<T>(newRootNode, newPivotNode, this.count + 1);
    }

    @Override
    public ImmutableLinkedList<T> addAll(T[] c)
    {
        if (c.length < 1)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newRootNode;
        Node<T> newPivotNode;

        if (this.rootNode == null)
        {
            newRootNode = new Node<T>(c[0]);
            Node<T> newCurrentNode = newRootNode;
            for (int i = 1; i < c.length; ++i)
            {
                newCurrentNode.next = new Node<T>(c[i]);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }
            newPivotNode = newCurrentNode;
        }
        else
        {
            newRootNode = new Node<T>(this.rootNode.data);
            Node<T> newCurrentNode = newRootNode;
            Node<T> currentNode = this.rootNode;

            while (currentNode.next != null)
            {
                currentNode = currentNode.next;
                newCurrentNode.next = new Node<T>(currentNode.data);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }

            for (int i = 0; i < c.length; ++i)
            {
                newCurrentNode.next = new Node<T>(c[i]);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }

            newPivotNode = newCurrentNode;
        }

        return new ImmutableLinkedList<T>(newRootNode, newPivotNode, this.count + c.length);
    }

    @Override
    public ImmutableLinkedList<T> addAll(int index, T[] c) {
        if ((index != 0 && (this.isEmpty() || index >= this.count)) || c.length < 1)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newRootNode;
        Node<T> newPivotNode;

        if (index == 0) {
            newRootNode = new Node<T>(c[0]);
            Node<T> newCurrentNode = newRootNode;

            for (int i = 1; i < c.length; ++i)
            {
                newCurrentNode.next = new Node<T>(c[i]);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }

            Node<T> currentNode = this.rootNode;

            while (currentNode != null)
            {
                newCurrentNode.next = new Node<T>(currentNode.data);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
                currentNode = currentNode.next;
            }
            newPivotNode = newCurrentNode;
        }
        else
        {
            newRootNode = new Node<T>(this.rootNode.data);
            Node<T> newCurrentNode = newRootNode;
            Node<T> currentNode = this.rootNode;

            int ndx = 1;
            while (currentNode.next != null)
            {
                if (ndx == index)
                {
                    for (int i = 0; i < c.length; ++i)
                    {
                        newCurrentNode.next = new Node<T>(c[i]);
                        newCurrentNode.next.previous = newCurrentNode;
                        newCurrentNode = newCurrentNode.next;
                    }
                }
                ndx++;
                currentNode = currentNode.next;
                newCurrentNode.next = new Node<T>(currentNode.data);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
            }
            newPivotNode = newCurrentNode;
        }

        return new ImmutableLinkedList<T>(newRootNode, newPivotNode, this.count + c.length);
    }

    public T getFirst()
    {
        if (this.rootNode == null)
        {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return this.rootNode.data;
    }

    public T getLast()
    {
        if (this.pivotNode == null)
        {
            throw new IndexOutOfBoundsException("The list is empty");
        }
        return this.pivotNode.data;
    }

    private Node<T> getNode(int index)
    {
        if (this.isEmpty() || index >= this.count)
        {
            throw new IndexOutOfBoundsException();
        }

        int ndx = 0;
        Node<T> currentNode = this.rootNode;
        while (ndx < index && currentNode.next != null)
        {
            ndx++;
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    @Override
    public T get(int index)
    {
        return this.getNode(index).data;
    }

    public ImmutableLinkedList<T> removeFirst()
    {
        return this.remove(0);
    }

    public ImmutableLinkedList<T> removeLast()
    {
        return this.remove(this.count - 1);
    }

    @Override
    public ImmutableLinkedList<T> remove(int index)
    {
        if (this.isEmpty() || index >= this.count)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newRootNode;
        Node<T> newPivotNode;

        newRootNode = new Node<T>(this.rootNode.data);
        Node<T> currentNode = this.rootNode;

        if (index == 0)
        {
            newRootNode = new Node<T>(currentNode.next.data);
            currentNode = currentNode.next;
        }
        Node<T> newCurrentNode = newRootNode;

        int ndx = 1;
        while (currentNode.next != null)
        {
            if (ndx == index)
            {
                currentNode = currentNode.next;
                ndx++;
                continue;
            }
            ndx++;
            currentNode = currentNode.next;
            newCurrentNode.next = new Node<T>(currentNode.data);
            newCurrentNode.next.previous = newCurrentNode;
            newCurrentNode = newCurrentNode.next;
        }
        newPivotNode = newCurrentNode;

        return new ImmutableLinkedList<T>(newRootNode, newPivotNode, this.count - 1);
    }

    @Override
    public ImmutableLinkedList<T> set(int index, T e) {
        if (this.isEmpty() || index >= this.count)
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newRootNode;
        Node<T> newPivotNode;

        newRootNode = new Node<T>(this.rootNode.data);
        Node<T> newCurrentNode = newRootNode;
        Node<T> currentNode = this.rootNode;

        if (index == 0)
        {
            newRootNode = new Node<T>(e);
            newCurrentNode = newRootNode;
        }
        int ndx = 1;
        while (currentNode.next != null)
        {
            if (ndx == index)
            {
                newCurrentNode.next = new Node<T>(e);
                newCurrentNode.next.previous = newCurrentNode;
                newCurrentNode = newCurrentNode.next;
                currentNode = currentNode.next;
                ndx++;
                continue;
            }
            ndx++;
            currentNode = currentNode.next;
            newCurrentNode.next = new Node<T>(currentNode.data);
            newCurrentNode.next.previous = newCurrentNode;
            newCurrentNode = newCurrentNode.next;
        }
        newPivotNode = newCurrentNode;

        return new ImmutableLinkedList<T>(newRootNode, newPivotNode, this.count);
    }

    @Override
    public int indexOf(T e) {
        int ndx = 0;

        Node<T> currentNode = this.rootNode;
        for (int i = 0; i < this.count; ++i)
        {
            if (currentNode.data == e)
            {
                return ndx;
            }
            ndx++;
            currentNode = currentNode.next;
        }

        return -1;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public ImmutableLinkedList<T> clear() {
        return new ImmutableLinkedList<T>();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T[] toArray() {
        T[] returnArray = (T[]) new Object[this.count];

        Node<T> currentNode = this.rootNode;
        for (int i = 0; i < this.count; ++i)
        {
            returnArray[i] = currentNode.data;
            currentNode = currentNode.next;
        }

        return returnArray;
    }

    @Override
    public String toString()
    {
        Node<T> currentNode = this.rootNode;

        StringBuilder buf = new StringBuilder();
        while (currentNode != null)
        {
            buf.append(currentNode.data.toString());
            buf.append(" -> ");
            currentNode = currentNode.next;
        }
        buf.append("null");

        return buf.toString();
    }
}
