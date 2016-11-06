package collections.immutable;

import main.java.ua.edu.ucu.collections.immutable.ImmutableLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    
    @Test
    public void addTest() {

        ImmutableLinkedList<Integer> linkedList = new ImmutableLinkedList<>();
        linkedList = linkedList.add(53);
        linkedList = linkedList.add(32);
        linkedList = linkedList.add(12);

        assertEquals("53 -> 32 -> 12 -> null", linkedList.toString());

    }
    
}
