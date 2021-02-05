package lists;

public class SinglyLinkedListIterator {
    private SinglyLinkedList singleLinkedList;
    private SingleListNode curNode;

    public SinglyLinkedListIterator(SinglyLinkedList singleLinkedList) {
        this.singleLinkedList = singleLinkedList;
        this.curNode = null;
        this.rewind();
    }

    public boolean hasNext() {
        if(this.curNode != null) {
            return true;
        }
        return false;
    }

    public Object next() {
        Object element = this.curNode.getElement();
        this.curNode = this.curNode.getNext();
        return element;
    }

    public void rewind() {
        this.curNode = this.singleLinkedList.getHead();
    }

}
