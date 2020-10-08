import java.util.Queue;
public class QueueArrayImpl<T> {
    Object[] queue;
    int capacity;
    int size;
    int head;
    int tail;

    public QueueArrayImpl(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = -1;
    }

    public boolean push(T element) {
        if(!this.isFull()) {
            this.tail = nextIndex(this.tail);
            this.queue[this.tail] = element;
            this.size++;
            //System.out.println("Head: "+this.head+"\tTail: "+this.tail+"\tSize: "+this.size);
            return true;
        }
        else {
            System.out.println("Could not push, queue is full!\n\n");
            return false;
        }
    }

    public T pop() {
        if(!isEmpty()) {
            T popped = (T) this.queue[this.head];
            this.queue[this.head] = null;
            this.head = nextIndex(this.head);
            this.size--;
            //System.out.println("Head: "+this.head+"\tTail: "+this.tail+"\tSize: "+this.size);
            return popped;
        }
        else {
            System.out.println("Could not pop, queue is empty!\n\n");
            return null;
        }
    }

    public int nextIndex(int index) {
        if(index+1 < this.capacity) {
            return index+1;
        }
        else {
            return 0;
        }
    }

    public void display() {
        if(!this.isEmpty()) {
            int i=this.head;
            while(true) {
                System.out.print(this.queue[i]);
                if(i == this.tail) {
                    System.out.println("");
                    break;
                }
                else {
                    System.out.print(" <- ");
                }
                i = nextIndex(i);
            }
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == this.capacity;
    }
}
