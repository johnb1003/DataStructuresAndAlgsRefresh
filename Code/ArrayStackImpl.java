public class ArrayStackImpl<T> {
    int size;
    int top;
    T[] stack;

    public ArrayStackImpl(int size) {
        this.size = size;
        this.stack = new T[size];
        this.top = -1;
    }

    public boolean push(T element) {
        if(!this.isFull()) {
            this.stack[++this.top] = element;
            return true;
        }
        else {
            return false;
        }
    }

    public T pop() {
        if(this.isEmpty()) {
            return null;
        }
        else {
            return this.stack[this.top--];
        }
    }

    public boolean isFull() {
        return (this.top >= this.size-1);
    }

    public boolean isEmpty() {
        return (this.top < 0);
    }
}
