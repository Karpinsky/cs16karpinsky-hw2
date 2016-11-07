package collections;

import main.java.ua.edu.ucu.collections.Stack;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void emptyConstructor()
    {
        Stack<String> stack = new Stack<>();

        assertEquals("null", stack.toString());
    }

    @Test
    public void initialDataArrayConstructor()
    {
        Stack<String> stack = new Stack<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertArrayEquals(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"}, stack.toArray());
        assertEquals("You! -> Yes -> you -> right -> there -> - -> you -> are -> awesome -> null", stack.toString());
    }

    @Test
    public void peekTest()
    {
        Stack<String> stack = new Stack<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertEquals(stack.peek(), "awesome");
    }

    @Test
    public void popTest()
    {
        Stack<String> stack = new Stack<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertEquals(stack.pop(), "awesome");
        assertArrayEquals(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are"}, stack.toArray());
        assertEquals("You! -> Yes -> you -> right -> there -> - -> you -> are -> null", stack.toString());
    }

    @Test
    public void pushTest()
    {
        Stack<String> stack = new Stack<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});
        stack.push("!");

        assertArrayEquals(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome", "!"}, stack.toArray());
        assertEquals("You! -> Yes -> you -> right -> there -> - -> you -> are -> awesome -> ! -> null", stack.toString());
    }

    @Test
    public void toArrayTest()
    {
        Stack<String> stack = new Stack<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertArrayEquals(stack.toArray(), new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});
    }

    @Test
    public void toStringTest()
    {
        Stack<String> stack = new Stack<>(new String[] {"You!", "Yes", "you", "right", "there", "-", "you", "are", "awesome"});

        assertEquals(stack.toString(), "You! -> Yes -> you -> right -> there -> - -> you -> are -> awesome -> null");
    }
    
}
