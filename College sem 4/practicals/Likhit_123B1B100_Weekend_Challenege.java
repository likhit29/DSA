//123B1B100
/*
Binary Search Tree 
1. Insert a Node
2. Delete a Node
3. Search for a Node
4. Display Inorder Traversal
5. Display Root-to-Leaf Paths
6. Find Diameter of the Tree
7. Find Sum of All Nodes
8. Find Total Number of Nodes
9. Find Maximum Value in the Tree
10. Find Minimum Value in the Tree
11. Find Height of the Tree
 */

 import java.util.Stack;
import java.util.Scanner;

class BinarySearchTree {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void search(Node root, int data) {
        if (root == null) {
            System.out.println("Not found");
            return;
        }
        if (data == root.data) {
            System.out.println("Found");
        } else if (data < root.data) {
            search(root.left, data);
        } else {
            search(root.right, data);
        }
    }

    public void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    public int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            root = root.left;
            minValue = root.data;
        }
        return minValue;
    }

    private static Stack<Integer> stack = new Stack<>();

    public static void rootToLeaf(Node root) {
        if (root == null) return;
        stack.push(root.data);
        rootToLeaf(root.left);
        if (root.left == null && root.right == null) {
            System.out.println(stack);
        }
        rootToLeaf(root.right);
        stack.pop();
    }

    public static int diameterOfBT(Node root) {
        if (root == null) return 0;
        int leftDiameter = diameterOfBT(root.left);
        int rightDiameter = diameterOfBT(root.right);
        int depthSpan = height(root.left) + height(root.right) + 2;
        return Math.max(depthSpan, Math.max(leftDiameter, rightDiameter));
    }

    public int sumOfNodes(Node root) {
        if (root == null) return 0;
        return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
    }

    public int countNodes(Node root) {
        if (root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int maxValue(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maxValue(root.left), maxValue(root.right)));
    }

    public static int height(Node root) {
        if (root == null) return -1;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}

public class Likhit_123B1B100_Weekend_Challenege {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Insert a Node");
            System.out.println("2. Delete a Node");
            System.out.println("3. Search for a Node");
            System.out.println("4. Display Inorder Traversal");
            System.out.println("5. Display Root-to-Leaf Paths");
            System.out.println("6. Find Diameter of the Tree");
            System.out.println("7. Find Sum of All Nodes");
            System.out.println("8. Find Total Number of Nodes");
            System.out.println("9. Find Maximum Value in the Tree");
            System.out.println("10. Find Minimum Value in the Tree");
            System.out.println("11. Find Height of the Tree");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();
                    bst.insert(insertValue);
                    System.out.println("Value inserted.");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();
                    bst.deleteKey(deleteValue);
                    System.out.println("Value deleted if it existed.");
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();
                    bst.search(bst.root, searchValue);
                    break;

                case 4:
                    System.out.println("Inorder Traversal:");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Root-to-Leaf Paths:");
                    BinarySearchTree.rootToLeaf(bst.root);
                    break;

                case 6:
                    System.out.println("Diameter of the Tree: " + BinarySearchTree.diameterOfBT(bst.root));
                    break;

                case 7:
                    System.out.println("Sum of All Nodes: " + bst.sumOfNodes(bst.root));
                    break;

                case 8:
                    System.out.println("Total Number of Nodes: " + bst.countNodes(bst.root));
                    break;

                case 9:
                    System.out.println("Maximum Value in the Tree: " + bst.maxValue(bst.root));
                    break;

                case 10:
                    System.out.println("Minimum Value in the Tree: " + bst.minValue(bst.root));
                    break;

                case 11:
                    System.out.println("Height of the Tree: " + BinarySearchTree.height(bst.root));
                    break;

                case 12:
                    System.out.println("Exiting program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
