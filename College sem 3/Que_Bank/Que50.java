import java.util.Scanner;

class Product {
    String name;
    double price;
    double rating; // Customer rating (e.g., out of 5)
    String arrivalDate; // Newest arrivals will be sorted based on this

    public Product(String name, double price, double rating, String arrivalDate) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return name + " | Price: " + price + " | Rating: " + rating + " | Arrival: " + arrivalDate;
    }
}

public class Que50 {
    
    // Merge Sort implementation using one array
    public static void mergeSort(Product[] products, int left, int right, String sortBy) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(products, left, mid, sortBy);
            mergeSort(products, mid + 1, right, sortBy);
            merge(products, left, mid, right, sortBy);
        }
    }

    // Merge method to combine two sorted halves
    private static void merge(Product[] products, int left, int mid, int right, String sortBy) {
        int i = left;      // Starting index for left subarray
        int j = mid + 1;   // Starting index for right subarray

        // Temporary array to store merged products
        Product[] temp = new Product[right - left + 1];
        int k = 0;

        // Compare and rearrange the elements
        while (i <= mid && j <= right) {
            if (sortBy.equals("price") && products[i].price <= products[j].price) {
                temp[k++] = products[i++];
            } else if (sortBy.equals("rating") && products[i].rating >= products[j].rating) {
                temp[k++] = products[i++];
            } else if (sortBy.equals("arrival") && products[i].arrivalDate.compareTo(products[j].arrivalDate) <= 0) {
                temp[k++] = products[i++];
            } else {
                temp[k++] = products[j++];
            }
        }

        // Copy remaining elements of left, if any
        while (i <= mid) {
            temp[k++] = products[i++];
        }

        // Copy remaining elements of right, if any
        while (j <= right) {
            temp[k++] = products[j++];
        }

        // Copy merged elements back into the original array
        for (int m = 0; m < temp.length; m++) {
            products[left + m] = temp[m];
        }
    }

    // Method to display the products
    public static void displayProducts(Product[] products) {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void main(String[] args) {
        // Sample products
        Product[] products = new Product[4];
        products[0] = new Product("Laptop", 999.99, 4.5, "2024-09-10");
        products[1] = new Product("Smartphone", 499.99, 4.7, "2024-09-15");
        products[2] = new Product("Headphones", 199.99, 4.3, "2024-08-20");
        products[3] = new Product("Smartwatch", 299.99, 4.6, "2024-09-05");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sorting option: \n1. Sort by Price \n2. Sort by Rating \n3. Sort by Newest Arrivals");
        int choice = scanner.nextInt();
        
        String sortBy = "";
        switch (choice) {
            case 1:
                sortBy = "price";
                break;
            case 2:
                sortBy = "rating";
                break;
            case 3:
                sortBy = "arrival";
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }

        // Perform Merge Sort based on the selected criteria
        mergeSort(products, 0, products.length - 1, sortBy);

        // Display sorted products
        System.out.println("\nSorted Products:");
        displayProducts(products);

        scanner.close();
    }
}
