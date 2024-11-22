import java.util.LinkedList;

public class Likhit_100_11<K, V> {

    private class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] buckets;
    private int N; // Number of buckets

    @SuppressWarnings("unchecked")
    public Likhit_100_11(int size) {
        this.N = size; // Set the number of buckets
        this.buckets = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            this.buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to compute bucket index
    private int hashFunction(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % N;
    }

    // Add or update a key-value pair
    public void put(K key, V value) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> bucket = buckets[bucketIndex];

        // Check if key already exists
        for (Node node : bucket) {
            if (node.key.equals(key)) {
                node.value = value; // Update value
                return;
            }
        }

        // Add new key-value pair
        bucket.add(new Node(key, value));
    }

    // Retrieve a value for a given key
    public V get(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> bucket = buckets[bucketIndex];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                return node.value; // Key found
            }
        }

        return null; // Key not found
    }

    // Remove a key-value pair
    public V remove(K key) {
        int bucketIndex = hashFunction(key);
        LinkedList<Node> bucket = buckets[bucketIndex];

        for (Node node : bucket) {
            if (node.key.equals(key)) {
                bucket.remove(node); // Remove key-value pair
                return node.value;
            }
        }

        return null; // Key not found
    }

    // Print all key-value pairs
    public void printAll() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Node node : buckets[i]) {
                System.out.print("{" + node.key + "=" + node.value + "} ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Likhit_100_11<String, Integer> map = new Likhit_100_11<>(4);

        map.put("India", 100);
        map.put("China", 200);
        map.put("USA", 300);
        map.put("Japan", 400);

        map.printAll();

        //System.out.println("Get value for 'India': " + map.get("India"));
        //System.out.println("Remove 'China': " + map.remove("China"));
        //map.printAll();
    }
}
