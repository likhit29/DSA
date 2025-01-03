import java.util.Arrays;

public class Unit5_3 {

    private int[] hashTable; // Array to store hash table
    private int size; // Size of the hash table

    // Constructor to initialize hash table
    public Unit5_3(int size) {
        this.size = size;
        this.hashTable = new int[size];
        Arrays.fill(hashTable, -1); // Initialize all slots to -1 (indicates empty)
    }

    // Primary hash function H1(x) = x % 13
    private int hashFunction1(int key) {
        return key % 13;
    }

    // Secondary hash function H2(x) = 7 - (x % 7)
    private int hashFunction2(int key) {
        return 7 - (key % 7);
    }

    // Insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction1(key); // Primary hash index
        int step = hashFunction2(key); // Step size from secondary hash function
        int originalIndex = index; // To check if the table is full

        int attempts = 0; // Number of attempts to resolve collision
        while (hashTable[index] != -1) { // If slot is not empty, handle collision
            attempts++; // Increment number of attempts
            index = (originalIndex + attempts * step) % size; // Update using double hashing formula

            if (index == originalIndex) { // If we have completed a full loop, table is full
                System.out.println("Hash table is full. Cannot insert " + key);
                return;
            }
        }

        // Insert key into the available slot
        hashTable[index] = key;
        System.out.println("Inserted " + key + " at index " + index + " after " + attempts + " step(s).");

        // Print hash table status after each insertion
        printHashTable();
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
        Unit5_3 hashTable = new Unit5_3(13);

        // Given Airtel recharge packs
        int[] rechargePacks = { 99, 199, 251, 349, 111, 10, 59, 751, 420 };

        // Insert all recharge pack values into the hash table
        for (int pack : rechargePacks) {
            hashTable.insert(pack);
        }
    }
}
