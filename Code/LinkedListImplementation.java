//import LinkedListNodeImplementation;
public class LinkedListImplementation<T> {
    LinkedListNodeImplementation head;
    int size;
    public LinkedListImplementation() {
        this.head = null;
        this.size = 0;
    }

    public LinkedListNodeImplementation getHead() {
        return this.head;
    }

    public void setHead(LinkedListNodeImplementation node) {
        this.head = node;
    }

    public void add(Object value) {
        LinkedListNodeImplementation node = new LinkedListNodeImplementation(value, null);

        if(this.head == null) {
            this.head = node;
        }
        else {
            node.next = this.head;
            this.head = node;
        }
    }

    public void delete() {
        if(this.head == null) {
            return;
        }
        else {
            this.head = this.head.next;
        }
    }

    public void display() {
        LinkedListNodeImplementation currNode = this.head;
        while(currNode != null) {
            System.out.print(currNode.value);

            if(currNode.next != null) {
                System.out.print(" -> ");
            }
            else {
                System.out.println("");
            }

            currNode = currNode.next;
        }
    }
}