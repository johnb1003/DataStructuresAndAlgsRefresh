public class QueueLinkedListImpl<T> {
    LinkedListNodeImplementation head;
    LinkedListNodeImplementation tail;
    int size;
    public QueueLinkedListImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void push(T element) {
        LinkedListNodeImplementation node = new LinkedListNodeImplementation(element, null);
        if(this.size == 0) {
            this.head = node;
            this.tail = node;
        }
        else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public T pop() {
        if(this.size > 0) {
            LinkedListNodeImplementation node = this.head;
            T element = (T) node.value;
            this.head = this.head.next;
            this.size--;

            if(this.size == 0) {
                this.tail = null;
            }
            return element;
        }
        else {
            return null;
        }
    }

    public void display() {
        LinkedListNodeImplementation node = this.head;

        while(node != null) {

            System.out.print(node.value);
            if(node == this.tail) {
                System.out.println("");
                break;
            }
            else {
                System.out.print(" <- ");
            }
            node = node.next;
        }
    }
}
