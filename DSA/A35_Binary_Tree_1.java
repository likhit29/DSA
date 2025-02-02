//Binary Tree - Hierarchical Data Structure
//Height of tree is calculated on 2 basis - Nodes and edges   
//Build Tree Preorder - First left then right

import java.util.*;

public class A35_Binary_Tree_1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {

        static int idx = 0; // static is important

        public static Node buildTree(int[] nodes) {
            
            // Base case: return null if the node value is -1.
            if (idx >= nodes.length || nodes[idx] == -1) {
                idx++;
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            // Recursively build the left and right subtrees.
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Preoder Traversal : Root -> Left Subtree -> Right Subtree
        public static void preorder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        // Inorder Traversal : Left Subtree -> Root -> Right Subtree
        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        // Postorder Traversal : Left Subtree -> Right Subtree -> Root
        public static void Postorder(Node root) {
            if (root == null) {
                return;
            }
            Postorder(root.left);
            Postorder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal
        // no recursion
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null); // null marker to indicate the end of a level

            while (!q.isEmpty()) {
                Node currNode = q.remove(); // Get the next node in the queue

                if (currNode == null) {
                    System.out.println(); // Print a new line for the next level

                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data + " ");

                    // Add the left and right children of the current node to the queue
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        // Height of Tree
        public static int height(Node root) {
            if (root == null) {
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        // Count Number of nodes of tree
        public static int count(Node root) {
            if (root == null) {
                return 0;
            }

            int lc = count(root.left);
            int rc = count(root.right);
            return lc + rc + 1;
        }

        // sum of nodes
        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }

            int ls = sum(root.left);
            int rs = sum(root.right);
            return ls + rs + root.data;
        }

        // Diameter of a tree = No of nodes in the longest path between 2 leaves
        // O(n²)
        public static int diameter1(Node root) {
            if (root == null) {
                return 0;
            }

            int leftDiam = diameter1(root.left);
            int leftHt = height(root.left);
            int rightDiam = diameter1(root.right);
            int rightHt = height(root.right);
            int selfDiam = leftHt + rightHt + 1;

            return Math.max(selfDiam, Math.max(rightDiam, leftDiam));
        }

        // O(n) - by making a class we are doing recursive once only
        static class Info {
            int diam;
            int ht;

            public Info(int diam, int ht) {
                this.diam = diam;
                this.ht = ht;
            }
        }

        public static Info diameter2(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info leftInfo = diameter2(root.left);
            Info rightInfo = diameter2(root.right);
            int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
            int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;
            return new Info(diam, ht);
        }
    }

    public static void main(String[] args) {

        // int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // BinaryTree tree = new BinaryTree();
        // Node root = tree.buildTree(nodes);
        // System.out.println("Root Node is - " + root.data);

        // Preorder Traversal
        // tree.preorder(root);

        // Inorder Traversal
        // tree.inorder(root);

        // Postorder Traversal
        // tree.Postorder(root);

        // tree.levelOrder(root);

        // System.out.println(tree.height(root));

        // System.out.println(tree.count(root));

        // System.out.println(tree.sum(root));

        // System.out.println(tree.diameter1(root));

        // System.out.println(tree.diameter2(root).diam);
        // System.out.println(tree.diameter2(root).ht);

    }
}
