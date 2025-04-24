class SplayTree {
    class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    private Node root;

    // Right rotation
    private Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        return y;
    }

    // Left rotation
    private Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        return y;
    }

    // Splay operation
    private Node splay(Node root, int key) {

        // if tree is empty or key is already at the root, return the root.
        if (root == null || root.key == key) {
            return root;
        }

        //If the key is smaller, it should be in the left subtree.
        if (key < root.key) {

            //If left child is null → key not present, return root.
            if (root.left == null) {
                return root;
            }

            // Zig-Zig (Left Left)
            if (key < root.left.key) {
                root.left.left = splay(root.left.left, key);
                root = rightRotate(root);
            }
            // Zig-Zag (Left Right)
            else if (key > root.left.key) {
                root.left.right = splay(root.left.right, key);
                if (root.left.right != null) {
                    root.left = leftRotate(root.left);
                }
            }

            if (root.left == null) {
                return root;
            } else {
                return rightRotate(root);
            }
        } else {
            if (root.right == null) {
                return root;
            }

            // Zag-Zig (Right Left)
            if (key < root.right.key) {
                root.right.left = splay(root.right.left, key);
                if (root.right.left != null) {
                    root.right = rightRotate(root.right);
                }
            }
            // Zag-Zag (Right Right)
            else if (key > root.right.key) {
                root.right.right = splay(root.right.right, key);
                root = leftRotate(root);
            }

            if (root.right == null) {
                return root;
            } else {
                return leftRotate(root);
            }
        }
    }

    // Insert key
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        root = splay(root, key);

        if (root.key == key) {
            return; // Duplicate key, do nothing
        }

        Node newNode = new Node(key);

        if (key < root.key) {
            newNode.right = root;
            newNode.left = root.left;
            root.left = null;
        } else {
            newNode.left = root;
            newNode.right = root.right;
            root.right = null;
        }

        root = newNode;
    }

    // Search key
    public boolean search(int key) {
        root = splay(root, key);
        if (root != null && root.key == key) {
            return true;
        } else {
            return false;
        }
    }

    // Delete key
    public void delete(int key) {
        if (root == null) {
            return;
        }

        root = splay(root, key);

        if (root.key != key) {
            return; // Key not found
        }

        if (root.left == null) {
            root = root.right;
        } else {
            Node temp = root.right;
            root = root.left;
            root = splay(root, key);
            root.right = temp;
        }
    }

    // In-order traversal
    public void inOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.key + " ");
            inOrder(node.right);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SplayTree tree = new SplayTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.print("In-order traversal: ");
        tree.inOrder();

        System.out.println("Searching 30: " + tree.search(30));

        tree.delete(30);
        System.out.print("After deleting 30: ");
        tree.inOrder();
    }
}
