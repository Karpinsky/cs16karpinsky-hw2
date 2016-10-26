package main.java.ua.edu.ucu.collections.immutable;

final public class ImmutableLinkedList implements ImmutableList {

    private int count = 0;

    private Node rootNode;
    private Node pivotNode;


    public ImmutableLinkedList()
    {
        rootNode = null;
        pivotNode = null;
        this.count = 0;
    }

    public ImmutableLinkedList(Object rootData)
    {
        rootNode = null;
        pivotNode = null;
        this.count = 0;
        this.add(rootData);
    }

    public ImmutableLinkedList(Object[] initialArray)
    {
        rootNode = null;
        pivotNode = null;
        this.count = 0;
        for (int i = 0; i < initialArray.length; ++i)
        {
            this.add(initialArray[i]);
        }
    }

    private ImmutableLinkedList(Node root)
    {
        int counter = 0;
        this.rootNode = root;

        Node loopNode = this.rootNode;
        if (loopNode != null)
        {
            counter++;
            while (loopNode.next != null)
            {
                loopNode = loopNode.next;
                counter++;
            }
        }

        this.count = counter;
        this.pivotNode = loopNode;
    }

    public ImmutableList addFirst(Object e)
    {
        return this.add(0, e);
    }

    @Override
    public ImmutableList add(Object e) {
        if (this.rootNode == null)
        {
            this.rootNode = new Node(e);
            this.pivotNode = this.rootNode;
        }
        else
        {
            this.pivotNode.next = new Node(e);
            this.pivotNode.next.previous = this.pivotNode;
            this.pivotNode = this.pivotNode.next;
        }

        this.count++;

        return new ImmutableLinkedList(this.rootNode);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Node keyElement = this.getNode(index);
        if (keyElement == null)
        {
            return this.add(e);
        }

        keyElement.previous.next = new Node(e);
        keyElement.previous.next.previous = keyElement.previous;
        keyElement.previous.next.next = keyElement;
        keyElement.previous = keyElement.previous.next;

        this.count++;

        return new ImmutableLinkedList(this.rootNode);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        for (int i = 0; i < c.length; ++i)
        {
            this.add(c[i]);
        }

        return new ImmutableLinkedList(this.rootNode);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Node keyElement = this.getNode(index);
        if (keyElement == null)
        {
            return this.addAll(c);
        }

        Node currentNode = keyElement.previous;
        for (int i = 0; i < c.length; ++i)
        {
            currentNode.next = new Node(c[i]);
            currentNode.next.previous = currentNode;
            currentNode = currentNode.next;
        }
        currentNode.next = keyElement;
        keyElement.previous = currentNode;

        return new ImmutableLinkedList(this.rootNode);
    }

    public Object getFirst()
    {
       return this.rootNode.data;
    }

    public Object getLast()
    {
        return this.pivotNode.data;
    }

    private Node getNode(int index)
    {
        int ndx = 0;

        if (this.isEmpty())
        {
            return null;
        }

        Node currentNode = this.rootNode;
        while (ndx < index && currentNode.next != null)
        {
            ndx++;
            currentNode = currentNode.next;
        }

        return ndx == index ? currentNode : null;
    }

    @Override
    public Object get(int index) {
        int ndx = 0;

        if (this.isEmpty())
        {
            return null;
        }

        Node currentNode = this.rootNode;
        while (ndx < index && currentNode.next != null)
        {
            ndx++;
            currentNode = currentNode.next;
        }

        return ndx == index ? currentNode.data : null;
    }

    public ImmutableList removeFirst()
    {
        return this.remove(0);
    }

    public ImmutableList removeLast()
    {
        return this.remove(this.count - 1);
    }

    @Override
    public ImmutableList remove(int index) {
        Node removeElement = this.getNode(index);

        if (removeElement != null)
        {
            removeElement.previous.next = removeElement.next;
            removeElement.next.previous = removeElement.previous;
            removeElement = null;
            this.count--;
        }

        return new ImmutableLinkedList(this.rootNode);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Node setElement = this.getNode(index);
        if (setElement != null)
        {
            setElement.data = e;
        }

        return new ImmutableLinkedList(this.rootNode);
    }

    @Override
    public int indexOf(Object e) {
        int ndx = 0;

        Node currentNode = this.rootNode;
        if (currentNode != null)
        {
            while (currentNode.next != null)
            {
                ndx++;
                currentNode = currentNode.next;
            }

            return ndx;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] returnArray = new Object[this.count];

        if (this.rootNode != null)
        {
            int i = 0;
            Node currentNode = this.rootNode;
            returnArray[i] = currentNode.data;
            while (currentNode.next != null)
            {
                currentNode = currentNode.next;
                i++;
                returnArray[i] = currentNode.data;
            }
        }

        return returnArray;
    }
}
