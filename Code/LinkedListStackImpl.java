public class LinkedListStackImpl<T> {
    LinkedListNodeImplementation head;
    public LinkedListStackImpl() {
        this.head = null;
    }

    public void push(T element) {
        LinkedListNodeImplementation newNode = new LinkedListNodeImplementation(element);
        newNode.next = this.head;
        this.head = newNode;
    }

    public T pop() {
        if(this.isEmpty()) {
            return null;
        }
        else {
            T popped = this.head.value;
            this.head = this.head.next;
            return popped;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}
