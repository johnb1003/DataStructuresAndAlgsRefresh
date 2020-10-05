public class HashMapEntryImpl {
    public String key;
    public Object value;
    public HashMapEntryImpl next;

    public HashMapEntryImpl(String key, Object value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public HashMapEntryImpl() {
        this.key = null;
        this.value = null;
        this.next = null;
    }
}
