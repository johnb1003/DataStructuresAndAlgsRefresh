public class LinkedListNodeImplementation {
    Object value;
    LinkedListNodeImplementation next;
    public LinkedListNodeImplementation(Object value, LinkedListNodeImplementation next) {
        this.value = value;
        this.next = next;
    }

    public LinkedListNodeImplementation getNext() {
        return this.next;
    }

    public void setNext(LinkedListNodeImplementation node) {
        this.next = node;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}