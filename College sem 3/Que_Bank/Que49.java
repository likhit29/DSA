public class Que49 {

    // Method to perform insertion sort on book titles
    public static void insertionSort(String[] titles) {
        int n = titles.length;
        for (int i = 1; i < n; i++) {
            String key = titles[i]; // Current title to be inserted
            int j = i - 1;

            // Move titles that are greater than key to one position ahead of their current position
            while (j >= 0 && titles[j].compareTo(key) > 0) {
                titles[j + 1] = titles[j];
                j = j - 1;
            }
            titles[j + 1] = key; // Insert the current title at the correct position
        }
    }

    // Method to print the sorted book titles
    public static void printTitles(String[] titles) {
        for (int i = 0; i < titles.length; i++) {
            System.out.println(titles[i]);
        }
    }

    public static void main(String[] args) {
        // Initialize the book titles directly
        String[] bookTitles = {
            "The Great Gatsby", 
            "To Kill a Mockingbird", 
            "1984", 
            "Pride and Prejudice", 
            "Moby Dick"
        };

        // Sort the book titles
        insertionSort(bookTitles);

        // Print the sorted book titles
        System.out.println("\nSorted Book Catalog:");
        printTitles(bookTitles);
    }
}
