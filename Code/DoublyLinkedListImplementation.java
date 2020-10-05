import DoublyLinkedListNodeImplementation;
public class DoublyLinkedListImplementation<T> {
    public DoublyLinkedListNodeImplementation head;
    public int size;

    public DoublyLinkedListImplementation() {
        this.head = null;
        this.size = 0;
    }

    public void add(Object node) {
        if(this.head == null) {
            this.head = new DoublyLinkedListNodeImplementation(node, null, null);
        }
        else {
            DoublyLinkedListNodeImplementation newNode = new DoublyLinkedListNodeImplementation(node, null, this.head);
            this.head.prev = newNode;
            this.head = newNode;
        }
        size++;
    }

    public void delete() {
        if(this.head == null) {
            return;
        }
        else {
            this.head = this.head.next;
            if(this.head != null) {
                this.head.prev = null;
            }
            size--;
        }
    }

    public void display() {
        DoublyLinkedListNodeImplementation currNode = this.head;
        while(currNode != null) {
            System.out.println(currNode.value);
            currNode = currNode.next;
        }
    }
}
