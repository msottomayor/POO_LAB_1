package lists;

public class SinglyLinkedList {
    private SingleListNode head;
    private SingleListNode tail;
    private int numElements;

    // Constructor:
    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.numElements = 0;
    }
    public SingleListNode getHead() {
        return this.head;
    }

    public boolean isEmpty() {
        if (this.numElements == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.numElements;
    }

    public Object getFirst() {
        return this.head.getElement();
    }

    public Object getLast() {
        return this.tail.getElement();
    }

    public Object get(int position) {
        SingleListNode curNode = this.head;
        int index = 0;
        if(this.head != null) {
            while (curNode.getElement() != null) {
                if (index == position) {
                    return curNode.getElement();
                }
                curNode = curNode.getNext();
                index++;
            }
        }
        return null;
    }

    public void insertFirst(Object element) {
        SingleListNode newNode = new SingleListNode(element, (SingleListNode) this.head);
        if (this.head == null) {
            this.tail = newNode;
        }
        this.head = newNode;
        this.numElements++;
    }

    public void insertLast(Object element) {
        SingleListNode newNode = new SingleListNode(element, null);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.setNext(newNode);
        }
        this.tail = newNode;
        this.numElements++;
    }

    public Object insert(Object element, int position) {
        if (position == 0) {
            this.insertFirst(element);
        } else if (position == this.numElements) {
            this.insertLast(element);
        } else {
            SingleListNode prevNode = this.head;
            SingleListNode curNode = this.head;
            int index = 0;
            while (prevNode != null) {
                if (position == index) {
                    SingleListNode newNode = new SingleListNode(element, curNode);
                    prevNode.setNext(newNode);
                    this.numElements++;
                    break;
                }
                prevNode = curNode;
                curNode = curNode.getNext();
                index++;
            }
        }

        return element;
    }

    public Object removeFirst() {
        if (this.numElements == 1) {
            SingleListNode oldNode = this.head;
            this.head = null;
            this.tail = null;
            this.numElements = 0;
            return oldNode.getElement();
        } else {
            SingleListNode oldNode = this.head;
            this.head = this.head.getNext();
            this.numElements--;
            return oldNode.getElement();
        }
    }

    public Object removeLast() {
        if (numElements == 1) {
            SingleListNode oldNode = this.head;
            this.head = null;
            this.tail = null;
            this.numElements = 0;
            return oldNode.getElement();
        } else if(numElements>1){
            SingleListNode curNode = this.head;
            while (curNode.getNext().getNext() != null){
                curNode = curNode.getNext();
            }
            SingleListNode oldNode = this.tail;
            this.tail = curNode;
            curNode.setNext(null);
            this.numElements--;
            return oldNode.getElement();
        }
        return null;
    }


    public Object remove(int position) {
        if(position == 0) {
            return this.removeFirst();
        } else if(position == this.numElements - 1) {
            return this.removeLast();
        } else {
            SingleListNode curNode = this.head;
            SingleListNode prevNode = curNode;
            int idx = 0;
            while(curNode != null) {
                if(idx == position) {
                    prevNode.setNext(curNode.getNext());
                    SingleListNode oldNode = curNode;
                    curNode.setNext(null);
                    this.numElements--;
                    return oldNode.getElement();
                }
                curNode = curNode.getNext();
                idx++;
            }
        }
    return null;
    }

    public SinglyLinkedListIterator iterator() {
        return new SinglyLinkedListIterator(this);
    }
}

