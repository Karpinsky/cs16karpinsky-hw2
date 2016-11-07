package collections.immutable;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void emptyConstructor()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();

        assertEquals("null", linkedList.toString());
    }

    @Test
    public void initialRootDataConstructor()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(34);

        assertEquals("34 -> null", linkedList.toString());
    }

    @Test
    public void initialDataArrayConstructor()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals("34 -> 1 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test
    public void addTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.add(53);
        linkedList = linkedList.add(32);
        linkedList = linkedList.add(12);

        assertEquals("53 -> 32 -> 12 -> null", linkedList.toString());
    }

    @Test
    public void addAtIndexTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.add(0, 53);
        linkedList = linkedList.add(32);
        linkedList = linkedList.add(1, 4);
        linkedList = linkedList.add(0, 555);

        assertEquals("555 -> 53 -> 4 -> 32 -> null", linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndexExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.add(0, 53);
        linkedList = linkedList.add(1, 32);
        linkedList = linkedList.add(1, 4);
        linkedList = linkedList.add(0, 555);
        linkedList = linkedList.add(4, 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndexExceptionWithSizeTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.add(0, 53);
        linkedList = linkedList.add(1, 32);
        linkedList = linkedList.add(1, 4);
        linkedList = linkedList.add(0, 555);
        linkedList = linkedList.add(linkedList.size(), 12);
    }

    @Test
    public void addFirstTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.addFirst(53);
        linkedList = linkedList.addFirst(32);
        linkedList = linkedList.addFirst(12);

        assertEquals("12 -> 32 -> 53 -> null", linkedList.toString());
    }

    @Test
    public void addAllTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.addAll(new Integer[] {34, 1, 23, 6});

        assertEquals("34 -> 1 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test
    public void addAllToNotEmptyTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(2);
        linkedList = linkedList.addAll(new Integer[] {34, 1, 23, 6});

        assertEquals("2 -> 34 -> 1 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.addAll(new Integer[] {});
    }

    @Test
    public void addAllAtIndexTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {2, 5, 7});
        linkedList = linkedList.addAll(2 ,new Integer[] {34, 1, 23, 6});

        assertEquals("2 -> 5 -> 34 -> 1 -> 23 -> 6 -> 7 -> null", linkedList.toString());
    }

    @Test
    public void addAllAtIndexToEmptyTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.addAll(0 ,new Integer[] {34, 1, 23, 6});

        assertEquals("34 -> 1 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllAtIndexExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {2, 5, 7});
        linkedList = linkedList.addAll(3 ,new Integer[] {34, 1, 23, 6});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllAtIndexToEmptyExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.addAll(1 ,new Integer[] {34, 1, 23, 6});
    }

    @Test
    public void getFirstTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {2, 5, 7});

        assertEquals(linkedList.getFirst().toString(), "2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirstExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();

        assertEquals(linkedList.getFirst().toString(), "2");
    }

    @Test
    public void getLastTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {2, 5, 7});

        assertEquals(linkedList.getLast().toString(), "7");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLastExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();

        assertEquals(linkedList.getLast().toString(), "7");
    }

    @Test
    public void getTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.get(2).toString(), "23");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.get(4).toString(), "23");
    }

    @Test
    public void removeTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.remove(1);

        assertEquals("34 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromSizeIndexTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.remove(linkedList.size());
    }

    @Test
    public void removeFirstTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.removeFirst();

        assertEquals("1 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test
    public void removeLastTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.removeLast();

        assertEquals("34 -> 1 -> 23 -> null", linkedList.toString());
    }

    @Test
    public void setTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.set(2, 5);

        assertEquals("34 -> 1 -> 5 -> 6 -> null", linkedList.toString());
    }

    @Test
    public void setAtZeroTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.set(0, 5);

        assertEquals("5 -> 1 -> 23 -> 6 -> null", linkedList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.set(5, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOnSizeExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.set(linkedList.size(), 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOnEmptyExceptionTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.set(0, 5);
    }

    @Test
    public void indexOfTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.indexOf(6), 3);
    }

    @Test
    public void sizeTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.size(), 4);
    }

    @Test
    public void clearTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});
        linkedList = linkedList.clear();

        assertEquals("null", linkedList.toString());
    }

    @Test
    public void isEmptyFalseTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.isEmpty(), false);
    }

    @Test
    public void isEmptyTrueTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();

        assertEquals(linkedList.isEmpty(), true);
    }

    @Test
    public void toArrayTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertArrayEquals(linkedList.toArray(), new Integer[] {34, 1, 23, 6});
    }

    @Test
    public void toStringTest()
    {
        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.toString(), "34 -> 1 -> 23 -> 6 -> null");
    }
}
