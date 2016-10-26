package main.java.ua.edu.ucu.collections.immutable;

final public class ImmutableArrayList implements ImmutableList {

    private Object[] elements;

    public ImmutableArrayList()
    {
        this.elements = new Object[0];
    }

    public ImmutableArrayList(Object[] initialArray)
    {
        this.elements = initialArray;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newArray = new Object[this.elements.length + 1];
        newArray[this.elements.length] = e;

        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newArray = new Object[this.elements.length + 1];
        newArray[index] = e;

        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(this.elements, index, newArray, index + 1, this.elements.length - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newArray = new Object[this.elements.length + c.length];

        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
        System.arraycopy(c, 0, newArray, this.elements.length, c.length);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newArray = new Object[this.elements.length + c.length];

        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(this.elements, index, newArray, index + c.length, this.elements.length - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public Object get(int index) {
        return this.elements[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newArray = new Object[this.elements.length - 1];

        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(this.elements, index + 1, newArray, index, newArray.length - index);

        return new ImmutableArrayList(newArray);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        this.elements[index] = e;
        return new ImmutableArrayList(this.elements);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.elements.length; ++i)
        {
            if (this.elements[i] == e)
            {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int size() {
        return this.elements.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.length == 1;
    }

    @Override
    public Object[] toArray() {
        return this.elements;
    }
}
