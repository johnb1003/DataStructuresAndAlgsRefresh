public class DoublyLinkedListNodeImplementation {
    Object value;
    DoublyLinkedListNodeImplementation next;
    DoublyLinkedListNodeImplementation prev;

    public DoublyLinkedListNodeImplementation(Object value, DoublyLinkedListNodeImplementation prev, DoublyLinkedListNodeImplementation next) {
        this.value = null;
        this.prev = prev;
        this.next = next;
    }
}