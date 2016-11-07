package collections;

import main.java.ua.edu.ucu.collections.Queue;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void emptyConstructor()
    {
        Queue<String> queue = new Queue<>();

        assertEquals("null", queue.toString());
    }

    @Test
    public void initialDataArrayConstructor()
    {
        Queue<String> queue = new Queue<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertArrayEquals(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"}, queue.toArray());
        assertEquals("You! -> Yes -> you -> right -> there -> - -> you -> are -> awesome -> null", queue.toString());
    }

    @Test
    public void peekTest()
    {
        Queue<String> queue = new Queue<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertEquals(queue.peek(), "You!");
    }

    @Test
    public void dequeueTest()
    {
        Queue<String> queue = new Queue<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertEquals(queue.dequeue(), "You!");
        assertArrayEquals(new String[] {"Yes", "you", "right", "there", "-", "you", "are", "awesome"}, queue.toArray());
        assertEquals("Yes -> you -> right -> there -> - -> you -> are -> awesome -> null", queue.toString());
    }

    @Test
    public void enqueueTest()
    {
        Queue<String> queue = new Queue<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});
        queue.enqueue("!");

        assertArrayEquals(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome", "!"}, queue.toArray());
        assertEquals("You! -> Yes -> you -> right -> there -> - -> you -> are -> awesome -> ! -> null", queue.toString());
    }

    @Test
    public void toArrayTest()
    {
        Queue<String> queue = new Queue<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertArrayEquals(queue.toArray(), new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});
    }

    @Test
    public void toStringTest()
    {
        Queue<String> queue = new Queue<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertEquals(queue.toString(), "You! -> Yes -> you -> right -> there -> - -> you -> are -> awesome -> null");
    }
    
}
