public class HashMapExample {
    public static HashMapImpl hashMap;
    public static void main(String[] args) {
        hashMap = new HashMapImpl<Integer>(10);

        hashMap.put("Hello", 5);
        hashMap.put("world", 4);

        System.out.println(hashMap.get("Hello"));
        System.out.println(hashMap.get("world"));
    }
}
