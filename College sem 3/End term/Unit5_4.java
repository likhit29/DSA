/*
Mid-square Method:  2 ways
1. Square the PRN number
2. Use the middle digits of the square as the hash value, reduced modulo the size of the hash table.
*/

/*
Quadratic Probing: (current index + i^2) % table size
i is the number of collisions.
 */

 import java.util.Arrays;

public class Unit5_4 {

    private int[] hashTable; // Array to store hash table
    private int size;        // Size of the hash table

    // Constructor to initialize hash table
    public Unit5_4(int size) {
        this.size = size;
        this.hashTable = new int[size];
        Arrays.fill(hashTable, -1); // Initialize all slots to -1 (indicates empty)
    }

    // Mid-square hash function

    private int hashFunction(int key) {
        int square = key * key; // Square the key
        int middleDigits = (square / 10) % 100; // Extract the middle two digits
        return middleDigits % size; // Return hash value modulo table size
    }
    
    // private int hashFunction2(int key) {
    //     int square = key * key; // Square the key
    //     String squareStr = Integer.toString(square); 
    //     int middle = squareStr.length() / 2; 
    //     int middleDigits = Integer.parseInt(squareStr.substring(middle - 1, middle + 1)); // Extract middle digits
    //     return middleDigits % size; // Return hash value modulo table size
    // }


    // Insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction(key); // Initial index using hash function
        int i = 0; // Start with quadratic probing at i = 0
        int originalIndex = index; // To detect full loop

        // Quadratic probing to resolve collisions
        while (hashTable[index] != -1) { // If slot is occupied, handle collision
            index = (originalIndex + i * i) % size; // Quadratic probing formula
            i++;
            if (i == size) { // If we have probed all slots, table is full
                System.out.println("Hash table is full. Cannot insert " + key);
                return;
            }
        }

        // Insert key into the available slot
        hashTable[index] = key;
        System.out.println("Inserted " + key + " at index " + index + ".");
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
        // Initialize hash table with size 10
        Unit5_4 hashTable = new Unit5_4(10);

        // Given PRN numbers
        int[] prnNumbers = {39, 223, 78, 753, 109, 119, 33, 168};

        // Insert all PRN numbers into the hash table
        for (int prn : prnNumbers) {
            hashTable.insert(prn);
        }
        //hashTable.printHashTable();
    }

}
