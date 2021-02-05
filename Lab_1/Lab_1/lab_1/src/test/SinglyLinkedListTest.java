package test;

import lists.SinglyLinkedList;
import lists.SinglyLinkedListIterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinglyLinkedListTest {
    SinglyLinkedList list;

    @Before
    public void setUP() {
        this.list = new SinglyLinkedList();
    }

    public void addElements(int quantity) {
        for(int i = 0; i < quantity; i++) this.list.insertLast("element " + (i+1));
    }

    public void removeElements(int quantity) {
        for(int i = 0; i < quantity; i++) this.list.removeLast();
    }

    @Test
    public void isEmptyTest() {
        assertTrue(this.list.isEmpty());
        this.addElements(4);
        assertFalse(this.list.isEmpty());
    }

    @Test
    public void sizeTest() {
        assertEquals(this.list.size(), 0);
        this.addElements(4);
        assertEquals(this.list.size(), 4);
        this.removeElements(4);
        assertEquals(this.list.size(), 0);
    }

    @Test
    public void getFirstTest() {
        this.addElements(3);
        assertEquals(this.list.getFirst(), "element 1");
    }

    @Test
    public void getLastTest() {
        this.addElements(3);
        assertEquals(this.list.getLast(), "element 3");

    }

    @Test
    public void getTest() {
        assertEquals(this.list.get(0), null);
        this.addElements(6);
        assertEquals(this.list.get(2), "element 3");
    }

    @Test
    public void insertFirstTest() {
        this.list.insertFirst("element");
        assertEquals(this.list.getLast(), "element");
        this.list.removeLast();
        this.addElements(5);
        assertNotEquals(this.list.getLast(), "element");
        this.list.insertFirst("element");
        assertEquals(list.getFirst(), "element");
    }

    @Test
    public void insertLastTest() {
        this.list.insertLast("element");
        assertEquals(this.list.getLast(), "element");
        this.list.removeLast();
        this.addElements(5);
        assertNotEquals(this.list.getFirst(), "element");
        this.list.insertLast("element");
        assertEquals(this.list.getLast(), "element");
    }

    @Test
    public void insertTest() {
        this.list.insert("element 1", 0);
        assertEquals(this.list.getFirst(), "element 1");
        this.addElements(4);
        this.list.insert("element X", 2);
        assertEquals(this.list.get(2), "element X");
        this.list.insert("last element", this.list.size());
        assertEquals(this.list.getLast(), "last element");
    }

    @Test
    public void removeFirstTest() {
        this.addElements(5);
        this.list.removeFirst();
        assertEquals(this.list.getFirst(), "element 2");
    }

    @Test
    public void removeFirstSingleElementTest() {
        this.addElements(1);
        assertEquals(this.list.removeFirst(), "element 1");
        assertTrue(this.list.isEmpty());
        this.addElements(1);
        assertEquals(this.list.getFirst(), "element 1");
        assertEquals(this.list.getLast(), "element 1");
        assertEquals(this.list.removeFirst(), "element 1");
    }

    @Test
    public void removeLastTest() {
        assertEquals(this.list.removeLast(), null);
        this.addElements(5);
        this.list.removeLast();
        assertEquals(this.list.getLast(), "element 4");
    }

    @Test
    public void removeLastSingleElementTest() {
        this.addElements(1);
        assertEquals(this.list.removeLast(), "element 1");
        assertTrue(this.list.isEmpty());
        this.addElements(1);
        assertEquals(this.list.getFirst(), "element 1");
        assertEquals(this.list.getLast(), "element 1");
        assertEquals(this.list.removeLast(), "element 1");
    }

    @Test
    public void removeTest() {
        assertEquals(this.list.remove(5), null);
        this.addElements(5);
        assertEquals(this.list.remove(0), "element 1");
        assertEquals(this.list.remove(2), "element 4");
        assertEquals(this.list.remove(2), "element 5");
    }

    @Test
    public void removeSingleElementTest() {
        this.addElements(1);
        assertEquals(this.list.remove(0), "element 1");
        assertTrue(this.list.isEmpty());
        this.addElements(1);
        assertEquals(this.list.getFirst(), "element 1");
        assertEquals(this.list.getLast(), "element 1");
        assertEquals(this.list.remove(0), "element 1");
    }

    @Test
    public void iteratorTest() {
        assertTrue(this.list.iterator() instanceof SinglyLinkedListIterator);
    }
}


