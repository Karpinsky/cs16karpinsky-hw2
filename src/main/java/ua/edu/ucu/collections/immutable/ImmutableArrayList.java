package main.java.ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList<T> implements ImmutableList<T> {

    private final T[] elements;

    public ImmutableArrayList()
    {
        this.elements = (T[]) new Object[0];
    }

    public ImmutableArrayList(T[] initialArray)
    {
        this.elements = initialArray;
    }

    @Override
    public ImmutableArrayList<T> add(T e) {
        T[] newArray = (T[]) new Object[this.elements.length + 1];
        newArray[this.elements.length] = e;

        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);

        return new ImmutableArrayList<T>(newArray);
    }

    @Override
    public ImmutableArrayList<T> add(int index, T e) {
        if (index != 0 && (this.isEmpty() || index >= this.elements.length))
        {
            throw new IndexOutOfBoundsException();
        }

        T[] newArray = (T[]) new Object[this.elements.length + 1];
        newArray[index] = e;

        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(this.elements, index, newArray, index + 1, this.elements.length - index);

        return new ImmutableArrayList<T>(newArray);
    }

    @Override
    public ImmutableArrayList<T> addAll(T[] c) {
        T[] newArray = (T[]) new Object[this.elements.length + c.length];

        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
        System.arraycopy(c, 0, newArray, this.elements.length, c.length);

        return new ImmutableArrayList<T>(newArray);
    }

    @Override
    public ImmutableArrayList<T> addAll(int index, T[] c) {
        if (index != 0 && (this.isEmpty() || index >= this.elements.length))
        {
            throw new IndexOutOfBoundsException();
        }

        T[] newArray = (T[]) new Object[this.elements.length + c.length];

        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(c, 0, newArray, index, c.length);
        System.arraycopy(this.elements, index, newArray, index + c.length, this.elements.length - index);

        return new ImmutableArrayList<T>(newArray);
    }

    @Override
    public T get(int index) {
        if (this.isEmpty() || index >= this.elements.length)
        {
            throw new IndexOutOfBoundsException();
        }

        return this.elements[index];
    }

    @Override
    public ImmutableArrayList<T> remove(int index) {
        if (this.isEmpty() || index >= this.elements.length)
        {
            throw new IndexOutOfBoundsException();
        }

        T[] newArray = (T[]) new Object[this.elements.length - 1];

        System.arraycopy(this.elements, 0, newArray, 0, index);
        System.arraycopy(this.elements, index + 1, newArray, index, newArray.length - index);

        return new ImmutableArrayList<T>(newArray);
    }

    @Override
    public ImmutableArrayList<T> set(int index, T e) {
        if (this.isEmpty() || index >= this.elements.length)
        {
            throw new IndexOutOfBoundsException();
        }

        T[] newArray = (T[]) new Object[this.elements.length];
        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);

        newArray[index] = e;
        return new ImmutableArrayList<T>(newArray);
    }

    @Override
    public int indexOf(T e) {
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
    public ImmutableArrayList<T> clear() {
        return new ImmutableArrayList<T>();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.length == 0;
    }

    @Override
    public T[] toArray() {

        T[] newArray = (T[]) new Object[this.elements.length];
        System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);

        return newArray;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(this.elements);
    }
}
