package test;

import lists.SinglyLinkedList;
import lists.SinglyLinkedListIterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SinglyLinkedListIteratorTest {
    SinglyLinkedList list;

    @Before
    public void setUp() {
        this.list = new SinglyLinkedList();
    }

    public void addElements(int quantity) {
        for(int i = 0; i < quantity; i++) this.list.insertLast("element " + (i+1));
    }

    @Test
    public void hasNextTest() {
        SinglyLinkedListIterator it = (SinglyLinkedListIterator) this.list.iterator();
        assertFalse(it.hasNext());
        this.addElements(3);
        it = (SinglyLinkedListIterator) this.list.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }

    @Test
    public void nextTest() {
        this.addElements(3);
        SinglyLinkedListIterator it = (SinglyLinkedListIterator) this.list.iterator();
        assertEquals(it.next(), "element 1");
        assertEquals(it.next(), "element 2");
        assertEquals(it.next(), "element 3");
    }

    @Test
    public void rewindTest() {
        this.addElements(3);
        SinglyLinkedListIterator it = this.list.iterator();
        assertEquals(it.next(), "element 1");
        assertEquals(it.next(), "element 2");
        it.rewind();
        assertEquals(it.next(),"element 1");
    }
}
