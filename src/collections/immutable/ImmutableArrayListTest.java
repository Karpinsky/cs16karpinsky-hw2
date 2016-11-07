package collections.immutable;

import main.java.ua.edu.ucu.collections.immutable.ImmutableArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void emptyConstructor()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();

        assertArrayEquals(new Integer[] {}, arrayList.toArray());
        assertEquals("[]", arrayList.toString());
    }

    @Test
    public void initialDataArrayConstructor()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertArrayEquals(new Integer[] {34, 1, 23, 6}, arrayList.toArray());
        assertEquals("[34, 1, 23, 6]", arrayList.toString());
    }

    @Test
    public void addTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.add(53);
        arrayList = arrayList.add(32);
        arrayList = arrayList.add(12);

        assertArrayEquals(new Integer[] {53, 32, 12}, arrayList.toArray());
        assertEquals("[53, 32, 12]", arrayList.toString());
    }

    @Test
    public void addAtIndexTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.add(0, 53);
        arrayList = arrayList.add(32);
        arrayList = arrayList.add(1, 4);
        arrayList = arrayList.add(0, 555);

        assertArrayEquals(new Integer[] {555, 53, 4, 32}, arrayList.toArray());
        assertEquals("[555, 53, 4, 32]", arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndexExceptionTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.add(0, 53);
        arrayList = arrayList.add(1, 32);
        arrayList = arrayList.add(1, 4);
        arrayList = arrayList.add(0, 555);
        arrayList = arrayList.add(4, 12);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndexExceptionWithSizeTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.add(0, 53);
        arrayList = arrayList.add(1, 32);
        arrayList = arrayList.add(1, 4);
        arrayList = arrayList.add(0, 555);
        arrayList = arrayList.add(arrayList.size(), 12);
    }

    @Test
    public void addFirstTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.add(0, 53);
        arrayList = arrayList.add(0, 32);
        arrayList = arrayList.add(0, 12);

        assertArrayEquals(new Integer[] {12, 32, 53}, arrayList.toArray());
        assertEquals("[12, 32, 53]", arrayList.toString());
    }

    @Test
    public void addAllTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.addAll(new Integer[] {34, 1, 23, 6});

        assertArrayEquals(new Integer[] {34, 1, 23, 6}, arrayList.toArray());
        assertEquals("[34, 1, 23, 6]", arrayList.toString());
    }

    @Test
    public void addAllToNotEmptyTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {2});
        arrayList = arrayList.addAll(new Integer[] {34, 1, 23, 6});

        assertArrayEquals(new Integer[] {2, 34, 1, 23, 6}, arrayList.toArray());
        assertEquals("[2, 34, 1, 23, 6]", arrayList.toString());
    }

    @Test
    public void addAllAtIndexTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {2, 5, 7});
        arrayList = arrayList.addAll(2 ,new Integer[] {34, 1, 23, 6});

        assertArrayEquals(new Integer[] {2, 5, 34, 1, 23, 6, 7}, arrayList.toArray());
        assertEquals("[2, 5, 34, 1, 23, 6, 7]", arrayList.toString());
    }

    @Test
    public void addAllAtIndexToEmptyTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.addAll(0 ,new Integer[] {34, 1, 23, 6});

        assertArrayEquals(new Integer[] {34, 1, 23, 6}, arrayList.toArray());
        assertEquals("[34, 1, 23, 6]", arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllAtIndexExceptionTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {2, 5, 7});
        arrayList = arrayList.addAll(3 ,new Integer[] {34, 1, 23, 6});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllAtIndexToEmptyExceptionTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.addAll(1 ,new Integer[] {34, 1, 23, 6});
    }

    @Test
    public void getTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(arrayList.get(2).toString(), "23");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionTest()
    {
        ImmutableArrayList<Integer> linkedList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(linkedList.get(4).toString(), "23");
    }

    @Test
    public void removeTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.remove(1);

        assertArrayEquals(new Integer[] {34, 23, 6}, arrayList.toArray());
        assertEquals("[34, 23, 6]", arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromEmptyTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.remove(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeFromSizeIndexTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.remove(arrayList.size());
    }

    @Test
    public void setTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.set(2, 5);

        assertArrayEquals(new Integer[] {34, 1, 5, 6}, arrayList.toArray());
        assertEquals("[34, 1, 5, 6]", arrayList.toString());
    }

    @Test
    public void setAtZeroTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.set(0, 5);

        assertArrayEquals(new Integer[] {5, 1, 23, 6}, arrayList.toArray());
        assertEquals("[5, 1, 23, 6]", arrayList.toString());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setExceptionTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.set(7, 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOnSizeExceptionTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.set(arrayList.size(), 11);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOnEmptyExceptionTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();
        arrayList = arrayList.set(0, 11);
    }

    @Test
    public void indexOfTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(arrayList.indexOf(1), 1);
    }

    @Test
    public void sizeTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6, 3});

        assertEquals(arrayList.size(), 5);
    }

    @Test
    public void clearTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});
        arrayList = arrayList.clear();

        assertEquals("[]", arrayList.toString());
    }

    @Test
    public void isEmptyFalseTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(arrayList.isEmpty(), false);
    }

    @Test
    public void isEmptyTrueTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>();

        assertEquals(arrayList.isEmpty(), true);
    }

    @Test
    public void toArrayTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertArrayEquals(arrayList.toArray(), new Integer[] {34, 1, 23, 6});
    }

    @Test
    public void toStringTest()
    {
        ImmutableArrayList<Integer> arrayList = new ImmutableArrayList<>(new Integer[] {34, 1, 23, 6});

        assertEquals(arrayList.toString(), "[34, 1, 23, 6]");
    }

}
