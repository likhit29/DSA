/*
1. Insert word (Handle insertion of duplicate entry)
2. Delete word
3. Search specific word
4. Display dictionary (Traversal)
5. Mirror image of dictionary
6. Create a copy of dictionary
7. Display dictionary level wise

*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    String key, value;
    Node left, right;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

class Dictionary {
    private Node root;

    public void insert(String key, String value) {
        root = insertRecursive(root, key, value);
    }

    private Node insertRecursive(Node node, String key, String value) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            node.value = value; 
        }
        return node;
    }

    public String search(String key) {
        Node result = searchRecursive(root, key);
        if (result != null) {
            return result.value;
        } else {
            return "Not found!";
        }
    }

    private Node searchRecursive(Node node, String key) {
        if (node == null) {
            return null;
        }

        if (key.equals(node.key)) {
            return node;
        }

        if (key.compareTo(node.key) < 0) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    public void delete(String key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node node, String key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            Node minNode = findMin(node.right);
            node.key = minNode.key;
            node.value = minNode.value;
            node.right = deleteRecursive(node.right, minNode.key);
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void display() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.key + " : " + node.value);
            inorder(node.right);
        }
    }

    public void printLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.key + ": " + temp.value + " | ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        System.out.println();
    }

    public Dictionary mirror() {
        Dictionary mirroredDict = new Dictionary();
        mirroredDict.root = mirrorRecursive(root);
        return mirroredDict;
    }

    private Node mirrorRecursive(Node node) {
        if (node == null) {
            return null;
        }
        Node mirroredNode = new Node(node.key, node.value);
        mirroredNode.left = mirrorRecursive(node.right);
        mirroredNode.right = mirrorRecursive(node.left);
        return mirroredNode;
    }

    public Dictionary copy() {
        Dictionary copyDict = new Dictionary();
        copyDict.root = copyRecursive(root);
        return copyDict;
    }

    private Node copyRecursive(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.key, node.value);
        newNode.left = copyRecursive(node.left);
        newNode.right = copyRecursive(node.right);
        return newNode;
    }
}

public class Likhit_100_1 {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nDictionary Operations:");
            System.out.println("1. Insert word");
            System.out.println("2. Delete word");
            System.out.println("3. Search word");
            System.out.println("4. Display dictionary");
            System.out.println("5. Print level-wise");
            System.out.println("6. Mirror dictionary");
            System.out.println("7. Create a copy of the dictionary");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                System.out.print("Enter word: ");
                String key = scanner.nextLine();
                System.out.print("Enter meaning: ");
                String value = scanner.nextLine();
                dict.insert(key, value);
            } else if (choice == 2) {
                System.out.print("Enter word to delete: ");
                String deleteKey = scanner.nextLine();
                dict.delete(deleteKey);
            } else if (choice == 3) {
                System.out.print("Enter word to search: ");
                String searchKey = scanner.nextLine();
                String meaning = dict.search(searchKey);
                System.out.println("Meaning: " + meaning);
            } else if (choice == 4) {
                System.out.println("Dictionary (In-order):");
                dict.display();
            } else if (choice == 5) {
                System.out.println("Dictionary (Level-wise):");
                dict.printLevelOrder();
            } else if (choice == 6) {
                Dictionary mirroredDict = dict.mirror();
                System.out.println("Mirrored Dictionary (In-order):");
                mirroredDict.display();
            } else if (choice == 7) {
                Dictionary copiedDict = dict.copy();
                System.out.println("Copied Dictionary (In-order):");
                copiedDict.display();
            } else if (choice == 8) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
