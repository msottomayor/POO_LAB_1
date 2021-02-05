package test;

import lists.SingleListNode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SingleListNodeTest {
    SingleListNode node;

    @Before
    public void setUp() {
        this.node = new SingleListNode("element 1", new SingleListNode("element 2", null));
    }

    @Test
    public void getElementTest() {
        assertEquals("element 1", this.node.getElement());

    }

    @Test
    public void getNextTest() {
        assertEquals("element 2", this.node.getNext().getElement());
        assertEquals(null, this.node.getNext().getNext());
    }

    @Test
    public void setNextTest() {
        assertNotEquals(this.node.getNext(), null);
        this.node.setNext(null);
        assertEquals(this.node.getNext(), null);
    }

}
