import java.util.Arrays;

public class Unit5_2 {

    private int[] hashTable; // Array to store hash table
    private int size;        // Size of the hash table

    // Constructor to initialize hash table
    public Unit5_2(int size) {
        this.size = size;
        this.hashTable = new int[size];
        Arrays.fill(hashTable, -1); // Initialize all slots to -1 (indicates empty)
    }

    // Hash function H(x) = x % size
    private int hashFunction(int key) {
        return key % size;
    }

    // Insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction(key); // Calculate hash index
        int originalIndex = index;    // Keep track of the original index
        int steps = 0;                // To count steps for linear probing

        // Handle collision using linear probing
        while (hashTable[index] != -1) { // Check for occupied slot
            steps++;
            index = (index + 1) % size; // Move to the next slot
            if (index == originalIndex) { // Table is full
                System.out.println("Hash table is full. Cannot insert " + key);
                return;
            }
        }

        // Insert key in the first available slot
        hashTable[index] = key;
        System.out.println("Inserted " + key + " at index " + index + " after " + steps + " step(s).");
    }

    // Print the current status of the hash table
    public void printHashTable() {
        System.out.println("Current Hash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + (hashTable[i] == -1 ? "empty" : hashTable[i]));
        }
    }

    // Main method
    public static void main(String[] args) {
        // Initialize hash table with size 13
        Unit5_2 hashTable = new Unit5_2(13);

        // Given final scores
        int[] finalScores = {224, 219, 220, 222, 214, 217, 226, 284, 296, 226};

        // Insert all final scores into the hash table
        for (int score : finalScores) {
            hashTable.insert(score);
        }

        // Print the final state of the hash table
        hashTable.printHashTable();
    }
}
