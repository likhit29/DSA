//Binary Tree - Hierarchical Data Structure



//Build Tree Preorder - First left then right
public class aa {
    
    // Definition for a binary tree node.
    static class Node {
        int data;
        Node left;
        Node right;

        // Constructor to create a new node with the given data.
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Class for binary tree operations.
    static class BinaryTree {
        static int idx = -1;

        // Method to build the tree from an array of nodes.
        public static Node buildTree(int[] nodes) {
            idx++;
            // Base case: return null if the node value is -1.
            if (nodes[idx] == -1) {
                return null;
            }

            // Create a new node with the current index value.
            Node newNode = new Node(nodes[idx]);

            // Recursively build the left and right subtrees.
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Main method to test the binary tree creation.
    public static void main(String[] args) {
        // Example array representing the binary tree.
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        // Building the tree from the array.
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        
    }
}












