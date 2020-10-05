import java.util.ArrayList;
public class HashMapImpl<T> {
    int size;
    HashMapEntryImpl[] arr; 
    public HashMapImpl(int size) {
        this.size = size;
        this.arr = new HashMapEntryImpl[size];
    }

    public void put(String key, Object value) {
        HashMapEntryImpl entry = new HashMapEntryImpl(key, value);

        int index = hash(key);

        entry.next = arr[index];
        arr[index] = entry;
    }

    public Object get(String key) {
        HashMapEntryImpl currNode = arr[hash(key)];

        while(currNode != null && !currNode.key.equals(key)) {
            currNode = currNode.next;
        }

        if(currNode == null) {
            return null;
        }
        else {
            return arr[hash(key)].value;
        }
    }

    public int hash(String key) {
        return key.hashCode() % this.size;
    }
}
